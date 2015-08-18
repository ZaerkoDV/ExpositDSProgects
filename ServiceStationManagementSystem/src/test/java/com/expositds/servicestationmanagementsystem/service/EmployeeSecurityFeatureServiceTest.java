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
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.model.EmployeeSecurityFeature;

/**
 * @author Zaerko_DV
 *
 */
public class EmployeeSecurityFeatureServiceTest {//extends AbstractTest {

//	private static final Logger logger = LoggerFactory.getLogger(EmployeeSecurityFeatureServiceTest.class);
//	
//	@Inject
//	@Qualifier("employeeSecurityFeatureService")
//	private EmployeeSecurityFeatureService employeeSecurityFeatureService;
//	
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//
//	public Employee employee;
//	public EmployeeSecurityFeature employeeSecurityFeature;
//	
//	@Before
//	public void initObjectsBeforeTest(){
//		employeeSecurityFeature=testObjectCreator.createEmployeeSecurityFeatureForTest();
//		employee=employeeSecurityFeature.getEmployee();
//	}
//	
//	@After 
//	public void clearObjectsForTest(){
//		employee= null;
//		employeeSecurityFeature=null;
//	}
//	
//	/**
//	 * Method testSaveEmployeeSecurityFeature are testing EmployeeSecurityFeature
//	 * save operation.That method use test object, which create before test run
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
//	public void testSaveEmployeeSecurityFeature(){
//		Assert.assertFalse(employeeSecurityFeature.equals(null));
//	}
//	
//	/**
//	 * Method testGettingEmployeeSecurityFeatureById are testing operation get
//	 * EmployeeSecurityFeature by id.That method use test object,which create
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
//	public void testGettingEmployeeSecurityFeatureById(){
//		Assert.assertNotNull(employeeSecurityFeatureService.getEntityById(EmployeeSecurityFeature.class,
//				employeeSecurityFeature.getIdEmployeSecurityFeature()));
//	}
//	
//	/**
//	 * Method testUpdateEmployeeSecurityFeature are testing update EmployeeSecurityFeature.
//	 * That method use test object, which create before test run and destroy test object
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
//	public void testUpdateEmployeeSecurityFeature(){
//		
//		employeeSecurityFeature.setEmployeLogin("employeLoginTest2");
//		employeeSecurityFeatureService.updateEntity(employeeSecurityFeature);
//		
//		final EmployeeSecurityFeature updatedEmployeeSecurityFeature =(EmployeeSecurityFeature) employeeSecurityFeatureService
//				.getEntityById(EmployeeSecurityFeature.class,employeeSecurityFeature.getIdEmployeSecurityFeature());	
//		Assert.assertTrue(updatedEmployeeSecurityFeature.getEmployeLogin().equals("employeLoginTest2"));
//	}
//	
//	/**
//	 * Method testDeleteEmployeeSecurityFeature are testing operation delete client
//	 * by id. That method use test object, which create before test run and destroy
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
//	public void testDeleteEmployeeSecurityFeatureById(){
//
//		employeeSecurityFeatureService.deleteEntityById(EmployeeSecurityFeature.class,employeeSecurityFeature
//				.getIdEmployeSecurityFeature());
//		Assert.assertNull(employeeSecurityFeatureService.getEntityById(EmployeeSecurityFeature.class, employeeSecurityFeature
//				.getIdEmployeSecurityFeature()));
//	}
//	
//	/**
//	 * Method testOnConfirmEmployeePassword() are testing operation convert employee
//	 * password to MD5 and check password. That method use test object, which create
//	 * before test run and destroy test object after method is finish.   
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 * @see org.apache.commons.codec.digest.DigestUtils
//	 */
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testOnConfirmEmployeePassword(){
//		
//		Assert.assertTrue(employeeSecurityFeature.getEmployePassword().equals(employeeSecurityFeature
//				.convertToMD5("employePasswordTest")));
//		Assert.assertFalse(employeeSecurityFeature.getEmployePassword().equals(employeeSecurityFeature
//				.convertToMD5("employePasswordTest2")));
//	}
//	
//	/**
//	 * Method testOnUniqueEmployeeLoginPassword are testing on unique
//	 * variable login and password. That method use test object, which
//	 * create before test run and destroy test object after method is
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
//	public void testOnUniqueEmployeeLoginPassword(){
//
//		Boolean isUniqueFalse=employeeSecurityFeatureService.isUniqueLoginPassword(
//				employeeSecurityFeature.getEmployeLogin(),employeeSecurityFeature.getEmployePassword());
//		Assert.assertFalse(isUniqueFalse);
//		
//		Boolean isUniqueTrue=employeeSecurityFeatureService.isUniqueLoginPassword("loginTest","passTest");
//		Assert.assertTrue(isUniqueTrue);
//	}
}
