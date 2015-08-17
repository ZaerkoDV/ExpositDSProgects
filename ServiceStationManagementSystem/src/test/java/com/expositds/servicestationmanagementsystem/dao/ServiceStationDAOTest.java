/**
 * @package com.expositds.servicestationmanagementsystem.dao
 * 
 * Packages located in the directory /src/test/java contains classes which exercise 
 * testing dao and service layer by mvc architecture. Classes used for test junit 
 * framework. 
 */
package com.expositds.servicestationmanagementsystem.dao;

import java.util.List;

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
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.Stead;

/**
 * Class ServiceStationDAOTest use to testing ServiceStationDAOImpl class which belong to dao layer.
 * Class use Junit tests. To create test objects use method createObjectsForTest.That method create
 * new object for test and applying anatation Inject to get dependency injection. This is realization
 * of pattern IoC. All methods return void include initObjectsBeforeTest.All methods use annotation
 * Rollback to roll back transaction which created for test.Also in class use Assert.These methods
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
public class ServiceStationDAOTest extends AbstractTest  {

	/**
	 * Variable logger use to get logger level for class ServiceStationDAOTest.
	 * 
	 * @param ServiceStationDAOTest.
	 * @return logger for class ServiceStationDAOTest.
	 */
	private static final Logger logger = LoggerFactory.getLogger(ServiceStationDAOTest.class);

	/**
	 * Annatation Inject use to get injection of EntityUtilDAOImpl
	 * and ServiceStationDAOImpl dependency.This is part of
	 * specification JSR-330.
	 */
	@Inject
	@Qualifier("serviceStationDAO")
	private ServiceStationDAO serviceStationDAO;

	public ServiceStation serviceStation;
	public Stead stead;
	public Department department;
	
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
	public void clearServiceStationAfterTest(){
		serviceStation = null;
		stead=null;
		department=null;
	}

	/**
	 * Method create new objects for test. 
	 * 
	 * @return ServiceStation if operation create new ServiceStation
	 * successfully completed else null and get exeption.
	 */
	public ServiceStation createServiceStationForTest() {

		serviceStation = new ServiceStation();
		serviceStation.setServiceStationName("serviceStationNameTest");
		//serviceStation.setServiceStationLogotype(serviceStationLogotype);
		serviceStation.setServiceStationAddress("serviceStationAddressTest");
		serviceStation.setServiceStationPhoneNumber("1234221");
		serviceStationDAO.saveEntity(serviceStation);

		stead = new Stead();
		stead.setSteadArea((Double)100.0);
		stead.setSteadCost((Double)10.0);
		serviceStationDAO.saveEntity(stead);

		department=new Department();
		department.setDepartmentName("departmentNameTest");
		department.setStead(stead);
		department.setServiceStation(serviceStation);
		serviceStationDAO.saveEntity(department);	

		return serviceStation;
	}

	/**
	 * Method testSaveServiceStation are testing ServiceStation on
	 * save operation.That method use test object, which create before
	 * test run and destroy test object after method is finish. 
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 * @see org.junit.Assert
	 */
	@Transactional
	@Rollback(true)
	@Test
	public void testSaveServiceStation(){
		Assert.assertFalse(serviceStation.equals(null));
	}

	/**
	 * Method testGettingServiceStationById are testing operation get ServiceStation
	 * by id.That method use test object, which create before test run and destroy
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
	public void testGettingServiceStationById(){
		Assert.assertNotNull(serviceStationDAO.getEntityById(ServiceStation.class, serviceStation
				.getIdServiceStation()));
	}

	/**
	 * Method testUpdateServiceStation are testing update ServiceStation. That
	 * method use test object, which create before test run and destroy test 
	 * object after method is finish.  
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 * @see org.junit.Assert
	 */
	@Transactional
	@Rollback(true)
	@Test
	public void testUpdateServiceStation(){

		serviceStation.setServiceStationName("serviceStationNameTest");
		serviceStationDAO.updateEntity(serviceStation);

		final ServiceStation updatedServiceStation =(ServiceStation) serviceStationDAO
				.getEntityById(ServiceStation.class,serviceStation.getIdServiceStation());	
		Assert.assertTrue(updatedServiceStation.getServiceStationName().equals("serviceStationNameTest"));
	}

	/**
	 * Method testDeleteServiceStationById are testing operation delete
	 * ServiceStation by id. That method use test object, which create
	 * before test run and destroy test object after method is finish.   
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 * @see org.junit.Assert
	 */	
	@Transactional
	@Rollback(true)
	@Test
	public void testDeleteServiceStationById(){

		serviceStationDAO.deleteEntityById(ServiceStation.class,serviceStation.getIdServiceStation());
		Assert.assertNull(serviceStationDAO.getEntityById(ServiceStation.class, serviceStation.getIdServiceStation()));
	}
	
	/**
	 * Method testGettiongListSteadUseServiceStation are testing create list
	 * stead which rent by service station. That method use test object, which
	 * create before test run and destroy test object after method is finish.   
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 * @see org.junit.Assert
	 */	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettiongListSteadUseServiceStation(){

		//list not empty
		List<Stead> listStead= serviceStationDAO.getListSteadUseServiceStation(serviceStation.getIdServiceStation());
		Assert.assertFalse(listStead.isEmpty());
		
		//list is empty because department not exist
		serviceStationDAO.deleteEntity(department);
		listStead= serviceStationDAO.getListSteadUseServiceStation(serviceStation.getIdServiceStation());
		Assert.assertTrue(listStead.isEmpty());
	}
	
	/**
	 * Method testGettiongTotalDepartmentArea are testing actual and expected
	 * total area service station(area of stead which use departmen of service
	 * station). That method use test object, which create before test run and
	 * destroy test object after method is finish.   
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 * @see org.junit.Assert
	 */	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingTotalServiceStationArea(){
		
		Double actual=serviceStationDAO.getTotalServiceStationArea(serviceStation.getIdServiceStation());
		Double expected=stead.getSteadArea();
		Assert.assertEquals(expected, actual);
		
		serviceStationDAO.deleteEntity(department);
		actual=serviceStationDAO.getTotalServiceStationArea(serviceStation.getIdServiceStation());
		expected=0.0;
		Assert.assertEquals(expected, actual);
	}
}
