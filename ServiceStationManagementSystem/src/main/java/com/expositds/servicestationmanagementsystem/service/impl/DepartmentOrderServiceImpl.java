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

import com.expositds.servicestationmanagementsystem.dao.DepartmentOrderDAO;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Detail;
import com.expositds.servicestationmanagementsystem.service.DepartmentOrderService;

/**
 * <p>The class DepartmentOrderServiceImpl use Service pattern which describes business logic application
 * ServiceStationManagemrntSystem. Service layer perform link between, presentation layer and DAO
 * layer.This layer is the main role becouse layer contents(set of methods in classes) affect on
 * functionality of all application.
 * This class contain methods which describes specific operation for DepartmentOrder.This class
 * perform service layer to DepartmentOrder.Class extend base class AbstractEntityCommonServiceImpl
 * and implement DepartmentOrderService interface which perform all methods of this class.
 * For logging use framework shell slf4j and framework log4j.Class contain also private, static
 * variable logger, which use to call log message. Class use Spring framework anatation to work
 * with service layer. 
 *  
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 19.08.2015
 * @author Zaerko Denis
 */
@Service(value="departmentOrderService")
public class DepartmentOrderServiceImpl extends AbstractEntityCommonServiceImpl implements DepartmentOrderService {

	/**
	 * Variable logger use to get logger level for class DepartmentOrderServiceImpl.
	 * 
	 * @param class name: DepartmentOrderServiceImpl.
	 * @return logger for class DepartmentOrderServiceImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(DepartmentOrderServiceImpl.class);

	/**
	 * Annatation Inject use to get injection DepartmentOrderDAO
	 * dependency. This is part of specification JSR-330.
	 */
	@Inject
	@Qualifier("departmentOrderDAO")
	private DepartmentOrderDAO departmentOrderDAO;

	/**
	 * This is set method of injection DepartmentOrderDAO dependency.
	 * This methods permit operation set(writeable) departmentOrderDAO.
	 */
	public void setDepartmentOrderDAO(DepartmentOrderDAO departmentOrderDAO) {
		this.departmentOrderDAO = departmentOrderDAO;
	}
	
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
	public List<DepartmentOrder> getListDepartmentOrderForEmployee(Long idEmployee){
		logger.info("Service: Create list order for employee by id="+idEmployee);
		return departmentOrderDAO.getListDepartmentOrderForEmployee(idEmployee);
	}
	
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
	public List<DepartmentOrder> getListNotcompletedOverdueDepartmentOrderForEmployee(Long idEmployee){
		logger.info("Service: Create list order with status notcompleted and overdue for employee by id="+idEmployee);
		return departmentOrderDAO.getListNotcompletedOverdueDepartmentOrderForEmployee(idEmployee);
	}
	
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
	public List<DepartmentOrder> getListDoneDepartmentOrderForEmployee(Long idEmployee){
		logger.info("Service: Create list order with status done for employee by id="+idEmployee);
		return departmentOrderDAO.getListDoneDepartmentOrderForEmployee(idEmployee);
	} 
	
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
	public Double getFullDetailCostForDepartmentOrder(Long idDepartmentOrder){
		logger.info("Service: Full details cost for order id="+idDepartmentOrder);
		return departmentOrderDAO.getFullDetailCostForDepartmentOrder(idDepartmentOrder);
	}
	
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
	public Double getOrderCostForDepartmentOrder(Long idDepartmentOrder){
		logger.info("Service: Get order cost for department order by order id="+idDepartmentOrder);
		return departmentOrderDAO.getOrderCostForDepartmentOrder(idDepartmentOrder);
	}
	
	/**
	 * Return detail list for department order.If list is empty return null.Parametr 
	 * idDepartmentOrder is attrebute of DepartmentOrder.
	 * 
	 * @type Long
	 * @param idDepartmentOrder
	 * 	 
	 * @return List<Detail> for department order.
	 */
	public List<Detail> getListDetailForDepartmentOrder(Long idDepartmentOrder){
		logger.info("Service: Get list details for department order by order id="+idDepartmentOrder);
		return departmentOrderDAO.getListDetailForDepartmentOrder(idDepartmentOrder);		
	}
}
