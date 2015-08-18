/**
 * 
 */
package com.expositds.servicestationmanagementsystem.service;

import java.util.List;

import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;

/**
 * @author Zaerko_DV
 *
 */
public interface DepartmentOrderService extends AbstractEntityCommonService {

	public List<DepartmentOrder> getListDepartmentOrderForEmployee(Long idEmployee);
	public List<DepartmentOrder> getListNotcompletedOverdueDepartmentOrderForEmployee(Long idEmployee);
	public List<DepartmentOrder> getListDoneDepartmentOrderForEmployee(Long idEmployee);
	public Double getFullDetailCostForDepartmentOrder(Long idDepartmentOrder);
	public Double getOrderCostForDepartmentOrder(Long idDepartmentOrder);
}
