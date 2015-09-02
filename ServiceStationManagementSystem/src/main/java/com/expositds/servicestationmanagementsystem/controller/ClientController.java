/**
 * @package com.expositds.servicestationmanagementsystem.controlle
 * 
 * Package com.expositds.servicestationmanagementsystem.controlle contain set of classes
 * which perform controller function in ServiceStationManagementSystem project. This project
 * is based on MVC architecture.This class is part of controller in MVC architecture. 
 * Controller provides communication between the user and the system: controls user input
 * and uses models and views to implement the necessary response. In Service Station Management
 * System, define three roles Client, Mechanic, Director. For each role, define separate
 * controller. All classes which contain postfix ìControllerî provide to
 * work Controller for Service Station Management System application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions. 
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
 * Class contain methods which describe communication between user with role client and system.
 * The client(user role) go to the website, the customer sees on the home page a list of all
 * stations, registered in the system, and brief information about them (name, town and the
 * average rating of the work). He can go to a separate page Service Station. This page displays
 * basic information about the work of the Service Station (name, address, phone number, the
 * average assessment of the work). Also, there are displayed all the reviews and evaluation of
 * Service Station. If the client has previously used the services of the service, he can view
 * the status of your order (the status and value of the work) by entering an email into the input
 * field and pressing the "check". Also, on this page the customer can send the application by
 * click. On the page that appears in special fields should leave your, e-mail, describe the
 * task and click "Send". This request will go mechanics. Also, the client has the opportunity
 * to register in the system. Go to the registration page can be on start page by clicking on
 * the "Sign up". On the registration page the customer must fill in the following fields:
 * last name, email, login, password, phone number. Once registered in the system, you can go
 * to your personal account (profile). In this account the customer can view the status of their
 * orders.
 * Class ClinetController use technologe IoC for work with other layer in application. All methods
 * are public in class. For logging use framework shell slf4j and framework log4j.Class contain
 * also private, static variable logger, which use to call log message.Controller use spring
 * framework for organize request/response mappling.
 * 
 * @version 1.0 31.08.2015
 * 
 * @see org.springframework.web
 * @see javax.servlet.http
 * @see org.springframework.stereotype
 * 
 * @author Denis Zaerko
 * @author Artyom_Khomyakov
 */
@Controller(value="clientController")
public class ClientController {

	/**
	 * Variable logger use to get logger level for class ClientController.
	 * 
	 * @param class name: ClientController
	 * @return logger for class ClientController.
	 */
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	/**
	 * Annatation Inject use to get dependency injection from service
	 * layer classes. This is part of specification JSR-330.
	 */
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
	
	/**
	 * This is set of methods of dependency injection .
	 * This methods give the right set(writeable) variable value.
	 */
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
	
	/**
	 * This method return the index.jsp page
	 * @type String
	 * @return index.jsp
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index() {
		logger.info("ClientController GET: index page");
		return "/index"; 						
	}

	/**
	 * This authentication method. Fill in the fields login and password if they  have been properly
	 * filled, then redirect to the appropriate page (director page, mechanic page or client page).
	 * If there were errors at the entrance, then redirects to a failure.jsp page.
	 * 
	 * @return ModelAndView
	 * @type String
	 */
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		
		logger.info("ClientController POST: index page");
		String confirmUserLogin=request.getParameter("login");
		String confirmUserPassword =DigestUtils.md5Hex(request.getParameter("password"));
		//System.out.println(confirmUserPassword.toString());
		
		Boolean isClient= clientService.signInClientByLoginPassword(confirmUserLogin, confirmUserPassword);
		Boolean isEmployee=employeeService.signInEmployeByLoginPassword(confirmUserLogin, confirmUserPassword);
		
		if(isClient){//client page
			Long idClient=clientService.getIdClientByLoginPassword(confirmUserLogin, confirmUserPassword);
			return new ModelAndView("redirect:" + "/profile/"+idClient+"/clientnotcompledoverdord");
			
		}else if(isEmployee){
			Long idEmployee=employeeService.getIdEmployeByLoginPassword(confirmUserLogin, confirmUserPassword);
			Employee employee=(Employee) abstractEntity—ommonService.getEntityById(Employee.class, idEmployee);
			
			//mechanic page
			if(employee.getEmployeFunction().equals("mechanic")){
				return new ModelAndView("redirect:" + "/profile/"+idEmployee+"/mechanicnotcompletedoverdord");		
			
			//director page
			}else if(employee.getEmployeFunction().equals("director")){
				return new ModelAndView("redirect:" + "/profile/"+idEmployee+"/directorpage");
				
			}else{
				return new ModelAndView("/failure");
			}
		//else return to start page		
		}else{
			return new ModelAndView("/failure");
		}
	}
											   //getregistration
	/**
	 * This method return the registration.jsp page.
	 * 
	 * @param ClientSecurityFeature
	 * @type String
	 * @return  registration.jsp
	 */	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String getregistration(Model model) {	
		
		ClientSecurityFeature clientSecurityFeature=new ClientSecurityFeature();
		model.addAttribute("clientSecurityFeature", clientSecurityFeature);
		logger.info("ClientController GET: registration page");
		
		return "/registration";
	}
												//postregistration
	/**
	 * This method saves the client with  if login and password was unique.
	 * If there were errors, it will redirect to the registration.jsp page.
	 * 
	 * @type String
	 * 
	 * @return success page
	 */ 
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
	/**
	 * This method return the clientnotcompledoverdord.jsp page together with a list 
	 * orders with the status not completed.
	 * 
	 * @type String
	 * @type Long
	 * @param idClient
	 * 
	 * @return clientnotcompledoverdord page
	 */
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
	/**
	 * This method return the clientdoneord.jsp page together with a list 
	 * orders with the status done.
	 * 
	 * @type String
	 * @type Long
	 * 
	 * @param idClient
	 * 
	 * @return clientdoneord page
	 */
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
	/**
	 * This method remove the Department Order by id department order
	 * and redirect to beforepage.
	 * 
	 * @type String
	 * @type Long
	 * 
	 * @param idClient
	 * @param idDepartmentOrder
	 * @param beforepage
	 * 
	 * @return beforepage
	 */
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
												//getrenew order
	/**
	 * This method return the clientreneword.jsp page with the a list of Departments and a list
	 * of the mechanics of this department.
	 * 
	 * @type String
	 * @type Long
	 * 
	 * @param idClient
	 * @param idDepartment
	 * 
	 * @return clientreneword
	 */
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
	/**
	 * This method delete client order by id and then update order data (set Client, Department, Employee, Start Order and Order Status) 
	 * and redirect to before page.
	 * 
	 * @type long
	 * @type String
	 * @type DepartmentOrder
	 * @type BindingResult
	 * 
	 * @param idClient
	 * @param idDepartmentOrder
	 * @param departmentOrder
	 * 
	 * @return clientnotcompledoverdord page
	 */
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
	/**
	 * This method return the addservicestationcomment.jsp 
	 * 
	 * @type String
	 * @type Long
	 * 
	 * @param beforepage
	 * @param idClient
	 * @param idServiceStation
	 * 
	 * @return addservicestationcomment.jsp 
	 */
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
	/**
	 * This method save the comments and marks for sevice station by clinet and redirect to before page.
	 * 
	 * @type Long
	 * @type String
	 * @param idClinet
	 * @param beforepage
	 * 
	 * @return beforepage
	 */
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
	/**
	 * This method return the allservicestation.jsp with list of all service station limit 20 per page.
	 * 
	 * @return allservicestation.jsp
	 */
	@RequestMapping(value="/allservicestation",method=RequestMethod.GET)
	public String getallservicestation(Model model) {
		
		logger.info("ClientController GET: all service stations list");
		List<ServiceStation> listServiceStation=(List<ServiceStation>)serviceStationService.getAllServiceStation();
		model.addAttribute("listServiceStation", listServiceStation);
		
		return "/allservicestation"; 						
	}
									//get review service station page
	
	/**
	 * This method return the servicestationreview.jsp with main information about service station.
	 * 
	 * @type String
	 * @type Long
	 * 
	 * @param idServiceStation
	 * @return servicestationreview page
	 */
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
	
	/**
	 * This method return the incompleteclientallord.jsp by client id with support "getClientByEmail" method of clientService.
	 * 
	 * @type String
	 * @type Long
	 * @type Clinet
	 * 
	 * @param Client
	 * @param idClient
	 * @param idServiceStation
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value="/servicestation/{idServiceStation}/servicestationreview",method=RequestMethod.POST)
	public ModelAndView postservicestationreview(@ModelAttribute("client") Client client,
			@PathVariable("idServiceStation") Long idServiceStation,BindingResult result, Model model) {
		
		logger.info("ClientController POST: service station review page");	
		Client autorizedClient =clientService.getClientByEmail(client.getClientEmail());
			
		return new ModelAndView("redirect:" + "/profile/"+autorizedClient.getIdClient()+"/incompleteclientallord");
	}
	
										//get incompleted client page
	/**
	 * This method return the incompleteclientallord.jsp by client id with list of Not Completed & Overdue Client Order
	 * and list of Done Client Order.
	 * 
	 * @type Long
	 * @param idClient
	 * 
	 * @return incompleteclientallord.jsp
	 */
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
	/**
	 * This method return the incompleteclientneword.jsp page with list of all  departments and list
	 * of employee of this department.
	 * 
	 * @return incompleteclientneword page
	 */
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
	/**
	 * This method create new department order. Order is created for non-registered client. Throws
	 * an error if an email is empty or not unique.
	 * 
	 * @type DepartmentOrder
	 * @param DepartmentOrder
	 * 
	 * @return incompleteclientneword page
	 */
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
