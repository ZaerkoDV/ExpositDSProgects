/**
 * 
 */
package com.expositds.servicestationmanagementsystem.service;

import java.util.List;

import com.expositds.servicestationmanagementsystem.model.Detail;

/**
 * @author Zaerko_DV
 *
 */
public interface DetailService extends  AbstractEntityCommonService {

	public List<Detail> getListAllDetail();
	public List<Detail> getListDetailWithStausAsParam(String detailStaus);
}
