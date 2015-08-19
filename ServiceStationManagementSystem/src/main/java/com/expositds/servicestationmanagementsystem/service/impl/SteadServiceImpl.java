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

import com.expositds.servicestationmanagementsystem.dao.SteadDAO;
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.Stead;
import com.expositds.servicestationmanagementsystem.service.SteadService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="steadService")
public class SteadServiceImpl extends AbstractEntityCommonServiceImpl implements SteadService{

	private static final Logger logger = LoggerFactory.getLogger(SteadServiceImpl.class);

	@Inject
	@Qualifier("steadDAO")
	private SteadDAO steadDAO;

	public void setSteadDAO(SteadDAO steadDAO) {
		this.steadDAO = steadDAO;
	}
	
	public List<Stead> getListStead(){
		return steadDAO.getListStead();
	}
	
	public List<Department> getListDepartmentUseCurrentStead(Long idStead){
		return steadDAO.getListDepartmentUseCurrentStead(idStead);
	}
}
