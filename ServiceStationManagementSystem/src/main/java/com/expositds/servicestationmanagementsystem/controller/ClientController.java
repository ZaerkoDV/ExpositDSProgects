/**
 * 
 */
package com.expositds.servicestationmanagementsystem.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.ClientSecurityFeature;
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.ServiceStationCommentMark;
import com.expositds.servicestationmanagementsystem.service.AbstractEntityCommonService;
import com.expositds.servicestationmanagementsystem.service.ClientSecurityFeatureService;
import com.expositds.servicestationmanagementsystem.service.ClientService;
import com.expositds.servicestationmanagementsystem.service.DepartmentOrderService;
import com.expositds.servicestationmanagementsystem.service.DepartmentService;
import com.expositds.servicestationmanagementsystem.service.EmployeeService;
import com.expositds.servicestationmanagementsystem.service.ServiceStationCommentMarkService;
import com.expositds.servicestationmanagementsystem.service.ServiceStationService;

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
	
	@Inject
	@Qualifier(value="departmentService")
	private DepartmentService departmentService;
	
	@Inject
	@Qualifier(value="serviceStationService")
	private ServiceStationService serviceStationService;
	
	@Inject
	@Qualifier(value="serviceStationCommentMarkService")
	private ServiceStationCommentMarkService serviceStationCommentMarkService;
	
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
	
	public void setDepartmentService(DepartmentService departmentService){
		this.departmentService=departmentService;
	}
	
	public void setServiceStationService(ServiceStationService serviceStationService){
		this.serviceStationService=serviceStationService;
	}
	
	public void setServiceStationCommentMarkService(ServiceStationCommentMarkService serviceStationCommentMarkService){
		this.serviceStationCommentMarkService=serviceStationCommentMarkService;
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
			
			return "/profile/"+idClient+"/clientnotcompledoverdord";
			
		}else if(isEmployee){//mechanic page
			Long idEmployee=employeeService.getIdEmployeByLoginPassword(userLogin, userPassword);
			return "/profile/{"+idEmployee+"}/mechanicnotcompletedoverdord";
			
		}else{//else return to start page
			return "/failure";
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
	
	@RequestMapping(value="/allservicestation",method=RequestMethod.GET)
	public String getallservicestation(Model model) {
		logger.info("ClientController GET: all service stations list");
		
		List<ServiceStation> listServiceStation=(List<ServiceStation>)serviceStationService.getAllServiceStation();
		model.addAttribute("listServiceStation", listServiceStation);
		
		return "/allservicestation"; 						
	}
	
											//client pages
	
////???????	
//get work      http://localhost:8080/ServiceStationManagementSystem/profile/1/clientnotcompledoverdord
//get not work	http://localhost:8080/ServiceStationManagementSystem/views/profile/1/clientnotcompledoverdord.jsp
	@RequestMapping(value="/profile/{idClient}/clientnotcompledoverdord",method=RequestMethod.GET)
	public String getclientnotcompledoverdorder(@PathVariable("idClient") Long idClient,Model model) {
		
		logger.info("ClientController GET: clientnotcompledoverdord page"+idClient);
		
		List<DepartmentOrder> listNotcompletedOverdueOrder=clientService.getListNotcompletedOverdueOrderForClient(idClient);
		model.addAttribute("listNotcompletedOverdueOrder", listNotcompletedOverdueOrder);
		
		Client client=(Client) abstractEntity—ommonService.getEntityById(Client.class, idClient);
		model.addAttribute("client",client);
		
		model.addAttribute("beforepage","clientnotcompledoverdord");
		
		return "/clientnotcompledoverdord"; 						
	}
	
	@RequestMapping(value="/profile/{idClient}/clientdoneord",method=RequestMethod.GET)
	public String getclientdoneord(@PathVariable("idClient") Long idClient,Model model) {
		
		logger.info("ClientController GET:clientdoneord page"+idClient);
		
		List<DepartmentOrder> listDoneOrder=clientService.getListDoneOrderForClient(idClient);
		model.addAttribute("listDoneOrder", listDoneOrder);
		
		Client client=(Client) abstractEntity—ommonService.getEntityById(Client.class, idClient);
		model.addAttribute("client",client);
		
		model.addAttribute("beforepage","clientdoneord");
		
		return "/clientdoneord"; 						
	}
												
												//delete
	
	@RequestMapping(value="/profile/{idClient}/{idDepartmentOrder}/delete",method=RequestMethod.GET)
	public String getdeleteclientord(@PathVariable("idClient") Long idClient,@PathVariable("idDepartmentOrder") Long idDepartmentOrder,
			Model model) {
		
		logger.info("ClientController GET: delete order by id department order="+idDepartmentOrder);
		//delete order
		abstractEntity—ommonService.deleteEntityById(DepartmentOrder.class, idDepartmentOrder);
		
		//return to clientnotcompledoverdord and refresh order list
		List<DepartmentOrder> listNotcompletedOverdueOrder=clientService.getListNotcompletedOverdueOrderForClient(idClient);
		model.addAttribute("listNotcompletedOverdueOrder", listNotcompletedOverdueOrder);
		
		Client client=(Client) abstractEntity—ommonService.getEntityById(Client.class, idClient);
		model.addAttribute("client",client);
		
		model.addAttribute("beforepage","clientnotcompledoverdord");
		
		return "/clientnotcompledoverdord";
	}
	
												//getrenew
	
	@RequestMapping(value="/profile/{idClient}/{idDepartmentOrder}/renew",method=RequestMethod.GET)
	public String getrenewclientord(@PathVariable("idClient") Long idClient,@PathVariable("idDepartmentOrder") Long idDepartmentOrder,
			Model model) {
		
		logger.info("ClientController GET: renew client order by id department order="+idDepartmentOrder);
		
		Client client=(Client) abstractEntity—ommonService.getEntityById(Client.class, idClient);
		model.addAttribute("client",client);
		
		//create new department order
		DepartmentOrder departmentOrder= (DepartmentOrder) abstractEntity—ommonService.getEntityById(DepartmentOrder.class, idDepartmentOrder);
		//create field client in department order
		model.addAttribute("departmentOrder",departmentOrder);
		
		List<Department> listAllDepartment=departmentService.getListAllDepartment();
		model.addAttribute("listAllDepartment",listAllDepartment);
		
		List<Employee> listAllMechanic=employeeService.getListMechanic();
		model.addAttribute("listAllMechanic",listAllMechanic);
		
		return "/clientreneword";
	}
	
	@RequestMapping(value="/profile/{idClient}/{idDepartmentOrder}/renew",method=RequestMethod.POST)
	public String postrenewclientord(@PathVariable("idClient") Long idClient,@PathVariable("idDepartmentOrder") Long idDepartmentOrder,
			@ModelAttribute("departmentOrder") DepartmentOrder departmentOrder,BindingResult result,Model model) {

		logger.info("ClientController GET: renew client order by id department order="+idDepartmentOrder);
		//abstractEntity—ommonService.updateEntity(departmentOrder);

		//return to page before
		List<DepartmentOrder> listNotcompletedOverdueOrder=clientService.getListNotcompletedOverdueOrderForClient(idClient);
		model.addAttribute("listNotcompletedOverdueOrder", listNotcompletedOverdueOrder);

		return "/clientnotcompledoverdord";
	}
	
	
	
	
	
	
	
	
	

	
												//client coments
	
	@RequestMapping(value="/profile/{idClient}/{beforepage}/{idServiceStation}/addservicestationcomment",method=RequestMethod.GET)
	public String getaddservicestationcomment(@PathVariable("idClient") Long idClient,@PathVariable("beforepage") String beforePage,
			@PathVariable("idServiceStation") Long idServiceStation, Model model) {
		
		logger.info("ClientController GET:addservicestationcomment page client="+idClient+" service station"+idServiceStation);
		//add comment
		ServiceStationCommentMark serviceStationCommentMark= new ServiceStationCommentMark();
		model.addAttribute("serviceStationCommentMark", serviceStationCommentMark);
		
		//client which do comment
		Client client= (Client) abstractEntity—ommonService.getEntityById(Client.class, idClient);
		model.addAttribute("client", client);
		
		//service station which get comments
		ServiceStation serviceStation= (ServiceStation) abstractEntity—ommonService.getEntityById(ServiceStation.class, idServiceStation);
		model.addAttribute("serviceStation", serviceStation);
		
		model.addAttribute("beforepage",beforePage);
	
		return "/addservicestationcomment";
	}

	@RequestMapping(value="/profile/{idClient}/{beforepage}/{idServiceStation}/addservicestationcomment",method=RequestMethod.POST)
	public String postaddservicestationcomment(@Valid @ModelAttribute("serviceStationCommentMark") ServiceStationCommentMark serviceStationCommentMark,
		@PathVariable("idClient") Long idClient,@PathVariable("beforepage") String beforePage, @PathVariable("idServiceStation") Long idServiceStation,BindingResult result, Model model) {
	
		logger.info("ClientController POST:addservicestationcomment page client="+idClient+" service station"+idServiceStation);
		
		//client which do comment 
		Client client=(Client) abstractEntity—ommonService.getEntityById(Client.class, idClient);
		serviceStationCommentMark.setClient(client);
		
		//service station which get comments
		ServiceStation serviceStation= (ServiceStation) abstractEntity—ommonService.getEntityById(ServiceStation.class, idServiceStation);
		serviceStationCommentMark.setServiceStation(serviceStation);
		
		//save service station comment mark
		abstractEntity—ommonService.saveEntity(serviceStationCommentMark);
		logger.info("ClientController POST:addservicestationcomment page comment save");
		
		
		//return to page beforePage frome come here
		if(beforePage.equals("clientnotcompledoverdord")){
			List<DepartmentOrder> listNotcompletedOverdueOrder=clientService.getListNotcompletedOverdueOrderForClient(idClient);
			model.addAttribute("listNotcompletedOverdueOrder", listNotcompletedOverdueOrder);
		}
		
		if(beforePage.equals("clientdoneord")){	
			//return to clientdoneord page
			List<DepartmentOrder> listDoneOrder=clientService.getListDoneOrderForClient(idClient);
			model.addAttribute("listDoneOrder", listDoneOrder);
		}
		model.addAttribute("client",client);
		
		return "/"+beforePage;
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
