package com.jstudyplanner.web;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jstudyplanner.domain.Campus;
import com.jstudyplanner.domain.Course;
import com.jstudyplanner.domain.CourseAvailability;
import com.jstudyplanner.domain.Enrollment;
import com.jstudyplanner.domain.Major;
import com.jstudyplanner.domain.Program;
import com.jstudyplanner.domain.Student;
import com.jstudyplanner.domain.Term;
import com.jstudyplanner.service.CAService;
import com.jstudyplanner.service.CampusService;
import com.jstudyplanner.service.CourseService;
import com.jstudyplanner.service.EnrollmentService;
import com.jstudyplanner.service.MajorService;
import com.jstudyplanner.service.ProgramService;
import com.jstudyplanner.service.TermService;
import com.jstudyplanner.service.UserService;
import com.jstudyplanner.service.implementation.CustomServiceException;


/**
 * Spring controller that manages staff user requests.
 * @author oleg
 */
@Controller
public class StaffController {
	
	private final ProgramService programService;
	private final MajorService majorService;
	private final CourseService courseService;
	private final UserService userService;
	private final TermService termService;
	private final CAService caService;
	private final CampusService campusService;
	private final EnrollmentService enrollmentService;
	
	private final static int DEFAULT_PAGE_SIZE = 10;
	
	
	/**
	 * Controller constructor. Service objects implementations should be marked with @Component
	 */
	@Inject
	public StaffController(ProgramService programService, MajorService majorService, 
			CourseService courseService, UserService userService, TermService termService,
			CAService courseAvailabilityService, CampusService campusService, 
			EnrollmentService enrollmentService) {
		this.programService = programService;
		this.majorService = majorService;
		this.courseService = courseService;
		this.userService = userService;
		this.termService = termService;
		this.caService = courseAvailabilityService;
		this.campusService = campusService;
		this.enrollmentService = enrollmentService;
	}	
	
	
	
	
	@RequestMapping(value = "/staff/home")
	public String staff() {
		return "staff/home";
	}
	
	
	// List handlers ---------------------------------------------
	/**
	 * Get all programs, add to session, set pagination and return program list view.
	 * Set parameters (page, pageSize) if not defined.
	 */
	@RequestMapping(value = "/staff/programlist")
	public ModelAndView listPrograms(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize, HttpSession session) {
		if (page == null) {
			page = 0;
		}
		
		PagedListHolder<Program> resultList = (PagedListHolder<Program>) session.getAttribute("StaffController_programList");
		if (resultList == null) {
			resultList = new PagedListHolder<Program>(programService.getAllPrograms());
			session.setAttribute("StaffController_programList", resultList);
			if (pageSize == null) {
				pageSize = DEFAULT_PAGE_SIZE;
			}
		}
		if (pageSize != null) {
			resultList.setPageSize(pageSize);
		}
		resultList.setPage(page);
		return new ModelAndView("staff/programlist", "resultList", resultList);
	} // listPrograms
	
	
	/**
	 * Get all majors, add to session, set pagination and return major list view.
	 * Set parameters (page, pageSize) if not defined.
	 */
	@RequestMapping(value = "/staff/majorlist")
	public ModelAndView listMajors(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize, HttpSession session) {
		if (page == null) {
			page = 0;
		}
		
		PagedListHolder<Major> resultList = (PagedListHolder<Major>) session.getAttribute("StaffController_majorList");
		if (resultList == null) {
			resultList = new PagedListHolder<Major>(majorService.getAllMajors());
			session.setAttribute("StaffController_majorList", resultList);
			if (pageSize == null) {
				pageSize = DEFAULT_PAGE_SIZE;
			}
		}
		if (pageSize != null) {
			resultList.setPageSize(pageSize);
		}
		resultList.setPage(page);
		return new ModelAndView("staff/majorlist", "resultList", resultList);
	} // listMajors
	
	
	/**
	 * Get all courses, add to session, set pagination and return course list view.
	 * Set parameters (page, pageSize) if not defined.
	 */
	@RequestMapping(value = "/staff/courselist")
	public ModelAndView listCourses(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize, HttpSession session) {
		if (page == null) {
			page = 0;
		}
		
		PagedListHolder<Course> resultList = (PagedListHolder<Course>) session.getAttribute("StaffController_courseList");
		if (resultList == null) {
			resultList = new PagedListHolder<Course>(courseService.getAllCourses());
			session.setAttribute("StaffController_courseList", resultList);
			if (pageSize == null) {
				pageSize = DEFAULT_PAGE_SIZE;
			}
		}
		if (pageSize != null) {
			resultList.setPageSize(pageSize);
		}
		resultList.setPage(page);
		return new ModelAndView("staff/courselist", "resultList", resultList);
	} // listCourses
	
	
	/**
	 * Get all Student users, add to session, set pagination and return student list view.
	 */
	@RequestMapping(value = "/staff/studentlist")
	public ModelAndView listStudents(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize, HttpSession session) {
		if (page == null) {
			page = 0;
		}
		
		// TODO add: limit students by managed campus
		PagedListHolder<Student> resultList = (PagedListHolder<Student>) session.getAttribute("StaffController_studentList");
		if (resultList == null) {
			resultList = new PagedListHolder<Student>(userService.getAllStudents());
			session.setAttribute("StaffController_studentList", resultList);
			if (pageSize == null) {
				pageSize = DEFAULT_PAGE_SIZE;
			}
		}
		if (pageSize != null) {
			resultList.setPageSize(pageSize);
		}
		resultList.setPage(page);
		return new ModelAndView("staff/studentlist", "resultList", resultList);
	} // listStudents
	
	
	/**
	 * Get all terms, add to session, set pagination and return term list view.
	 */
	@RequestMapping(value = "/staff/termlist")
	public ModelAndView listTerms(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize, HttpSession session) {
		if (page == null) {
			page = 0;
		}
		
		PagedListHolder<Term> resultList = (PagedListHolder<Term>) session.getAttribute("StaffController_termList");
		if (resultList == null) {
			resultList = new PagedListHolder<Term>(termService.getAllTerms());
			session.setAttribute("StaffController_termList", resultList);
			if (pageSize == null) {
				pageSize = DEFAULT_PAGE_SIZE;
			}
		}
		if (pageSize != null) {
			resultList.setPageSize(pageSize);
		}
		resultList.setPage(page);
		return new ModelAndView("staff/termlist", "resultList", resultList);
	} // listTerms
	
	
	/**
	 * Get all CourseAvailability objects (course schedule), add to session, set pagination and return CourseAvailability list view.
	 */
	@RequestMapping(value = "/staff/calist")
	public ModelAndView listCA(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize, HttpSession session) {
		if (page == null) {
			page = 0;
		}
		
		PagedListHolder<CourseAvailability> resultList = (PagedListHolder<CourseAvailability>) session.getAttribute("StaffController_CAList");
		if (resultList == null) {
			resultList = new PagedListHolder<CourseAvailability>(caService.getAllCAs());
			session.setAttribute("StaffController_CAList", resultList);
			if (pageSize == null) {
				pageSize = DEFAULT_PAGE_SIZE;
			}
		}
		if (pageSize != null) {
			resultList.setPageSize(pageSize);
		}
		resultList.setPage(page);
		return new ModelAndView("staff/calist", "resultList", resultList);
	} // listCA
	
	
	/**
	 * Get all Enrollments, add to session, set pagination and return enrollment list view.
	 * Set parameters (page, pageSize) if not defined.
	 */
	@RequestMapping(value = "/staff/enrollmentlist")
	public ModelAndView listEnrollments(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize, HttpSession session) {
		if (page == null) {
			page = 0;
		}
		
		PagedListHolder<Enrollment> resultList = (PagedListHolder<Enrollment>) session.getAttribute("StaffController_enrollmentList");
		if (resultList == null) {
			resultList = new PagedListHolder<Enrollment>(enrollmentService.getAllEnrollments());
			session.setAttribute("StaffController_enrollmentList", resultList);
			if (pageSize == null) {
				pageSize = DEFAULT_PAGE_SIZE;
			}
		}
		if (pageSize != null) {
			resultList.setPageSize(pageSize);
		}
		resultList.setPage(page);
		return new ModelAndView("staff/enrollmentlist", "resultList", resultList);
	} // listEnrollments
	
	
	
	
	
	
	
	// Edit / Create methods ----------------------------------------
	/**
	 * Redirect to Program Create page (form)
	 */
	@RequestMapping(value = "/staff/programcreate")
	public String redirectToProgramCreate(Model model) {
		Program program = new Program();
		model.addAttribute("program", program);
		return "staff/programcreate";
	}
	
	
	/**
	 * Redirect to Major Create page (form)
	 */
	@RequestMapping(value = "/staff/majorcreate")
	public String redirectToMajorCreate(Model model) {
		Major major = new Major();
		model.addAttribute("major", major);
		List<Program> programList = programService.getProgramsByStatus(true);
		model.addAttribute("programList", programList);
		return "staff/majorcreate";
	}
	
	
	/**
	 * Redirect to Course Create page (form)
	 */
	@RequestMapping(value = "/staff/coursecreate")
	public String redirectToCourseCreate(Model model) {
		Course course = new Course();
		model.addAttribute("course", course);
		return "staff/coursecreate";
	}
	
	
	/**
	 * Redirect to Student Create page (form)
	 */
	@RequestMapping(value = "/staff/studentcreate")
	public String redirectToStudentCreate(Model model) {
		Student studentUser = new Student();
		model.addAttribute("studentUser", studentUser);
		return "staff/studentcreate";
	}
	
	
	/**
	 * Redirect to Term Create page (form)
	 */
	@RequestMapping(value = "/staff/termcreate")
	public String redirectToTermCreate(Model model) {
		Term term = new Term();
		model.addAttribute("term", term);
		return "staff/termcreate";
	}
	
	
	/**
	 * Redirect to CourseAvailability Create page (form)
	 * Get all enabled campuses, term, and courses
	 */
	@RequestMapping(value = "/staff/cacreate")
	public String redirectToCACreate(Model model) {
		CourseAvailability ca = new CourseAvailability();
		model.addAttribute("ca", ca);
		List<Campus> campusList = campusService.getCampusesByStatus(true);
		model.addAttribute("campusList", campusList);
		List<Term> termList = termService.getTermsByStatus(true);
		model.addAttribute("termList", termList);
		List<Course> courseList = courseService.getCoursesByStatus(true);
		model.addAttribute("courseList", courseList);
		return "staff/cacreate";
	}
	
	
	/**
	 * Redirect to CourseAvailability Create page (form) - multiple course selection.
	 * Get all enabled campuses and term.
	 */
	@RequestMapping(value = "/staff/cacreatemultiple")
	public String redirectToCACreateMultiple(Model model) {
		List<Campus> campusList = campusService.getCampusesByStatus(true);
		model.addAttribute("campusList", campusList);
		List<Term> termList = termService.getTermsByStatus(true);
		model.addAttribute("termList", termList);
		return "staff/cacreatemultiple";
	}
	
	
	/**
	 * Redirect to CourseAvailability Create page (form) - multiple course selection.
	 * Get all enabled campuses and term.
	 */
	@RequestMapping(value = "/staff/addcacourses/{campusID}/{termID}")
	public ModelAndView createMultipleCAs(
			@PathVariable("campusID") Long campusID,
			@PathVariable("termID") Long termID, Long[] courseIDs, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("staff/calist");
		
		Campus campus = campusService.getCampusById(campusID);
		Term term = termService.getTermById(termID);
		
		StringBuilder infoMessage = caService.createMultipleCA(campus, term, courseIDs);
		modelAndView.addObject("infoMessage", infoMessage);
		
		PagedListHolder<CourseAvailability> resultList = new PagedListHolder<CourseAvailability>(caService.getAllCAs());
		modelAndView.addObject("resultList", resultList);
		session.setAttribute("StaffController_CAList", resultList);
		
		return modelAndView;
	}
	
	
	
	
	/**
	 * Redirect to Program Edit/Delete page (form) for program identified by code parameter.
	 * @param id - program ID
	 */
	@RequestMapping(value = "/staff/programedit/{id}")
	public String redirectToProgramEditDelete(@PathVariable("id") Long id, Model model) {
		Program program = (Program) programService.getProgramById(id);
		model.addAttribute("program", program);
		// TODO handle if program not found
		return "staff/programedit";
	}
	
	
	/**
	 * Redirect to Major Edit/Delete page (form) for major identified by code parameter
	 * Get list of all enabled programs to populate programs drop down list.
	 */
	@RequestMapping(value = "/staff/majoredit/{id}")
	public String redirectToMajorEditDelete(@PathVariable("id") Long id, Model model) {
		Major major = (Major) majorService.getMajorById(id);
		model.addAttribute("major", major);
		
		List<Program> programList = programService.getProgramsByStatus(true);
		model.addAttribute("programList", programList);
		// TODO handle if major not found
		return "staff/majoredit";
	}
	
	
	/**
	 * Redirect to Course Edit/Delete page (form) for course identified by code parameter
	 */
	@RequestMapping(value = "/staff/courseedit/{id}")
	public String redirectToCourseEditDelete(@PathVariable("id") Long id, Model model) {
		Course course = (Course) courseService.getCourseById(id);
		model.addAttribute("course", course);
		// TODO handle if course not found
		return "staff/courseedit";
	}
	
	
	/**
	 * Redirect to Student Edit/Delete page (form) for student identified by username parameter
	 */
	@RequestMapping(value = "/staff/studentedit/{username:.+}")
	public String redirectToStudentEditDelete(@PathVariable("username") String username, Model model) {
		Student studentUser = (Student) userService.getUserByUsername(username);
		model.addAttribute("studentUser", studentUser);
		// TODO handle if studentuser not found
		return "staff/studentedit";
	}
	
	
	/**
	 * Redirect to Term Edit/Delete page (form) for term identified by year and number parameters
	 */
	@RequestMapping(value = "/staff/termedit/{year}/{number}")
	public String redirectToTermEditDelete(@PathVariable("year") Integer year, @PathVariable("number") Integer number, Model model) {
		Term term = termService.getTermByYearAndNumber(year, number);
		model.addAttribute("term", term);
		// TODO handle if term not found
		return "staff/termedit";
	}
	
	
	/**
	 * Redirect to Major Edit/Delete page (form) for major identified by code parameter
	 * Get list of all enabled programs to populate programs drop down list.
	 */
	@RequestMapping(value = "/staff/caedit/{id}")
	public String redirectToCAEditDelete(@PathVariable("id") Long id, Model model) {
		CourseAvailability ca = caService.getCAById(id);
		model.addAttribute("ca", ca);
		
		List<Campus> campusList = campusService.getCampusesByStatus(true);
		model.addAttribute("campusList", campusList);
		List<Term> termList = termService.getTermsByStatus(true);
		model.addAttribute("termList", termList);
		List<Course> courseList = courseService.getCoursesByStatus(true);
		model.addAttribute("courseList", courseList);
		// TODO handle if ca not found
		return "staff/caedit";
	}
	
	
	
	/**
	 * Delete program by code. Update program list after deletion.
	 */
	@RequestMapping(value = "/staff/programdelete/{code:.+}")
	public ModelAndView deleteProgram(@PathVariable("code") String code, HttpSession session) {
		// TODO logic for delete program if not successful
		Program program = (Program) programService.getProgramByCode(code);
		programService.deleteProgram(program);
		ModelAndView modelAndView = new ModelAndView("staff/programlist");
		
		String infoMessage = "Program '" + program.getTitle() + "' deleted successfully.";
		modelAndView.addObject("infoMessage", infoMessage);
		
		PagedListHolder<Program> resultList = new PagedListHolder<Program>(programService.getAllPrograms());
		modelAndView.addObject("resultList", resultList);
		session.setAttribute("StaffController_programList", resultList);
		
		return modelAndView;
	} // deleteProgram
	
	
	/**
	 * Delete major by code. Update major list after deletion.
	 */
	@RequestMapping(value = "/staff/majordelete/{code:.+}")
	public ModelAndView deleteMajor(@PathVariable("code") String code, HttpSession session) {
		// TODO logic for delete major if not successful
		Major major = (Major) majorService.getMajorByCode(code);
		majorService.delete(major);
		ModelAndView modelAndView = new ModelAndView("staff/majorlist");
		
		String infoMessage = "Major '" + major.getTitle() + "' deleted successfully.";
		modelAndView.addObject("infoMessage", infoMessage);
		
		PagedListHolder<Major> resultList = new PagedListHolder<Major>(majorService.getAllMajors());
		modelAndView.addObject("resultList", resultList);
		session.setAttribute("StaffController_majorList", resultList);
		
		return modelAndView;
	} // deleteMajor
	
	
	/**
	 * Delete course by code. Update course list after deletion.
	 */
	@RequestMapping(value = "/staff/coursedelete/{code:.+}")
	public ModelAndView deleteCourse(@PathVariable("code") String code, HttpSession session) {
		// TODO logic for delete course if not successful
		Course course = (Course) courseService.getCourseByCode(code);
		courseService.delete(course);
		ModelAndView modelAndView = new ModelAndView("staff/courselist");
		
		String infoMessage = "Course '" + course.getTitle() + "' deleted successfully.";
		modelAndView.addObject("infoMessage", infoMessage);
		
		PagedListHolder<Course> resultList = new PagedListHolder<Course>(courseService.getAllCourses());
		modelAndView.addObject("resultList", resultList);
		session.setAttribute("StaffController_courseList", resultList);
		
		return modelAndView;
	} // deleteCourse
	
	
	/**
	 * Delete student user by username. Update student list after deletion.
	 */
	@RequestMapping(value = "/staff/studentdelete/{username:.+}")
	public ModelAndView deleteStudent(@PathVariable("username") String username, HttpSession session) {
		// TODO logic for delete student if not successful
		userService.delete(username);
		ModelAndView modelAndView = new ModelAndView("staff/studentlist");
		
		String infoMessage = "Student user '" + username + "' deleted successfully.";
		modelAndView.addObject("infoMessage", infoMessage);
		
		PagedListHolder<Student> resultList = new PagedListHolder<Student>(userService.getAllStudents());
		modelAndView.addObject("resultList", resultList);
		session.setAttribute("StaffController_studentList", resultList);
		
		return modelAndView;
	}
	
	
	/**
	 * Delete term by year and number. Update term list after deletion.
	 */
	@RequestMapping(value = "/staff/termdelete/{year}/{number}")
	public ModelAndView deleteTerm(@PathVariable("year") Integer year, @PathVariable("number") Integer number, HttpSession session) {
		// TODO logic for delete term if not successful
		Term term = termService.getTermByYearAndNumber(year, number);
		termService.delete(term);
		ModelAndView modelAndView = new ModelAndView("staff/termlist");
		
		String infoMessage = "Term " + term.getNumber() + " " + term.getYear() + " deleted successfully.";
		modelAndView.addObject("infoMessage", infoMessage);
		
		PagedListHolder<Term> resultList = new PagedListHolder<Term>(termService.getAllTerms());
		modelAndView.addObject("resultList", resultList);
		session.setAttribute("StaffController_termList", resultList);
		
		return modelAndView;
	}
	
	
	/**
	 * Delete CourseAvailability by id. Update CourseAvailability list after deletion.
	 */
	@RequestMapping(value = "/staff/cadelete/{id}")
	public ModelAndView deleteCA(@PathVariable("id") Long id, HttpSession session) {
		// TODO logic for delete CourseAvailability if not successful
		CourseAvailability ca = caService.getCAById(id);
		caService.delete(ca);
		ModelAndView modelAndView = new ModelAndView("staff/calist");
		
		String infoMessage = "Course '" + ca.getCourse().getTitle() + "' successfully removed from the schedule term "
			+ ca.getTerm().getNumber() + " " + ca.getTerm().getYear() + ", " + ca.getCampus().getTitle() + " campus.";
		modelAndView.addObject("infoMessage", infoMessage);
		
		PagedListHolder<CourseAvailability> resultList = new PagedListHolder<CourseAvailability>(caService.getAllCAs());
		modelAndView.addObject("resultList", resultList);
		session.setAttribute("StaffController_CAList", resultList);
		
		return modelAndView;
	}
	
	
	
	/**
	 * Updates/creates program. If program updated/created successfully then update program list and display info message.
	 * If update/create was not successful then redirect back to the edit/create page and display error message.
	 */
	@RequestMapping(value = "/staff/programupdate", method = RequestMethod.POST)
	public ModelAndView saveProgram(@ModelAttribute Program program, HttpSession session) {
		ModelAndView modelAndView;
		try {
			if (program.getId() != null) {
				Program existingProgram = (Program) programService.getProgramById(program.getId());
				program.setCoreCourses(existingProgram.getCoreCourses());
				program.setElectiveCourses(existingProgram.getElectiveCourses());
			}
			
			programService.save(program);
			
			modelAndView = new ModelAndView("staff/programedit");
			modelAndView.addObject("program", program);
			
			String infoMessage = "Program '" + program.getTitle() + "' saved successfully.";
			modelAndView.addObject("infoMessage", infoMessage);
			
			PagedListHolder<Program> resultList = new PagedListHolder<Program>(programService.getAllPrograms());
			modelAndView.addObject("resultList", resultList);
			session.setAttribute("StaffController_programList", resultList);
		} catch (CustomServiceException ex) {
			if (program.getId() == null) {
				modelAndView = new ModelAndView("staff/programcreate");
			} else {
				modelAndView = new ModelAndView("staff/programedit");
			}
			modelAndView.addObject("program", program);
			modelAndView.addObject("errorMessage", ex.getErrorMsg());
		}
		
		return modelAndView;
	} // saveProgram
	
	
	/**
	 * Updates/creates major. If major updated/created successfully then update major list and display info message.
	 * If update/create was not successful then redirect back to the edit/create page and display error message.
	 */
	@RequestMapping(value = "/staff/majorupdate", method = RequestMethod.POST)
	public ModelAndView saveMajor(@ModelAttribute Major major, @RequestParam(required = false) String action, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (major.getId() != null) {
				Major existingMajor = (Major) majorService.getMajorById(major.getId());
				major.setCompulsoryCourses(existingMajor.getCompulsoryCourses());
			}
			
			Program program = programService.getProgramByCode(major.getProgram().getCode());
			major.setProgram(program);
			majorService.save(major);
			
			modelAndView = new ModelAndView("staff/majoredit");
			modelAndView.addObject("major", major);
				
			String infoMessage = "Major '" + major.getTitle() + "' saved successfully.";
			modelAndView.addObject("infoMessage", infoMessage);
			
			PagedListHolder<Major> resultList = new PagedListHolder<Major>(majorService.getAllMajors());
			modelAndView.addObject("resultList", resultList);
			session.setAttribute("StaffController_majorList", resultList);
		} catch (CustomServiceException ex) {
			if (major.getId() == null) {
				modelAndView = new ModelAndView("staff/majorcreate");
			} else {
				modelAndView = new ModelAndView("staff/majoredit");
			}
			modelAndView.addObject("major", major);
			modelAndView.addObject("errorMessage", ex.getErrorMsg());
			List<Program> programList = programService.getProgramsByStatus(true);
			modelAndView.addObject("programList", programList);
		}
		
		return modelAndView;
	} // saveMajor
	
	
	/**
	 * Updates/creates course. If course updated/created successfully then refresh course list and display info message.
	 * If update/create was not successful then redirect back to the edit/create page and display error message.
	 * @param course - course details from the form. It doesn't capture prerequisites so if the course is not new
	 * (id != null) then method should set its prerequisites first.
	 */
	@RequestMapping(value = "/staff/courseupdate", method = RequestMethod.POST)
	public ModelAndView saveCourse(@ModelAttribute Course course, HttpSession session) {
		ModelAndView modelAndView;
		try {
			if (course.getId() != null) {
				Course existingCourse = (Course) courseService.getCourseById(course.getId());
				course.setPrerequisites(existingCourse.getPrerequisites());
			}
			
			courseService.save(course);
			
			modelAndView = new ModelAndView("staff/courseedit");
			modelAndView.addObject("course", course);
			
			String infoMessage = "Course '" + course.getTitle() + "' saved successfully.";
			modelAndView.addObject("infoMessage", infoMessage);
			
			PagedListHolder<Course> resultList = new PagedListHolder<Course>(courseService.getAllCourses());
			modelAndView.addObject("resultList", resultList);
			session.setAttribute("StaffController_courseList", resultList);
		} catch (CustomServiceException ex) {
			if (course.getId() == null) {
				modelAndView = new ModelAndView("staff/coursecreate");
			} else {
				modelAndView = new ModelAndView("staff/courseedit");
			}
			modelAndView.addObject("course", course);
			modelAndView.addObject("errorMessage", ex.getErrorMsg());
		}
		
		return modelAndView;
	} // saveCourse
	
	
	/**
	 * Updates/creates student user. If student user updated/created successfully then open student user list (also refresh it).
	 * If update/create was not successful then redirect back to the edit/create page and display error message.
	 */
	@RequestMapping(value = "/staff/studentupdate", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute Student studentUser, HttpSession session) {
		ModelAndView modelAndView;
		try {
			userService.save(studentUser);
			
			modelAndView = new ModelAndView("staff/studentlist");
			String infoMessage = "Student user '" + studentUser.getUsername() + "' saved successfully.";
			modelAndView.addObject("infoMessage", infoMessage);
			
			PagedListHolder<Student> resultList = new PagedListHolder<Student>(userService.getAllStudents());
			modelAndView.addObject("resultList", resultList);
			session.setAttribute("StaffController_studentList", resultList);
		} catch (CustomServiceException ex) {
			if (studentUser.getId() == null) {
				modelAndView = new ModelAndView("staff/studentcreate");
			} else {
				modelAndView = new ModelAndView("staff/studentedit");
			}
			modelAndView.addObject("studentUser", studentUser);
			modelAndView.addObject("errorMessage", ex.getErrorMsg());
		}
		
		return modelAndView;
	}
	
	
	/**
	 * Updates/creates term. If term updated/created successfully then open term list (also refresh it).
	 * If update/create was not successful then redirect back to the edit/create page and display error message.
	 * This method uses @RequestParam instead of @ModelAttribute to parse dates from strings individually.
	 */
	@RequestMapping(value = "/staff/termupdate", method = RequestMethod.POST)
	//public ModelAndView updateTerm(@ModelAttribute Term term, HttpSession session) {
	public ModelAndView saveTerm(
			@RequestParam(required = false) Long id,
			@RequestParam Integer year,
			@RequestParam Integer number,
			@RequestParam String startDate,
			@RequestParam String finishDate,
			@RequestParam(required = false) Byte enabled,
			HttpSession session) {
		
		ModelAndView modelAndView = new ModelAndView();
		Term term = new Term();
		term.setId(id);
		term.setYear(year);
		term.setNumber(number);
		term.setEnabled(enabled);
		
		try {
			Date start = new Date(new SimpleDateFormat("dd-MM-yyyy").parse(startDate).getTime());
			Date finish = new Date(new SimpleDateFormat("dd-MM-yyyy").parse(finishDate).getTime());
			
			term.setStartDate(start);
			term.setFinishDate(finish);
			
			//System.out.println("startDate: " + startDate + ", finishDate: " + finishDate);
			termService.save(term);
			
			modelAndView.setViewName("staff/termlist");
			String infoMessage = "Term " + term.getNumber() + " " + term.getYear() + " saved successfully.";
			modelAndView.addObject("infoMessage", infoMessage);
			
			PagedListHolder<Term> resultList = new PagedListHolder<Term>(termService.getAllTerms());
			modelAndView.addObject("resultList", resultList);
			session.setAttribute("StaffController_termList", resultList);
		} catch (CustomServiceException ex) {
			if (id == null) {
				modelAndView.setViewName("staff/termcreate");
			} else {
				modelAndView.setViewName("staff/termedit");
			}
			modelAndView.addObject("term", term);
			modelAndView.addObject("errorMessage", ex.getErrorMsg());
		} catch (ParseException e) {
			if (id == null) {
				modelAndView.setViewName("staff/termcreate");
			} else {
				modelAndView.setViewName("staff/termedit");
			}
			modelAndView.addObject("term", term);
			modelAndView.addObject("errorMessage", "Error parsing start or finish date. Please enter correct date.");
		}
		
		return modelAndView;
	} // saveTerm
	
	
	/**
	 * Updates/creates CourseAvailability object. If CourseAvailability updated/created successfully then open CourseAvailability list (also refresh it).
	 * If update/create was not successful then redirect back to the edit/create page and display error message.
	 */
	@RequestMapping(value = "/staff/caupdate", method = RequestMethod.POST)
	public ModelAndView saveCA(@ModelAttribute CourseAvailability ca, HttpSession session) {
		ModelAndView modelAndView;
		try {
			Campus campus = campusService.getCampusByCode(ca.getCampus().getCode());
			ca.setCampus(campus);
			
			Term term = termService.getTermById(ca.getTerm().getId());
			ca.setTerm(term);
			
			Course course = courseService.getCourseByCode(ca.getCourse().getCode());
			ca.setCourse(course);
			
			caService.save(ca);
			
			modelAndView = new ModelAndView("staff/calist");
			String infoMessage = "Course '" + course.getTitle() + "' scheduled successfully for term " + term.getNumber()
				+ " " + term.getYear() + " in " + campus.getTitle() + " campus.";
			modelAndView.addObject("infoMessage", infoMessage);
			
			PagedListHolder<CourseAvailability> resultList = new PagedListHolder<CourseAvailability>(caService.getAllCAs());
			modelAndView.addObject("resultList", resultList);
			session.setAttribute("StaffController_CAList", resultList);
		} catch (CustomServiceException ex) {
			if (ca.getId() == null) {
				modelAndView = new ModelAndView("staff/cacreate");
			} else {
				modelAndView = new ModelAndView("staff/caedit");
			}
			modelAndView.addObject("ca", ca);
			modelAndView.addObject("errorMessage", ex.getErrorMsg());
			List<Campus> campusList = campusService.getCampusesByStatus(true);
			modelAndView.addObject("campusList", campusList);
			List<Term> termList = termService.getTermsByStatus(true);
			modelAndView.addObject("termList", termList);
			List<Course> courseList = courseService.getCoursesByStatus(true);
			modelAndView.addObject("courseList", courseList);
		}
		
		return modelAndView;
	} // saveCA
	
	
	/**
	 * Creates multiple CourseAvailability objects. If CourseAvailability updated/created successfully 
	 * then open CourseAvailability list (also refresh it).
	 * If update/create was not successful then redirect back to the create page and display error message.
	 */
	@RequestMapping(value = "/staff/caupdatemultiple", method = RequestMethod.POST)
	public ModelAndView saveCAMultiple(@RequestParam(required = false) Long campusid, HttpSession session) {
		return null;
	}
	
	
	
	
	// ------------------------------------------------------------------------------------------
	// Actions with courses, e.g. add/remove prerequisites, core, elective, compulsory courses
	// ------------------------------------------------------------------------------------------
	/**
	 * Use service object to get all courses that can be added as prerequisites to the given 
	 * course (by id), add to session, set pagination and return course list view.
	 * Set parameters (page, pageSize) if not defined.
	 * Add action type attribute = "addPrerequisites" to the model.
	 * @param courseID - given course id
	 */
	@RequestMapping(value = "/staff/prerequisitelist/{id}")
	public ModelAndView listPrerequisits(@PathVariable("id") Long courseID,	@RequestParam(required = false) Integer page, 
			@RequestParam(required = false) Integer pageSize, HttpSession session) {
		
		PagedListHolder<Course> resultList = (PagedListHolder<Course>) session.getAttribute("StaffController_prerequisiteList");
		
		if ((page == null && pageSize == null) || resultList == null) {	// first request (not page navigation) - get prerequisites from service
			resultList = new PagedListHolder<Course>(courseService.getAvailablePrerequisites(courseID));
			session.setAttribute("StaffController_prerequisiteList", resultList);
			if (pageSize == null) {
				pageSize = DEFAULT_PAGE_SIZE;
			}
		}
		if (page == null) {
			page = 0;
		}
		resultList.setPage(page);
		if (pageSize != null) {
			resultList.setPageSize(pageSize);
		}
		
		ModelAndView modelAndView = new ModelAndView("staff/courseselectlist", "resultList", resultList);
		modelAndView.addObject("courseID", courseID);
		modelAndView.addObject("actionType", "addPrerequisites");
		
		return modelAndView;
	} // listCourses
	
	
	/**
	 * Handle 'Remove Selected' prerequisites button for batch delete courses from prerequisites list.
	 * Calls service object's removePrerequisites() method and redirects back to Edit page.
	 * @param courseID - given course ID
	 * @param prerequisiteIDs - array of course IDs to remove from prerequisites
	 */
	@RequestMapping(value = "/staff/removeprerequisites/{id}", method = RequestMethod.POST)
	public ModelAndView removePrerequisites(@PathVariable("id") Long courseID, Long[] prerequisiteIDs) {
		ModelAndView modelAndView = new ModelAndView("staff/courseedit");
		try {
			courseService.removePrerequisites(courseID, prerequisiteIDs);
			String infoMessage = "Course prerequisites updated successfully.";
			modelAndView.addObject("infoMessage", infoMessage);
		} catch (CustomServiceException ex) {
			modelAndView.addObject("errorMessage", ex.getErrorMsg());
		}
		Course course = courseService.getCourseById(courseID);
		modelAndView.addObject("course", course);
		
		return modelAndView;
	}
	
	
	/**
	 * Handle 'Add Selected' prerequisites button for batch add courses to prerequisites list.
	 * Calls service object's addPrerequisites() method and redirects back to Edit page.
	 * This can be invoked by form submission OR a link, therefore request method is GET.
	 * @param courseID - given course ID
	 * @param courseIDs - array of course IDs to add to prerequisites
	 */
	@RequestMapping(value = "/staff/addprerequisites/{id}", method = RequestMethod.GET)
	public ModelAndView addPrerequisites(@PathVariable("id") Long courseID, Long[] courseIDs) {
		ModelAndView modelAndView = new ModelAndView("staff/courseedit");
		try {
			courseService.addPrerequisites(courseID, courseIDs);
			String infoMessage = "Course prerequisites updated successfully.";
			modelAndView.addObject("infoMessage", infoMessage);
		} catch (CustomServiceException ex) {
			modelAndView.addObject("errorMessage", ex.getErrorMsg());
		}
		Course course = courseService.getCourseById(courseID);
		modelAndView.addObject("course", course);
		
		return modelAndView;
	}
	
	
	// -- Major Compulsory Courses ------------------------------------------------------------------
	/**
	 * Use service object to get all courses that can be added as compulsory courses to the given 
	 * major (by id), add to session, set pagination and return course list view.
	 * Set parameters (page, pageSize) if not defined.
	 * Add action type attribute = "addCompulsoryCourses" to the model.
	 * @param majorID - given major ID
	 */
	@RequestMapping(value = "/staff/compulsorycourseslist/{id}")
	public ModelAndView listCompulsoryCourses(@PathVariable("id") Long majorID,	@RequestParam(required = false) Integer page, 
			@RequestParam(required = false) Integer pageSize, HttpSession session) {
		
		PagedListHolder<Course> resultList = (PagedListHolder<Course>) session.getAttribute("StaffController_compulsoryCoursesList");
		
		if ((page == null && pageSize == null) || resultList == null) {	// first request (not page navigation) - get prerequisites from service
			page = 0;
			resultList = new PagedListHolder<Course>(majorService.getAvailableCompulsoryCourses(majorID));
			session.setAttribute("StaffController_compulsoryCoursesList", resultList);
			if (pageSize == null) {
				pageSize = DEFAULT_PAGE_SIZE;
			}
		}
		if (page == null) {
			page = 0;
		}
		resultList.setPage(page);
		if (pageSize != null) {
			resultList.setPageSize(pageSize);
		}
		
		ModelAndView modelAndView = new ModelAndView("staff/courseselectlist", "resultList", resultList);
		modelAndView.addObject("majorID", majorID);
		modelAndView.addObject("actionType", "addCompulsoryCourses");
		
		return modelAndView;
	}
	
	
	/**
	 * Handle 'Remove Selected' Compulsory Courses button for batch delete courses from Compulsory Courses list.
	 * Calls service object's removeCompulsoryCourses() method and redirects back to Edit page.
	 * @param majorID - given major ID
	 * @param courseIDs - array of course IDs to remove from major's compulsory courses
	 */
	@RequestMapping(value = "/staff/removecompulsorycourses/{id}", method = RequestMethod.POST)
	public ModelAndView removeCompulsoryCourses(@PathVariable("id") Long majorID, Long[] courseIDs) {
		ModelAndView modelAndView = new ModelAndView("staff/majoredit");
		try {
			majorService.removeCompulsoryCourses(majorID, courseIDs);
			String infoMessage = "Compulsory courses updated successfully.";
			modelAndView.addObject("infoMessage", infoMessage);
		} catch (CustomServiceException ex) {
			modelAndView.addObject("errorMessage", ex.getErrorMsg());
		}
		Major major = majorService.getMajorById(majorID);
		modelAndView.addObject("major", major);
		List<Program> programList = programService.getProgramsByStatus(true);
		modelAndView.addObject("programList", programList);
		
		return modelAndView;
	}
	
	
	/**
	 * Handle 'Add Selected' courses button for batch add courses to compulsory courses list.
	 * Calls service object's addCompulsoryCourses() method and redirects back to Edit page.
	 * This can be invoked by form submission OR a link, therefore request method is GET.
	 */
	@RequestMapping(value = "/staff/addcompulsorycourses/{id}", method = RequestMethod.GET)
	public ModelAndView addCompulsoryCourses(@PathVariable("id") Long majorID, Long[] courseIDs) {
		ModelAndView modelAndView = new ModelAndView("staff/majoredit");
		try {
			majorService.addCompulsoryCourses(majorID, courseIDs);
			String infoMessage = "Compulsory courses updated successfully.";
			modelAndView.addObject("infoMessage", infoMessage);
		} catch (CustomServiceException ex) {
			modelAndView.addObject("errorMessage", ex.getErrorMsg());
		}
		Major major = majorService.getMajorById(majorID);
		modelAndView.addObject("major", major);
		List<Program> programList = programService.getProgramsByStatus(true);
		modelAndView.addObject("programList", programList);
		
		return modelAndView;
	}
	
	
	// -- Program Core Courses ----------------------------------------------------------------------
	/**
	 * Use service object to get all courses that can be added as core courses to the given 
	 * program (by id), add to session, set pagination and return course list view.
	 * Set parameters (page, pageSize) if not defined.
	 * Add action type attribute = "addCoreCourses" to the model.
	 * @param programID - given program ID
	 */
	@RequestMapping(value = "/staff/corecourseslist/{id}")
	public ModelAndView listCoreCourses(@PathVariable("id") Long programID,	@RequestParam(required = false) Integer page, 
			@RequestParam(required = false) Integer pageSize, HttpSession session) {
		
		PagedListHolder<Course> resultList = (PagedListHolder<Course>) session.getAttribute("StaffController_coreCoursesList");
		
		if ((page == null && pageSize == null) || resultList == null) {	// first request (not page navigation) - get prerequisites from service
			page = 0;
			resultList = new PagedListHolder<Course>(programService.getAvailableCoreCourses(programID));
			session.setAttribute("StaffController_coreCoursesList", resultList);
			if (pageSize == null) {
				pageSize = DEFAULT_PAGE_SIZE;
			}
		}
		if (page == null) {
			page = 0;
		}
		resultList.setPage(page);
		if (pageSize != null) {
			resultList.setPageSize(pageSize);
		}
		
		ModelAndView modelAndView = new ModelAndView("staff/courseselectlist", "resultList", resultList);
		modelAndView.addObject("programID", programID);
		modelAndView.addObject("actionType", "addCoreCourses");
		
		return modelAndView;
	}
	
	
	/**
	 * Handle 'Remove Selected' Core Courses button for batch delete courses from Core Courses list.
	 * Calls service object's removeCoreCourses() method and redirects back to Edit page.
	 * @param programID - given program ID
	 * @param courseIDs - array of course IDs to remove from program's core courses
	 */
	@RequestMapping(value = "/staff/removecorecourses/{id}", method = RequestMethod.POST)
	public ModelAndView removeCoreCourses(@PathVariable("id") Long programID, Long[] courseIDs) {
		ModelAndView modelAndView = new ModelAndView("staff/programedit");
		try {
			programService.removeCoreCourses(programID, courseIDs);
			String infoMessage = "Core courses updated successfully.";
			modelAndView.addObject("infoMessage", infoMessage);
		} catch (CustomServiceException ex) {
			modelAndView.addObject("errorMessage", ex.getErrorMsg());
		}
		Program program = programService.getProgramById(programID);
		modelAndView.addObject("program", program);
		
		return modelAndView;
	}
	
	
	/**
	 * Handle 'Add Selected' courses button for batch add courses to core courses list.
	 * Calls service object's addCoreCourses() method and redirects back to Edit page.
	 * This can be invoked by form submission OR a link, therefore request method is GET.
	 */
	@RequestMapping(value = "/staff/addcorecourses/{id}", method = RequestMethod.GET)
	public ModelAndView addCoreCourses(@PathVariable("id") Long programID, Long[] courseIDs) {
		ModelAndView modelAndView = new ModelAndView("staff/programedit");
		try {
			programService.addCoreCourses(programID, courseIDs);
			String infoMessage = "Core courses updated successfully.";
			modelAndView.addObject("infoMessage", infoMessage);
		} catch (CustomServiceException ex) {
			modelAndView.addObject("errorMessage", ex.getErrorMsg());
		}
		Program program = programService.getProgramById(programID);
		modelAndView.addObject("program", program);
		
		return modelAndView;
	}
	
	
	// -- Program Elective Courses ------------------------------------------------------------------
	/**
	 * Use service object to get all courses that can be added as elective courses to the given 
	 * program (by id), add to session, set pagination and return course list view.
	 * Set parameters (page, pageSize) if not defined.
	 * Add action type attribute = "addElectiveCourses" to the model.
	 * @param programID - given program ID
	 */
	@RequestMapping(value = "/staff/electivecourseslist/{id}")
	public ModelAndView listElectiveCourses(@PathVariable("id") Long programID,	@RequestParam(required = false) Integer page, 
			@RequestParam(required = false) Integer pageSize, HttpSession session) {
		
		PagedListHolder<Course> resultList = (PagedListHolder<Course>) session.getAttribute("StaffController_electiveCoursesList");
		
		if ((page == null && pageSize == null) || resultList == null) {	// first request (not page navigation) - get prerequisites from service
			page = 0;
			resultList = new PagedListHolder<Course>(programService.getAvailableElectiveCourses(programID));
			session.setAttribute("StaffController_electiveCoursesList", resultList);
			if (pageSize == null) {
				pageSize = DEFAULT_PAGE_SIZE;
			}
		}
		if (page == null) {
			page = 0;
		}
		resultList.setPage(page);
		if (pageSize != null) {
			resultList.setPageSize(pageSize);
		}
		
		ModelAndView modelAndView = new ModelAndView("staff/courseselectlist", "resultList", resultList);
		modelAndView.addObject("programID", programID);
		modelAndView.addObject("actionType", "addElectiveCourses");
		
		return modelAndView;
	}
	
	
	/**
	 * Handle 'Remove Selected' Elective Courses button for batch delete courses from Elective Courses list.
	 * Calls service object's removeElectiveCourses() method and redirects back to Edit page.
	 * @param programID - given program ID
	 * @param courseIDs - array of course IDs to remove from program's elective courses
	 */
	@RequestMapping(value = "/staff/removeelectivecourses/{id}", method = RequestMethod.POST)
	public ModelAndView removeElectiveCourses(@PathVariable("id") Long programID, Long[] courseIDs) {
		ModelAndView modelAndView = new ModelAndView("staff/programedit");
		try {
			programService.removeElectiveCourses(programID, courseIDs);
			String infoMessage = "Elective courses updated successfully.";
			modelAndView.addObject("infoMessage", infoMessage);
		} catch (CustomServiceException ex) {
			modelAndView.addObject("errorMessage", ex.getErrorMsg());
		}
		Program program = programService.getProgramById(programID);
		modelAndView.addObject("program", program);
		
		return modelAndView;
	}
	
	
	/**
	 * Handle 'Add Selected' courses button for batch add courses to elective courses list.
	 * Calls service object's addElectiveCourses() method and redirects back to Edit page.
	 * This can be invoked by form submission OR a link, therefore request method is GET.
	 */
	@RequestMapping(value = "/staff/addelectivecourses/{id}", method = RequestMethod.GET)
	public ModelAndView addElectiveCourses(@PathVariable("id") Long programID, Long[] courseIDs) {
		ModelAndView modelAndView = new ModelAndView("staff/programedit");
		try {
			programService.addElectiveCourses(programID, courseIDs);
			String infoMessage = "Elective courses updated successfully.";
			modelAndView.addObject("infoMessage", infoMessage);
		} catch (CustomServiceException ex) {
			modelAndView.addObject("errorMessage", ex.getErrorMsg());
		}
		Program program = programService.getProgramById(programID);
		modelAndView.addObject("program", program);
		
		return modelAndView;
	}
	
	
	
	
	
	/**
	 * Use service object to get all courses that can be added to the schedule (courseAvailability)
	 * found by given campus and term, add to session, set pagination and return course list view.
	 * Set parameters (page, pageSize) if not defined.
	 * Add action type attribute = "addCACourses" to the model.
	 * 
	 * @param campusID - given campus ID
	 * @param termID - given term ID
	 */
	@RequestMapping(value = "/staff/cacourselist")
	public ModelAndView listCACourses(@RequestParam(required = true) Long campusID,	
			@RequestParam(required = true) Long termID,	
			@RequestParam(required = false) Integer page, 
			@RequestParam(required = false) Integer pageSize, HttpSession session) {
		
		PagedListHolder<Course> resultList = (PagedListHolder<Course>) session.getAttribute("StaffController_CACoursesList");
		
		if ((page == null && pageSize == null) || resultList == null) {	// first request (not page navigation) - get prerequisites from service
			page = 0;
			resultList = new PagedListHolder<Course>(caService.getAvailableCACourses(campusID, termID));
			session.setAttribute("StaffController_CACoursesList", resultList);
			if (pageSize == null) {
				pageSize = DEFAULT_PAGE_SIZE;
			}
		}
		if (page == null) {
			page = 0;
		}
		resultList.setPage(page);
		if (pageSize != null) {
			resultList.setPageSize(pageSize);
		}
		
		ModelAndView modelAndView = new ModelAndView("staff/courseselectlist", "resultList", resultList);
		modelAndView.addObject("campusID", campusID);
		modelAndView.addObject("termID", termID);
		modelAndView.addObject("actionType", "addCACourses");
		
		return modelAndView;
	}
	
}