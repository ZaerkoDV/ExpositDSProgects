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

import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;

/**
 * <p>The interface DepartmentOrderService contain methods ads which realize in class
 * DepartmentOrderServiceImpl. Class DepartmentOrderServiceImpl use Service pattern which
 * describes service layer of application. This class contain general operation to all classes.
 * This interface contain ads methods which perform busness logic all application. Interface
 * extend AbstractEntityCommonService interface which contain ads base operation of any entity.
 * 
 * @version 1.0 19.08.2015
 * @author Zaerko Denis
 */
public interface DepartmentOrderService extends AbstractEntityCommonService {

	/**
	 * Return list of order which employee made in all departments. If employee
	 * hava orders method return listAllEmployeOrder else method return null. 
	 * Parametr idEmployee is attrebute of Employee. List  contain serving on 20
	 * rows and start on 1 row. This methods addresses to method in DAO layer for
	 * execution operation.
	 * 
	 * @type Long
	 * @param idEmployee
	 * 	 
	 * @return List<DepartmentOrder> for employee
	 */
	public List<DepartmentOrder> getListDepartmentOrderForEmployee(Long idEmployee);
	
	/**
	 * Return list of order which employee made in all departments with status not
	 * completed or overdue.If employee hava orders method return listAllEmployeOrder
	 * else method return null. Parametr idEmployee is attrebute of Employee.List 
	 * contain serving on 20 rows and start on 1 row. This methods addresses to method
	 * in DAO layer for execution operation.
	 * 
	 * @type Long
	 * @param idEmployee
	 * 	 
	 * @return List<DepartmentOrder> for employee.
	 */
	public List<DepartmentOrder> getListNotcompletedOverdueDepartmentOrderForEmployee(Long idEmployee);
	
	/**
	 * Return list of order which employee made in all departments with status done.
	 * If employee hava orders method return listAllEmployeOrder else method return
	 * null. Parametr idEmployee is attrebute of Employee. List contain serving on 20
	 * rows and start on 1 row. This methods addresses to method in DAO layer for
	 * execution operation.
	 * 
	 * @type Long
	 * @param idEmployee
	 * 	 
	 * @return List<DepartmentOrder> for employee.
	 */
	public List<DepartmentOrder> getListDoneDepartmentOrderForEmployee(Long idEmployee);
	
	/**
	 * Return full cost details which use in department orders. If order have details method
	 * return same sum else method return zero. Parametr idDepartmentOrder is attrebute of
	 * DepartmentOrder.This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type Long
	 * @param idDepartmentOrder
	 *  	 
	 * @return Full detail cost
	 */
	public Double getFullDetailCostForDepartmentOrder(Long idDepartmentOrder);
	
	/**
	 * Return order cost(work cost and sum of detail cost). If order have order method return
	 * same value else method return zero. Parametr idDepartmentOrder is attrebute of
	 * DepartmentOrder.This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type Long
	 * @param idDepartmentOrder
	 * 	 
	 * @return order cost.
	 */
	public Double getOrderCostForDepartmentOrder(Long idDepartmentOrder);
}
