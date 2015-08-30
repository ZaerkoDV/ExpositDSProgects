/**
 * 
 */
package com.expositds.servicestationmanagementsystem.controller;

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

import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Detail;
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.ServiceStationCommentMark;
import com.expositds.servicestationmanagementsystem.service.AbstractEntityCommonService;
import com.expositds.servicestationmanagementsystem.service.DepartmentOrderService;
import com.expositds.servicestationmanagementsystem.service.DepartmentService;
import com.expositds.servicestationmanagementsystem.service.EmployeeService;
import com.expositds.servicestationmanagementsystem.service.ServiceStationCommentMarkService;
import com.expositds.servicestationmanagementsystem.service.ServiceStationService;

/**
 * @author Denis Zaerko
 * @author Artyom_Khomyakov
 */
@Controller(value="mechanicController")
public class MechanicController {
	
	private static final Logger logger = LoggerFactory.getLogger(MechanicController.class);
	
	@Inject
	@Qualifier("abstractEntity—ommonService")
	private AbstractEntityCommonService abstractEntity—ommonService;
	
	@Inject
	@Qualifier(value="employeeService")
	private EmployeeService employeeService;
	
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
	
								//get mechanic notcompleted and overdue order

	@RequestMapping(value="/profile/{idEmployee}/mechanicnotcompletedoverdord",method=RequestMethod.GET)
	public String getmechanicnotcompletedoverdord(@PathVariable("idEmployee") Long idEmployee,Model model) {
		
		logger.info("MechanicController GET: mechanic notcompleted overdue order page");
		
		Employee employee=(Employee) abstractEntity—ommonService.getEntityById(Employee.class, idEmployee);
		model.addAttribute("employee",employee);
				
		List<DepartmentOrder> listNotcompletedOverdueOrder= departmentOrderService.getListNotcompletedOverdueDepartmentOrderForEmployee(idEmployee);
		model.addAttribute("listNotcompletedOverdueOrder",listNotcompletedOverdueOrder);
	
		return "/mechanicnotcompletedoverdord"; 						
	}
	
										//get mechanic done order
	
	@RequestMapping(value="/profile/{idEmployee}/mechanicdoneord",method=RequestMethod.GET)
	public String getmechanicmechanicdoneord(@PathVariable("idEmployee") Long idEmployee,Model model) {
		
		logger.info("MechanicController GET: mechanic done order page");
		
		Employee employee=(Employee) abstractEntity—ommonService.getEntityById(Employee.class, idEmployee);
		model.addAttribute("employee",employee);
		
		List<DepartmentOrder> listDoneOrder= departmentOrderService.getListDoneDepartmentOrderForEmployee(idEmployee);
		model.addAttribute("listDoneOrder",listDoneOrder);
		
		return "/mechanicdoneord";
	}
										//get mechanic edit order
	
	@RequestMapping(value="/profile/{idEmployee}/{idDepartmentOrder}/mechaniccreateord",method=RequestMethod.GET)
	public String getmechaniccreateord(@PathVariable("idEmployee") Long idEmployee,
			@PathVariable("idDepartmentOrder") Long idDepartmentOrder, Model model) {
		
		logger.info("MechanicController GET: mechanic create order page");
		
		DepartmentOrder departmentOrder=(DepartmentOrder) abstractEntity—ommonService
				.getEntityById(DepartmentOrder.class, idDepartmentOrder);
		model.addAttribute("departmentOrder", departmentOrder);
		
		Client client=departmentOrder.getClient();
		model.addAttribute("client",client);
		
		Double fullDetailCostForOrder= departmentOrderService.getFullDetailCostForDepartmentOrder(idDepartmentOrder);
		model.addAttribute("fullDetailCostForOrder",fullDetailCostForOrder);
		
		return "/mechaniccreateord";
	}
	
										//post mechanic edit order
	
	@RequestMapping(value="/profile/{idEmployee}/{idDepartmentOrder}/mechaniccreateord",method=RequestMethod.POST)
	public ModelAndView postmechaniccreateord(@Valid @ModelAttribute("departmentOrder") DepartmentOrder departmentOrder,
			@PathVariable("idEmployee") Long idEmployee,@PathVariable("idDepartmentOrder") Long idDepartmentOrder,	Model model){
		
		logger.info("MechanicController POST: mechanic create order page");
		DepartmentOrder departmentOrderAfterEdit=(DepartmentOrder) abstractEntity—ommonService
				.getEntityById(DepartmentOrder.class, idDepartmentOrder);
		
		//upated order description
		departmentOrderAfterEdit.setOrderDescription(departmentOrder.getOrderDescription());
		//order cost is sum of work cost and details cost	
		Double fullDetailCostForOrder= departmentOrderService.getFullDetailCostForDepartmentOrder(idDepartmentOrder);
		departmentOrderAfterEdit.setOrderCost(fullDetailCostForOrder+departmentOrder.getWorkCost());
		//upated work cost
		departmentOrderAfterEdit.setWorkCost(departmentOrder.getWorkCost());
		//update end order date
		departmentOrderAfterEdit.setEndOrder(departmentOrder.getEndOrder());
		//update order status
		departmentOrderAfterEdit.setOrderStatus(departmentOrder.getOrderStatus());
		
		abstractEntity—ommonService.updateEntity(departmentOrderAfterEdit);	

		return new ModelAndView("redirect:" + "/profile/"+idEmployee+"/mechanicnotcompletedoverdord");
	}	
									//get create detail for department order
	
	@RequestMapping(value="/profile/{idEmployee}/{idDepartmentOrder}/mechanicchangedetail",method=RequestMethod.GET)
	public String getmechanicchangedetail(@PathVariable("idEmployee") Long idEmployee,@PathVariable("idDepartmentOrder") 
			Long idDepartmentOrder, Model model){
		
		logger.info("MechanicController GET: mechanic create detail for order.");
		
		Detail detail=new Detail();
		model.addAttribute("detail", detail);
		model.addAttribute("idEmployee",idEmployee);
		model.addAttribute("idDepartmentOrder",idDepartmentOrder);
		
		return "/mechanicchangedetail";
	}
									//post create detail for department order
	
	@RequestMapping(value="/profile/{idEmployee}/{idDepartmentOrder}/mechanicchangedetail",method=RequestMethod.POST)
	public ModelAndView getmechanicchangedetail(@Valid @ModelAttribute("detail") Detail detail,
			@PathVariable("idEmployee") Long idEmployee,@PathVariable("idDepartmentOrder") Long idDepartmentOrder,
			BindingResult result, Model model){
		
		logger.info("MechanicController POST: mechanic create detail for order.");
		
		DepartmentOrder departmentOrder=(DepartmentOrder) abstractEntity—ommonService
				.getEntityById(DepartmentOrder.class, idDepartmentOrder);
		//save new detail for order
		detail.setDepartmentOrder(departmentOrder);
		abstractEntity—ommonService.saveEntity(detail);		
		
		return new ModelAndView("redirect:" + "/profile/"+idEmployee+"/"+idDepartmentOrder+"/mechaniccreateord");
	}
		
									//get list details for department order
	
	@RequestMapping(value="/profile/{idEmployee}/{idDepartmentOrder}/detailindepartmentord",method=RequestMethod.GET)
	public String getdetailindepartmentord(@PathVariable("idEmployee") Long idEmployee,
			@PathVariable("idDepartmentOrder") Long idDepartmentOrder, Model model) {

		logger.info("MechanicController GET: page details for department order");
		List<Detail> listDetail=departmentOrderService.getListDetailForDepartmentOrder(idDepartmentOrder);
		model.addAttribute("listDetail",listDetail);

		model.addAttribute("idEmployee",idEmployee);
		model.addAttribute("idDepartmentOrder",idDepartmentOrder);

		return "/detailindepartmentord";
	}
	
									//get delete detail in department order

	@RequestMapping(value="/profile/{idEmployee}/{idDepartmentOrder}/detailindepartmentord/{idDetail}/delete",method=RequestMethod.GET)
	public ModelAndView getDeleteDetailInDepartmentOrd(@PathVariable("idEmployee") Long idEmployee,@PathVariable("idDepartmentOrder") 
		Long idDepartmentOrder,@PathVariable("idDetail") Long idDetail, Model model) {

		logger.info("MechanicController GET: delete detail frome department order");
		abstractEntity—ommonService.deleteEntityById(Detail.class, idDetail);

		return new ModelAndView("redirect:" + "/profile/"+idEmployee+"/"+idDepartmentOrder+"/detailindepartmentord");
	}
	
								//get mechanic comments in service station
	
	@RequestMapping(value="/profile/{idEmployee}/mechanicselectcomments",method=RequestMethod.GET)
	public String getmechanicselectcomments(@PathVariable("idEmployee") Long idEmployee,Model model) {
		
		logger.info("MechanicController GET: mechanic select comment page");
	
		ServiceStationCommentMark serviceStationCommentMark=new ServiceStationCommentMark();
		model.addAttribute("serviceStationCommentMark",serviceStationCommentMark);
		
		List<ServiceStation> listServiceStation=serviceStationService.getAllServiceStation();
		model.addAttribute("listServiceStation",listServiceStation);
		
		model.addAttribute("idEmployee",idEmployee);
		
		return "/mechanicselectcomments"; 						
	}
	
								//post mechanic comments in service station
	
	@RequestMapping(value="/profile/{idEmployee}/mechanicselectcomments",method=RequestMethod.POST)
	public String postmechanicselectcomments(@ModelAttribute("serviceStationCommentMark") ServiceStationCommentMark serviceStationCommentMark,
			@PathVariable("idEmployee") Long idEmployee, BindingResult result, Model model) {
		
		logger.info("MechanicController POST: mechanic select comment page");
		Long idServiceStation=serviceStationCommentMark.getServiceStation().getIdServiceStation();
		
		List<ServiceStationCommentMark> listServiceStationCommentMark=(List<ServiceStationCommentMark>) serviceStationCommentMarkService
				.getListCommentMarkStatusAsParamByIdServiceStation(idServiceStation, "mechanic");
		model.addAttribute("listServiceStationCommentMark",listServiceStationCommentMark);
		
		model.addAttribute("idEmployee",idEmployee);
		
		ServiceStation serviceStation =(ServiceStation) abstractEntity—ommonService.getEntityById(ServiceStation.class, idServiceStation);
		model.addAttribute("serviceStation",serviceStation);
		
		return "/mechaniccommentsinservicestation";
	}
	
}
