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

/**
 * <p>The interface EmployeeSecurityFeatureService contain methods ads which realize in class
 * EmployeeSecurityFeatureServiceImpl. Class EmployeeSecurityFeatureService use Service pattern
 * which describes service layer of application. This class contain general operation to
 * all classes.This interface contain ads methods which perform busness logic all application.
 * Interface extend AbstractEntityCommonService interface which contain ads base operation of any
 * entity.
 * 
 * @version 1.0 18.08.2015
 * @author Zaerko Denis
 */
public interface EmployeeSecurityFeatureService extends AbstractEntityCommonService {

	/**
	 * Return result check on unique client login and password. If data base contains transmitted
	 * login or password return false else return true. 
	 * 
	 * @type String
	 * @type Boolean
	 * @param clientLogin
	 * @param clientPassword
	 * 
	 * @return true if login and password not exist in data base else false.
	 */
	public Boolean isUniqueLoginPassword(String employeLogin, String employePassword);
}
