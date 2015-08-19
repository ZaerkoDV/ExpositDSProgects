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
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.Stead;

/**
 * @author Zaerko_DV
 *
 */
public class SteadServiceTest {//extends AbstractTest {
	
//	private static final Logger logger = LoggerFactory.getLogger(SteadServiceTest.class);
//	
//	@Inject
//	@Qualifier("steadService")
//	private SteadService steadService;
//	
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//
//	public ServiceStation serviceStation;
//	public Stead stead;
//	public Department department;
//	
//	@Before
//	public void initObjectsBeforeTest(){
//		
//		serviceStation=testObjectCreator.createServiceStationForTest();
//		stead=testObjectCreator.createSteadForTest();	
//		department=testObjectCreator.createDepartmentForTest();
//	}
//	
//	@After 
//	public void clearObjectsForTest(){
//		serviceStation=null;
//		stead=null;
//		department=null;
//	}
//
//	/**
//	 * Method testSaveStead are testing stead on save operation.That method use test
//	 * object, which create before test run and destroy test object after method is
//	 * finish. 
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testSaveStead(){
//		Assert.assertFalse(stead.equals(null));
//	}
//
//	/**
//	 * Method testGettingSteadById are testing operation get stead by his id.That
//	 * method use test object,which create before test run and destroy test object
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
//	public void testGettingSteadById(){
//		Assert.assertNotNull(steadService.getEntityById(Stead.class, stead.getIdStead()));
//	}
//
//	/**
//	 * Method testUpdateStead are testing update stead. That method use test object,
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
//	public void testUpdateStead(){
//
//		stead.setSteadArea((Double)101.0);
//		steadService.updateEntity(stead);
//
//		final Stead updatedStead =(Stead) steadService.getEntityById(Stead.class,stead.getIdStead());	
//		Assert.assertTrue(updatedStead.getSteadArea().equals((Double)101.0));
//	}
//
//	/**
//	 * Method testDeleteStead are testing operation delete stead by id. That method
//	 * use test object, which create before test run and destroy test object after
//	 * method is finish.   
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testDeleteStead(){
//
//		steadService.deleteEntity(stead);
//		Assert.assertNull(steadService.getEntityById(Stead.class, stead.getIdStead()));
//	}
//	
//	/**
//	 * Method testGettingListStead are testing create list all stead.
//	 * That method use test object, which create before test run and
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
//	public void testGettingListStead(){
//
//		//stad exist
//		Assert.assertFalse(steadService.getListStead().isEmpty());
//		
//		//stad not exist
//		steadService.deleteEntity(stead);
//		Assert.assertTrue(steadService.getListStead().isEmpty());
//	}
//	
//	/**
//	 * Method testGettingListDepartmentUseCurrentStead are testing create
//	 * of list department which use current stead.That method use test object,
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
//	public void testGettingListDepartmentUseCurrentStead(){
//
//		//stad exist
//		List<Department> listDepartmetUseCurrentStead=steadService.getListDepartmentUseCurrentStead(stead.getIdStead());
//		Assert.assertFalse(listDepartmetUseCurrentStead.isEmpty());
//		
//		//stad not exist
//		steadService.deleteEntity(department);
//		listDepartmetUseCurrentStead=steadService.getListDepartmentUseCurrentStead(stead.getIdStead());
//		Assert.assertTrue(listDepartmetUseCurrentStead.isEmpty());
//	}
}
