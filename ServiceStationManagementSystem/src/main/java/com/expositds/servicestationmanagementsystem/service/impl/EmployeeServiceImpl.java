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
import org.springframework.transaction.annotation.Transactional;

import com.expositds.servicestationmanagementsystem.dao.EmployeeDAO;
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.service.EmployeeService;

/**
 * <p>The class EmployeeServiceImpl use Service pattern which describes business logic application
 * ServiceStationManagemrntSystem. Service layer perform link between, presentation layer and DAO
 * layer.This layer is the main role becouse layer contents(set of methods in classes) affect on
 * functionality of all application.
 * This class contain methods which describes specific operation for Employee.This class perform
 * service layer to EmployeeServiceImpl.Class extend base class AbstractEntityCommonServiceImpl and
 * implement EmployeeService interface which perform all methods of this class.
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
@Service(value="employeeService")
public class EmployeeServiceImpl extends AbstractEntityCommonServiceImpl implements EmployeeService {

	/**
	 * Variable logger use to get logger level for class EmployeeServiceImpl.
	 * 
	 * @param class name: EmployeeServiceImpl.
	 * @return logger for class EmployeeServiceImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	/**
	 * Annatation Inject use to get injection EmployeeDAO
	 * dependency. This is part of specification JSR-330.
	 */
	@Inject
	@Qualifier("employeeDAO")
	private EmployeeDAO employeeDAO;

	/**
	 * This is set method of injection EmployeeDAO dependency. This methods
	 * permit operation set(writeable) employeeDAO.
	 */
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
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
	public List<Employee> getListEmployeByLastName(String employeLastName){
		logger.info("Service:Create list employee by last name="+employeLastName);
		return employeeDAO.getListEmployeByLastName(employeLastName);
	}
	
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
	public Long getIdEmployeByLoginPassword(String employeLogin, String employePassword){
		logger.info("Service:get id employee by login="+employeLogin+" and password="+employePassword);
		return employeeDAO.getIdEmployeByLoginPassword(employeLogin, employePassword);
	}
	
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
	public Boolean signInEmployeByLoginPassword(String employeLogin, String employePassword){
		logger.info("Service: Employee sign in by login="+employeLogin+" and password="+employePassword);
		return employeeDAO.signInEmployeByLoginPassword(employeLogin, employePassword);
	}
	
	/**
	 * Return list of employee which have function as mechanic.If data base contains mechanic
	 * return list of mechanics else return null. List contain serving on 20 rows and start on
	 * 1 row.This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type List
	 * 
	 * @return List<Employee> all employee which have function as mechanic.
	 */
	public List<Employee> getListMechanic(){
		logger.info("Service:Create list employee with function mechanic");
		return employeeDAO.getListMechanic();
	}

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
	public List<Department> getListDepartmentForEmployee(Long idEmployee){
		logger.info("Service:Get list departments in which employee work by employee id="+idEmployee);
		return employeeDAO.getListDepartmentForEmployee(idEmployee);
	}
}
