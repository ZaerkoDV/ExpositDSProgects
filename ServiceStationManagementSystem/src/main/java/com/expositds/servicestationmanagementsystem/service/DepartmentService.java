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

	public List<DepartmentOrder> getListDepartmentOrderByIdDepartment(Long idDepartment);
	public List<Client> getListClientByIdDepartment(Long idDepartment);
	public List<Employee> getListEmployeByIdDepartment(Long idDepartment);
	public Double getTotalDetailCostForNotcompletedOverdueDepartmentOrder(Long idDepartment);
	public Double getFullIncomeForNotcompletedOverdueDepartmentOrder(Long idDepartment);
	public Double getSumEmployeeWagesForDeportment(Long idDepartment);
	public Double getTotalDetailCostForDoneDepartmentOrder(Long idDepartment, Date startData,Date endData);
	public Double getFullIncomeForDoneDepartmentOrder(Long idDepartment,Date startData,Date endData);
}
