/**
 * @package com.expositds.servicestationmanagementsystem.service.impl
 * 
 * Package com.expositds.servicestationmanagementsystem.service.impl contain set of class
 * which description service layer in ServiceStationManagementSystem project. This project
 * is based on MVC architecture.This class is part of service layer in MVC architecture.This
 * layer defines the boundary of the application and a set of permitted operations. It
 * encapsulates the business logic of the application and controls the answers in the
 * implementation of operations. All classes which contain postfix “Service” provide to
 * work Service  for Service Station Management System application.
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
import org.springframework.stereotype.Service;

import com.expositds.servicestationmanagementsystem.dao.ServiceStationCommentMarkDAO;
import com.expositds.servicestationmanagementsystem.model.ServiceStationCommentMark;
import com.expositds.servicestationmanagementsystem.service.ServiceStationCommentMarkService;

/**
 * <p>The class ServiceStationCommentMarkServiceImpl use Service pattern which describes business
 * logic application ServiceStationManagemrntSystem. Service layer perform link between, presentation
 * layer and DAO layer.This layer is the main role becouse layer contents(set of methods in classes)
 * affect on functionality of all application.
 * This class contain methods which describes specific operation for ServiceStationCommentMark.This
 * class perform service layer to Detail.Class extend base class AbstractEntityCommonServiceImpl and
 * implement ServiceStationCommentMarkService interface which perform all methods of this class.
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
@Service(value="serviceStationCommentMarkService")
public class ServiceStationCommentMarkServiceImpl extends AbstractEntityCommonServiceImpl implements ServiceStationCommentMarkService {

	/**
	 * Variable logger use to get logger level for class ServiceStationCommentMarkServiceImpl.
	 * 
	 * @param class name: DetailServiceImpl.
	 * @return logger for class DetailServiceImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(ServiceStationCommentMarkServiceImpl.class);

	/**
	 * Annatation Inject use to get injection ServiceStationCommentMarkDAO
	 * dependency. This is part of specification JSR-330.
	 */
	@Inject
	@Qualifier("serviceStationCommentMarkDAO")
	private ServiceStationCommentMarkDAO serviceStationCommentMarkDAO;

	/**
	 * This is set method of injection ServiceStationCommentMarkDAO dependency.This methods
	 * permit operation set(writeable) serviceStationCommentMarkDAO.
	 */
	public void setServiceStationCommentMarkDAO(ServiceStationCommentMarkDAO serviceStationCommentMarkDAO) {
		this.serviceStationCommentMarkDAO = serviceStationCommentMarkDAO;
	}	

	/**
	 * Return list of service station mark and comment with status as paremetr
	 * Parametr viewStatus may have next value:all, mechnic, director. List 
	 * contain serving on 20 rows and start on 1 row.If list comments and mark
	 * is empty return null.This methods addresses to method in DAO layer for
	 * execution operation.
	 * 
	 * @type List
	 * @type Long
	 * @type String
	 * @param idServiceStation
	 * @param viewStatus
	 * 
	 * @return List<ServiceStationCommentMark> or null;
	 */
	public List<ServiceStationCommentMark> getListCommentMarkStatusAsParamByIdServiceStation(Long idServiceStation,String viewStatus){
		logger.info("Service:Create list comment and mark with view status="+viewStatus+" for serivice"
				+ " station by id service station="+idServiceStation);
		return serviceStationCommentMarkDAO.getListCommentMarkStatusAsParamByIdServiceStation(idServiceStation, viewStatus);
	}

	/**
	 * Return list of service station mark and comment in all service stations
	 * which hava any view status and write one client. List  contain serving on
	 * 20 rows and start on 1 row. If list comments and mark is empty return null.
	 * This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type List
	 * @type Long
	 * @type String
	 * @param idServiceStation
	 * @param viewStatus
	 * 
	 * @return List<ServiceStationCommentMark> or null;
	 */
	public List<ServiceStationCommentMark> getListCommentMarkByIdClient(Long idClient){
		logger.info("Service:Create list comment and mark for client="+idClient);
		return serviceStationCommentMarkDAO.getListCommentMarkByIdClient(idClient);
	}

	/**
	 * Return list of service station mark and comment for service station which
	 * sorted by degerssive mark. List contain serving on 20 rows and start on 1 row.
	 * If list comments and mark is empty return null.This methods addresses to method
	 * in DAO layer for execution operation.
	 * 
	 * @type List
	 * @type Long
	 * @type String
	 * @param idServiceStation
	 * @param viewStatus
	 * 
	 * @return List<ServiceStationCommentMark> or null;
	 */
	public List<ServiceStationCommentMark> getListCommentMarkSortByDegressiveMark(Long idServiceStation){
		logger.info("Service:Create list comment and mark sort by degessive mark for service"
				+ " station by service staiotion id="+idServiceStation);
		return serviceStationCommentMarkDAO.getListCommentMarkSortByDegressiveMark(idServiceStation);
	}
}
