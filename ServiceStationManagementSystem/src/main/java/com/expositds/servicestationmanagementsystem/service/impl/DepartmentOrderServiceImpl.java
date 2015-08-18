/**
 * 
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
import com.expositds.servicestationmanagementsystem.service.DepartmentOrderService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="departmentOrderService")
public class DepartmentOrderServiceImpl extends AbstractEntityCommonServiceImpl implements DepartmentOrderService {

	private static final Logger logger = LoggerFactory.getLogger(DepartmentOrderServiceImpl.class);

	@Inject
	@Qualifier("departmentOrderDAO")
	private DepartmentOrderDAO departmentOrderDAO;

	public void setDepartmentOrderDAO(DepartmentOrderDAO departmentOrderDAO) {
		this.departmentOrderDAO = departmentOrderDAO;
	}

	public List<DepartmentOrder> getListDepartmentOrderForEmployee(Long idEmployee){
		return departmentOrderDAO.getListDepartmentOrderForEmployee(idEmployee);
	}
	
	public List<DepartmentOrder> getListNotcompletedOverdueDepartmentOrderForEmployee(Long idEmployee){
		return departmentOrderDAO.getListNotcompletedOverdueDepartmentOrderForEmployee(idEmployee);
	}
	
	public List<DepartmentOrder> getListDoneDepartmentOrderForEmployee(Long idEmployee){
		return departmentOrderDAO.getListDoneDepartmentOrderForEmployee(idEmployee);
	} 
	
	public Double getFullDetailCostForDepartmentOrder(Long idDepartmentOrder){
		return departmentOrderDAO.getFullDetailCostForDepartmentOrder(idDepartmentOrder);
	}
	
	public Double getOrderCostForDepartmentOrder(Long idDepartmentOrder){
		return departmentOrderDAO.getOrderCostForDepartmentOrder(idDepartmentOrder);
	}
}
