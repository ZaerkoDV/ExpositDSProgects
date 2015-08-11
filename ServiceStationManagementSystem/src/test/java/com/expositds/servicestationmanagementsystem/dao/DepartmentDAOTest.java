/**
 * @package com.expositds.servicestationmanagementsystem.dao
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
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.servicestationmanagementsystem.AbstractTest;
import com.expositds.servicestationmanagementsystem.dao.impl.DepartmentDAOImpl;
import com.expositds.servicestationmanagementsystem.dao.impl.EntityUtilDAOImpl;
import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Detail;
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.model.EmployeeSecurityFeature;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.Stead;

/**
 * Class DepartmentDAOTest use to testing DepartmentDAO class which belong to dao layer.
 * Class use Junit tests. To create test objects use method createDepartmentForTest.That
 * method create new object for test and applying anatation Inject to get dependency 
 * injection. This is realization of pattern IoC. All methods return void except 
 * createDepartmentForTest. All methods use annotation Rollback to roll back transaction
 * which created for test. Also in class use Assert. These methods set assertion methods
 * useful for writing tests.
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
public class DepartmentDAOTest extends AbstractTest  {

	/**
	 * Variable logger use to get logger level for class DepartmentDAOTest.
	 * 
	 * @param DepartmentDAOTest
	 * @return logger for class DepartmentDAOTest.
	 */
	private static final Logger logger = LoggerFactory.getLogger(DepartmentDAOTest.class);

	/**
	 * Annatation Inject use to get injection of EntityUtilDAOImpl
	 * and DepartmentDAOImpl dependency. This is part of specification
	 * JSR-330.
	 */
	@Inject
	private DepartmentDAOImpl departmentDAO;

	@Inject
	private EntityUtilDAOImpl entityUtilDAO;
	
	public ServiceStation serviceStation;
	public Stead stead;
	public Department department;
	public Client client;
	public Employee employee;
	public EmployeeSecurityFeature employeeSecurityFeature;
	public DepartmentOrder departmentOrder;
	public Detail detail;

	/**
	 * Create test object before test start.
	 */
	@Before
	public void initDepartmentBeforeTest(){
		department = createDepartmentForTest();
	}

	/**
	 * Destroy test object after method finish.
	 */
	@After 
	public void clearDepartmentAfterTest(){
		serviceStation=null;
		stead=null;
		department=null;
		client= null;
		employee=null;
		employeeSecurityFeature=null;
		departmentOrder=null;
		detail=null;
	}

	/**
	 * Method create new objects for test. 
	 * 
	 * @return Department if operation create new department
	 * successfully completed else null and get exeption.
	 */
	public Department createDepartmentForTest() {

		serviceStation = new ServiceStation();
		serviceStation.setServiceStationName("serviceStationNameTest");
		//serviceStation.setServiceStationLogotype(serviceStationLogotype);
		serviceStation.setServiceStationAddress("serviceStationAddressTest");
		serviceStation.setServiceStationPhoneNumber("1234221");
		entityUtilDAO.saveEntity(serviceStation);

		stead = new Stead();
		stead.setSteadArea((Double)100.0);
		stead.setSteadCost((Double)10.0);
		entityUtilDAO.saveEntity(stead);
	
		department=new Department();
		department.setDepartmentName("departmentNameTest");
		department.setStead(stead);
		department.setServiceStation(serviceStation);
		entityUtilDAO.saveEntity(department);

		client = new Client();
		client.setClientFirstName("clientFirstNameTest");
		client.setClientLastName("clientLastNameTest");
		client.setClientMiddleName("clientMiddleNameTest");
		java.util.Date date = new java.util.Date();
		client.setClientBirthday(new Date(date.getTime()-10));
		client.setClientTelephone("12345");
		client.setClientEmail("test@mail.ru");
		entityUtilDAO.saveEntity(client);

		employee = new Employee();
		employee.setEmployeFirstName("employeFirstNameTest");
		employee.setEmployeLastName("employeLastNameTest");
		employee.setEmployeMiddleName("employeMiddleNameTest");
		employee.setEmployeFunction("employeFunctionTest");
		employee.setEmployeTelephone("234567");
		employee.setEmployeBirthday(new Date(date.getTime()-10));
		employee.setEmployeEmail("test@mail.ru");
		employee.setWages((Double)1024.1);
		entityUtilDAO.saveEntity(employee);
		
		employeeSecurityFeature = new EmployeeSecurityFeature();
		employeeSecurityFeature.setEmployeLogin("employeLoginTest");
		employeeSecurityFeature.setEmployePassword("employePasswordTest");
		employeeSecurityFeature.setEmployee(employee);
		entityUtilDAO.saveEntity(employeeSecurityFeature);

		departmentOrder=new DepartmentOrder();
		departmentOrder.setOrderDescription("testOrderDescription");
		departmentOrder.setStartOrder(new Date(date.getTime()));
		departmentOrder.setEndOrder(new Date(date.getTime()+1000));
		departmentOrder.setOrderCost((Double)100.0);
		departmentOrder.setWorkCost((Double)10.0);
		departmentOrder.setOrderStatus("notcompleted");
		departmentOrder.setClient(client);
		departmentOrder.setEmployee(employee);
		departmentOrder.setDepartment(department);
		entityUtilDAO.saveEntity(departmentOrder);	
		
		detail=new Detail();
		detail.setDetailName("detailNameTest");
		detail.setDetailManufacturer("detailManufacturerTest");
		detail.setDetailStatus("notexist");
		detail.setDetailCost((Double)100.0);	
		detail.setDetailWarrantyDay((long)100);
		detail.setDepartmentOrder(departmentOrder);
		entityUtilDAO.saveEntity(detail);

		return department;
	}

	/**
	 * Method testSaveDepartment are testing department save operation.That method 
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
	public void testSaveDepartment(){
		Assert.assertFalse(department.equals(null));
	}

	/**
	 * Method testGettingDepartmentById are testing operation get department by his
	 * id.That method use test object,which create before test run and destroy test
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
	public void testGettingDepartmentById(){
		Assert.assertNotNull(entityUtilDAO.getEntityById(Department.class,department.getIdDepartment()));
	}

	/**
	 * Method testUpdateDepartment are testing operation update department. That
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
	public void testUpdateDepartment(){
		department.setDepartmentName("departmentNameTest2");
		entityUtilDAO.updateEntity(department);

		Department updatedDepartment =(Department)entityUtilDAO
				.getEntityById(Department.class,department.getIdDepartment());	
		Assert.assertTrue(updatedDepartment.getDepartmentName().equals("departmentNameTest2"));
	}

	/**
	 * Method testDeleteDepartmentById are testing operation delete department by id.
	 * That method use test object, which create before test run and destroy test
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
	public void testDeleteDepartmentById(){

		entityUtilDAO.deleteEntityById(Department.class,department.getIdDepartment());
		Assert.assertNull(entityUtilDAO.getEntityById(Department.class, department.getIdDepartment()));
	}
	
	/**
	 * Method testGettingListDepartmentOrderByIdDepartment are testing operation
	 * create list of department order which belong department. That method use
	 * test object, which create before test run and destroy test object after 
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
	public void testGettingListDepartmentOrderByIdDepartment(){

		//department order exist
		List<DepartmentOrder> listDepartmentOrder=departmentDAO
				.getListDepartmentOrderByIdDepartment(department.getIdDepartment());
		Assert.assertFalse(listDepartmentOrder.isEmpty());
		
		//department order not exist
		entityUtilDAO.deleteEntity(departmentOrder);
		listDepartmentOrder=departmentDAO
				.getListDepartmentOrderByIdDepartment(department.getIdDepartment());
		Assert.assertTrue(listDepartmentOrder.isEmpty());
	}
	
	/**
	 * Method testGettingListClientByIdDepartment are testing operation
	 * create list of client which use department. That method use test
	 * object, which create before test run and destroy test object after 
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
	public void testGettingListClientByIdDepartment(){
		//department have client
		List<Client> listDepartmentClient=departmentDAO
				.getListClientByIdDepartment(department.getIdDepartment());
		Assert.assertFalse(listDepartmentClient.isEmpty());
		
		//department 
		entityUtilDAO.deleteEntity(client);
		listDepartmentClient=departmentDAO
				.getListClientByIdDepartment(department.getIdDepartment());
		Assert.assertTrue(listDepartmentClient.isEmpty());
	}
	
	/**
	 * Method testGettingListEmployeByIdDepartment are testing operation
	 * create list of employee which work in department.That method use test
	 * object, which create before test run and destroy test object after 
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
	public void testGettingListEmployeByIdDepartment(){
		
		//department have employee
		List<Employee> listDepartmentEmployee=departmentDAO
				.getListEmployeByIdDepartment(department.getIdDepartment());
		Assert.assertFalse(listDepartmentEmployee.isEmpty());
		
		//department have not employee
		entityUtilDAO.deleteEntity(employee);
		System.out.println(employee.getIdEmployee());
		
		listDepartmentEmployee=departmentDAO
				.getListEmployeByIdDepartment(department.getIdDepartment());
		Assert.assertTrue(listDepartmentEmployee.isEmpty());
	}
	
	/**
	 * Method testGettingTotalDetailCostForNotcompletedOverdueDepartmentOrder
	 * are testing operation get total sum costs detail in clients orders which
	 * have status notcompleted or overdue and which belong samedepartment.
	 * That method use test object, which create before test run and destroy 
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
	public void testGettingTotalDetailCostForNotcompletedOverdueDepartmentOrder(){
		
		//Total details cost not zero becouse order have detail.
		Double actual =departmentDAO
				.getTotalDetailCostForNotcompletedOverdueDepartmentOrder(department.getIdDepartment());
		Double expected=detail.getDetailCost();
		Assert.assertEquals(expected, actual);
		
		//Total details cost equals zero becouse order haven't detail.
		entityUtilDAO.deleteEntity(detail);
		actual =departmentDAO
				.getTotalDetailCostForNotcompletedOverdueDepartmentOrder(department.getIdDepartment());
		expected=0.0;
		System.out.println(actual);
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * Method testGettingFullIncomeForNotcompletedOverdueDepartmentOrder
	 * are testing operation get full income for not completed and overdue
	 * clients orders and which belong department.That method use test object,
	 * which create before test run and destroy test object after method is
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
	public void testGettingFullIncomeForNotcompletedOverdueDepartmentOrder(){
		
		Double actual =departmentDAO.getFullIncomeForNotcompletedOverdueDepartmentOrder(department
				.getIdDepartment());
		Double expected=departmentOrder.getOrderCost();
		Assert.assertEquals(expected, actual);
		
		entityUtilDAO.deleteEntity(departmentOrder);
		actual =departmentDAO.getFullIncomeForNotcompletedOverdueDepartmentOrder(department.getIdDepartment());
		expected=0.0;
		Assert.assertEquals(expected, actual);
	}
}
