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

import com.jstudyplanner.domain.Campus;
import com.jstudyplanner.service.CampusService;

@Controller
public class CampusController {
	
	private final CampusService campusService;
	private final static int DEFAULT_PAGE_SIZE = 10;
	
	/**
	 * CampusService implementation should be marked with @Component
	 * @param campusService
	 */
	@Inject
	public CampusController(CampusService campusService) {
		this.campusService = campusService;
	}
	
	/**
	 * Get all Campuses, add to session, set pagination and return campus view.
	 * Set parameters (page, pageSize) if not defined.
	 */
	@RequestMapping(value = "/campuses/list", method = RequestMethod.GET)
	public ModelAndView listCampuses(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize, HttpSession session) {
		if (page == null) {
			page = 0;
		}
		// get enabled campuses instead of getAllCampuses
		PagedListHolder<Campus> resultList = (PagedListHolder<Campus>) session.getAttribute("CampusController_resultList");
		if (resultList == null) {
			resultList = new PagedListHolder<Campus>(campusService.getAllCampuses());
			session.setAttribute("CampusController_resultList", resultList);
			if (pageSize == null) {
				pageSize = DEFAULT_PAGE_SIZE;
			}
		}
		if (pageSize != null) {
			resultList.setPageSize(pageSize);
		}
		resultList.setPage(page);
		return new ModelAndView("campuses/list", "resultList", resultList);
	} // listCampuses
	
	/**
	 * Get campus details and return details view.
	 * @param code campus code
	 * @param model
	 * @return details view
	 */
	@RequestMapping(value = "/campuses/{code:.+}", method = RequestMethod.GET)
	public String getCampusDetails(@PathVariable("code") String code, Model model) {
		model.addAttribute("campus", campusService.getCampusByCode(code));
		return "campuses/details";
	}
}