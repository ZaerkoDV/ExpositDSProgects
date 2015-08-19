/**
 * 
 */
package com.expositds.servicestationmanagementsystem.service;

import java.util.List;

import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.Stead;


/**
 * @author Zaerko_DV
 *
 */
public interface SteadService extends  AbstractEntityCommonService {

	public List<Stead> getListStead();
	public List<Department> getListDepartmentUseCurrentStead(Long idStead);
}
