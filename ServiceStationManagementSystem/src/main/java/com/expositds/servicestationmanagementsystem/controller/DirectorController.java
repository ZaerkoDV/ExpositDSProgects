package com.expositds.servicestationmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Artyom_Khomyakov
 *
 */

@Controller
@RequestMapping("/directorpage")
public class DirectorController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model) {
		return "redirect:directorpage/income";
	}
	
	@RequestMapping(value="/income", method=RequestMethod.GET)
	public String income(Model model) {	
		return "income";
	}
	
	@RequestMapping(value="/costs", method=RequestMethod.GET)
	public String costs(Model model) {	
		return "costs";
	}
	
	@RequestMapping(value="/comments", method=RequestMethod.GET)
	public String comments(Model model) {	
		return "directorcomments";
	}
	
	@RequestMapping(value="/report", method=RequestMethod.GET)
	public String report(Model model) {	
		return "report";
	}
	
	@RequestMapping(value="/report/download", method=RequestMethod.GET)
	public String dowload(Model model) {	
		return "redirect:/directorpage/report";
	}

}
