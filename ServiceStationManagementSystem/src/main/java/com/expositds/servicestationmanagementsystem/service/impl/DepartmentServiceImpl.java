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

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.expositds.servicestationmanagementsystem.dao.DepartmentDAO;
import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.service.DepartmentService;

/**
 * <p>The class DepartmentServiceImpl use Service pattern which describes business logic application
 * ServiceStationManagemrntSystem. Service layer perform link between, presentation layer and DAO layer.
 * This layer is the main role becouse layer contents(set of methods in classes) affect on functionality
 * of all application.
 * This class contain methods which describes specific operation for Department.This class perform service
 * layer to Department.Class extend base class AbstractEntityCommonServiceImpl and implement DepartmentService
 * interface which perform all methods of this class.
 * For logging use framework shell slf4j and framework log4j.Class contain also private, static variable
 * logger, which use to call log message. Class use Spring framework anatation to work with service layer. 
 *  
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 19.08.2015
 * @author Zaerko Denis
 */
@Service(value="departmentService")
public class DepartmentServiceImpl extends AbstractEntityCommonServiceImpl implements DepartmentService {

	/**
	 * Variable logger use to get logger level for class DepartmentServiceImpl.
	 * 
	 * @param class name: DepartmentServiceImpl.
	 * @return logger for class DepartmentServiceImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	/**
	 * Annatation Inject use to get injection DepartmentDAO
	 * dependency. This is part of specification JSR-330.
	 */
	@Inject
	@Qualifier("departmentDAO")
	private DepartmentDAO departmentDAO;

	/**
	 * This is set method of injection DepartmentDAO dependency.This methods
	 * permit operation set(writeable) departmentDAO.
	 */
	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}
	 
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
	public List<DepartmentOrder> getListDepartmentOrderByIdDepartment(Long idDepartment){
		logger.info("Service: Create list order in department by department id="+idDepartment);
		return departmentDAO.getListDepartmentOrderByIdDepartment(idDepartment);
	}
	
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
	public List<Client> getListClientByIdDepartment(Long idDepartment){
		logger.info("Service: Create list client in department by department id="+idDepartment);
		return departmentDAO.getListClientByIdDepartment(idDepartment);
	}

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
	public List<Employee> getListEmployeByIdDepartment(Long idDepartment){
		logger.info("Service: Create list employee in department by department id="+idDepartment);
		return departmentDAO.getListEmployeByIdDepartment(idDepartment);
	}
	
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
	public Double getTotalDetailCostForNotcompletedOverdueDepartmentOrder(Long idDepartment){
		logger.info("Service: Count total detail cost for not completed and overdue order in department"
				+ " by department id="+idDepartment);
		return departmentDAO.getTotalDetailCostForNotcompletedOverdueDepartmentOrder(idDepartment);
	}
	
	/**
	 * Method return full income(work cost and detail cost) which have department.
	 * This method addresses to method in DAO layer for execution operation.  
	 * 
	 * @type Long
	 * @param idDepartment
	 * 
	 * @return Total sum(double type) detail cost in department. 
	 */
	public Double getFullIncomeForNotcompletedOverdueDepartmentOrder(Long idDepartment){
		logger.info("Service:Get full income for not completed and overdue order in department"
				+ " by department id="+idDepartment);
		return departmentDAO.getFullIncomeForNotcompletedOverdueDepartmentOrder(idDepartment);
	}
	
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
	public Double getSumEmployeeWagesForDeportment(Long idDepartment){
		logger.info("Service: Get sum employee wages for department by department id="+idDepartment);
		return departmentDAO.getSumEmployeeWagesForDeportment(idDepartment);
	}
	
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
	public Double getTotalDetailCostForDoneDepartmentOrder(Long idDepartment, Date startDate,Date endDate){
		logger.info("Service: Count total detail cost for done order in department by department id="+idDepartment);
		return departmentDAO.getTotalDetailCostForDoneDepartmentOrder(idDepartment, startDate, endDate);
	}
	
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
	public Double getFullIncomeForDoneDepartmentOrder(Long idDepartment,Date startDate,Date endDate){
		logger.info("Service:Get full income for done order in department by department id="+idDepartment);
		return departmentDAO.getFullIncomeForDoneDepartmentOrder(idDepartment, startDate, endDate);
	}
	
	/**
	 * Return list of all deparment(exist or not exist at that momant). If data base contains
	 * any department method return list of department else return null. List contain serving on
	 * 20 rows and start on 1 row. This method addresses to method in DAO layer for execution
	 * operation.  
	 * 
	 * @type List
	 * 
	 * @return List<Department>  
	 */
	public List<Department> getListAllDepartment(){
		logger.info("Service:List with all department loaded.");
		return departmentDAO.getListAllDepartment();
	}
}
