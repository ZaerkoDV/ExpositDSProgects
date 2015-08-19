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
import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Detail;
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.model.EmployeeSecurityFeature;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.Stead;

/**
 * @author Zaerko_DV
 *
 */
public class DetailServiceTest {//extends AbstractTest {
	
//	private static final Logger logger = LoggerFactory.getLogger(DetailServiceTest.class);
//	
//	@Inject
//	@Qualifier("detailService")
//	private DetailService detailService;
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
//	public EmployeeSecurityFeature employeeSecurityFeature;
//	public DepartmentOrder departmentOrder;
//	public Detail detail;
//	
//	@Before
//	public void initObjectsBeforeTest(){
//		
//		serviceStation=testObjectCreator.createServiceStationForTest();
//		stead=testObjectCreator.createSteadForTest();	
//		department=testObjectCreator.createDepartmentForTest();
//		departmentOrder=testObjectCreator.createDepartmentOrder();
//		detail=testObjectCreator.createDetailForTeat();
//		client=testObjectCreator.createClientForTest();
//		employee=testObjectCreator.createEmployeeForTest();
//		employeeSecurityFeature=testObjectCreator.createEmployeeSecurityFeatureForTest();
//	}
//	
//	@After 
//	public void clearObjectsForTest(){
//		serviceStation=null;
//		stead=null;
//		department=null;
//		client=null;
//		employee=null;
//		departmentOrder=null;
//		detail=null;
//		employeeSecurityFeature=null;
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
//		Assert.assertNotNull(detailService.getEntityById(Detail.class, detail.getIdDetail()));
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
//		detailService.updateEntity(detail);
//
//		final Detail updatedDetail =(Detail) detailService.getEntityById(Detail.class,detail.getIdDetail());	
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
//		detailService.deleteEntityById(Detail.class, detail.getIdDetail());
//		Assert.assertNull(detailService.getEntityById(Detail.class, detail.getIdDetail()));
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
//		Assert.assertFalse(detailService.getListAllDetail().isEmpty());
//		detailService.deleteEntity(detail);
//		Assert.assertTrue(detailService.getListAllDetail().isEmpty());
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
//		Assert.assertFalse(detailService.getListDetailWithStausAsParam("notexist").isEmpty());
//		Assert.assertTrue(detailService.getListDetailWithStausAsParam("exist").isEmpty());
//		
//		//detail exist		
//		detail.setDetailStatus("exist");
//		detailService.updateEntity(detail);
//		Assert.assertFalse(detailService.getListDetailWithStausAsParam("exist").isEmpty());
//		Assert.assertTrue(detailService.getListDetailWithStausAsParam("notexist").isEmpty());
//	}	
}
