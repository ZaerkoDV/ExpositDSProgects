/**
 * 
 */
package com.expositds.servicestationmanagementsystem.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import com.expositds.servicestationmanagementsystem.dao.DepartmentDAO;
import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.service.DepartmentService;

/**
 * @author Zaerko_DV
 *
 */
public class DepartmentServiceImpl extends AbstractEntityCommonServiceImpl implements DepartmentService {

	private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Inject
	@Qualifier("departmentDAO")
	private DepartmentDAO departmentDAO;

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}
	
	
	public List<DepartmentOrder> getListDepartmentOrderByIdDepartment(Long idDepartment){
		return departmentDAO.getListDepartmentOrderByIdDepartment(idDepartment);
	}
	
	public List<Client> getListClientByIdDepartment(Long idDepartment){
		return departmentDAO.getListClientByIdDepartment(idDepartment);
	}

	public List<Employee> getListEmployeByIdDepartment(Long idDepartment){
		return departmentDAO.getListEmployeByIdDepartment(idDepartment);
	}
	
	public Double getTotalDetailCostForNotcompletedOverdueDepartmentOrder(Long idDepartment){
		return departmentDAO.getTotalDetailCostForNotcompletedOverdueDepartmentOrder(idDepartment);
	}
	
	public Double getFullIncomeForNotcompletedOverdueDepartmentOrder(Long idDepartment){
		return departmentDAO.getFullIncomeForNotcompletedOverdueDepartmentOrder(idDepartment);
	}
	
	public Double getSumEmployeeWagesForDeportment(Long idDepartment){
		return departmentDAO.getSumEmployeeWagesForDeportment(idDepartment);
	}
	
	public Double getTotalDetailCostForDoneDepartmentOrder(Long idDepartment, Date startData,Date endData){
		return departmentDAO.getTotalDetailCostForDoneDepartmentOrder(idDepartment, startData, endData);
	}
	
	public Double getFullIncomeForDoneDepartmentOrder(Long idDepartment,Date startData,Date endData){
		return departmentDAO.getFullIncomeForDoneDepartmentOrder(idDepartment, startData, endData);
	}
}
