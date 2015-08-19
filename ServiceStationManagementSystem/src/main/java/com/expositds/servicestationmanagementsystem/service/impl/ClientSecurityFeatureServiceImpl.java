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

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.expositds.servicestationmanagementsystem.dao.ClientSecurityFeatureDAO;
import com.expositds.servicestationmanagementsystem.service.ClientSecurityFeatureService;

/**
 * <p>The class AbstractEntityCommonServiceImpl use Service pattern which describes business
 * logic application ServiceStationManagemrntSystem. Service layer perform link between,
 * presentation layer and DAO layer.This layer is the main role becouse layer contents(set of
 * methods in classes) affect on functionality of all application.
 * This class contain methods which describes specific operation for ClientSecurityFeatury.This
 * class perform service layer to ClientSecurityFeatureServiceImpl.Class extend  base class
 * AbstractEntityCommonServiceImpl and implement ClientSecurityFeatureService interface which
 * perform all methods of this class.
 * For logging use framework shell slf4j and framework log4j.Class contain also private, static
 * variable logger, which use to call log message. Class use Spring framework anatation to work
 * with service layer. 
 * 
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 18.08.2015
 * @author Zaerko Denis
 */
@Service(value="clientSecurityFeatureService")
public class ClientSecurityFeatureServiceImpl extends AbstractEntityCommonServiceImpl implements ClientSecurityFeatureService {
	
	/**
	 * Variable logger use to get logger level for class ClientSecurityFeatureServiceImpl.
	 * 
	 * @param class name: ClientSecurityFeatureServiceImpl
	 * @return logger for class ClientSecurityFeatureServiceImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(ClientSecurityFeatureServiceImpl.class);
	
	/**
	 * Annatation Inject use to get injection ClientSecurityFeatureDAO
	 * dependency. This is part of specification JSR-330.
	 */
	@Inject
	@Qualifier("clientSecurityFeatureDAO")
	private ClientSecurityFeatureDAO clientSecurityFeatureDAO;
	
	/**
	 * This is set method of injection ClientSecurityFeatureDAO dependency.
	 * This methods permit operation set(writeable) clientSecurityFeatureDAO.
	 */
	public void setClientSecurityFeatureDAO(ClientSecurityFeatureDAO clientSecurityFeatureDAO) {
		this.clientSecurityFeatureDAO = clientSecurityFeatureDAO;
	}
	
	/**
	 * Return result check on unique client login and password. If data base contains transmitted
	 * login or password return false else return true. This methods addresses to method in DAO
	 * layer for execution operation.
	 * 
	 * @type String
	 * @type Boolean
	 * @param clientLogin
	 * @param clientPassword
	 * 
	 * @return true if login and password not exist in data base else false.
	 */
	public Boolean isUniqueLoginPassword(String clientLogin, String clientPassword){
		logger.info("Service:Check on unique login="+clientLogin+" and password="+clientPassword);
		return clientSecurityFeatureDAO.isUniqueLoginPassword(clientLogin, clientPassword);
	}
}
