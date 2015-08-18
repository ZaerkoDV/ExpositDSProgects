/**
 * 
 */
package com.expositds.servicestationmanagementsystem.controller;



import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.expositds.servicestationmanagementsystem.service.ClientService;

/**
 * @author Artyom_Khomyakov
 *
 */
@Controller
public class ClientController {

	/**
     * Retrieves the index page
     *
     */
//	@Inject
//	@Qualifier("clientService")
//	private ClientService clientService;
	
	@RequestMapping(value = { "", "/", "/index" }, method = { RequestMethod.GET })
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String registration(Model model) {	
		return "registration";
	}
	
	@RequestMapping(value="/station", method=RequestMethod.GET)
	public String station(Model model) {	
		return "station";
	}
	
	@RequestMapping(value="/station/request/{stationId}", method=RequestMethod.GET)
	public String request(Model model) {	
		return "request";
	}
	
	/**
     * Retrieves the profile pages
     *
     */
	@RequestMapping(value="/profile/", method=RequestMethod.GET)
	public String main(Model model) {	
		return "redirect: /profile/inprogress";
	}
	
	@RequestMapping(value="/profile/inprogress", method=RequestMethod.GET)
	public String inProgress(Model model) {	
		return "inprogress";
	}
	
	@RequestMapping(value="/profile/done", method=RequestMethod.GET)
	public String done(Model model) {	
		return "done";
	}
	
	@RequestMapping(value="/profile/overdue", method=RequestMethod.GET)
	public String overdue(Model model) {	
		return "overdue";
	}
	
	@RequestMapping(value="/profile/overdue/renew/{departmentOrderId}", method=RequestMethod.GET)
	public String renew(Model model) {	
		return "renew";
	}
	
	@RequestMapping(value= {"/profile/overdue/addcomment/{ServiceStationId}", "/profile/done/addcomment/{ServiceStationId}"}, method=RequestMethod.GET)
	public String addcomment(Model model) {	
		return "addcomment";
	}
	
	@RequestMapping(value="/profile/overdue/detele/{departmentOrderId}", method=RequestMethod.GET)
	public String delete(Model model) {	
		return "redirect: /profile/overdue";
	}
	
}
