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

import java.util.Date;
import java.util.List;

import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Employee;

/**
 * <p>The interface DepartmentDAO contain methods ads which realize in class DepartmentDAOImpl.
 * Class DepartmentDAOImpl use DAO pattern which describes layer of data access to object. DAO
 * layer perform link between relational and object model. Model for this dao layer describied
 * in class Department.This interface contain ads methods which intended to access operation
 * with object.Interface produce special operation with object.Base operation(for any object)
 * include as separate interface AbstractEntityCommonDAO which extend to this interface.Class
 * use Spring framework to work whith ORM.In particular often use HibernateTemplate for integration
 * Hibernate and Spring technologys. For work with data base use hibernate criteria. 
 * 
 * @version 1.0 11.08.2015
 * @author Zaerko Denis
 */
public interface DepartmentDAO extends AbstractEntityCommonDAO {

	/**
	 * Method return list of order in department by department id. Parametr
	 * (department id) must be not null and exist in data base. 
	 * 
	 * @type Long
	 * @param idDepartment
	 * @throw NullPointerException
	 * 
	 * @return List<DepartmentOrder> in department.
	 */
	public List<DepartmentOrder> getListDepartmentOrderByIdDepartment(Long idDepartment);
	
	/**
	 * Method return list of client in department by id department.Parametr
	 * (department id) must be not null and exist in data base. 
	 * 
	 * @type Long
	 * @param idDepartment
	 * @throw NullPointerException
	 * 
	 * @return List<Client> in department.
	 */
	public List<Client> getListClientByIdDepartment(Long idDepartment);
	
	/**
	 * Method return list of employee in department by id department.Parametr
	 * (department id) must be not null and exist in data base. 
	 * 
	 * @type Long
	 * @param idDepartment
	 * @throw NullPointerException
	 * 
	 * @return List<Employee> in department.
	 */
	public List<Employee> getListEmployeByIdDepartment(Long idDepartment);
	
	/**
	 * Method return total cost detail which use in department orders and 
	 * have status notcompleted or overdue.  
	 * 
	 * @type Long
	 * @param idDepartment
	 * @throw NullPointerException
	 * 
	 * @return Total sum(double type) detail cost in department. 
	 */
	public Double getTotalDetailCostForNotcompletedOverdueDepartmentOrder(Long idDepartment);
	
	/**
	 * Method return full income(work cost and detail cost) which have department.  
	 * 
	 * @type Long
	 * @param idDepartment
	 * @throw NullPointerException
	 * 
	 * @return Total sum(double type) detail cost in department. 
	 */
	public Double getFullIncomeForNotcompletedOverdueDepartmentOrder(Long idDepartment);
	
	/**
	 * Method return sum wages for all employes which work in department.  
	 * 
	 * @type Long
	 * @type Double
	 * @param idDepartment
	 * @throw NullPointerException
	 * 
	 * @return sem wages or null if department have not employes 
	 */
	public Double getSumEmployeeWagesForDeportment(Long idDepartment);
	
	/**
	 * Method return total cost detail which use in department orders and 
	 * have status done.  
	 * 
	 * @type Long
	 * @param idDepartment
	 * @throw NullPointerException
	 * 
	 * @return Total sum(double type) detail cost in department. 
	 */
	public Double getTotalDetailCostForDoneDepartmentOrder(Long idDepartment, Date startData,Date endData);
	
	/**
	 * Method return full income(work cost and detail cost) which have department for
	 * deprtment order which have status done.   
	 * 
	 * @type Long
	 * @param idDepartment
	 * @throw NullPointerException
	 * 
	 * @return full income for department.
	 */
	public Double getFullIncomeForDoneDepartmentOrder(Long idDepartment,Date startData,Date endData);
}
