/**
 * 
 */
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
@RequestMapping("/mechanicpage")
public class MechanicController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model) {
		return "redirect:mechanicpage/notdone";
	}
	
	@RequestMapping(value="/notdone", method=RequestMethod.GET)
	public String notdone(Model model) {	
		return "mechanicnotdone";
	}
	
	@RequestMapping(value="/inprogress", method=RequestMethod.GET)
	public String inprogress(Model model) {	
		return "mechanicinprogress";
	}
	
	@RequestMapping(value="/overdue", method=RequestMethod.GET)
	public String overdue(Model model) {	
		return "mechanicoverdue";
	}
	
	@RequestMapping(value="/done", method=RequestMethod.GET)
	public String done(Model model) {	
		return "mechanicdone";
	}
	
	@RequestMapping(value="/comments", method=RequestMethod.GET)
	public String comments(Model model) {	
		return "mechaniccomments";
	}
	
	@RequestMapping(value="/notdone/save/{DepartmentOrderId}", method=RequestMethod.GET)
	public String save(Model model) {	
		return "mechanicinprogress";
	}
	
	@RequestMapping(value="/inprogress/order/{DepartmentId}", method=RequestMethod.GET)
	public String order(Model model) {	
		return "orderdetail";
	}
	
	@RequestMapping(value="/inprogress/finish/{DepartmentOrderId}", method=RequestMethod.GET)
	public String finish(Model model) {	
		return "mechanicdone";
	}

}
