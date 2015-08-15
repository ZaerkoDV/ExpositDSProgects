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
public class DetailDAOTest extends AbstractTest {

	/**
	 * Variable logger use to get logger level for class DetailDAOTest.
	 * 
	 * @param DetailDAOTest
	 * @return logger for class DetailDAOTest.
	 */
	private static final Logger logger = LoggerFactory.getLogger(DetailDAOTest.class);

	/**
	 * Annatation Inject use to get injection of EntityUtilDAOImpl
	 * and DetailDAOImpl dependency. This is part of specification
	 * JSR-330.
	 */
	@Inject
	@Qualifier("detailDAO")
	private DetailDAO detailDAO;

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
	public void initDetailBeforeTest(){
		detail = createDetailForTest();
	}

	/**
	 * Destroy test object after method finish.
	 */
	@After 
	public void clearDepartmentOrderAfterTest(){
		serviceStation=null;
		stead=null;
		department=null;
		client=null;
		employee=null;
		employeeSecurityFeature=null;
		departmentOrder=null;
	}

	/**
	 * Method create new objects for test. 
	 * 
	 * @return Detail if operation create new detail
	 * successfully completed else null and get exeption.
	 */
	public Detail createDetailForTest() {

		serviceStation = new ServiceStation();
		serviceStation.setServiceStationName("serviceStationNameTest");
		//serviceStation.setServiceStationLogotype(serviceStationLogotype);
		serviceStation.setServiceStationAddress("serviceStationAddressTest");
		serviceStation.setServiceStationPhoneNumber("1234221");
		detailDAO.saveEntity(serviceStation);

		stead = new Stead();
		stead.setSteadArea((Double)100.0);
		stead.setSteadCost((Double)10.0);
		detailDAO.saveEntity(stead);

		department=new Department();
		department.setDepartmentName("departmentNameTest");
		department.setStead(stead);
		department.setServiceStation(serviceStation);
		detailDAO.saveEntity(department);	

		client = new Client();
		client.setClientFirstName("clientFirstNameTest");
		client.setClientLastName("clientLastNameTest");
		client.setClientMiddleName("clientMiddleNameTest");
		java.util.Date date = new java.util.Date();
		client.setClientBirthday(new Date(date.getTime()-10));
		client.setClientTelephone("12345");
		client.setClientEmail("test@mail.ru");
		detailDAO.saveEntity(client);

		employee = new Employee();
		employee.setEmployeFirstName("employeFirstNameTest");
		employee.setEmployeLastName("employeLastNameTest");
		employee.setEmployeMiddleName("employeMiddleNameTest");
		employee.setEmployeFunction("employeFunctionTest");
		employee.setEmployeTelephone("234567");
		employee.setEmployeBirthday(new Date(date.getTime()-10));
		employee.setEmployeEmail("test@mail.ru");
		employee.setWages((Double)1024.1);
		detailDAO.saveEntity(employee);
		
		employeeSecurityFeature = new EmployeeSecurityFeature();
		employeeSecurityFeature.setEmployeLogin("employeLoginTest");
		employeeSecurityFeature.setEmployePassword("employePasswordTest");
		employeeSecurityFeature.setEmployee(employee);
		detailDAO.saveEntity(employeeSecurityFeature);

		departmentOrder=new DepartmentOrder();
		departmentOrder.setOrderDescription("testOrderDescription");
		departmentOrder.setStartOrder(new Date(date.getTime()));
		departmentOrder.setEndOrder(new Date(date.getTime()+1000));
		departmentOrder.setOrderCost(100.0);
		departmentOrder.setWorkCost((Double)10.0);
		departmentOrder.setOrderStatus("TestStatus");
		departmentOrder.setClient(client);
		departmentOrder.setEmployee(employee);
		departmentOrder.setDepartment(department);
		detailDAO.saveEntity(departmentOrder);

		detail=new Detail();
		detail.setDetailName("detailNameTest");
		detail.setDetailManufacturer("detailManufacturerTest");
		detail.setDetailStatus("notexist");
		detail.setDetailCost((Double)100.0);		
		detail.setDetailWarrantyDay((long)100);
		detail.setDepartmentOrder(departmentOrder);
		detailDAO.saveEntity(detail);

		return detail;
	}

	/**
	 * Method testSaveDetail are testing client save operation.That method use test
	 * object, which create before test run and destroy test object after method is
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
	public void testSaveDetail(){
		Assert.assertFalse(detail.equals(null));
	}

	/**
	 * Method testGettingDetailById are testing operation get detail by his id.That
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
	public void testGettingDetailById(){
		Assert.assertNotNull(detailDAO.getEntityById(Detail.class, detail.getIdDetail()));
	}

	/**
	 * Method testUpdateDetail are testing update detail. That method use test object,
	 * which create before test run and destroy test object after method is finish.  
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 * @see org.junit.Assert
	 */
	@Transactional
	@Rollback(true)
	@Test
	public void testUpdateDetail(){

		detail.setDetailManufacturer("detailManufacturerTest");
		detailDAO.updateEntity(detail);

		final Detail updatedDetail =(Detail) detailDAO.getEntityById(Detail.class,detail.getIdDetail());	
		Assert.assertTrue(updatedDetail.getDetailManufacturer().equals("detailManufacturerTest"));
	}

	/**
	 * Method testDeleteDetailById are testing operation delete detail. That method
	 * use test object, which create before test run and destroy test object
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
	public void testDeleteDetailById(){

		detailDAO.deleteEntityById(Detail.class, detail.getIdDetail());
		Assert.assertNull(detailDAO.getEntityById(Detail.class, detail.getIdDetail()));
	}
	
	/**
	 * Method testGettingListAllDetail are testing create list of all details.
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
	public void testGettingListAllDetail(){
		
		Assert.assertFalse(detailDAO.getListAllDetail().isEmpty());
		detailDAO.deleteEntity(detail);
		Assert.assertTrue(detailDAO.getListAllDetail().isEmpty());
	}

	/**
	 * Method testGettingListDetailWithStausAsParam are testing create list of
	 * details which have same status(exist or not exist).Detail status perform
	 * as parametr in method.That method use test object, which create before test
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
	public void testGettingListDetailWithStausAsParam(){
		
		//detail not exist
		Assert.assertFalse(detailDAO.getListDetailWithStausAsParam("notexist").isEmpty());
		Assert.assertTrue(detailDAO.getListDetailWithStausAsParam("exist").isEmpty());
		
		//detail exist		
		detail.setDetailStatus("exist");
		detailDAO.updateEntity(detail);
		Assert.assertFalse(detailDAO.getListDetailWithStausAsParam("exist").isEmpty());
		Assert.assertTrue(detailDAO.getListDetailWithStausAsParam("notexist").isEmpty());
	}	
}
