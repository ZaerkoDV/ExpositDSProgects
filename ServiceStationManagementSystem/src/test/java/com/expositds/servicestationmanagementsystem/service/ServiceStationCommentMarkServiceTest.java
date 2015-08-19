/**
 * 
 */
package com.expositds.servicestationmanagementsystem.service;

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
import com.expositds.servicestationmanagementsystem.TestObjectCreator;
import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.ServiceStationCommentMark;
import com.expositds.servicestationmanagementsystem.service.impl.ServiceStationCommentMarkServiceImpl;

/**
 * @author Zaerko_DV
 *
 */
public class ServiceStationCommentMarkServiceTest {//extends AbstractTest {
	
//	private static final Logger logger = LoggerFactory.getLogger(ServiceStationCommentMarkServiceTest.class);
//	
//	@Inject
//	@Qualifier("serviceStationCommentMarkService")
//	private ServiceStationCommentMarkService serviceStationCommentMarkService;
//	
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//	
//	public ServiceStation serviceStation;
//	public Client client;
//	public ServiceStationCommentMark serviceStationCommentMark;
//	
//	/**
//	 * Create test object before test start.
//	 */
//	@Before
//	public void initServiceStationCommentMarkBeforeTest(){
//		serviceStation=testObjectCreator.createServiceStationForTest();
//		client=testObjectCreator.createClientForTest();
//		serviceStationCommentMark=testObjectCreator.createServiceStationCommentMarkForTest();
//	}
//
//	/**
//	 * Destroy test object after method finish.
//	 */
//	@After 
//	public void clearServiceStationCommentMarkAfterTest(){
//		client=null;
//		serviceStation = null;
//		serviceStationCommentMark= null;
//	}
//	
//	/**
//	 * Method testSaveServiceStationCommentMark are testing serviceStationCommentMark
//	 * on save operation.That method use test object, which create before test run and
//	 * destroy test object after method is finish. 
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testSaveServiceStationCommentMark(){
//		Assert.assertFalse(serviceStationCommentMark.equals(null));
//	}
//
//	/**
//	 * Method testGettingServiceStationCommentMarkById are testing operation get
//	 * ServiceStationCommentMark by id.That method use test object,which create
//	 * before test run and destroy test object after method is finish.  
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingServiceStationCommentMarkById(){
//		Assert.assertNotNull(serviceStationCommentMarkService.getEntityById(ServiceStationCommentMark.class,
//				serviceStationCommentMark.getIdServiceStation—ommentMark()));
//	}
//
//	/**
//	 * Method testUpdateServiceStationCommentMark are testing on operation update
//	 * ServiceStationCommentMark on operation update. That method use test object,
//	 * which create before test run and destroy test object after method is finish.  
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testUpdateServiceStationCommentMark(){
//		serviceStationCommentMark.setComment("SameTestCommentTest2");
//		serviceStationCommentMarkService.updateEntity(serviceStationCommentMark);
//
//		final ServiceStationCommentMark updatedServiceStationCommentMark =(ServiceStationCommentMark)serviceStationCommentMarkService
//				.getEntityById(ServiceStationCommentMark.class,serviceStationCommentMark.getIdServiceStation—ommentMark());	
//		Assert.assertTrue(updatedServiceStationCommentMark.getComment().equals("SameTestCommentTest2"));
//	}
//
//	/**
//	 * Method testDeleteServiceStationCommentMark are testing operation delete 
//	 * ServiceStationCommentMark by id. That method use test object, which create
//	 * before test run and destroy test object after method is finish.   
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteServiceStationCommentMark(){
//
//		serviceStationCommentMarkService.deleteEntity(serviceStationCommentMark);
//		Assert.assertNull(serviceStationCommentMarkService.getEntityById(ServiceStationCommentMark.class,serviceStationCommentMark
//				.getIdServiceStation—ommentMark()));
//	}
//	
//	/**
//	 * Method testGettingListCommentMarkStatusAsParamByIdServiceStation are 
//	 * testing create list service station comment and mark with view status
//	 * which perform as method parametr. That method use test object, which
//	 * create before test run and destroy test object after method is finish.   
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListCommentMarkStatusAsParamByIdServiceStation(){
//		
//		Long idServiceStation=serviceStation.getIdServiceStation();
//		List<ServiceStationCommentMark> listServiceStationCommentMark;
//		
//		//list of comment mark for all in not empty
//		String viewStatus="all";
//		listServiceStationCommentMark =serviceStationCommentMarkService
//				.getListCommentMarkStatusAsParamByIdServiceStation(idServiceStation, viewStatus);
//		Assert.assertFalse(listServiceStationCommentMark.isEmpty());
//		
//		//list of comment mark for mechanic in not empty
//		viewStatus="mechanic";
//		serviceStationCommentMark.setViewStatus(viewStatus);
//		serviceStationCommentMarkService.updateEntity(serviceStationCommentMark);
//		listServiceStationCommentMark =serviceStationCommentMarkService
//				.getListCommentMarkStatusAsParamByIdServiceStation(idServiceStation, viewStatus);
//		Assert.assertFalse(listServiceStationCommentMark.isEmpty());
//		
//		//list of comment mark for director in not empty
//		viewStatus="director";
//		serviceStationCommentMark.setViewStatus(viewStatus);
//		serviceStationCommentMarkService.updateEntity(serviceStationCommentMark);
//		
//		listServiceStationCommentMark =serviceStationCommentMarkService
//				.getListCommentMarkStatusAsParamByIdServiceStation(idServiceStation, viewStatus);
//		Assert.assertFalse(listServiceStationCommentMark.isEmpty());
//		
//		//list of comment mark is empty
//		serviceStationCommentMarkService.deleteEntity(serviceStationCommentMark);
//		listServiceStationCommentMark =serviceStationCommentMarkService
//				.getListCommentMarkStatusAsParamByIdServiceStation(idServiceStation, viewStatus);
//		Assert.assertTrue(listServiceStationCommentMark.isEmpty());
//	}
//
//	/**
//	 * Method testGettingListCommentMarkByClient are testing create list of 
//	 * service station comment and mark with all view status and which add same
//	 * client. That method use test object, which create before test run and
//	 * destroy test object after method is finish.   
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListCommentMarkByClient(){
//	
//		List<ServiceStationCommentMark> listCommentMarkByClient;
//		listCommentMarkByClient= serviceStationCommentMarkService.getListCommentMarkByIdClient(client
//				.getIdClient());
//		Assert.assertFalse(listCommentMarkByClient.isEmpty());
//		
//		serviceStationCommentMarkService.deleteEntity(serviceStationCommentMark);
//		listCommentMarkByClient=serviceStationCommentMarkService.getListCommentMarkByIdClient(client
//				.getIdClient());
//		Assert.assertTrue(listCommentMarkByClient.isEmpty());
//	}
//	
//	/**
//	 * Method testGettingListCommentMarkSortByDegressiveMark are testing create
//	 * list of service station comment and mark with all view status and which sort
//	 * by degressive mark. That method use test object, which create before test run
//	 * and destroy test object after method is finish.   
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListCommentMarkSortByDegressiveMark(){
//	
//		List<ServiceStationCommentMark> listServiceStationCommentMarkSortDegressiveMark;
//		
//		//mark exist
//		listServiceStationCommentMarkSortDegressiveMark= serviceStationCommentMarkService
//				.getListCommentMarkSortByDegressiveMark(serviceStation.getIdServiceStation());
//		Assert.assertFalse(listServiceStationCommentMarkSortDegressiveMark.isEmpty());
//	
//		//remove mark
//		serviceStationCommentMarkService.deleteEntity(serviceStationCommentMark);
//		//mark not exist
//		listServiceStationCommentMarkSortDegressiveMark=serviceStationCommentMarkService
//				.getListCommentMarkSortByDegressiveMark(serviceStation.getIdServiceStation());
//		Assert.assertTrue(listServiceStationCommentMarkSortDegressiveMark.isEmpty());
//	}
}
