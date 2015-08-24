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

import java.util.Date;
import java.util.List;

import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Employee;

/**
 * <p>The interface DepartmentService contain methods ads which realize in class DepartmentServiceImpl.
 * Class DepartmentServiceImpl use Service pattern which describes service layer of application. This
 * class contain general operation to all classes.This interface contain ads methods which perform
 * busness logic all application. Interface extend AbstractEntityCommonService interface which contain
 * ads base operation of any entity.
 * 
 * @version 1.0 19.08.2015
 * @author Zaerko Denis
 */
public interface DepartmentService extends  AbstractEntityCommonService{

	/**
	 * Method return list of order in department by department id. Parametr
	 * (department id) must be not null and exist in data base.This method
	 * addresses to method in DAO layer for execution operation. 
	 * 
	 * @type Long
	 * @param idDepartment
	 * 
	 * @return List<DepartmentOrder> in department or null.
	 */
	public List<DepartmentOrder> getListDepartmentOrderByIdDepartment(Long idDepartment);
	
	/**
	 * Method return list of client in department by id department.Parametr
	 * (department id) must be not null and exist in data base.This method
	 * addresses to method in DAO layer for execution operation. 
	 * 
	 * @type List
	 * @type Long
	 * @param idDepartment
	 * 
	 * @return List<Client> in department or null.
	 */
	public List<Client> getListClientByIdDepartment(Long idDepartment);
	
	/**
	 * Method return list of employee in department by id department.Parametr
	 * (department id) must be not null and exist in data base.This method
	 * addresses to method in DAO layer for execution operation. 
	 * 
	 * @type Long
	 * @param idDepartment
	 * 
	 * @return List<Employee> in department.
	 */
	public List<Employee> getListEmployeByIdDepartment(Long idDepartment);
	
	/**
	 * Method return total cost detail which use in department orders and 
	 * have status notcompleted or overdue.This method addresses to method
	 * in DAO layer for execution operation.
	 * 
	 * @type Long
	 * @param idDepartment
	 * 
	 * @return Total sum(double type) detail cost in department. 
	 */
	public Double getTotalDetailCostForNotcompletedOverdueDepartmentOrder(Long idDepartment);
	
	/**
	 * Method return full income(work cost and detail cost) which have department.
	 * This method addresses to method in DAO layer for execution operation.  
	 * 
	 * @type Long
	 * @param idDepartment
	 * 
	 * @return Total sum(double type) detail cost in department. 
	 */
	public Double getFullIncomeForNotcompletedOverdueDepartmentOrder(Long idDepartment);
	
	/**
	 * Method return sum wages for all employes which work in department.
	 * This method addresses to method in DAO layer for execution operation.   
	 * 
	 * @type Long
	 * @type Double
	 * @param idDepartment
	 * 
	 * @return sem wages or null if department have not employes 
	 */
	public Double getSumEmployeeWagesForDeportment(Long idDepartment);
	
	/**
	 * Method return total cost detail which use in department orders and 
	 * have status done. This method addresses to method in DAO layer for
	 * execution operation.
	 * 
	 * @type Long
	 * @param idDepartment
	 * 
	 * @return Total sum(double type) detail cost in department. 
	 */
	public Double getTotalDetailCostForDoneDepartmentOrder(Long idDepartment, Date startData,Date endData);
	
	/**
	 * Method return full income(work cost and detail cost) which have department for
	 * deprtment order which have status done. This method addresses to method in DAO
	 * layer for execution operation.  
	 * 
	 * @type Long
	 * @param idDepartment
	 * 
	 * @return full income for department.
	 */
	public Double getFullIncomeForDoneDepartmentOrder(Long idDepartment,Date startData,Date endData);
}
