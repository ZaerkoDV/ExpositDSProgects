/**
 * 
 */
package com.expositds.servicestationmanagementsystem;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.expositds.servicestationmanagementsystem.dao.AbstractEntityCommonDAO;
import com.expositds.servicestationmanagementsystem.dao.AbstractEntityCommonDAOTest;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;

/**
 * @author Zaerko_DV
 *
 */
//@Component(value="testObjectCreator")
public class TestObjectCreator {

	private static final Logger logger = LoggerFactory.getLogger(TestObjectCreator.class);
	
	@Inject
	@Qualifier("abstractEntity—ommonDAO")
	private AbstractEntityCommonDAO abstractEntity—ommonDAO;
	
	public ServiceStation serviceStation;

	public ServiceStation createObjectsForTest() {

		serviceStation = new ServiceStation();
		serviceStation.setServiceStationName("serviceStationNameTest");
		//serviceStation.setServiceStationLogotype(serviceStationLogotype);
		serviceStation.setServiceStationAddress("serviceStationAddressTest");
		serviceStation.setServiceStationPhoneNumber("1234221");
		abstractEntity—ommonDAO.saveEntity((ServiceStation)serviceStation);	
		
		return serviceStation;
	}
		
}
