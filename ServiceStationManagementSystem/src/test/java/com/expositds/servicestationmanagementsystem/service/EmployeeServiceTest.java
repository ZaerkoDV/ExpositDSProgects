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
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.model.EmployeeSecurityFeature;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.Stead;

/**
 * @author Zaerko_DV
 *
 */
public class EmployeeServiceTest {//extends AbstractTest{

//	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceTest.class);
//	
//	@Inject
//	@Qualifier("employeeService")
//	private EmployeeService employeeService;
//	
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//	
//	public ServiceStation serviceStation;
//	public Stead stead;
//	public Department department;
//	public Client client;
//	//public ClientSecurityFeature clientSecurityFeature;
//	public Employee employee;
//	public DepartmentOrder departmentOrder;
//	public EmployeeSecurityFeature employeeSecurityFeature;
//	
//	@Before
//	public void initObjectsBeforeTest(){
//		
//		departmentOrder=testObjectCreator.createDepartmentOrder();
//		department=departmentOrder.getDepartment();
//		client=departmentOrder.getClient();
//		employee=departmentOrder.getEmployee();
//		stead=department.getStead();
//		serviceStation=department.getServiceStation();
//		
//		//clientSecurityFeature=testObjectCreator.createClientSecurityFeature();
//		employeeSecurityFeature=testObjectCreator.createEmployeeSecurityFeatureForTest();
//	}
//	
//	@After 
//	public void clearObjectsForTest(){
//		serviceStation= null;
//		stead= null;
//		department= null;
//		client= null;
//		//clientSecurityFeature = null;
//		employee= null;
//		employeeSecurityFeature=null;
//		departmentOrder= null;
//	}
//	
//	/**
//	 * Method testSaveEmployee are testing employee on save operation.That method 
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
//	public void testSaveEmployee(){
//		Assert.assertFalse(employee.equals(null));
//	}
//
//	/**
//	 * Method testGettingEmployeeById are testing operation get employe by his id.
//	 * That method use test object,which create before test run and destroy test
//	 * object after method is finish.  
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingEmployeeById(){
//		Assert.assertNotNull(employeeService.getEntityById(Employee.class, employee.getIdEmployee()));
//	}
//
//	/**
//	 * Method testUpdateEmployee are testing update employee. That method use test
//	 * object, which create before test run and destroy test object after method
//	 * is finish.  
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testUpdateEmployee(){
//
//		employee.setEmployeFirstName("employeFirstName2");
//		employeeService.updateEntity(employee);
//
//		final Employee updatedEmployee =(Employee) employeeService.getEntityById(Employee.class,
//				employee.getIdEmployee());	
//		Assert.assertTrue(updatedEmployee.getEmployeFirstName().equals("employeFirstName2"));
//	}
//
//	/**
//	 * Method testDeleteEmployeeById are testing operation delete employee by id. That
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
//	public void testDeleteEmployeeById(){
//
//		employeeService.deleteEntityById(Employee.class, employee.getIdEmployee());
//		Assert.assertNull(employeeService.getEntityById(Employee.class,employee.getIdEmployee()));
//	}
//
//	/**
//	 * Method testGettingListEmployeeByLastName are testing create list employee by
//	 * last name.That method use test object, which create before test run and destroy
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
//	public void testGettingListEmployeeByLastName(){
//
//		List<Employee> employeList=employeeService.getListEmployeByLastName(employee.getEmployeLastName());
//		Assert.assertFalse(employeList.isEmpty());
//
//		employeList=employeeService.getListEmployeByLastName("sameTestLastName");
//		Assert.assertTrue(employeList.isEmpty());
//	}
//
//	/**
//	 * Method testGettingIdEmployeByLoginPassword are testing operation get employee
//	 * by login and password. That method use test object, which create before test
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
//	public void testGettingIdEmployeByLoginPassword(){
//
//		//login and password exist.
//		String employeLogin=employeeSecurityFeature.getEmployeLogin();
//		String employePassword=employeeSecurityFeature.getEmployePassword();
//		Long idEmployee=employeeService.getIdEmployeByLoginPassword(employeLogin,employePassword);
//		Assert.assertNotNull(idEmployee);
//
//		//login and password not exist
//		employeLogin="falseTestEmployeLogin";
//		employePassword="falseTestClientPassword";
//		idEmployee=employeeService.getIdEmployeByLoginPassword(employeLogin, employePassword);
//		Assert.assertNull(idEmployee);
//	}
//
//	/**
//	 * Method testOnSignInEmployeeByLoginPassword are testing sign in employee by
//	 * login and password. That method use test object, which create before test
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
//	public void testOnSignInEmployeeByLoginPassword(){
//
//		//login and password exist.
//		String employeLogin=employeeSecurityFeature.getEmployeLogin();
//		String employePassword=employeeSecurityFeature.getEmployePassword();
//		Assert.assertTrue(employeeService.signInEmployeByLoginPassword(employeLogin,employePassword));
//
//		//login and password not exist
//		employeLogin="falseTestEmployePassword";
//		employePassword="falseTestEmployePassword";
//		Assert.assertFalse(employeeService.signInEmployeByLoginPassword(employeLogin,employePassword));
//	}
//
//	/**
//	 * Method testGettingListMechanic are testing create list all employee which have
//	 * function mechanic.That method use test object, which create before test run and
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
//	public void testGettingListMechanic(){
//
//		//Mechanic exist.
//		Assert.assertFalse(employeeService.getListMechanic().isEmpty());
//
//		//Mechanic not exist
//		employee.setEmployeFunction("director");
//		employeeService.updateEntity(employee);
//		Assert.assertTrue(employeeService.getListMechanic().isEmpty());
//	}
//
//	/**
//	 * Method testGettingListDepartmentForEmployee are testing create list of departments
//	 * in which employee work. That method use test object, which create before test run
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
//	public void testGettingListDepartmentForEmployee(){
//
//		List<Department> listDepartment =employeeService.getListDepartmentForEmployee(employee.getIdEmployee());
//		Assert.assertFalse(listDepartment.isEmpty());
//	}
}
