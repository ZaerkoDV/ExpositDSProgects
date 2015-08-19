/**
 * @package com.expositds.servicestationmanagementsystem.service
 * 
 * Package com.expositds.servicestationmanagementsystem.service contain set of interfaces
 * which description service layer in ServiceStationManagementSystem project. This project
 * is based on MVC architecture.This inerface perform class which is part of service layer in
 * MVC architecture.This layer defines the boundary of the application and a set of permitted
 * operations. It encapsulates the business logic of the application and controls the answers
 * in the implementation of operations. All classes which contain postfix “Service” provide to
 * work Service  for Service Station Management System application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions. 
 */
package com.expositds.servicestationmanagementsystem.service;

import java.util.List;

import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.Stead;

/**
 * <p>The interface SteadService contain methods ads which realize in class SteadServiceImpl. Class
 * SteadServiceImpl use Service pattern which describes service layer of application. This class
 * contain general operation to all classes.This interface contain ads methods which perform busness
 * logic all application. Interface extend AbstractEntityCommonService interface which contain ads
 * base operation of any entity.
 * 
 * @version 1.0 19.08.2015
 * @author Zaerko Denis
 */
public interface SteadService extends  AbstractEntityCommonService {

	 /**
	  * Return list of stead if steads exist in data base else return null.This method
	  * addresses to method in DAO layer for execution operation. 
	  * 
	  * @type List
	  * 
	  * @return List<Stead> all stead if steads exist else null.
	  */
	public List<Stead> getListStead();
	
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
	public List<Department> getListDepartmentUseCurrentStead(Long idStead);
}
