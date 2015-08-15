/**
 *  @package com.expositds.servicestationmanagementsystem.dao
 * 
 * Packages located in the directory /src/test/java contains classes which exercise 
 * testing dao and service layer by mvc architecture. Classes used for test junit 
 * framework.
 */
package com.expositds.servicestationmanagementsystem.dao;

import java.util.Date;
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
import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.ServiceStationCommentMark;

/**
 * <p> Class ServiceStationCommentMarkDAOTest use to testing ServiceStationCommentMarkDAOImpl class which
 * belong to dao layer. Class use Junit tests. To create test objects use method createObjectsForTest.
 * That method create new object for test and applying anatation Inject to get dependency injection.This
 * is realization of pattern IoC.All methods return void include initObjectsBeforeTest.All methods use
 * annotation Rollback to roll back transaction which created for test. Also in class use Assert.These
 * methods set assertion methods useful for writing tests.
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
public class ServiceStationCommentMarkDAOTest extends AbstractTest { 

	/**
	 * Variable logger use to get logger level for class ServiceStationCommentMarkDAOTest.
	 * 
	 * @param ServiceStationCommentMarkDAOTest
	 * @return logger for class ServiceStationCommentMarkDAOTest.
	 */
	private static final Logger logger = LoggerFactory.getLogger(ServiceStationCommentMarkDAOTest.class);

	/**
	 * Annatation Inject use to get injection of EntityUtilDAOImpl
	 * and ServiceStationCommentMarkDAOImpl dependency.This is part
	 * of specification JSR-330.
	 */
	@Inject
	@Qualifier("serviceStationCommentMarkDAO")
	private ServiceStationCommentMarkDAO serviceStationCommentMarkDAO;

	public ServiceStation serviceStation;
	public Client client;
	public ServiceStationCommentMark serviceStationCommentMark;
	
	/**
	 * Create test object before test start.
	 */
	@Before
	public void initServiceStationCommentMarkBeforeTest(){
		serviceStationCommentMark = createServiceStationCommentMarkForTest();
	}

	/**
	 * Destroy test object after method finish.
	 */
	@After 
	public void clearServiceStationCommentMarkAfterTest(){
		client=null;
		serviceStation = null;
		serviceStationCommentMark= null;
	}

	/**
	 * Method create new objects for test. 
	 * 
	 * @return ServiceStationCommentMark if operation create new
	 * serviceStationCommentMark successfully completed else null
	 * and get exeption.
	 */
	public ServiceStationCommentMark createServiceStationCommentMarkForTest() {

		serviceStation = new ServiceStation();
		serviceStation.setServiceStationName("serviceStationNameTest");
		//serviceStation.setServiceStationLogotype(serviceStationLogotype);
		serviceStation.setServiceStationAddress("serviceStationAddressTest");
		serviceStation.setServiceStationPhoneNumber("1234221");
		serviceStationCommentMarkDAO.saveEntity(serviceStation);

		client = new Client();
		client.setClientFirstName("clientFirstNameTest");
		client.setClientLastName("clientLastNameTest");
		client.setClientMiddleName("clientMiddleNameTest");
		java.util.Date date = new java.util.Date();
		client.setClientBirthday(new Date(date.getTime()-10));
		client.setClientTelephone("12345");
		client.setClientEmail("test@mail.ru");
		serviceStationCommentMarkDAO.saveEntity(client);

		serviceStationCommentMark = new ServiceStationCommentMark();
		serviceStationCommentMark.setComment("SameTestComment");
		serviceStationCommentMark.setViewStatus("all");
		serviceStationCommentMark.setMark((long)100);
		serviceStationCommentMark.setServiceStation(serviceStation);	
		serviceStationCommentMark.setClient(client);
		serviceStationCommentMarkDAO.saveEntity(serviceStationCommentMark);

		return serviceStationCommentMark;
	}

	/**
	 * Method testSaveServiceStationCommentMark are testing serviceStationCommentMark
	 * on save operation.That method use test object, which create before test run and
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
	public void testSaveServiceStationCommentMark(){
		Assert.assertFalse(serviceStationCommentMark.equals(null));
	}

	/**
	 * Method testGettingServiceStationCommentMarkById are testing operation get
	 * ServiceStationCommentMark by id.That method use test object,which create
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
	public void testGettingServiceStationCommentMarkById(){
		Assert.assertNotNull(serviceStationCommentMarkDAO.getEntityById(ServiceStationCommentMark.class,
				serviceStationCommentMark.getIdServiceStation—ommentMark()));
	}

	/**
	 * Method testUpdateServiceStationCommentMark are testing on operation update
	 * ServiceStationCommentMark on operation update. That method use test object,
	 * which create before test run and destroy test object after method is finish.  
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 * @see org.junit.Assert
	 */
	@Transactional
	@Rollback(true)
	@Test
	public void testUpdateServiceStationCommentMark(){
		serviceStationCommentMark.setComment("SameTestCommentTest2");
		serviceStationCommentMarkDAO.updateEntity(serviceStationCommentMark);

		final ServiceStationCommentMark updatedServiceStationCommentMark =(ServiceStationCommentMark) serviceStationCommentMarkDAO
				.getEntityById(ServiceStationCommentMark.class,serviceStationCommentMark.getIdServiceStation—ommentMark());	
		Assert.assertTrue(updatedServiceStationCommentMark.getComment().equals("SameTestCommentTest2"));
	}

	/**
	 * Method testDeleteServiceStationCommentMark are testing operation delete 
	 * ServiceStationCommentMark by id. That method use test object, which create
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
	public void testDeleteServiceStationCommentMark(){

		serviceStationCommentMarkDAO.deleteEntity(serviceStationCommentMark);
		Assert.assertNull(serviceStationCommentMarkDAO.getEntityById(ServiceStationCommentMark.class,serviceStationCommentMark
				.getIdServiceStation—ommentMark()));
	}
	
	/**
	 * Method testGettingListCommentMarkStatusAsParamByIdServiceStation are 
	 * testing create list service station comment and mark with view status
	 * which perform as method parametr. That method use test object, which
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
	public void testGettingListCommentMarkStatusAsParamByIdServiceStation(){
		
		Long idServiceStation=serviceStation.getIdServiceStation();
		List<ServiceStationCommentMark> listServiceStationCommentMark;
		
		//list of comment mark for all in not empty
		String viewStatus="all";
		listServiceStationCommentMark =serviceStationCommentMarkDAO
				.getListCommentMarkStatusAsParamByIdServiceStation(idServiceStation, viewStatus);
		Assert.assertFalse(listServiceStationCommentMark.isEmpty());
		
		//list of comment mark for mechanic in not empty
		viewStatus="mechanic";
		serviceStationCommentMark.setViewStatus(viewStatus);
		serviceStationCommentMarkDAO.updateEntity(serviceStationCommentMark);
		listServiceStationCommentMark =serviceStationCommentMarkDAO
				.getListCommentMarkStatusAsParamByIdServiceStation(idServiceStation, viewStatus);
		Assert.assertFalse(listServiceStationCommentMark.isEmpty());
		
		//list of comment mark for director in not empty
		viewStatus="director";
		serviceStationCommentMark.setViewStatus(viewStatus);
		serviceStationCommentMarkDAO.updateEntity(serviceStationCommentMark);
		
		listServiceStationCommentMark =serviceStationCommentMarkDAO
				.getListCommentMarkStatusAsParamByIdServiceStation(idServiceStation, viewStatus);
		Assert.assertFalse(listServiceStationCommentMark.isEmpty());
		
		//list of comment mark is empty
		serviceStationCommentMarkDAO.deleteEntity(serviceStationCommentMark);
		listServiceStationCommentMark =serviceStationCommentMarkDAO
				.getListCommentMarkStatusAsParamByIdServiceStation(idServiceStation, viewStatus);
		Assert.assertTrue(listServiceStationCommentMark.isEmpty());
	}

	/**
	 * Method testGettingListCommentMarkByClient are testing create list of 
	 * service station comment and mark with all view status and which add same
	 * client. That method use test object, which create before test run and
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
	public void testGettingListCommentMarkByClient(){
	
		List<ServiceStationCommentMark> listCommentMarkByClient;
		listCommentMarkByClient= serviceStationCommentMarkDAO.getListCommentMarkByIdClient(client
				.getIdClient());
		Assert.assertFalse(listCommentMarkByClient.isEmpty());
		
		serviceStationCommentMarkDAO.deleteEntity(serviceStationCommentMark);
		listCommentMarkByClient=serviceStationCommentMarkDAO.getListCommentMarkByIdClient(client
				.getIdClient());
		Assert.assertTrue(listCommentMarkByClient.isEmpty());
	}
	
	/**
	 * Method testGettingListCommentMarkSortByDegressiveMark are testing create
	 * list of service station comment and mark with all view status and which sort
	 * by degressive mark. That method use test object, which create before test run
	 * and destroy test object after method is finish.   
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 * @see org.junit.Assert
	 */	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingListCommentMarkSortByDegressiveMark(){
	
		List<ServiceStationCommentMark> listServiceStationCommentMarkSortDegressiveMark;
		
		//mark exist
		listServiceStationCommentMarkSortDegressiveMark= serviceStationCommentMarkDAO
				.getListCommentMarkSortByDegressiveMark(serviceStation.getIdServiceStation());
		Assert.assertFalse(listServiceStationCommentMarkSortDegressiveMark.isEmpty());
	
		//remove mark
		serviceStationCommentMarkDAO.deleteEntity(serviceStationCommentMark);
		//mark not exist
		listServiceStationCommentMarkSortDegressiveMark=serviceStationCommentMarkDAO
				.getListCommentMarkSortByDegressiveMark(serviceStation.getIdServiceStation());
		Assert.assertTrue(listServiceStationCommentMarkSortDegressiveMark.isEmpty());
	}
}
