package com.jstudyplanner.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jstudyplanner.domain.Campus;
import com.jstudyplanner.domain.Course;
import com.jstudyplanner.domain.CourseAvailability;
import com.jstudyplanner.domain.Enrollment;
import com.jstudyplanner.domain.Student;
import com.jstudyplanner.domain.Term;
import com.jstudyplanner.service.CAService;
import com.jstudyplanner.service.CourseService;
import com.jstudyplanner.service.EnrollmentService;
import com.jstudyplanner.service.TermService;
import com.jstudyplanner.service.UserService;
import com.jstudyplanner.service.implementation.CustomServiceException;



/**
 * Spring controller that manages student user requests.
 * @author oleg
 */
@Controller
public class StudentController {
	
	private final UserService userService;
	private final EnrollmentService enrollmentService;
	private final TermService termService;
	private final CAService caService;
	private final CourseService courseService;
	private final static int DEFAULT_PAGE_SIZE = 10;
	
	
	/**
	 * Controller constructor. Service objects implementations should be marked with @Component
	 */
	@Inject
	public StudentController(UserService userService, EnrollmentService enrollmentService, TermService termService,
			CAService courseAvailabilityService, CourseService courseService) {
		this.userService = userService;
		this.enrollmentService = enrollmentService;
		this.termService = termService;
		this.caService = courseAvailabilityService;
		this.courseService = courseService;
	}
	
	/**
	 * Get current (logged in) student from security context
	 */
	Student getCurrentStudent() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Student student = (Student) userService.getUserByUsername(username);
		return student;
	}
	
	/**
	 * Redirect to student home page. Get current user details to be displayed on the page. Add student to current session
	 */
	@RequestMapping(value = {"/student/home","/student/student"}, method = RequestMethod.GET)
	public ModelAndView student(HttpSession session) {
		Student student = getCurrentStudent();
		session.setAttribute("currentStudent", student);
		return new ModelAndView("student/student", "student", student);
	}
	
	
	// List handlers ---------------------------------------------
	
	/**
	 * Get all Enrollments of the current student users, add to session, set pagination and return enrollment list view.
	 */
	@RequestMapping(value = "/student/enrollmentlist")
	public ModelAndView listEnrollments(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize, HttpSession session) {
		if (page == null) {
			page = 0;
		}
		
		PagedListHolder<Enrollment> resultList = (PagedListHolder<Enrollment>) session.getAttribute("StudentController_enrollmentList");
		if (resultList == null) {
			resultList = new PagedListHolder<Enrollment>(enrollmentService.getEnrollmentsByStudent(getCurrentStudent()));
			session.setAttribute("StudentController_enrollmentList", resultList);
			if (pageSize == null) {
				pageSize = DEFAULT_PAGE_SIZE;
			}
		}
		if (pageSize != null) {
			resultList.setPageSize(pageSize);
		}
		resultList.setPage(page);
		return new ModelAndView("student/enrollmentlist", "resultList", resultList);
	} // listEnrollments
	
	
	
	
	// Edit / Create / Delete methods --------------------------------
	
	/**
	 * Redirect to Enrollment Create page (form)
	 */
	@RequestMapping(value = "/student/enrollmentcreate")
	public String redirectToEnrollmentCreate(Model model) {
		Enrollment enrollment = new Enrollment();
		model.addAttribute("enrollment", enrollment);
		List<Term> termList = termService.getFutureTerms();
		model.addAttribute("termList", termList);
		return "student/enrollmentcreate";
	}
	
	
	/**
	 * Redirect to Enrollment Update / Delete page (form).
	 * Get list of future terms for term drop down list. So user can change term.
	 * Get set of courses available for enrollment for enrollment's term. So user can change course.
	 */
	@RequestMapping(value = "/student/enrollmentedit/{id}")
	public String redirectToEnrollmentEditDelete(@PathVariable("id") Long id, Model model) {
		Enrollment enrollment = enrollmentService.getEnrollmentById(id);
		// TODO handle if enrollment not found by id
		model.addAttribute("enrollment", enrollment);
		List<Term> termList = termService.getFutureTerms();
		model.addAttribute("termList", termList);
		
		Term term = enrollment.getCourseAvailability().getTerm();
		Set<Course> courseSet = getCACoursesByTerm(term.getId());
		model.addAttribute("courseSet", courseSet);
		
		return "student/enrollmentedit";
	}
	
	
	/**
	 * Get set of courses available in the given term for current user (associated with a campus).
	 * This method can be used by Ajax requests to populate cascade drop down lists (select - option).
	 * The set of Courses is processed by Jackson JSON processor. Used on Enrollment Create/Edit forms.
	 * @param id  - term id
	 * @return set of Course objects 
	 */
	@RequestMapping(value = "/student/getCACoursesByTerm")
	public @ResponseBody Set<Course> getCACoursesByTerm(@RequestParam(value = "id", required = true) Long id) {
		Student student = getCurrentStudent();
		Campus campus = student.getCampus();
		Term term = termService.getTermById(id);
		Set<Course> courseSet = new HashSet<Course>();
		List<CourseAvailability> caList;
		
		try {
			caList = caService.getCAByCampusAndTerm(campus, term);
			for (CourseAvailability ca : caList) {
				courseSet.add(ca.getCourse());
			}
		} catch (CustomServiceException ex) {
			// TODO handle if no courses found - do we really need this? Probably write to log file.
			//courseSet.add(new Course(null, null, "no courses", null, null, null));
		}
		
		return courseSet;
	}
	
	
	/**
	 * Attempts to delete enrollment using service object's delete method
	 * @param id - enrollment id
	 * @param session
	 */
	@RequestMapping(value = "/student/enrollmentdelete/{id}")
	public ModelAndView deleteEnrollment(@PathVariable("id") Long id, HttpSession session) {
		// TODO handle if enrollment not found
		Enrollment enrollment = enrollmentService.getEnrollmentById(id);
		ModelAndView modelAndView;
		try {
			enrollmentService.delete(enrollment, getCurrentStudent());
			
			modelAndView = new ModelAndView("student/enrollmentlist");
			String infoMessage = "Course '" + enrollment.getCourseAvailability().getCourse().getTitle() 
					+ "' removed successfully from your plan.";
			modelAndView.addObject("infoMessage", infoMessage);
			
			PagedListHolder<Enrollment> resultList = new PagedListHolder<Enrollment>(enrollmentService.getEnrollmentsByStudent(getCurrentStudent()));
			session.setAttribute("StudentController_enrollmentList", resultList);
			modelAndView.addObject("resultList", resultList);
		} catch (CustomServiceException ex) {
			modelAndView = new ModelAndView("student/enrollmentedit");
			
			modelAndView.addObject("errorMessage", ex.getErrorMsg());
			
			modelAndView.addObject("enrollment", enrollment);
			List<Term> termList = termService.getFutureTerms();
			modelAndView.addObject("termList", termList);
			
			Term term = enrollment.getCourseAvailability().getTerm();
			Set<Course> courseSet = getCACoursesByTerm(term.getId());
			modelAndView.addObject("courseSet", courseSet);
		}
		
		return modelAndView;
	} // deleteEnrollment
	
	
	/**
	 * Updates/creates Enrollment object. If Enrollment updated/created successfully then open Enrollment list (also refresh it).
	 * If update/create was not successful then redirect back to the edit/create page and display error message.
	 */
	@RequestMapping(value = "/student/enrollmentupdate", method = RequestMethod.POST)
	public ModelAndView saveEnrollment(@ModelAttribute Enrollment enrollment, HttpSession session) {
		ModelAndView modelAndView;
		try {
			Student student = getCurrentStudent();
			Campus campus = student.getCampus();
			Term term = termService.getTermById(enrollment.getCourseAvailability().getTerm().getId());
			Course course = courseService.getCourseById(enrollment.getCourseAvailability().getCourse().getId());
			CourseAvailability ca = caService.getCAByCampusTermAndCourse(campus, term, course);
			
			enrollment.setStudent(student);
			enrollment.setCourseAvailability(ca);
			
			if (enrollment.getId() == null ) {
				enrollment.setStatus("planned"); // this is a new enrollment
			}
			
			enrollmentService.save(enrollment); // attempts to save enrollment, can throw exception
			
			modelAndView = new ModelAndView("student/enrollmentlist");
			String infoMessage = "Course '" + course.getTitle() + "' scheduled successfully for " + term.getShortDescription() + ".";
			modelAndView.addObject("infoMessage", infoMessage);
			
			PagedListHolder<Enrollment> resultList = new PagedListHolder<Enrollment>(enrollmentService.getEnrollmentsByStudent(student));
			modelAndView.addObject("resultList", resultList);
			session.setAttribute("StudentController_enrollmentList", resultList);
		} catch (CustomServiceException ex) {
			if (enrollment.getId() == null) {
				modelAndView = new ModelAndView("student/enrollmentcreate");
			} else {
				modelAndView = new ModelAndView("student/enrollmentedit");
			}
			modelAndView.addObject("enrollment", enrollment);
			modelAndView.addObject("errorMessage", ex.getErrorMsg());
			
			List<Term> termList = termService.getFutureTerms();
			modelAndView.addObject("termList", termList);
			
			Term term = enrollment.getCourseAvailability().getTerm();
			Set<Course> courseSet = getCACoursesByTerm(term.getId());
			modelAndView.addObject("courseSet", courseSet);
		}
		
		return modelAndView;
	} // saveEnrollment
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}