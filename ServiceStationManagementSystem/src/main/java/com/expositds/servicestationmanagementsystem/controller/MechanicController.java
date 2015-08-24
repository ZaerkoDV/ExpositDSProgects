/**
 * 
 */
package com.expositds.servicestationmanagementsystem.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Detail;
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.ServiceStationCommentMark;
import com.expositds.servicestationmanagementsystem.service.DepartmentOrderService;
import com.expositds.servicestationmanagementsystem.service.DetailService;
import com.expositds.servicestationmanagementsystem.service.EmployeeService;
import com.expositds.servicestationmanagementsystem.service.ServiceStationCommentMarkService;

/**
 * @author Artyom_Khomyakov
 *
 */

@Controller
@RequestMapping("/mechanicpage")
public class MechanicController {
	
	@Inject
	@Qualifier("departmentOrderService")
	private DepartmentOrderService departmenOrderService;
	
	@Inject
	@Qualifier("employeeService")
	private EmployeeService employeeService;
	
	@Inject
	@Qualifier("detailService")
	private DetailService detailService;
	
	@Inject
	@Qualifier("serviceStationCommentMarkService")
	private ServiceStationCommentMarkService serviceStationCommentMarkService;
	
	private static final Logger logger = LoggerFactory.getLogger(MechanicController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(@PathVariable("idEmployee") Long idEmployee, Model model) {
		return "redirect:mechanicpage/{idEmployee}/notdone";
	}
	
	
	@RequestMapping(value="/{idEmployee}/notcompleted", method=RequestMethod.GET)
	public String notcompleted(@PathVariable("idEmployee") Long idEmployee, Model model) {	
		List<DepartmentOrder> listNotDoneOverdue = departmenOrderService.getListNotcompletedOverdueDepartmentOrderForEmployee(idEmployee);
		Object employee = employeeService.getEntityById(Employee.class, idEmployee);
		/*Object costAllDetail = departmenOrderService.getFullDetailCostForDepartmentOrder(idDepartmentOrder);
		model.addAttribute("costAllDetail", costAllDetail);*/
		model.addAttribute("listNotDoneOverdue", listNotDoneOverdue);
		model.addAttribute("employee", employee);
		return "mechanicnotcompletedoverdue";
	}
	
	
	@RequestMapping(value="/{idEmployee}/done", method=RequestMethod.GET)
	public String done(@PathVariable("idEmployee") Long idEmployee, Model model) {	
		List<DepartmentOrder> listDone = departmenOrderService.getListDoneDepartmentOrderForEmployee(idEmployee);
		Object employee = employeeService.getEntityById(Employee.class, idEmployee);
		model.addAttribute("listDone", listDone);
		model.addAttribute("employee", employee);
		return "mechanicdone";
	}
	
	@RequestMapping(value="/{idEmployee}/comments", method=RequestMethod.GET)
	public String comments(@PathVariable("idEmployee") Long idEmployee, Model model) {
		Object employee = employeeService.getEntityById(Employee.class, idEmployee);
		//List<ServiceStationCommentMark> listServiceStationCommentMark = serviceStationCommentMarkService.getListCommentMarkStatusAsParamByIdServiceStation(, null);
		model.addAttribute("employee", employee);
		//`model.addAttribute("listServiceStationCommentMark", listServiceStationCommentMark);
		return "mechaniccomments";
	}
	
	@RequestMapping(value="/notcompleted/save/{DepartmentOrderId}", method=RequestMethod.GET)
	public String save(Model model) {	
		return "mechanicinprogress";
	}
	
	@RequestMapping(value="/notcompleted/order/{DepartmentId}", method=RequestMethod.GET)
	public String order(Model model) {	
		return "mechanicorderdetail";
	}
	
	@RequestMapping(value="/notcompleted/finish/{DepartmentOrderId}", method=RequestMethod.GET)
	public String finish(Model model) {	
		return "mechanicdone";
	}

}
