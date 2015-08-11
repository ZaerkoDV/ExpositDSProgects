/**
 * @package com.expositds.servicestationmanagementsystem.dao
 * 
 * Packages located in the directory /src/test/java contains classes which exercise 
 * testing dao and service layer by mvc architecture. Classes used for test junit 
 * framework. 
 */
package com.expositds.servicestationmanagementsystem.dao;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.servicestationmanagementsystem.AbstractTest;
import com.expositds.servicestationmanagementsystem.dao.impl.EntityUtilDAOImpl;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
/**
 * Class EntityUntilDAOTest use to testing EntityUntilDAO class which belong to dao layer.Class use
 * Junit tests. To create test objects use method createServiceStationForTest.That method create new
 * object for test and applying anatation Inject to get dependency injection. This is realization of
 * pattern IoC. All methods return void except createServiceStationForTest.All methods use annotation
 * Rollback to roll back transaction which created for test. Also in class use Assert. These  methods
 * set assertion methods useful for writing tests.
 * 
 * @see org.springframework.transaction
 * @see javax.inject.Inject
 * @see org.slf4j
 * @see org.junit
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 10.08.2015
 * @author Zaerko Denis
 */
public class EntityUntilDAOTest extends AbstractTest {
	
	/**
	 * Variable logger use to get logger level for class EntityUntilDAOTest.
	 * 
	 * @param EntityUntilDAOTest
	 * @return logger for class EntityUntilDAOTest.
	 */
	private static final Logger logger = LoggerFactory.getLogger(EntityUntilDAOTest.class);
	
	/**
	 * Annatation Inject use to get injection of EntityUtilDAOImpl
	 * dependency. This is part of specification JSR-330.
	 */
	@Inject
	private EntityUtilDAOImpl entityUtilDAO;
	
	public ServiceStation serviceStation;
	
	/**
	 * Create test object before test start.
	 */
	@Before
	public void initServiceStationBeforeTest(){
		serviceStation = createServiceStationForTest();
	}
	
	/**
	 * Destroy test object after method finish.
	 */
	@After 
	public void clearServiceStationForTest(){
		serviceStation= null;
	}
	
	/**
	 * Method create new objects for test. 
	 * 
	 * @return ServiceStation(this may any object not till service station)
	 * if operation create new client successfully completed else null and
	 * get exeption.
	 */
	public ServiceStation createServiceStationForTest() {

		serviceStation = new ServiceStation();
		serviceStation.setServiceStationName("serviceStationNameTest");
		//serviceStation.setServiceStationLogotype(serviceStationLogotype);
		serviceStation.setServiceStationAddress("serviceStationAddressTest");
		serviceStation.setServiceStationPhoneNumber("1234221");
		entityUtilDAO.saveEntity((ServiceStation)serviceStation);
		
		return serviceStation;
	}
	
	/**
	 * Method testSaveEntityt are testing (abstract)entity on save operation.That
	 * method use test abstract object, which create before test run and destroy
	 * test object after method is finish. 
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 * @see org.junit.Assert
	 */
	@Transactional
	@Rollback(true)
	@Test
	public void testSaveEntity(){
		Assert.assertFalse(serviceStation.equals(null));
	}

	/**
	 * Method testGettingEntityById are testing operation get entity by id.That
	 * method use test (abstract)object, which create before test run and destroy
	 * test object after method is finish.  
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 * @see org.junit.Assert
	 */
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingEntityById(){
		Object entity=entityUtilDAO.getEntityById(ServiceStation.class, serviceStation.getIdServiceStation());
		Assert.assertNotNull(entity);
	}

	/**
	 * Method testUpdateEntity are testing update entity.That method use test
	 * (abstract) object, which create before test run and destroy test object
	 * after method is finish.  
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 * @see org.junit.Assert
	 */
	@Transactional
	@Rollback(true)
	@Test
	public void testUpdateEntity(){

		serviceStation.setServiceStationName("serviceStationNameTest");
		entityUtilDAO.updateEntity(serviceStation);

		final ServiceStation updatedServiceStation =(ServiceStation) entityUtilDAO
				.getEntityById(ServiceStation.class, serviceStation.getIdServiceStation());	
		Assert.assertTrue(updatedServiceStation.getServiceStationName().equals("serviceStationNameTest"));
	}

	/**
	 * Method testDeleteEntityById are testing operation delete entity by id. That
	 * method use test object, which create before test run and destroy test object
	 * after method is finish.   
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 * @see org.junit.Assert
	 */	
	@Transactional
	@Rollback(true)
	@Test
	public void testDeleteEntityById(){
		entityUtilDAO.deleteEntityById(ServiceStation.class, serviceStation.getIdServiceStation());
		Assert.assertNull(entityUtilDAO.getEntityById(ServiceStation.class, serviceStation.getIdServiceStation()));
	}
	
	/**
	 * Method testDeleteEntity are testing operation delete entity. That method
	 * use test object, which create before test run and destroy test object
	 * after method is finish.   
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 * @see org.junit.Assert
	 */	
	@Transactional
	@Rollback(true)
	@Test
	public void testDeleteEntity(){
		entityUtilDAO.deleteEntity(serviceStation);
		Assert.assertNull(entityUtilDAO.getEntityById(ServiceStation.class, serviceStation.getIdServiceStation()));
	}
}

