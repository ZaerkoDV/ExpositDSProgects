/**
 * 
 */
package com.expositds.servicestationmanagementsystem.service;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.servicestationmanagementsystem.AbstractTest;
import com.expositds.servicestationmanagementsystem.TestObjectCreator;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;

/**
 * @author Zaerko_DV
 *
 */
public class AbstractEntityCommonServiceTest {//extends AbstractTest  {
	
//	private static final Logger logger = LoggerFactory.getLogger(AbstractEntityCommonServiceTest.class);
//	
//	@Inject
//	@Qualifier("abstractEntity—ommonService")
//	private AbstractEntityCommonService abstractEntity—ommonService;
//	
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//	
//	public ServiceStation serviceStation;
//	
//	@Before
//	public void initObjectsBeforeTest(){
//		this.serviceStation=testObjectCreator.createServiceStationForTest();
//	}
//	
//	@After 
//	public void clearObjectsForTest(){
//		serviceStation= null;
//	}
//	
//	/**
//	 * Method testSaveEntityt are testing (abstract)entity on save operation.That
//	 * method use test abstract object, which create before test run and destroy
//	 * test object after method is finish. 
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testSaveEntity(){
//		Assert.assertFalse(serviceStation.equals(null));
//	}
//
//	/**
//	 * Method testGettingEntityById are testing operation get entity by id.That
//	 * method use test (abstract)object, which create before test run and destroy
//	 * test object after method is finish.  
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingEntityById(){
//		Object entity=abstractEntity—ommonService.getEntityById(ServiceStation.class, serviceStation.getIdServiceStation());
//		Assert.assertNotNull(entity);
//	}
//
//	/**
//	 * Method testUpdateEntity are testing update entity.That method use test
//	 * (abstract) object, which create before test run and destroy test object
//	 * after method is finish.  
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testUpdateEntity(){
//
//		serviceStation.setServiceStationName("serviceStationNameTest");
//		abstractEntity—ommonService.updateEntity(serviceStation);
//
//		final ServiceStation updatedServiceStation =(ServiceStation) abstractEntity—ommonService
//				.getEntityById(ServiceStation.class, serviceStation.getIdServiceStation());	
//		Assert.assertTrue(updatedServiceStation.getServiceStationName().equals("serviceStationNameTest"));
//	}
//
//	/**
//	 * Method testDeleteEntityById are testing operation delete entity by id. That
//	 * method use test object, which create before test run and destroy test object
//	 * after method is finish.   
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteEntityById(){
//		abstractEntity—ommonService.deleteEntityById(ServiceStation.class, serviceStation.getIdServiceStation());
//		Assert.assertNull(abstractEntity—ommonService.getEntityById(ServiceStation.class, serviceStation.getIdServiceStation()));
//	}
//	
//	/**
//	 * Method testDeleteEntity are testing operation delete entity. That method
//	 * use test object, which create before test run and destroy test object
//	 * after method is finish.   
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteEntity(){
//		abstractEntity—ommonService.deleteEntity(serviceStation);
//		Assert.assertNull(abstractEntity—ommonService.getEntityById(ServiceStation.class, serviceStation.getIdServiceStation()));
//	}
}
