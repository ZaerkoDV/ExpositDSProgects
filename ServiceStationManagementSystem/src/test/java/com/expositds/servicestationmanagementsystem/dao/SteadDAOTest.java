/**
 *@package com.expositds.servicestationmanagementsystem.dao
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
import com.expositds.servicestationmanagementsystem.TestObjectCreator;
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.Stead;
/**
 * Class SteadDAOTest use to testing SteadDAOImpl class which belong to dao layer. Class use Junit
 * tests.To create test objects use method createObjectsForTest.That method create new object for test
 * and applying anatation Inject to get dependency injection. This is realization of pattern IoC.
 * All methods return void include initObjectsBeforeTest. All methods use annotation Rollback to roll
 * back transaction which created for test. Also in class use Assert. These  methods set assertion
 * methods useful for writing tests.
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
public class SteadDAOTest {//extends AbstractTest  {

//	/**
//	 * Variable logger use to get logger level for class SteadDAOTest.
//	 * 
//	 * @param SteadDAOTest.
//	 * @return logger for class SteadDAOTest.
//	 */
//	private static final Logger logger = LoggerFactory.getLogger(SteadDAOTest.class);
//
//	/**
//	 * Annatation Inject use to get injection of EntityUtilDAOImpl
//	 * and SteadDAOImpl dependency. This is part of specification
//	 * JSR-330.
//	 */
//	@Inject
//	@Qualifier("steadDAO")
//	private SteadDAO steadDAO;
//
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//	
//	public Stead stead;
//	public ServiceStation serviceStation;
//	public Department department;
//
//	/**
//	 * Create test object before test start.
//	 */
//	@Before
//	public void initSteadBeforeTest(){
//		department=testObjectCreator.createDepartmentForTest();
//		stead=department.getStead();
//		serviceStation=department.getServiceStation();
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
//		Assert.assertNotNull(steadDAO.getEntityById(Stead.class, stead.getIdStead()));
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
//		steadDAO.updateEntity(stead);
//
//		final Stead updatedStead =(Stead) steadDAO.getEntityById(Stead.class,stead.getIdStead());	
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
//		steadDAO.deleteEntity(stead);
//		Assert.assertNull(steadDAO.getEntityById(Stead.class, stead.getIdStead()));
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
//		Assert.assertFalse(steadDAO.getListStead().isEmpty());
//		
//		//stad not exist
//		steadDAO.deleteEntity(stead);
//		Assert.assertTrue(steadDAO.getListStead().isEmpty());
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
//		List<Department> listDepartmetUseCurrentStead=steadDAO.getListDepartmentUseCurrentStead(stead.getIdStead());
//		Assert.assertFalse(listDepartmetUseCurrentStead.isEmpty());
//		
//		//stad not exist
//		steadDAO.deleteEntity(department);
//		listDepartmetUseCurrentStead=steadDAO.getListDepartmentUseCurrentStead(stead.getIdStead());
//		Assert.assertTrue(listDepartmetUseCurrentStead.isEmpty());
//	}
}
