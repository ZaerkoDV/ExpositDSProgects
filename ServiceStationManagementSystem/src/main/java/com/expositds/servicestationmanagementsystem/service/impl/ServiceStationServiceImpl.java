/**
 * 
 */
package com.expositds.servicestationmanagementsystem.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import com.expositds.servicestationmanagementsystem.dao.ServiceStationDAO;
import com.expositds.servicestationmanagementsystem.model.Stead;
import com.expositds.servicestationmanagementsystem.service.ServiceStationService;

/**
 * @author Zaerko_DV
 *
 */
public class ServiceStationServiceImpl extends AbstractEntityCommonServiceImpl implements ServiceStationService {

	private static final Logger logger = LoggerFactory.getLogger(ServiceStationServiceImpl.class);

	@Inject
	@Qualifier("serviceStationDAO")
	private ServiceStationDAO serviceStationDAO;

	public void setServiceStationDAO(ServiceStationDAO serviceStationDAO) {
		this.serviceStationDAO = serviceStationDAO;
	}
	
	public List<Stead> getListSteadUseServiceStation(Long idServiceStation){
		return serviceStationDAO.getListSteadUseServiceStation(idServiceStation);
	}
	
	public Double getTotalServiceStationArea(Long idServiceStation){
		return serviceStationDAO.getTotalServiceStationArea(idServiceStation);
	}
	
	
	//other methods
	
}
