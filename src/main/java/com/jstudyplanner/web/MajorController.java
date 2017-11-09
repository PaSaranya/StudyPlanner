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

import com.jstudyplanner.domain.Major;
import com.jstudyplanner.service.MajorService;

@Controller
public class MajorController {
	
	private final MajorService majorService;
	private final static int DEFAULT_PAGE_SIZE = 10;
	
	/**
	 * Controller constructor.
	 * MajorService implementation should be marked with @Component
	 * @param majorService
	 */
	@Inject
	public MajorController(MajorService majorService) {
		this.majorService = majorService;
	}
	

	/**
	 * Get all Majors, add to session, set pagination and return majors view.
	 * Set parameters (page, pageSize) if not defined.
	 */
	@RequestMapping(value = "/majors/list", method = RequestMethod.GET)
	public ModelAndView listMajors(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize, HttpSession session) {
		if (page == null) {
			page = 0;
		}
		
		PagedListHolder<Major> resultList = (PagedListHolder<Major>) session.getAttribute("MajorController_resultList");
		if (resultList == null) {
			resultList = new PagedListHolder<Major>(majorService.getAllMajors());
			session.setAttribute("MajorController_resultList", resultList);
			if (pageSize == null) {
				pageSize = DEFAULT_PAGE_SIZE;
			}
		}
		if (pageSize != null) {
			resultList.setPageSize(pageSize);
		}
		resultList.setPage(page);
		return new ModelAndView("majors/list", "resultList", resultList);
	} // listMajors
	
	/**
	 * Get major details and return details view.
	 * @param code
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/majors/{code:.+}", method = RequestMethod.GET)
	public String getMajorDetails(@PathVariable("code") String code, Model model) {
		model.addAttribute(majorService.getMajorByCode(code));
		return "majors/details";
	}
}