/**
 * @package com.expositds.servicestationmanagementsystem.service.impl
 * 
 * Package com.expositds.servicestationmanagementsystem.service.impl contain set of class
 * which description service layer in ServiceStationManagementSystem project. This project
 * is based on MVC architecture.This class is part of service layer in MVC architecture.This
 * layer defines the boundary of the application and a set of permitted operations. It
 * encapsulates the business logic of the application and controls the answers in the
 * implementation of operations. All classes which contain postfix “Service” provide to
 * work Service for Service Station Management System application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions. 
 */
package com.expositds.servicestationmanagementsystem.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import com.expositds.servicestationmanagementsystem.dao.ServiceStationDAO;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.Stead;
import com.expositds.servicestationmanagementsystem.service.ServiceStationService;

/**
 * <p>The class ServiceStationServiceImpl use Service pattern which describes business logic application
 * ServiceStationManagemrntSystem. Service layer perform link between, presentation layer and DAO layer.
 * This layer is the main role becouse layer contents(set of methods in classes) affect on functionality
 * of all application.
 * This class contain methods which describes specific operation for ServiceStation.This class perform
 * service layer to ServiceStation.Class extend base class AbstractEntityCommonServiceImpl and implement
 * ServiceStationService interface which perform all methods of this class.
 * For logging use framework shell slf4j and framework log4j.Class contain also private, static variable
 * logger, which use to call log message. Class use Spring framework anatation to work with service layer. 
 *  
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 19.08.2015
 * @author Zaerko Denis
 */
public class ServiceStationServiceImpl extends AbstractEntityCommonServiceImpl implements ServiceStationService {

	/**
	 * Variable logger use to get logger level for class ServiceStationServiceImpl.
	 * 
	 * @param class name: ServiceStationServiceImpl.
	 * @return logger for class ServiceStationServiceImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(ServiceStationServiceImpl.class);

	/**
	 * Annatation Inject use to get injection ServiceStationDAO
	 * dependency. This is part of specification JSR-330.
	 */
	@Inject
	@Qualifier("serviceStationDAO")
	private ServiceStationDAO serviceStationDAO;

	/**
	 * This is set method of injection ServiceStationDAO dependency.
	 * This methods permit operation set(writeable) serviceStationDAO.
	 */
	public void setServiceStationDAO(ServiceStationDAO serviceStationDAO) {
		this.serviceStationDAO = serviceStationDAO;
	}
	 
	/**
	 * Return list of stead which use to service station departments rent. If
	 * service station(departments) use stead as rent method return list stead
	 * else return null.This method addresses to method in DAO layer for execution
	 * operation.   
	 * 
	 * @type Long
	 * @type List
	 * @param idServiceStation)
	 * 
	 * @return List<Stead> which use(include) in service station.
	 */
	public List<Stead> getListSteadUseServiceStation(Long idServiceStation){
		logger.info("Service:Create list stead which use service station by service station id="+idServiceStation);
		return serviceStationDAO.getListSteadUseServiceStation(idServiceStation);
	}
	
	/**
	 * Return total(sum) area which use service station(departments which include in
	 * service station). Method return same value if service station use same stead else
	 * return null.This method addresses to method in DAO layer for execution operation.   
	 * 
	 * @type Long
	 * @type Double
	 * @type List
	 * @param idServiceStation)
	 * 
	 * @return List<Stead> which use(include) in service station.
	 */
	public Double getTotalServiceStationArea(Long idServiceStation){
		logger.info("Service:Count total area which use service station by service station id="+idServiceStation);
		return serviceStationDAO.getTotalServiceStationArea(idServiceStation);
	}
	
	/**
	 * Return list of all service sattion which exist in data base else return null.
	 * This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type List
	 * @return List<ServiceStation> or null.
	 */
	public List<ServiceStation> getAllServiceStation(){
		logger.info("Service:Create list with all service statons.");
		return serviceStationDAO.getAllServiceStation();
	}
	
	
	//other methods
	
}
