package com.jstudyplanner.web;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jstudyplanner.domain.Course;
import com.jstudyplanner.service.CourseService;

@Controller
public class CourseController {
	
	private final CourseService courseService;
	private final static int DEFAULT_PAGE_SIZE = 10;
	
	/**
	 * Controller constructor.
	 * ProgramService implementation should be marked with @Component
	 * @param programService 
	 */
	@Inject
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	
	/**
	 * Get all Courses, add to session, set pagination and return courses view.
	 * Set parameters (page, pageSize) if not defined.
	 */
	@RequestMapping(value = "/courses/list", method = RequestMethod.GET)
	public ModelAndView listCourses(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize, HttpSession session) {
		if (page == null) {
			page = 0;
		}
		
		PagedListHolder<Course> resultList = (PagedListHolder<Course>) session.getAttribute("CourseController_resultList");
		if (resultList == null) {
			resultList = new PagedListHolder<Course>(courseService.getAllCourses());
			session.setAttribute("CourseController_resultList", resultList);
			if (pageSize == null) {
				pageSize = DEFAULT_PAGE_SIZE;
			}
		}
		if (pageSize != null) {
			resultList.setPageSize(pageSize);
		}
		resultList.setPage(page);
		return new ModelAndView("courses/list", "resultList", resultList);
	} // listCourses
	
	
	/**
	 * Get course details and return details view.
	 * @param code
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/courses/{code:.+}", method = RequestMethod.GET)
	public String getMajorDetails(@PathVariable("code") String code, Model model) {
		model.addAttribute(courseService.getCourseByCode(code));
		return "courses/details";
	}
}