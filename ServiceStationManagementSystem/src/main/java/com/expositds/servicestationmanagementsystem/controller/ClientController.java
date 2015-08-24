/**
 * 
 */
package com.expositds.servicestationmanagementsystem.controller;



import java.util.List;
import java.util.Set;

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
import org.springframework.web.servlet.ModelAndView;

import com.expositds.servicestationmanagementsystem.dao.DepartmentDAO;
import com.expositds.servicestationmanagementsystem.dao.ServiceStationDAO;
import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.ClientSecurityFeature;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.ServiceStationCommentMark;
import com.expositds.servicestationmanagementsystem.service.AbstractEntityCommonService;
import com.expositds.servicestationmanagementsystem.service.ClientSecurityFeatureService;
import com.expositds.servicestationmanagementsystem.service.ClientService;
import com.expositds.servicestationmanagementsystem.service.DepartmentOrderService;
import com.expositds.servicestationmanagementsystem.service.ServiceStationCommentMarkService;
import com.expositds.servicestationmanagementsystem.service.ServiceStationService;


/**
 * @author Artyom_Khomyakov
 *
 */
@Controller
public class ClientController {

	/*
     * Connect the Service layer with a Controller
     */
	
	@Inject
	@Qualifier("serviceStationService")
	private ServiceStationService serviceStationService;
	
	@Inject
	@Qualifier("departmentOrderService")
	private DepartmentOrderService departmenOrderService;
	
	@Inject
	@Qualifier("clientService")
	private ClientService clientService;
	
	@Inject
	@Qualifier("clientSecurityFeatureService")
	private ClientSecurityFeatureService clientSecurityFeatureService;
	
	@Inject
	@Qualifier("serviceStationCommentMarkService")
	private ServiceStationCommentMarkService serviceStationCommentMarkService;
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	/*
	 * This method returns the index.jsp of the page along with 
	 * a list of service stations
	*/
	@RequestMapping(value = { "", "/", "/index" }, method = { RequestMethod.GET })
	public String index(Model model) {
		List<ServiceStation> listServiceStation = serviceStationService.getAllServiceStation();
        model.addAttribute("listServiceStation", listServiceStation);
        logger.info("GET:User get index page with list Service Station");
		return "index";
	}


	
	/*
	 * This method returns the registration.jsp page creates an instance 
	 * of the client and adds the attribute "client" in the model
	 */
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String registration(Model model) {	
		Client client = new Client();
		//ClientSecurityFeature clientSecurityFeature = new ClientSecurityFeature();
		//model.addAttribute("clientSecurityFeature", clientSecurityFeature);
		model.addAttribute("client", client);
		logger.info("GET:User get registration page");
		return "registration";
	}
	
	
	/*
	 * This method takes an attribute the client, 
	 * the clientService save entity and redirect profile page
	*/ 
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String signup(@ModelAttribute("client") Client client, Model model) {	
		/*if(!clientSecurityFeatureService.isUniqueLoginPassword(clientSecurityFeature.getClientLogin(), clientSecurityFeature.getClientPassword())){
			model.addAttribute("errorMessage", "Login must be is unique");
			logger.info("POST:Client login not was unique");
			return "registration";
		}
		else{*/
		clientService.saveEntity(client);
		//clientSecurityFeatureService.saveEntity(clientSecurityFeature);
		/*logger.info("POST:New client create successful"+client.getIdClient());*/
		return "registration";
		//}
	}
	
	/*
	 * This method returns the page station.jsp with 
	 * all the information using the attribute ServiceStation
	 * The object of the ServiceStation we make the object of the 
	 * ServiceStation by the method of serviceServiceStation getEntityById.
	 */
	@RequestMapping(value="/station/{idServiceStation}", method=RequestMethod.GET)
	public String station(@PathVariable("idServiceStation") Long idServiceStation, Model model) {	
		Object serviceStation = serviceStationService.getEntityById(ServiceStation.class, idServiceStation);
		model.addAttribute(idServiceStation);
		model.addAttribute(serviceStation);
		logger.info("GET:Service Station page loaded successfully"+idServiceStation);
		return "station";
	}
	
	/*
	 * This method returns a page request.jsp, creates an instance of 
	 * the class DepartmenOrder and records it in attribute model
	 * With help @PathVariable we know about the object ServiceStation
	 */
	@RequestMapping(value="/station/{idServiceStation}/request", method=RequestMethod.GET)
	public String request(@PathVariable("idServiceStation") Long idServiceStation, Model model) {
		Object serviceStation = serviceStationService.getEntityById(ServiceStation.class, idServiceStation);
		model.addAttribute(idServiceStation);
		model.addAttribute(serviceStation);
		DepartmentOrder order = new DepartmentOrder();
		model.addAttribute("DepartmentOrder", order);
		logger.info("GET:Request page loaded successfully"+idServiceStation);
		return "clientrequest";
	}
	
	/*
	 * This method gets the full attribute order.
	 * Service departmenOrderService save the order with help saveEntity method.
	 * Redirect to index page.
	 */
	@RequestMapping(value="/station/{idServiceStation}/request", method=RequestMethod.POST)
	public String send(@ModelAttribute("order") DepartmentOrder order, Model model) {	
		this.departmenOrderService.saveEntity(order);
		return "index";
	}
	
	/*@RequestMapping(value="/station/{idServiceStation}/check", method=RequestMethod.GET)
	public String check(@PathVariable("idServiceStation") Long idServiceStation, Model model) {	
		return "redirect:/station/{idServiceStation}";
	}*/
	
	/*
     * Retrieves the profile pages
     *
     */
	/*
	 * Redirect to inprogress.jsp
	 */
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String home(Model model) {	
		return "redirect:profile/notcompleted";
	}
	
	/*
	 * This method returns inprogress.jsp page together with a list 
	 * orders with the status notcompleted.
	 */
	@RequestMapping(value="/profile/notcompleted", method=RequestMethod.GET)
	public String notcompleted(Client client, Model model) {	
		return "clientnotcompleted";
	}
	
	@RequestMapping(value="/profile/done", method=RequestMethod.GET)
	public String done(Model model) {	
		return "clientdone";
	}
	
	@RequestMapping(value="/profile/overdue", method=RequestMethod.GET)
	public String overdue(Model model) {	
		return "clientoverdue";
	}
	
	@RequestMapping(value="/profile/overdue/renew/{DepartmentId}", method=RequestMethod.GET)
	public String renew(Model model) {	
		return "clientrenew";
	}
	
	@RequestMapping(value= {"/profile/overdue/addcomment/{ServiceStationId}", "/profile/done/addcomment/{ServiceStationId}"}, method=RequestMethod.GET)
	public String addcomment(Model model) {	
		return "clientaddcomment";
	}
	
	@RequestMapping(value="/profile/overdue/detele/{departmentOrderId}", method=RequestMethod.GET)
	public String delete(Model model) {	
		return "redirect:/overdue";
	}
	
}
