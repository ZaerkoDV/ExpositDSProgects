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

import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;

/**
 * <p>The interface DepartmentOrderDAO contain methods ads which realize in class 
 * DepartmentOrderDAOImpl. Class DepartmentOrderDAOImpl use DAO pattern which describes
 * layer of data access to object. DAO layer perform link between relational and object
 * model. Model for this dao layer describied in class DepartmentOrder.This interface
 * contain ads methods which intended to access operation with object.Interface produce
 * special operation with object.Base operation(for any object) include as separate
 * interface AbstractEntityCommonDAO which extend to this interface.Class use Spring
 * framework to work whith ORM.In particular often use HibernateTemplate for integration
 * Hibernate and Spring technologys. For work with data base use hibernate criteria. 
 * 
 * @version 1.0 11.08.2015
 * @author Zaerko Denis
 */
public interface DepartmentOrderDAO extends AbstractEntityCommonDAO {

	/**
	 * Return list of order which employee made in all departments. If employee
	 * hava orders method return listAllEmployeOrder else method return null. 
	 * Parametr idEmployee is attrebute of Employee. List  contain serving on 20
	 * rows and start on 1 row. 
	 * 
	 * @type Long
	 * @param idEmployee
	 * @throws NullPointerException
	 * 	 
	 * @return List<DepartmentOrder> for employee
	 */
	public List<DepartmentOrder> getListDepartmentOrderForEmployee(Long idEmployee);
	
	
	/**
	 * Return list of order which employee made in all departments with status not
	 * completed or overdue.If employee hava orders method return listAllEmployeOrder
	 * else method return null. Parametr idEmployee is attrebute of Employee.List 
	 * contain serving on 20 rows and start on 1 row. 
	 * 
	 * @type Long
	 * @param idEmployee
	 * @throws NullPointerException
	 * 	 
	 * @return List<DepartmentOrder> for employee.
	 */
	public List<DepartmentOrder> getListNotcompletedOverdueDepartmentOrderForEmployee(Long idEmployee);
	
	/**
	 * Return list of order which employee made in all departments with status done.
	 * If employee hava orders method return listAllEmployeOrder else method return
	 * null. Parametr idEmployee is attrebute of Employee. List contain serving on 20
	 * rows and start on 1 row. 
	 * 
	 * @type Long
	 * @param idEmployee
	 * @throws NullPointerException
	 * 	 
	 * @return List<DepartmentOrder> for employee.
	 */
	public List<DepartmentOrder> getListDoneDepartmentOrderForEmployee(Long idEmployee);
	
	/**
	 * Return full cost details which use in department orders. If order have
	 * details method return same sum else method return zero. Parametr 
	 * idDepartmentOrder is attrebute of DepartmentOrder.
	 * 
	 * @type Long
	 * @param idDepartmentOrder
	 * @throws NullPointerException
	 * 	 
	 * @return Full detail cost
	 */
	public Double getFullDetailCostForDepartmentOrder(Long idDepartmentOrder);
	
	/**
	 * Return order cost(work cost and sum of detail cost). If order have
	 * order method return same value else method return zero. Parametr 
	 * idDepartmentOrder is attrebute of DepartmentOrder.
	 * 
	 * @type Long
	 * @param idDepartmentOrder
	 * @throws NullPointerException
	 * 	 
	 * @return order cost.
	 */
	public Double getOrderCostForDepartmentOrder(Long idDepartmentOrder);
	
}
