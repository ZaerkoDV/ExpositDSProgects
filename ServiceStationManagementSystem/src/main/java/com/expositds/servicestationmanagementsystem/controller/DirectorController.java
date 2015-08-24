package com.expositds.servicestationmanagementsystem.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.service.DepartmentOrderService;
import com.expositds.servicestationmanagementsystem.service.DepartmentService;
import com.expositds.servicestationmanagementsystem.service.EmployeeService;
import com.expositds.servicestationmanagementsystem.service.ServiceStationService;

/**
 * @author Artyom_Khomyakov
 *
 */



@Controller
@RequestMapping("/directorpage")
public class DirectorController {
	
	@Inject
	@Qualifier("departmentOrderService")
	private DepartmentOrderService departmenOrderService;
	
	@Inject
	@Qualifier("departmentService")
	private DepartmentService departmenService;
	
	@Inject
	@Qualifier("serviceStationService")
	private ServiceStationService serviceStationService;
	
	@Inject
	@Qualifier("employeeService")
	private EmployeeService employeeService;
	
	private static final Logger logger = LoggerFactory.getLogger(DirectorController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model) {
		return "redirect:directorpage/income";
	}
	
	@RequestMapping(value="/{idEmployee}/income", method=RequestMethod.GET)
	public String income(@PathVariable("idEmployee") Long idEmployee, Model model) {	
		Object employee = employeeService.getEntityById(Employee.class, idEmployee);
		//List<Department> incomeForDone = departmenService.getFullIncomeForDoneDepartmentOrder(idDepartment, startData, endData);
		//List<Department> incomeForNotDoneOverdue = departmenService.getFullIncomeForNotcompletedOverdueDepartmentOrder(idDepartment);
		//List<ServiceStation> listDepartment = serviceStationService.getListDepartmentForServiceStation(idServiceStation);
		//model.addAttribute("listDepartment", listDepartment);
		model.addAttribute("employee", employee);
		//model.addAttribute("incomeForDone", incomeForDone);
		//model.addAttribute("incomeForNotDoneOverdue", incomeForNotDoneOverdue);
		return "directorincome";
	}
	
	@RequestMapping(value="/{idEmployee}/income", method=RequestMethod.POST)
	public String incomePost(@ModelAttribute("employee, incomeForDone, incomeForNotDoneOverdue") @PathVariable("idEmployee") Long idEmployee, Model model) {	
		
		return "directorincome";
	}
	
	@RequestMapping(value="/{idEmployee}/costs", method=RequestMethod.GET)
	public String costs(@PathVariable("idEmployee") Long idEmployee, Model model) {	
		Object employee = employeeService.getEntityById(Employee.class, idEmployee);
		model.addAttribute("employee", employee);
		return "directorcosts";
	}
	
	@RequestMapping(value="/{idEmployee}/comments", method=RequestMethod.GET)
	public String comments(@PathVariable("idEmployee") Long idEmployee, Model model) {	
		Object employee = employeeService.getEntityById(Employee.class, idEmployee);
		model.addAttribute("employee", employee);
		return "directorcomments";
	}
	
	@RequestMapping(value="/{idEmployee}/report", method=RequestMethod.GET)
	public String report(@PathVariable("idEmployee") Long idEmployee, Model model) {	
		return "directorreport";
	}
	
	@RequestMapping(value="/{idEmployee}/report/download", method=RequestMethod.POST)
	public String dowload(Model model) {	
		return "redirect:/directorpage/report";
	}

}
