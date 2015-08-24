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

import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.Employee;

/**
 * <p>The interface EmployeeService contain methods ads which realize in class EmployeeServiceImpl.
 * Class EmployeeServiceImpl use Service pattern which describes service layer of application.
 * This class contain general operation to all classes.This interface contain ads methods which
 * perform busness logic all application. Interface extend AbstractEntityCommonService interface
 * which contain ads base operation of any entity.
 * 
 * @version 1.0 18.08.2015
 * @author Zaerko Denis
 */
public interface EmployeeService extends AbstractEntityCommonService {

	/**
	 * Return list of employee by last name. If data base contains employee with transmitted
	 * last name return list of employes else return null. List contain serving on 20 rows
	 * and start on 1 row. This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type String
	 * @param employeLastName
	 * 
	 * @return List<Employee> all employee with last name as parametr.
	 */
	public List<Employee> getListEmployeByLastName(String employeLastName);
	
	/**
	 * Return identification number of employee in data base by login and password.
	 * If login and password exist return idEmployee which have type Long else return
	 * null.This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type String
	 * @param employeLogin
	 * @param employePassword
	 * 
	 * @return id(Long) employee by login and password else null.
	 */
	public Long getIdEmployeByLoginPassword(String employeLogin, String employePassword);
	
	/**
	 * Return result of user sign in(true/false).If employee login and password exist in
	 * data base return true else false. Login and password must be unique else method generate
	 * exeption.This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type String
	 * @type Boolean
	 * @param employeLogin
	 * @param employePassword
	 * 
	 * @return Boolean
	 */
	public Boolean signInEmployeByLoginPassword(String employeLogin, String employePassword);
	
	/**
	 * Return list of employee which have function as mechanic.If data base contains mechanic
	 * return list of mechanics else return null. List contain serving on 20 rows and start on
	 * 1 row.This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type List
	 * 
	 * @return List<Employee> all employee which have function as mechanic.
	 */
	public List<Employee> getListMechanic();
	
	/**
	 * Return list of departments in which employee work.If employee work in departments method
	 * return list of work places else return null. List  contain serving on 20 rows and start
	 * on 1 row. This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type Long
	 * @type List
	 * @param idEmployee
	 * 
	 * @return List<Department> all department in which employee work.
	 */
	public List<Department> getListDepartmentForEmployee(Long idEmployee);
	
}
