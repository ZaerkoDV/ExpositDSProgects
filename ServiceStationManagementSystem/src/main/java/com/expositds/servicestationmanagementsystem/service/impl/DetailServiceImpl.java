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

import com.expositds.servicestationmanagementsystem.dao.DetailDAO;
import com.expositds.servicestationmanagementsystem.model.Detail;
import com.expositds.servicestationmanagementsystem.service.DetailService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="detailService")
public class DetailServiceImpl extends AbstractEntityCommonServiceImpl implements DetailService{
	
	private static final Logger logger = LoggerFactory.getLogger(DetailServiceImpl.class);

	@Inject
	@Qualifier("detailDAO")
	private DetailDAO detailDAO;

	public void setDetailDAO(DetailDAO detailDAO) {
		this.detailDAO = detailDAO;
	}
	
	public List<Detail> getListAllDetail(){
		return detailDAO.getListAllDetail();
	}
	
	public List<Detail> getListDetailWithStausAsParam(String detailStaus){
		return detailDAO.getListDetailWithStausAsParam(detailStaus);
	}
}
