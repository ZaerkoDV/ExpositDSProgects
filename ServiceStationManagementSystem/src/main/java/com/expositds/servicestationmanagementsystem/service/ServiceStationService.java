/**
 * 
 */
package com.expositds.servicestationmanagementsystem.service;

import java.util.List;

import com.expositds.servicestationmanagementsystem.model.Stead;

/**
 * @author Zaerko_DV
 *
 */
public interface ServiceStationService extends  AbstractEntityCommonService{

	public List<Stead> getListSteadUseServiceStation(Long idServiceStation);
	public Double getTotalServiceStationArea(Long idServiceStation);
}
