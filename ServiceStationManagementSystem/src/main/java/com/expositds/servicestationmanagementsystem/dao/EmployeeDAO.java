/**
 * @package com.expositds.servicestationmanagementsystem.dao
 * 
 * Package com.expositds.servicestationmanagementsystem.dao contain set of classes and
 * interfaces which description layer of data access object in ServiceStationManagementSystem
 * project. This project is based on MVC architecture.This class is part of dao layer in MVC
 * architecture. This layer offer abstract interface for work with any type data base. This 
 * pattern give a chance work with DAO (data-access-object) without matter what kind of storage
 * engine is used and without need for a special way to match this storage engine. All classes
 * which contain word"DAO"provide to work DAL for Service Station Management System application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.   
 */
package com.expositds.servicestationmanagementsystem.dao;

import java.util.List;

import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.Employee;

/**
 * <p>The interface EmployeeDAO contain methods ads which realize in class EmployeeDAOImpl.
 * Class EmployeeDAOImpl use DAO pattern which describes layer of data access to object. DAO
 * layer perform link between relational and object model.Model for this dao layer describied
 * in class Employee.This interface contain ads methods which intended to access to operation
 * with objects.Class use Spring framework to work whith ORM.In particular often use
 * HibernateTemplate for integration Hibernate and Spring technologys. For work with data base
 * use hibernate criteria. 
 * 
 * @version 1.0 11.08.2015
 * @author Zaerko Denis
 */
public interface EmployeeDAO {

	/**
	 * Return list of employee by last name. If data base contains employee with transmitted
	 * last name return list of employes else return null. List contain serving on 20 rows
	 * and start on 1 row. 
	 * 
	 * @type String
	 * @param employeLastName
	 * @throw DataAccessException 
	 * @throw NullPointerException
	 * 
	 * @return List<Employee> all employee with last name as parametr.
	 */
	public List<Employee> getListEmployeByLastName(String employeLastName);
	
	/**
	 * Return identification number of employee in data base by login and password.
	 * If login and password exist return idEmployee which have type Long else return
	 * null.
	 * 
	 * @type String
	 * @param employeLogin
	 * @param employePassword
	 * @throws NullPointerException
	 * @throw DataAccessException
	 * 
	 * @return Long
	 */
	public Long getIdEmployeByLoginPassword(String employeLogin, String employePassword);
	
	/**
	 * Return result of user sign in(true/false).If employee login and password
	 * exist in data base return true else false. Login and password must be
	 * unique else method generate exeption NonUniqueResultException.
	 * 
	 * @type String
	 * @type Boolean
	 * @param employeLogin
	 * @param employePassword
	 * @throw HibernateObjectRetrievalFailureException
	 * 
	 * @return Boolean
	 */
	public Boolean signInEmployeByLoginPassword(String employeLogin, String employePassword);
	
	/**
	 * Return list of employee which have function as mechanic.If data base
	 * contains mechanic return list of mechanics else return null. List 
	 * contain serving on 20 rows and start on 1 row. 
	 * 
	 * @type List
	 * @throw DataAccessException 
	 * @throw NullPointerException
	 * 
	 * @return List<Employee> all employee which have function as mechanic.
	 */
	public List<Employee> getListMechanic();
	
	/**
	 * Return list of departments in which employee work.If employee work
	 * in departments method return list of work places else return null.
	 * List  contain serving on 20 rows and start on 1 row. 
	 * 
	 * @type List
	 * @throw DataAccessException 
	 * @throw NullPointerException
	 * 
	 * @return List<Employee> all employee which have function as mechanic.
	 */
	public List<Department> getListDepartmentForEmployee(Long idEmployee);
	
	
}
