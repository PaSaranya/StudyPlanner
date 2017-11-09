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
import com.jstudyplanner.domain.Program;
import com.jstudyplanner.service.ProgramService;

/**
 * Program Controller
 */
@Controller
public class ProgramController {
	
	private final ProgramService programService;
	private final static int DEFAULT_PAGE_SIZE = 10;
	
	/**
	 * ProgramService implementation should be marked with @Component
	 * @param programService 
	 */
	@Inject
	public ProgramController(ProgramService programService) {
		this.programService = programService;
	}
	
	/**
	 * Get all Programs, add to session, set pagination and return program view.
	 * Set parameters (page, pageSize) if not defined.
	 */
	@RequestMapping(value = "/programs/list", method = RequestMethod.GET)
	public ModelAndView listPrograms(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize, HttpSession session) {
		if (page == null) {
			page = 0;
		}
		
		PagedListHolder<Program> resultList = (PagedListHolder<Program>) session.getAttribute("ProgramController_resultList");
		if (resultList == null) {
			resultList = new PagedListHolder<Program>(programService.getAllPrograms());
			session.setAttribute("ProgramController_resultList", resultList);
			if (pageSize == null) {
				pageSize = DEFAULT_PAGE_SIZE;
			}
		}
		if (pageSize != null) {
			resultList.setPageSize(pageSize);
		}
		resultList.setPage(page);
		return new ModelAndView("programs/list", "resultList", resultList);
	}
	
	/**
	 * Get program details including list of majors and return details view.
	 * @param code program code
	 * @param model
	 * @return details view
	 */
	@RequestMapping(value = "/programs/{code:.+}", method = RequestMethod.GET)
	public String getProgramDetails(@PathVariable("code") String code, Model model) {
		Program program = programService.getProgramByCode(code);
		model.addAttribute("program", program);
		model.addAttribute("majors", programService.getProgramMajors(program));
		return "programs/details";
	}
}