/**
 * 
 */
package com.expositds.servicestationmanagementsystem.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.ClientSecurityFeature;
import com.expositds.servicestationmanagementsystem.service.AbstractEntityCommonService;
import com.expositds.servicestationmanagementsystem.service.ClientSecurityFeatureService;
import com.expositds.servicestationmanagementsystem.service.ClientService;
import com.expositds.servicestationmanagementsystem.service.EmployeeService;

/**
 * @author Artyom_Khomyakov
 * @author Denis Zaerko
 *
 */
@Controller(value="clientController")
public class ClientController {

	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@Inject
	@Qualifier("abstractEntity—ommonService")
	private AbstractEntityCommonService abstractEntity—ommonService;
	
	@Inject
	@Qualifier("clientService")
	private ClientService clientService;

	@Inject
	@Qualifier("clientSecurityFeatureService")
	private ClientSecurityFeatureService clientSecurityFeatureService;
	
	@Inject
	@Qualifier(value="employeeService")
	private EmployeeService employeeService;
	
	public void setAbstractEntityCommonService(AbstractEntityCommonService abstractEntity—ommonService) {
		this.abstractEntity—ommonService = abstractEntity—ommonService;
	}
	
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public void setClientSecurityFeatureService(ClientSecurityFeatureService clientSecurityFeatureService) {
		this.clientSecurityFeatureService = clientSecurityFeatureService;
	}

	public void setEmployeeService(EmployeeService employeeService){
		this.employeeService=employeeService;
	}
	
	
	
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index() {									
		logger.info("ClientController GET: index page");
		return "/index";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response){
		
		logger.info("ClientController POST: index page");
		//String confirmUserLogin=DigestUtils.md5Hex(request.getParameter("login"));
		//String confirmUserPassword =DigestUtils.md5Hex(request.getParameter("password"));
		
		String userLogin=request.getParameter("login");
		String userPassword=request.getParameter("password");
		
		Boolean isClient= clientService.signInClientByLoginPassword(userLogin, userPassword);
		Boolean isEmployee=employeeService.signInEmployeByLoginPassword(userLogin, userPassword);
		
		if(isClient){//client page
			Long idClient=clientService.getIdClientByLoginPassword(userLogin, userPassword);
			
			return "/profile/{"+idClient+"}/notcompledoverdclientord";
			
		}else if(isEmployee){//mechanic page
			Long idEmployee=employeeService.getIdEmployeByLoginPassword(userLogin, userPassword);
			return "/profile/{"+idEmployee+"}/mechanicnotcompletedoverdord";
			
		}else{//else return to start page
			return "/ServiceStationManagementSystem/index";
		}
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String getregistration(Model model) {	
		
		ClientSecurityFeature clientSecurityFeature=new ClientSecurityFeature();
		model.addAttribute("clientSecurityFeature", clientSecurityFeature);
		logger.info("ClientController GET: registration page");
		
		return "/registration";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String postregistration(@Valid @ModelAttribute("clientSecurityFeature") ClientSecurityFeature clientSecurityFeature,
			BindingResult result, Model model){

		if(result.hasErrors()) {
			logger.info("ClientController POST: registration page.Erorr in form!");
			return "/registration";
			
		} else if(clientSecurityFeatureService.isUniqueLoginPassword(clientSecurityFeature.getClientLogin(), clientSecurityFeature.getClientPassword())){
			
			logger.info("ClientController POST: registration page");
			//client save
			abstractEntity—ommonService.saveEntity(clientSecurityFeature.getClient());
			//clientSecurityFeature save
			clientSecurityFeature.setClient(clientSecurityFeature.getClient());
			abstractEntity—ommonService.saveEntity(clientSecurityFeature);
			logger.info("ClientController POST: Client save successful!");
			return "/success";
			
		}else{
			logger.info("ClientController POST: Client not save! Change fields!");
			return "/registration";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	

//	
//	@RequestMapping(value="/station/{stationId}", method=RequestMethod.GET)
//	public String station(Model model) {	
//		return "station";
//	}
//	
//	@RequestMapping(value="/station/{stationId}/request", method=RequestMethod.GET)
//	public String request(Model model) {	
//		return "request";
//	}
//	
//	@RequestMapping(value="/station/{stationId}/request/send", method=RequestMethod.GET)
//	public String send(Model model) {	
//		return "redirect:/station/{stationId}/request";
//	}
//	
//	@RequestMapping(value="/station/{stationId}/check", method=RequestMethod.GET)
//	public String check(Model model) {	
//		return "redirect:/station/{stationId}";
//	}
//	
//	/**
//     * Retrieves the profile pages
//     *
//     */
//	@RequestMapping(value="/profile", method=RequestMethod.GET)
//	public String home(Model model) {	
//		return "redirect:profile/inprogress";
//	}
//	
//	@RequestMapping(value="/profile/inprogress", method=RequestMethod.GET)
//	public String inProgress(Model model) {	
//		return "inprogress";
//	}
//	
//	@RequestMapping(value="/profile/done", method=RequestMethod.GET)
//	public String done(Model model) {	
//		return "done";
//	}
//	
//	@RequestMapping(value="/profile/overdue", method=RequestMethod.GET)
//	public String overdue(Model model) {	
//		return "overdue";
//	}
//	
//	@RequestMapping(value="/profile/overdue/renew/{DepartmentId}", method=RequestMethod.GET)
//	public String renew(Model model) {	
//		return "renew";
//	}
//	
//	@RequestMapping(value= {"/profile/overdue/addcomment/{ServiceStationId}", "/profile/done/addcomment/{ServiceStationId}"}, method=RequestMethod.GET)
//	public String addcomment(Model model) {	
//		return "addcomment";
//	}
//	
//	@RequestMapping(value="/profile/overdue/detele/{departmentOrderId}", method=RequestMethod.GET)
//	public String delete(Model model) {	
//		return "redirect:/overdue";
//	}
	
}
