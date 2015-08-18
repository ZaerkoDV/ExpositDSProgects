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

import com.expositds.servicestationmanagementsystem.dao.ServiceStationCommentMarkDAO;
import com.expositds.servicestationmanagementsystem.model.ServiceStationCommentMark;
import com.expositds.servicestationmanagementsystem.service.ServiceStationCommentMarkService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="serviceStationCommentMarkService")
public class ServiceStationCommentMarkServiceImpl extends AbstractEntityCommonServiceImpl implements ServiceStationCommentMarkService {

	private static final Logger logger = LoggerFactory.getLogger(ServiceStationCommentMarkServiceImpl.class);

	@Inject
	@Qualifier("serviceStationCommentMarkDAO")
	private ServiceStationCommentMarkDAO serviceStationCommentMarkDAO;

	public void setServiceStationCommentMarkDAO(
			ServiceStationCommentMarkDAO serviceStationCommentMarkDAO) {
		this.serviceStationCommentMarkDAO = serviceStationCommentMarkDAO;
	}	
	
	
	public List<ServiceStationCommentMark> getListCommentMarkStatusAsParamByIdServiceStation(Long idServiceStation,String viewStatus){
		return serviceStationCommentMarkDAO.getListCommentMarkStatusAsParamByIdServiceStation(idServiceStation, viewStatus);
	}
	
	public List<ServiceStationCommentMark> getListCommentMarkByIdClient(Long idClient){
		return serviceStationCommentMarkDAO.getListCommentMarkByIdClient(idClient);
	}
	
	public List<ServiceStationCommentMark> getListCommentMarkSortByDegressiveMark(Long idServiceStation){
		return serviceStationCommentMarkDAO.getListCommentMarkSortByDegressiveMark(idServiceStation);
	}
}
