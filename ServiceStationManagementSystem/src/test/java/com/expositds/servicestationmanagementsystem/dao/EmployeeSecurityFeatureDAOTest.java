/**
 * @package com.expositds.servicestationmanagementsystem.dao
 * 
 * Packages located in the directory /src/test/java contains classes which exercise 
 * testing dao and service layer by mvc architecture. Classes used for test junit 
 * framework. 
 */
package com.expositds.servicestationmanagementsystem.dao;

import java.sql.Date;

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
import com.expositds.servicestationmanagementsystem.dao.impl.EmployeeSecurityFeatureDAOImpl;
import com.expositds.servicestationmanagementsystem.dao.impl.EntityUtilDAOImpl;
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.model.EmployeeSecurityFeature;

/**
 * Class EmployeeSecurityFeatureDAOTest use to testing EmployeeSecurityFeatureDAO class
 * which belong to dao layer. Class use Junit tests. To create test objects use method
 * createEmployeeSecurityFeatureForTest.That method create new object for test and applying
 * anatation Inject to get dependency injection. This is realization of pattern IoC. All
 * methods return void except createEmployeeSecurityFeatureForTest.All methods use 
 * annotation Rollback to roll back transaction which created for test. Also in class use
 * Assert. These methods set assertion methods useful for writing tests.
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
public class EmployeeSecurityFeatureDAOTest extends AbstractTest {

	/**
	 * Variable logger use to get logger level for class EmployeeSecurityFeatureDAOTest.
	 * 
	 * @param EmployeeSecurityFeatureDAOTest.
	 * @return logger for class EmployeeSecurityFeatureDAOTest.
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeSecurityFeatureDAOTest.class);
	
	/**
	 * Annatation Inject use to get injection of EntityUtilDAOImpl
	 * and EmployeeSecurityFeatureDAOImpl dependency. This is part
	 * of specification JSR-330.
	 */
	@Inject
	private EmployeeSecurityFeatureDAOImpl employeeSecurityFeatureDAO;
	
	@Inject
	private EntityUtilDAOImpl entityUtilDAO;

	public Employee employee;
	public EmployeeSecurityFeature employeeSecurityFeature;

	/**
	 * Create test object before test start.
	 */
	@Before
	public void initEmployeeSecurityFeatureBeforeTest(){
		employeeSecurityFeature = createEmployeeSecurityFeatureForTest();
	}

	/**
	 * Destroy test object after method finish.
	 */
	@After 
	public void clearEmployeeSecurityFeatureAfterTest(){
		employee=null;
		employeeSecurityFeature = null;
	}
	
	/**
	 * Method create new objects for test. 
	 * 
	 * @return  EmployeeSecurityFeature if operation create new 
	 * employeeSecurityFeature successfully completed else null
	 * and get exeption.
	 */
	public EmployeeSecurityFeature createEmployeeSecurityFeatureForTest() {

		employee = new Employee();
		employee.setEmployeFirstName("employeFirstNameTest");
		employee.setEmployeLastName("employeLastNameTest");
		employee.setEmployeMiddleName("employeMiddleNameTest");
		employee.setEmployeFunction("mechanic");
		employee.setEmployeTelephone("234567");
		java.util.Date date = new java.util.Date();
		employee.setEmployeBirthday(new Date(date.getTime()-10));
		employee.setEmployeEmail("test@mail.ru");
		employee.setWages((Double)1024.1);
		entityUtilDAO.saveEntity(employee);

		employeeSecurityFeature = new EmployeeSecurityFeature();
		employeeSecurityFeature.setEmployeLogin("employeLoginTest");
		employeeSecurityFeature.setEmployePassword("employePasswordTest");
		employeeSecurityFeature.setEmployee(employee);
		entityUtilDAO.saveEntity(employeeSecurityFeature);

		return employeeSecurityFeature;
	}
	
	/**
	 * Method testSaveEmployeeSecurityFeature are testing EmployeeSecurityFeature
	 * save operation.That method use test object, which create before test run
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
	public void testSaveEmployeeSecurityFeature(){
		Assert.assertFalse(employeeSecurityFeature.equals(null));
	}
	
	/**
	 * Method testGettingEmployeeSecurityFeatureById are testing operation get
	 * EmployeeSecurityFeature by id.That method use test object,which create
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
	public void testGettingEmployeeSecurityFeatureById(){
		Assert.assertNotNull(entityUtilDAO.getEntityById(EmployeeSecurityFeature.class,
				employeeSecurityFeature.getIdEmployeSecurityFeature()));
	}
	
	/**
	 * Method testUpdateEmployeeSecurityFeature are testing update EmployeeSecurityFeature.
	 * That method use test object, which create before test run and destroy test object
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
	public void testUpdateEmployeeSecurityFeature(){
		
		employeeSecurityFeature.setEmployeLogin("employeLoginTest2");
		entityUtilDAO.updateEntity(employeeSecurityFeature);
		
		final EmployeeSecurityFeature updatedEmployeeSecurityFeature =(EmployeeSecurityFeature) entityUtilDAO
				.getEntityById(EmployeeSecurityFeature.class,employeeSecurityFeature.getIdEmployeSecurityFeature());	
		Assert.assertTrue(updatedEmployeeSecurityFeature.getEmployeLogin().equals("employeLoginTest2"));
	}
	
	/**
	 * Method testDeleteEmployeeSecurityFeature are testing operation delete client
	 * by id. That method use test object, which create before test run and destroy
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
	public void testDeleteEmployeeSecurityFeatureById(){

		entityUtilDAO.deleteEntityById(EmployeeSecurityFeature.class,employeeSecurityFeature.getIdEmployeSecurityFeature());
		Assert.assertNull(entityUtilDAO.getEntityById(EmployeeSecurityFeature.class, employeeSecurityFeature
				.getIdEmployeSecurityFeature()));
	}
	
	/**
	 * Method testOnUniqueEmployeeLoginPassword are testing on unique
	 * variable login and password. That method use test object, which
	 * create before test run and destroy test object after method is
	 * finish.   
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 * @see org.junit.Assert
	 */	
	@Transactional
	@Rollback(true)
	@Test
	public void testOnUniqueEmployeeLoginPassword(){

		Boolean isUniqueFalse=employeeSecurityFeatureDAO.isUniqueLoginPassword(
				employeeSecurityFeature.getEmployeLogin(),employeeSecurityFeature.getEmployePassword());
		Assert.assertFalse(isUniqueFalse);
		
		Boolean isUniqueTrue=employeeSecurityFeatureDAO.isUniqueLoginPassword("loginTest","passTest");
		Assert.assertTrue(isUniqueTrue);
	}
}
