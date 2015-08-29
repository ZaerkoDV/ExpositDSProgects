/**
 * 
 */
package com.expositds.servicestationmanagementsystem.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
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
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		
		logger.info("ClientController POST: index page");
		//String confirmUserLogin=DigestUtils.md5Hex(request.getParameter("login"));
		//String confirmUserPassword =DigestUtils.md5Hex(request.getParameter("password"));
		String userLogin=request.getParameter("login");
		String userPassword=request.getParameter("password");
		
		Boolean isClient= clientService.signInClientByLoginPassword(userLogin, userPassword);
		Boolean isEmployee=employeeService.signInEmployeByLoginPassword(userLogin, userPassword);
		
		if(isClient){//client page
			
			Long idClient=clientService.getIdClientByLoginPassword(userLogin, userPassword);
			return new ModelAndView("redirect:" + "/profile/"+idClient+"/clientnotcompledoverdord");
			
		}else if(isEmployee){//mechanic page
			
			Long idEmployee=employeeService.getIdEmployeByLoginPassword(userLogin, userPassword);
			return new ModelAndView("redirect:" + "/profile/"+idEmployee+"/mechanicnotcompletedoverdord");
////&&&&			
		}else{//else return to start page
			return new ModelAndView("redirect:" + "/failure");
		}
	}
											   //getregistration
							
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String getregistration(Model model) {	
		
		ClientSecurityFeature clientSecurityFeature=new ClientSecurityFeature();
		model.addAttribute("clientSecurityFeature", clientSecurityFeature);
		logger.info("ClientController GET: registration page");
		
		return "/registration";
	}
												//postregistration
								
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
		
											// get client pages
	
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
	
										//post client pages
	
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
	
	@RequestMapping(value="/profile/{idClient}/{beforepage}/{idDepartmentOrder}/delete",method=RequestMethod.GET)
	public String getdeleteclientord(@PathVariable("idClient") Long idClient,@PathVariable("beforepage") String beforepage,
			@PathVariable("idDepartmentOrder") Long idDepartmentOrder,
			Model model) {
		
		logger.info("ClientController GET: delete order by id department order="+idDepartmentOrder);
		//delete order
		abstractEntity—ommonService.deleteEntityById(DepartmentOrder.class, idDepartmentOrder);
		
		Client client=(Client) abstractEntity—ommonService.getEntityById(Client.class, idClient);
		model.addAttribute("client",client);
		
		//return to clientnotcompledoverdord and refresh order list
		if(beforepage.equals("clientnotcompledoverdord")){
			List<DepartmentOrder> listNotcompletedOverdueOrder=clientService.getListNotcompletedOverdueOrderForClient(idClient);
			model.addAttribute("listNotcompletedOverdueOrder", listNotcompletedOverdueOrder);
			
			model.addAttribute("beforepage","clientnotcompledoverdord");
		}
		
		//return to incompleteclientallord and refresh order list
		if(beforepage.equals("incompleteclientallord")){
			List<DepartmentOrder> listNotCompletedOverdueClientOrder= clientService.getListNotcompletedOverdueOrderForClient(client.getIdClient());
			model.addAttribute("listNotCompletedOverdueClientOrder", listNotCompletedOverdueClientOrder);
			
			List<DepartmentOrder> listDoneClientOrder= clientService.getListDoneOrderForClient(client.getIdClient());
			model.addAttribute("listDoneClientOrder", listDoneClientOrder);
			
			model.addAttribute("beforepage","incompleteclientallord");
		}
		return "/"+beforepage;
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
	
													//postrenew
	
	@RequestMapping(value="/profile/{idClient}/{idDepartmentOrder}/renew",method=RequestMethod.POST)
	public String postrenewclientord(@PathVariable("idClient") Long idClient,@PathVariable("idDepartmentOrder") Long idDepartmentOrder,
			@ModelAttribute("departmentOrder") DepartmentOrder departmentOrder,BindingResult result,Model model) {

		logger.info("ClientController GET: delete client order by id old department order="+idDepartmentOrder);
		logger.info("ClientController GET: save client order with new id department order="+departmentOrder.getEmployee().getIdEmployee());
		
		Client client=(Client) abstractEntity—ommonService.getEntityById(Client.class, idClient);
		Department newDepartment= (Department) abstractEntity—ommonService.getEntityById(Department.class, departmentOrder.getDepartment().getIdDepartment());
		Employee newEmployee=(Employee) abstractEntity—ommonService.getEntityById(Employee.class, departmentOrder.getEmployee().getIdEmployee());
		
		//update old order data
		departmentOrder.setClient(client);
		departmentOrder.setDepartment(newDepartment);
		departmentOrder.setEmployee(newEmployee);
		departmentOrder.setStartOrder(new Date());
		departmentOrder.setOrderStatus("notcompleted");
		abstractEntity—ommonService.updateEntity(departmentOrder);
		
		//return to page before
		List<DepartmentOrder> listNotcompletedOverdueOrder=clientService.getListNotcompletedOverdueOrderForClient(idClient);
		model.addAttribute("listNotcompletedOverdueOrder", listNotcompletedOverdueOrder);
		
		model.addAttribute("departmentOrder",departmentOrder);
	
		model.addAttribute("client",client);

		return "/clientnotcompledoverdord";
	}
	
											//get client coments for service station
	
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
	
											//post client coments for service station

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
		
		
		//return client (or incompleted client) to page beforePage frome he come
		if(beforePage.equals("clientnotcompledoverdord")){
			List<DepartmentOrder> listNotcompletedOverdueOrder=clientService.getListNotcompletedOverdueOrderForClient(idClient);
			model.addAttribute("listNotcompletedOverdueOrder", listNotcompletedOverdueOrder);
		}
		
		if(beforePage.equals("clientdoneord")){	
			List<DepartmentOrder> listDoneOrder=clientService.getListDoneOrderForClient(idClient);
			model.addAttribute("listDoneOrder", listDoneOrder);
		}
		
		if(beforePage.equals("incompleteclientallord")){
			List<DepartmentOrder> listNotCompletedOverdueClientOrder= clientService.getListNotcompletedOverdueOrderForClient(client.getIdClient());
			model.addAttribute("listNotCompletedOverdueClientOrder", listNotCompletedOverdueClientOrder);
			
			List<DepartmentOrder> listDoneClientOrder= clientService.getListDoneOrderForClient(client.getIdClient());
			model.addAttribute("listDoneClientOrder", listDoneClientOrder);
		}
				
		model.addAttribute("client",client);
		
		return "/"+beforePage;
	}
									//getallservicestation
	
	@RequestMapping(value="/allservicestation",method=RequestMethod.GET)
	public String getallservicestation(Model model) {
		
		logger.info("ClientController GET: all service stations list");
		List<ServiceStation> listServiceStation=(List<ServiceStation>)serviceStationService.getAllServiceStation();
		model.addAttribute("listServiceStation", listServiceStation);
		
		return "/allservicestation"; 						
	}
									//get review service station page
	
	@RequestMapping(value="/servicestation/{idServiceStation}/servicestationreview",method=RequestMethod.GET)
	public String getservicestationreview(@PathVariable("idServiceStation") Long idServiceStation, Model model) {
		
		logger.info("ClientController GET: service station review page");
		
		String viewStatus="all";
		List<ServiceStationCommentMark> listServiceStationCommentMark=serviceStationCommentMarkService
				.getListCommentMarkStatusAsParamByIdServiceStation(idServiceStation, viewStatus);
		model.addAttribute("listServiceStationCommentMark", listServiceStationCommentMark);
		
		ServiceStation serviceStation=(ServiceStation) abstractEntity—ommonService.getEntityById(ServiceStation.class, idServiceStation);
		model.addAttribute("serviceStation", serviceStation);
		
		List<Department>listServiceStationDepartment=serviceStationService.getListDepartmentForServiceStation(idServiceStation);
		int countDepartment=listServiceStationDepartment.size();
		model.addAttribute("countDepartment", countDepartment);	
		
		List<Client>listServiceStationClient=serviceStationService.getListClientForServiceStation(idServiceStation);
		int clientCount=listServiceStationClient.size();
		model.addAttribute("clientCount", clientCount);
		
		Client client=new Client();
		model.addAttribute("client", client);
				
		return "/servicestationreview";
	}
									    //post review service station page
	
	@RequestMapping(value="/servicestation/{idServiceStation}/servicestationreview",method=RequestMethod.POST)
	public ModelAndView postservicestationreview(@ModelAttribute("client") Client client,
			@PathVariable("idServiceStation") Long idServiceStation,BindingResult result, Model model) {
		
		logger.info("ClientController POST: service station review page");	
		Client autorizedClient =clientService.getClientByEmail(client.getClientEmail());
			
		return new ModelAndView("redirect:" + "/profile/"+autorizedClient.getIdClient()+"/incompleteclientallord");
	}
	
										//get incompleted client page
///??????
/////////	
	@RequestMapping(value="/profile/{idClient}/incompleteclientallord",method=RequestMethod.GET)
	public String getincompleteclientallord(@PathVariable("idClient") Long idClient, Model model) {
		
		logger.info("ClientController GET: incompleted client page");	
		
		List<DepartmentOrder> listNotCompletedOverdueClientOrder= clientService.getListNotcompletedOverdueOrderForClient(idClient);
		model.addAttribute("listNotCompletedOverdueClientOrder", listNotCompletedOverdueClientOrder);
		
		List<DepartmentOrder> listDoneClientOrder= clientService.getListDoneOrderForClient(idClient);
		model.addAttribute("listDoneClientOrder", listDoneClientOrder);
		
		Client client =(Client) abstractEntity—ommonService.getEntityById(Client.class, idClient);
		model.addAttribute("client", client);
		
		model.addAttribute("beforepage","incompleteclientallord");	
		
		return "/incompleteclientallord";
	}
	
										//get add new client order in department
	
	@RequestMapping(value="/profile/incompleteclientneword",method=RequestMethod.GET)
	public String getincompleteclientneword(Model model) {
		
		logger.info("ClientController GET:client create new department order");
		
		//create new department order
		DepartmentOrder departmentOrder=new DepartmentOrder();
		model.addAttribute("departmentOrder",departmentOrder);
		
		List<Department> listAllDepartment=departmentService.getListAllDepartment();
		model.addAttribute("listAllDepartment",listAllDepartment);
		
		List<Employee> listAllMechanic=employeeService.getListMechanic();
		model.addAttribute("listAllMechanic",listAllMechanic);
		
		return "/incompleteclientneword";
	}

									//post add new client order in department
	
	@RequestMapping(value="/profile/incompleteclientneword",method=RequestMethod.POST)
	public String getincompleteclientneword(@Valid @ModelAttribute("departmentOrder") DepartmentOrder departmentOrder,
			BindingResult result,Model model) {
		
		logger.info("ClientController POST:client create new department order");
		
		//if email is not uniqual or empty
		if(departmentOrder.getClient().getClientEmail()=="") {
			model.addAttribute("error","error");

		}else{
			Client client =new Client();
			client.setClientFirstName("unknow");
			client.setClientFirstName("unknow");
			client.setClientEmail(departmentOrder.getClient().getClientEmail());
			abstractEntity—ommonService.saveEntity(client);

			Employee employee= (Employee) abstractEntity—ommonService.getEntityById(Employee.class, departmentOrder.getEmployee().getIdEmployee());
			Department department= (Department) abstractEntity—ommonService.getEntityById(Department.class, departmentOrder.getDepartment().getIdDepartment());

			departmentOrder.setClient(client);
			departmentOrder.setDepartment(department);
			departmentOrder.setEmployee(employee);
			departmentOrder.setStartOrder(new Date());
			departmentOrder.setOrderStatus("notcompleted");
			abstractEntity—ommonService.saveEntity(departmentOrder);
		}
		
		model.addAttribute("departmentOrder",departmentOrder);
		List<Department> listAllDepartment=departmentService.getListAllDepartment();
		model.addAttribute("listAllDepartment",listAllDepartment);
		
		List<Employee> listAllMechanic=employeeService.getListMechanic();
		model.addAttribute("listAllMechanic",listAllMechanic);
		
		return "/incompleteclientneword";
	}
}
