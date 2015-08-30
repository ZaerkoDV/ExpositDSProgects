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
 * @author Denis Zaerko
 * @author Artyom_Khomyakov
 */
@Controller(value="directorController")
public class DirectorController {
	
private static final Logger logger = LoggerFactory.getLogger(DirectorController.class);
	
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

	@RequestMapping(value="/profile/{idDirector}/directorpage",method=RequestMethod.GET)
	public String getdirectorpage(@PathVariable("idDirector") Long idDirector,Model model) {

		logger.info("DirectorController GET: director page");
		
		Employee employee=(Employee) abstractEntity—ommonService.getEntityById(Employee.class, idDirector);
		model.addAttribute("employee",employee);
		
		List<Employee> listEmployeeForServiceStation=serviceStationService
				.getListEmployeeForServiceStation(employee.getDirectorOfServiceStation());
		model.addAttribute("listEmployeeForServiceStation",listEmployeeForServiceStation);
		
		return "/directorpage"; 						
	}
										//get delete employee
	
	@RequestMapping(value="/profile/{idDirector}/directorpage/{idEmployee}/delete",method=RequestMethod.GET)
	public ModelAndView getemployeedelete(@PathVariable("idDirector") Long idDirector,
			@PathVariable("idEmployee") Long idEmployee,Model model) {
		
		logger.info("DirectorController GET: delete employee by id="+idEmployee);
		abstractEntity—ommonService.deleteEntityById(Employee.class, idEmployee);
		return new ModelAndView("redirect:" + "/profile/"+idDirector+"/directorpage");
	}
	
										//get edit employee
	
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
	
	@RequestMapping(value="/profile/{idDirector}/directorpage/{idEmployee}/editemployee", method=RequestMethod.POST)
	public ModelAndView posteditemployee(@Valid @ModelAttribute("employee") Employee employee,
			@PathVariable("idDirector") Long idDirector,@PathVariable("idEmployee") Long idEmployee,
			BindingResult result, Model model){
	
		logger.info("DirectorController POST: edit employee");
		//update employee
		abstractEntity—ommonService.updateEntity(employee);
		
		return new ModelAndView("redirect:" + "/profile/"+idDirector+"/directorpage");
	}
	

	@RequestMapping(value="/profile/{idDirector}/addemployee",method=RequestMethod.GET)
	public String getaddemployee(@PathVariable("idDirector") Long idDirector,Model model){
		
		logger.info("DirectorController GET: add new employee");
		
		EmployeeSecurityFeature employeeSecurityFeature=new EmployeeSecurityFeature();
		model.addAttribute("employeeSecurityFeature", employeeSecurityFeature);
		
		model.addAttribute("idDirector",idDirector);
		
		return "/addemployee";
	}
	
	
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
