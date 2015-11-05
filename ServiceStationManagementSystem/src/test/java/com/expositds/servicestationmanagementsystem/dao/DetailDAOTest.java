/**
 * @package com.expositds.servicestationmanagementsystem.dao
 * 
 * Packages located in the directory /src/test/java contains classes which exercise 
 * testing dao and service layer by mvc architecture. Classes used for test junit 
 * framework.
 */
package com.expositds.servicestationmanagementsystem.dao;

import java.util.Date;

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
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Detail;
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.model.EmployeeSecurityFeature;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.Stead;

/**
 * Class DetailDAOTest use to testing DetailDAOImpl class which belong to dao layer.Class
 * use Junit tests.To create test objects use method createObjectsForTest. That method create
 * new object for test and applying anatation Inject to get dependency injection. This is
 * realization of pattern IoC. All methods return void include initObjectsBeforeTest. All
 * methods use annotation Rollback to roll back transaction which created for test. Also in
 * class use Assert.These methods set assertion methods useful for writing tests.
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
public class DetailDAOTest {//extends AbstractTest {

//	/**
//	 * Variable logger use to get logger level for class DetailDAOTest.
//	 * 
//	 * @param DetailDAOTest
//	 * @return logger for class DetailDAOTest.
//	 */
//	private static final Logger logger = LoggerFactory.getLogger(DetailDAOTest.class);
//
//	/**
//	 * Annatation Inject use to get injection of EntityUtilDAOImpl
//	 * and DetailDAOImpl dependency. This is part of specification
//	 * JSR-330.
//	 */
//	@Inject
//	@Qualifier("detailDAO")
//	private DetailDAO detailDAO;
//	
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//
//	public ServiceStation serviceStation;
//	public Stead stead;
//	public Department department;
//	public Client client;
//	public Employee employee;
//	public DepartmentOrder departmentOrder;
//	public Detail detail;
//
//	/**
//	 * Create test object before test start.
//	 */
//	@Before
//	public void initDetailBeforeTest(){
//		detail=testObjectCreator.createDetailForTeat();
//		departmentOrder=detail.getDepartmentOrder();
//		client=departmentOrder.getClient();
//		employee=departmentOrder.getEmployee();
//		department=departmentOrder.getDepartment();
//		stead=department.getStead();
//		serviceStation=department.getServiceStation();
//	}
//
//	/**
//	 * Method testSaveDetail are testing client save operation.That method use test
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
//	public void testSaveDetail(){
//		Assert.assertFalse(detail.equals(null));
//	}
//
//	/**
//	 * Method testGettingDetailById are testing operation get detail by his id.That
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
//	public void testGettingDetailById(){
//		Assert.assertNotNull(detailDAO.getEntityById(Detail.class, detail.getIdDetail()));
//	}
//
//	/**
//	 * Method testUpdateDetail are testing update detail. That method use test object,
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
//	public void testUpdateDetail(){
//
//		detail.setDetailManufacturer("detailManufacturerTest");
//		detailDAO.updateEntity(detail);
//
//		final Detail updatedDetail =(Detail) detailDAO.getEntityById(Detail.class,detail.getIdDetail());	
//		Assert.assertTrue(updatedDetail.getDetailManufacturer().equals("detailManufacturerTest"));
//	}
//
//	/**
//	 * Method testDeleteDetailById are testing operation delete detail. That method
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
//	public void testDeleteDetailById(){
//
//		detailDAO.deleteEntityById(Detail.class, detail.getIdDetail());
//		Assert.assertNull(detailDAO.getEntityById(Detail.class, detail.getIdDetail()));
//	}
//	
//	/**
//	 * Method testGettingListAllDetail are testing create list of all details.
//	 * That method use test object, which create before test run and destroy
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
//	public void testGettingListAllDetail(){
//		
//		Assert.assertFalse(detailDAO.getListAllDetail().isEmpty());
//		detailDAO.deleteEntity(detail);
//		Assert.assertTrue(detailDAO.getListAllDetail().isEmpty());
//	}
//
//	/**
//	 * Method testGettingListDetailWithStausAsParam are testing create list of
//	 * details which have same status(exist or not exist).Detail status perform
//	 * as parametr in method.That method use test object, which create before test
//	 * run and destroy test object after method is finish.   
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListDetailWithStausAsParam(){
//		
//		//detail not exist
//		Assert.assertFalse(detailDAO.getListDetailWithStausAsParam("notexist").isEmpty());
//		Assert.assertTrue(detailDAO.getListDetailWithStausAsParam("exist").isEmpty());
//		
//		//detail exist		
//		detail.setDetailStatus("exist");
//		detailDAO.updateEntity(detail);
//		Assert.assertFalse(detailDAO.getListDetailWithStausAsParam("exist").isEmpty());
//		Assert.assertTrue(detailDAO.getListDetailWithStausAsParam("notexist").isEmpty());
//	}	
}
