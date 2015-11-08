/**
 * @package com.expositds.servicestationmanagementsystem.controlle
 * 
 * Package com.expositds.servicestationmanagementsystem.controlle contain set of classes
 * which perform controller function in ServiceStationManagementSystem project. This project
 * is based on MVC architecture.This class is part of controller in MVC architecture. Controller
 * provides communication between the user and the system: controls user input and uses models
 * and views to implement the necessary response. In Service Station Management System, define
 * three roles Client, Mechanic,Director. For each role,define separate controller.All classes
 * which contain postfix ìControllerî provide to work Controller for Service Station Management
 * System application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions. 
 */
package com.expositds.servicestationmanagementsystem.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

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

import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.model.EmployeeSecurityFeature;
import com.expositds.servicestationmanagementsystem.model.ServiceStationCommentMark;
import com.expositds.servicestationmanagementsystem.service.AbstractEntityCommonService;
import com.expositds.servicestationmanagementsystem.service.DepartmentOrderService;
import com.expositds.servicestationmanagementsystem.service.DepartmentService;
import com.expositds.servicestationmanagementsystem.service.EmployeeSecurityFeatureService;
import com.expositds.servicestationmanagementsystem.service.EmployeeService;
import com.expositds.servicestationmanagementsystem.service.ServiceStationCommentMarkService;
import com.expositds.servicestationmanagementsystem.service.ServiceStationService;

/**
 * Class contain methods which describe communication between user with role director and system.
 * 
 * User with role mechanic performs clinet orders in department. When client do order he choose
 * mechanic from list of mecThe role of the director is as follows:gathering information on the
 * work stations and its departments and generation of financial reports. Also director may right
 * create new mechanic,delete mechanic and edit information about mechanic.Director may browse 
 * client comment about service station.
 * Class DirectorController use technologe IoC for work with other layer in application. All methods
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
@Controller(value="directorController")
public class DirectorController {
	
	/**
	 * Variable logger use to get logger level for class DirectorController.
	 * 
	 * @param class name: DirectorController
	 * @return logger for class DirectorController.
	 */
	private static final Logger logger = LoggerFactory.getLogger(DirectorController.class);
	
	/**
	 * Annatation Inject use to get dependency injection from service
	 * layer classes. This is part of specification JSR-330.
	 */
	@Inject
	@Qualifier("abstractEntity—ommonService")
	private AbstractEntityCommonService abstractEntity—ommonService;
	
	@Inject
	@Qualifier(value="employeeService")
	private EmployeeService employeeService;
	
	@Inject
	@Qualifier(value="employeeSecurityFeatureService")
	private EmployeeSecurityFeatureService employeeSecurityFeatureService;
	
	@Inject
	@Qualifier(value="departmentOrderService")
	private DepartmentOrderService departmentOrderService;
	
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
	
	public void setEmployeeService(EmployeeService employeeService){
		this.employeeService=employeeService;
	}
	
	public void setEmployeeSecurityFeatureService(EmployeeSecurityFeatureService employeeSecurityFeatureService){
		this.employeeSecurityFeatureService=employeeSecurityFeatureService;
	}
	
	public void setDepartmentOrderService(DepartmentOrderService departmentOrderService){
		this.departmentOrderService=departmentOrderService;
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
	
										//get director page
	/**
	 * This method return the directorpage.jsp page by id director with a list of all employee of this Service Station
	 * 
	 * @type Long
	 * @param idDirector
	 * 
	 * @return directorpage page
	 */
	@RequestMapping(value="/profile/{idDirector}/directorpage",method=RequestMethod.GET)
	public String getdirectorpage(@PathVariable("idDirector") Long idDirector,Model model) {

		logger.info("DirectorController GET: director page");
		
		Employee employee=(Employee) abstractEntity—ommonService.getEntityById(Employee.class, idDirector);
		model.addAttribute("employee",employee);
		//model.addAttribute("idDirector",idDirector);
		
		List<Employee> listEmployeeForServiceStation=serviceStationService
				.getListEmployeeForServiceStation(employee.getDirectorOfServiceStation());
		model.addAttribute("listEmployeeForServiceStation",listEmployeeForServiceStation);
		
		return "/directorpage"; 						
	}
										//get delete employee
	/**
	 * This method removes Employee by idEmployee and redirect to directorpage.jsp page.
	 * 
	 * @type Long
	 * @param idDirector
	 * @param idEmployee
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value="/profile/{idDirector}/directorpage/{idEmployee}/delete",method=RequestMethod.GET)
	public ModelAndView getemployeedelete(@PathVariable("idDirector") Long idDirector,
			@PathVariable("idEmployee") Long idEmployee,Model model) {
		
		logger.info("DirectorController GET: delete employee by id="+idEmployee);
		abstractEntity—ommonService.deleteEntityById(Employee.class, idEmployee);
		return new ModelAndView("redirect:" + "/profile/"+idDirector+"/directorpage");
	}
	
										//get edit employee
	/**
	 * This method return the editemployee.jsp page.
	 * 
	 * @type Long
	 * @param idDirector
	 * @param idEmployee
	 * 
	 * @return editemployee page
	 */
	@RequestMapping(value="/profile/{idDirector}/directorpage/{idEmployee}/editemployee",method=RequestMethod.GET)
	public String geteditemployee(@PathVariable("idDirector") Long idDirector,
			@PathVariable("idEmployee") Long idEmployee,Model model){
		
		logger.info("DirectorController GET: edite employee");
		Employee employee=(Employee) abstractEntity—ommonService.getEntityById(Employee.class, idEmployee);		
		model.addAttribute("employee", employee);
		model.addAttribute("idDirector",idDirector);
		
		return "/editemployee";
	}
												//post edit employee
	/**
	 * This method update employee data and redirect to directorpage.jsp.
	 * 
	 * @type Long
	 * @type Employee
	 * 
	 * @param employee
	 * @param idDirector
	 * @param idEmployee
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value="/profile/{idDirector}/directorpage/{idEmployee}/editemployee", method=RequestMethod.POST)
	public ModelAndView posteditemployee(@Valid @ModelAttribute("employee") Employee employee,
			@PathVariable("idDirector") Long idDirector,@PathVariable("idEmployee") Long idEmployee,
			BindingResult result, Model model){
	
		logger.info("DirectorController POST: edit employee");
		//update employee
		abstractEntity—ommonService.updateEntity(employee);
		
		return new ModelAndView("redirect:" + "/profile/"+idDirector+"/directorpage");
	}
	
	/**
	 * This method return the addemployee.jsp page.
	 * 
	 * @type Long
	 * @param idDirector
	 * 
	 * @return addemployee page
	 */
	@RequestMapping(value="/profile/{idDirector}/addemployee",method=RequestMethod.GET)
	public String getaddemployee(@PathVariable("idDirector") Long idDirector,Model model){
		
		logger.info("DirectorController GET: add new employee");
		
		EmployeeSecurityFeature employeeSecurityFeature=new EmployeeSecurityFeature();
		model.addAttribute("employeeSecurityFeature", employeeSecurityFeature);
		
		model.addAttribute("idDirector",idDirector);
		
		return "/addemployee";
	}
	
	/**
	 * This method create new Employee and save him.After redirect to directorpage.jsp
	 * 
	 * @type Long
	 * @type EmployeeSecurityFeature
	 * 
	 * @param employeeSecurityFeature
	 * @param idDirector
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value="/profile/{idDirector}/addemployee", method=RequestMethod.POST)
	public ModelAndView postaddemployee(@Valid @ModelAttribute("employeeSecurityFeature") EmployeeSecurityFeature employeeSecurityFeature,
			@PathVariable("idDirector") Long idDirector,BindingResult result, Model model){
	
		logger.info("DirectorController POST: add new employee");
		
		//save client
		abstractEntity—ommonService.saveEntity(employeeSecurityFeature.getEmployee());
		employeeSecurityFeature.setEmployee(employeeSecurityFeature.getEmployee());
		//save confirm password
		abstractEntity—ommonService.saveEntity(employeeSecurityFeature);
		
		return new ModelAndView("redirect:" + "/profile/"+idDirector+"/directorpage");
	}
		
									//get director comments page
	/**
	 * This method return the directorcomments.jsp page with a list of all comments and marks left by client to ServiceStation
	 * with view status = "director".
	 * 
	 * @type Long
	 * @param idDirector
	 * @param idServiceStation
	 * 
	 * @return directorcomments.jsp
	 */
	@RequestMapping(value="/profile/{idDirector}/{idServiceStation}/directorcomments",method=RequestMethod.GET)
	public String getdirectorshowincomexpres(@PathVariable("idDirector") Long idDirector,
			@PathVariable("idServiceStation") Long idServiceStation,Model model) {

		logger.info("DirectorController GET: director comments page");
		
		Employee employee=(Employee) abstractEntity—ommonService.getEntityById(Employee.class, idDirector);
		model.addAttribute("employee",employee);
		
		List<ServiceStationCommentMark> listServiceStationCommentMark=serviceStationCommentMarkService
				.getListCommentMarkStatusAsParamByIdServiceStation(idServiceStation, "director");
		model.addAttribute("listServiceStationCommentMark",listServiceStationCommentMark);
		
		return "/directorcomments"; 						
	}
								  //get director financical report page
	/**
	 * This method return the directorgeneratereport.jsp page. On page director may
	 * select date report and then genetate financical report for service station.
	 * 
	 * @type Long
	 * 
	 * @param idDirector
	 * @param idServiceStation
	 * 
	 * @return directorgeneratereport page
	 */
	@RequestMapping(value="/profile/{idDirector}/{idServiceStation}/directorgeneratereport",method=RequestMethod.GET)
	public String getdirectorgeneratereport(@PathVariable("idDirector") Long idDirector,
			@PathVariable("idServiceStation") Long idServiceStation,Model model) {
		
		logger.info("DirectorController GET: director financical report page");
		
		Employee employee=(Employee) abstractEntity—ommonService.getEntityById(Employee.class, idDirector);
		model.addAttribute("employee",employee);
		
		DepartmentOrder departmentOrder=new DepartmentOrder();
		departmentOrder.setEndOrder(new Date());
		departmentOrder.setStartOrder(new Date());
		model.addAttribute("departmentOrder",departmentOrder);
		
		List<Department> listDepartment=serviceStationService.getListDepartmentForServiceStation(idServiceStation);
		model.addAttribute("listDepartment",listDepartment);
		
		return "/directorgeneratereport";
	}
	
									//post director financical report page
	/**
	 * This method return the directorgeneratereport.jsp page. On page director may
	 * select department of service station, date report and then genetate financical
	 * report for department.
	 * 
	 * @type Long
	 * 
	 * @param idDirector
	 * @param idServiceStation
	 * 
	 * @return directorgeneratereport page
	 */
	@RequestMapping(value="/profile/{idDirector}/{idServiceStation}/directorgeneratereport",method=RequestMethod.POST)
	public ModelAndView postdirectorgeneratereport(@ModelAttribute("departmentOrder") DepartmentOrder departmentOrder,
			@PathVariable("idDirector") Long idDirector,@PathVariable("idServiceStation") Long idServiceStation,
			BindingResult result, Model model){

		logger.info("DirectorController POST: director financical report page "+departmentOrder.getDepartment().getIdDepartment());
		
		//generate general report
		if(departmentOrder.getDepartment().getIdDepartment().equals((long)0)){
			serviceStationService
				.getFinancialReportForServiceStation(idServiceStation, departmentOrder.getStartOrder(),	departmentOrder.getEndOrder());
			
		//generate report for department	
		}else{
			serviceStationService.getFinancialReportForDepartmet(departmentOrder.getDepartment().getIdDepartment(),
					departmentOrder.getStartOrder(), departmentOrder.getEndOrder());	
		}
		return new ModelAndView("redirect:" + "/profile/"+idDirector+"/"+idServiceStation+"/directorgeneratereport");
	}
}
