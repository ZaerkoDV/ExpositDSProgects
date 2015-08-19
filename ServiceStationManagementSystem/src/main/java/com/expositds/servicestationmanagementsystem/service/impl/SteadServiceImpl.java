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

import com.expositds.servicestationmanagementsystem.dao.SteadDAO;
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.Stead;
import com.expositds.servicestationmanagementsystem.service.SteadService;

/**
 * <p>The class SteadServiceImpl use Service pattern which describes business logic application
 * ServiceStationManagemrntSystem. Service layer perform link between, presentation layer and DAO layer.
 * This layer is the main role becouse layer contents(set of methods in classes) affect on functionality
 * of all application.
 * This class contain methods which describes specific operation for Stead.This class perform service
 * layer to Stead.Class extend base class AbstractEntityCommonServiceImpl and implement SteadService interface
 * which perform all methods of this class.
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
@Service(value="steadService")
public class SteadServiceImpl extends AbstractEntityCommonServiceImpl implements SteadService{

	/**
	 * Variable logger use to get logger level for class SteadServiceImpl.
	 * 
	 * @param class name: SteadServiceImpl.
	 * @return logger for class SteadServiceImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(SteadServiceImpl.class);

	/**
	 * Annatation Inject use to get injection SteadDAO
	 * dependency. This is part of specification JSR-330.
	 */
	@Inject
	@Qualifier("steadDAO")
	private SteadDAO steadDAO;

	/**
	 * This is set method of injection SteadDAO dependency.This methods
	 * permit operation set(writeable) steadDAO.
	 */
	public void setSteadDAO(SteadDAO steadDAO) {
		this.steadDAO = steadDAO;
	}

	/**
	 * Return list of stead if steads exist in data base else return null.This method
	 * addresses to method in DAO layer for execution operation. 
	 * 
	 * @type List
	 * 
	 * @return List<Stead> all stead if steads exist else null.
	 */
	public List<Stead> getListStead(){
		logger.info("Service:Create list all stead");
		return steadDAO.getListStead();
	}

	/**
	 * Return list of departments which use current stead if steads exist in data base
	 * else return null.This method addresses to method in DAO layer for execution operation. 
	 * 
	 * @type List
	 * @type Long
	 * @param idStead
	 * 
	 * @return List<Department> which use current stead else return null.
	 */
	public List<Department> getListDepartmentUseCurrentStead(Long idStead){
		logger.info("Service:Create list department which use current stead by stead id="+idStead);
		return steadDAO.getListDepartmentUseCurrentStead(idStead);
	}
}
