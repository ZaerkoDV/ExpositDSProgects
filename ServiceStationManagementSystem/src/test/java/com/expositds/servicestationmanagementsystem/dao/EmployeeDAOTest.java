/**
 * @package com.expositds.servicestationmanagementsystem.dao
 * 
 * Packages located in the directory /src/test/java contains classes which exercise 
 * testing dao and service layer by mvc architecture. Classes used for test junit 
 * framework.
 */
package com.expositds.servicestationmanagementsystem.dao;

import java.sql.Date;
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
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.model.EmployeeSecurityFeature;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.Stead;

/**
 * Class EmployeeDAOTest use to testing EmployeeDAOImpl class which belong to dao layer. Class use
 * Junit tests. To create test objects use method createObjectsForTest.That method create new object
 * for test and applying anatation Inject to get dependency injection.This is realization of pattern
 * IoC.All methods return void include initObjectsBeforeTest.All methods use annotation Rollback to
 * roll back transaction which created for test. Also in class use Assert.These methods set assertion
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
public class EmployeeDAOTest extends AbstractTest {

	/**
	 * Variable logger use to get logger level for class EmployeeDAOTest.
	 * 
	 * @param EmployeeDAOTest
	 * @return logger for class EmployeeDAOTest.
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOTest.class);

	/**
	 * Annatation Inject use to get injection of EntityUtilDAOImpl
	 * and EmployeeDAOImpl dependency. This is part of specification
	 * JSR-330.
	 */
	@Inject
	@Qualifier("employeeDAO")
	private EmployeeDAO employeeDAO;

	public ServiceStation serviceStation;
	public Stead stead;
	public Department department;
	public Client client;
	public Employee employee;
	public EmployeeSecurityFeature employeeSecurityFeature;
	public DepartmentOrder departmentOrder;

	/**
	 * Create test object before test start.
	 */
	@Before
	public void initEmployeeBeforeTest(){
		employee = createEmployeeForTest();
	}

	/**
	 * Destroy test object after method finish.
	 */
	@After 
	public void clearEmployeeAfterTest(){
		serviceStation= null;
		stead= null;
		department= null;
		client= null;
		employee= null;
		employeeSecurityFeature = null;
		departmentOrder= null;
	}

	/**
	 * Method create new objects for test. 
	 * 
	 * @return Employee if operation create new employee
	 * successfully completed else null and get exeption.
	 */
	public Employee createEmployeeForTest() {

		serviceStation = new ServiceStation();
		serviceStation.setServiceStationName("serviceStationNameTest");
		//serviceStation.setServiceStationLogotype(serviceStationLogotype);
		serviceStation.setServiceStationAddress("serviceStationAddressTest");
		serviceStation.setServiceStationPhoneNumber("1234221");
		employeeDAO.saveEntity(serviceStation);

		stead = new Stead();
		stead.setSteadArea((Double)100.0);
		stead.setSteadCost((Double)10.0);
		employeeDAO.saveEntity(stead);

		department=new Department();
		department.setDepartmentName("departmentNameTest");
		department.setStead(stead);
		department.setServiceStation(serviceStation);
		employeeDAO.saveEntity(department);	

		client = new Client();
		client.setClientFirstName("clientFirstNameTest");
		client.setClientLastName("clientLastNameTest");
		client.setClientMiddleName("clientMiddleNameTest");
		java.util.Date date = new java.util.Date();
		client.setClientBirthday(new Date(date.getTime()-10));
		client.setClientTelephone("12345");
		client.setClientEmail("test@mail.ru");
		employeeDAO.saveEntity(client);

		employee = new Employee();
		employee.setEmployeFirstName("employeFirstNameTest");
		employee.setEmployeLastName("employeLastNameTest");
		employee.setEmployeMiddleName("employeMiddleNameTest");
		employee.setEmployeFunction("mechanic");
		employee.setEmployeTelephone("234567");
		employee.setEmployeBirthday(new Date(date.getTime()-10));
		employee.setEmployeEmail("test@mail.ru");
		employee.setWages((Double)1024.1);
		employeeDAO.saveEntity(employee);
		
		employeeSecurityFeature = new EmployeeSecurityFeature();
		employeeSecurityFeature.setEmployeLogin("employeLoginTest");
		employeeSecurityFeature.setEmployePassword("employePasswordTest");
		employeeSecurityFeature.setEmployee(employee);
		employeeDAO.saveEntity(employeeSecurityFeature);
		
		employeeSecurityFeature = new EmployeeSecurityFeature();
		employeeSecurityFeature.setEmployeLogin("employeLoginTest");
		employeeSecurityFeature.setEmployePassword("employePasswordTest");
		employeeSecurityFeature.setEmployee(employee);
		employeeDAO.saveEntity(employeeSecurityFeature);

		departmentOrder=new DepartmentOrder();
		departmentOrder.setOrderDescription("testOrderDescription");
		departmentOrder.setStartOrder(new Date(date.getTime()));
		departmentOrder.setEndOrder(new Date(date.getTime()+1000));
		departmentOrder.setOrderCost(100.0);
		departmentOrder.setWorkCost((Double)10.0);
		departmentOrder.setOrderStatus("notcompleted");
		departmentOrder.setClient(client);
		departmentOrder.setEmployee(employee);
		departmentOrder.setDepartment(department);
		employeeDAO.saveEntity(departmentOrder);		

		return employee;
	}

	/**
	 * Method testSaveEmployee are testing employee on save operation.That method 
	 * use test object, which create before test run and destroy test object after
	 * method is finish. 
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 * @see org.junit.Assert
	 */
	@Transactional
	@Rollback(true)
	@Test
	public void testSaveEmployee(){
		Assert.assertFalse(employee.equals(null));
	}

	/**
	 * Method testGettingEmployeeById are testing operation get employe by his id.
	 * That method use test object,which create before test run and destroy test
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
	public void testGettingEmployeeById(){
		Assert.assertNotNull(employeeDAO.getEntityById(Employee.class, employee.getIdEmployee()));
	}

	/**
	 * Method testUpdateEmployee are testing update employee. That method use test
	 * object, which create before test run and destroy test object after method
	 * is finish.  
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 * @see org.junit.Assert
	 */
	@Transactional
	@Rollback(true)
	@Test
	public void testUpdateEmployee(){

		employee.setEmployeFirstName("employeFirstName2");
		employeeDAO.updateEntity(employee);

		final Employee updatedEmployee =(Employee) employeeDAO.getEntityById(Employee.class,
				employee.getIdEmployee());	
		Assert.assertTrue(updatedEmployee.getEmployeFirstName().equals("employeFirstName2"));
	}

	/**
	 * Method testDeleteEmployeeById are testing operation delete employee by id. That
	 * method use test object, which create before test run and destroy test object
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
	public void testDeleteEmployeeById(){

		employeeDAO.deleteEntityById(Employee.class, employee.getIdEmployee());
		Assert.assertNull(employeeDAO.getEntityById(Employee.class,employee.getIdEmployee()));
	}

	/**
	 * Method testGettingListEmployeeByLastName are testing create list employee by
	 * last name.That method use test object, which create before test run and destroy
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
	public void testGettingListEmployeeByLastName(){

		List<Employee> employeList=employeeDAO.getListEmployeByLastName(employee.getEmployeLastName());
		Assert.assertFalse(employeList.isEmpty());

		employeList=employeeDAO.getListEmployeByLastName("sameTestLastName");
		Assert.assertTrue(employeList.isEmpty());
	}

	/**
	 * Method testGettingIdEmployeByLoginPassword are testing operation get employee
	 * by login and password. That method use test object, which create before test
	 * run and destroy test object after method is finish.   
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 * @see org.junit.Assert
	 */	
	@Transactional
	@Rollback(true)
	@Test
	public void testGettingIdEmployeByLoginPassword(){

		//login and password exist.
		String employeLogin=employeeSecurityFeature.getEmployeLogin();
		String employePassword=employeeSecurityFeature.getEmployePassword();
		Long idEmployee=employeeDAO.getIdEmployeByLoginPassword(employeLogin,employePassword);
		Assert.assertNotNull(idEmployee);

		//login and password not exist
		employeLogin="falseTestEmployeLogin";
		employePassword="falseTestClientPassword";
		idEmployee=employeeDAO.getIdEmployeByLoginPassword(employeLogin, employePassword);
		Assert.assertNull(idEmployee);
	}

	/**
	 * Method testOnSignInEmployeeByLoginPassword are testing sign in employee by
	 * login and password. That method use test object, which create before test
	 * run and destroy test object after method is finish.   
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 * @see org.junit.Assert
	 */	
	@Transactional
	@Rollback(true)
	@Test
	public void testOnSignInEmployeeByLoginPassword(){

		//login and password exist.
		String employeLogin=employeeSecurityFeature.getEmployeLogin();
		String employePassword=employeeSecurityFeature.getEmployePassword();
		Assert.assertTrue(employeeDAO.signInEmployeByLoginPassword(employeLogin,employePassword));

		//login and password not exist
		employeLogin="falseTestEmployePassword";
		employePassword="falseTestEmployePassword";
		Assert.assertFalse(employeeDAO.signInEmployeByLoginPassword(employeLogin,employePassword));
	}

	/**
	 * Method testGettingListMechanic are testing create list all employee which have
	 * function mechanic.That method use test object, which create before test run and
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
	public void testGettingListMechanic(){

		//Mechanic exist.
		Assert.assertFalse(employeeDAO.getListMechanic().isEmpty());

		//Mechanic not exist
		employee.setEmployeFunction("director");
		employeeDAO.updateEntity(employee);
		Assert.assertTrue(employeeDAO.getListMechanic().isEmpty());
	}

	/**
	 * Method testGettingListDepartmentForEmployee are testing create list of departments
	 * in which employee work. That method use test object, which create before test run
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
	public void testGettingListDepartmentForEmployee(){

		List<Department> listDepartment =employeeDAO.getListDepartmentForEmployee(employee.getIdEmployee());
		Assert.assertFalse(listDepartment.isEmpty());
	}
}
