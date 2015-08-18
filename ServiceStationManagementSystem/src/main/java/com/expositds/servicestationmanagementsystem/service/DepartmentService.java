/**
 * 
 */
package com.expositds.servicestationmanagementsystem.service;

import java.util.Date;
import java.util.List;

import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Employee;

/**
 * @author Zaerko_DV
 *
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
