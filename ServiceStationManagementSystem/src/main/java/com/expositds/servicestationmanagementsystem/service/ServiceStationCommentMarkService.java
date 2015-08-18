/**
 * 
 */
package com.expositds.servicestationmanagementsystem.service;

import java.util.List;

import com.expositds.servicestationmanagementsystem.model.ServiceStationCommentMark;

/**
 * @author Zaerko_DV
 *
 */
public interface ServiceStationCommentMarkService extends  AbstractEntityCommonService {

	public List<ServiceStationCommentMark> getListCommentMarkStatusAsParamByIdServiceStation(Long idServiceStation,String viewStatus);
	public List<ServiceStationCommentMark> getListCommentMarkByIdClient(Long idClient);
	public List<ServiceStationCommentMark> getListCommentMarkSortByDegressiveMark(Long idServiceStation);
}
