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

import com.expositds.servicestationmanagementsystem.dao.DetailDAO;
import com.expositds.servicestationmanagementsystem.model.Detail;
import com.expositds.servicestationmanagementsystem.service.DetailService;

/**
 * <p>The class DetailServiceImpl use Service pattern which describes business logic application
 * ServiceStationManagemrntSystem. Service layer perform link between, presentation layer and DAO
 * layer.This layer is the main role becouse layer contents(set of methods in classes) affect on
 * functionality of all application.
 * This class contain methods which describes specific operation for Detail.This class perform
 * service layer to Detail.Class extend base class AbstractEntityCommonServiceImpl and implement
 * DetailService interface which perform all methods of this class.
 * For logging use framework shell slf4j and framework log4j.Class contain also private, static
 * variable logger, which use to call log message. Class use Spring framework anatation to work
 * with service layer. 
 *  
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 19.08.2015
 * @author Zaerko Denis
 */
@Service(value="detailService")
public class DetailServiceImpl extends AbstractEntityCommonServiceImpl implements DetailService{
	
	/**
	 * Variable logger use to get logger level for class DetailServiceImpl.
	 * 
	 * @param class name: DetailServiceImpl.
	 * @return logger for class DetailServiceImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(DetailServiceImpl.class);

	/**
	 * Annatation Inject use to get injection DetailDAO
	 * dependency. This is part of specification JSR-330.
	 */
	@Inject
	@Qualifier("detailDAO")
	private DetailDAO detailDAO;

	/**
	 * This is set method of injection DetailDAO dependency.This methods
	 * permit operation set(writeable) detailDAO.
	 */
	public void setDetailDAO(DetailDAO detailDAO) {
		this.detailDAO = detailDAO;
	}
	
	/**
	 * Return list of all details(exist or not exist at that momant). If data base contains
	 * any datails method return list of details else return null. List contain serving on
	 * 20 rows and start on 1 row. This methods addresses to method in DAO layer for execution
	 * operation.
	 * 
	 * @type List
	 * 
	 * @return List<Detail> or null
	 */
	public List<Detail> getListAllDetail(){
		logger.info("Service:Get list all detail.");
		return detailDAO.getListAllDetail();
	}
	
	/**
	 * Return list of details which have same status. Status details for search indicated
	 * as parametr. If data base contains datail with status method return list of this 
	 * details else return null. List contain serving on 20 rows and start on 1 row. 
	 * This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type List
	 * @type String
	 * @param detailStaus
	 * 
	 * @return List<Detail> with status or null.
	 */
	public List<Detail> getListDetailWithStausAsParam(String detailStaus){
		logger.info("Service:Get list detail with status="+detailStaus);
		return detailDAO.getListDetailWithStausAsParam(detailStaus);
	}
}
