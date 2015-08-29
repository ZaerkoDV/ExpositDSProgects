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
 * Class DepartmentOrderDAOTest use to testing DepartmentOrderDAOImpl class which belong to dao layer.
 * Class use Junit tests. To create test objects use method createObjectsForTest.That method create
 * new object for test and applying anatation Inject to get dependency injection.This is realization
 * of pattern IoC. All methods return void include initObjectsBeforeTest. All methods use annotation
 * Rollback to roll back transaction which created for test. Also in class use Assert. These methods
 * set assertion methods useful for writing tests.
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
public class DepartmentOrderDAOTest {//extends AbstractTest {

//	/**
//	 * Variable logger use to get logger level for class DepartmentOrderDAOTest.
//	 * 
//	 * @param DepartmentOrderDAOTest.
//	 * @return logger for class DepartmentOrderDAOTest.
//	 */
//	private static final Logger logger = LoggerFactory.getLogger(DepartmentOrderDAOTest.class);
//
//	/**
//	 * Annatation Inject use to get injection of EntityUtilDAOImpl
//	 * and DepartmentOrderDAOImpl dependency. This is part of
//	 * specification JSR-330.
//	 */
//	@Inject
//	@Qualifier("departmentOrderDAO")
//	private DepartmentOrderDAO departmentOrderDAO;
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
//	/**
//	 * Create test object before test start.
//	 */
//	@Before
//	public void initDepartmentOrderBeforeTest(){
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
//	/**
//	 * Destroy test object after method finish.
//	 */
//	@After 
//	public void clearDepartmentOrderAfterTest(){
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
//	 * Method testSaveDepartmentOrder are testing DepartmentOrder on save operation.
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
//	public void testSaveDepartmentOrder(){
//		Assert.assertFalse(departmentOrder.equals(null));
//	}
//
//	/**
//	 * Method testGettingDepartmentOrderById are testing operation get DepartmentOrder
//	 * by id.That method use test object,which create before test run and destroy test
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
//	public void testGettingDepartmentOrderById(){
//		Assert.assertNotNull(departmentOrderDAO.getEntityById(DepartmentOrder.class,departmentOrder
//				.getIdDepartmentOrder()));
//	}
//
//	/**
//	 * Method testUpdateDepartmentOrdert are testing update DepartmentOrdert. That
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
//	public void testUpdateDepartmentOrdert(){
//		departmentOrder.setOrderDescription("testOrderDescription2");
//		departmentOrderDAO.updateEntity(departmentOrder);
//
//		final DepartmentOrder updatedDepartmentOrder =(DepartmentOrder) departmentOrderDAO
//				.getEntityById(DepartmentOrder.class, departmentOrder.getIdDepartmentOrder());	
//		Assert.assertTrue(updatedDepartmentOrder.getOrderDescription().equals("testOrderDescription2"));
//	}
//
//	/**
//	 * Method testDeleteDepartmentOrder are testing operation delete DepartmentOrder
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
//	public void testDeleteDepartmentOrderById(){
//
//		departmentOrderDAO.deleteEntityById(DepartmentOrder.class,departmentOrder.getIdDepartmentOrder());
//		Assert.assertNull(departmentOrderDAO.getEntityById(DepartmentOrder.class,departmentOrder
//				.getIdDepartmentOrder()));
//	}
//
//	/**
//	 * Method testGettingListDepartmentOrderForEmployee are testing create list of 
//	 * department order for employee which work in this department. That method use
//	 * test object, which create before test run and destroy test object after method
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
//	public void testGettingListDepartmentOrderForEmployee(){
//		
//		List<DepartmentOrder> listEmployeOrder;
//		
//		listEmployeOrder=departmentOrderDAO.getListDepartmentOrderForEmployee(employee.getIdEmployee());
//		Assert.assertFalse(listEmployeOrder.isEmpty());
//
//		departmentOrderDAO.deleteEntity(employee);
//		listEmployeOrder=departmentOrderDAO.getListDepartmentOrderForEmployee(employee.getIdEmployee());
//		Assert.assertTrue(listEmployeOrder.isEmpty());
//	}
//
//	/**
//	 * Method testGettingListDepartmentOrderForEmployee are testing create list of 
//	 * department order with notcompleted and overdue status for employee and which
//	 * work in this department. That method use test object, which create before test
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
//	public void testGettingListNotcompletedOverdueDepartmentOrderForEmployee(){
//
//		List<DepartmentOrder> employeNotcompletedOverdueOrderList;
//		
//		//overdue order exist.
//		departmentOrder.setOrderStatus("overdue");
//		departmentOrderDAO.updateEntity(departmentOrder);
//		
//		employeNotcompletedOverdueOrderList=departmentOrderDAO
//				.getListNotcompletedOverdueDepartmentOrderForEmployee(employee.getIdEmployee());
//		Assert.assertFalse(employeNotcompletedOverdueOrderList.isEmpty());
//
//		//notcomplited order not exist.
//		departmentOrder.setOrderStatus("done");
//		departmentOrderDAO.updateEntity(departmentOrder);
//
//		employeNotcompletedOverdueOrderList=departmentOrderDAO
//				.getListNotcompletedOverdueDepartmentOrderForEmployee(employee.getIdEmployee());
//		Assert.assertTrue(employeNotcompletedOverdueOrderList.isEmpty());
//	}
//	
//	/**
//	 * Method testGettingListDepartmentOrderForEmployee are testing create list of 
//	 * department order with done status for employee and which work in this
//	 * department. That method use test object, which create before test run and 
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
//	public void testGettingListDoneDepartmentOrderForEmployee(){
//
//		//notcomplited order exist.
//		departmentOrder.setOrderStatus("done");
//		departmentOrderDAO.updateEntity(departmentOrder);
//		
//		List<DepartmentOrder> employeDoneDepartmentOrderList=departmentOrderDAO
//				.getListDoneDepartmentOrderForEmployee(employee.getIdEmployee());
//		Assert.assertFalse(employeDoneDepartmentOrderList.isEmpty());
//
//		//notcomplited order not exist.
//		departmentOrder.setOrderStatus("notcomplited");
//		departmentOrderDAO.updateEntity(departmentOrder);
//		
//		employeDoneDepartmentOrderList=departmentOrderDAO
//				.getListDoneDepartmentOrderForEmployee(employee.getIdEmployee());
//		Assert.assertTrue(employeDoneDepartmentOrderList.isEmpty());
//	}
//
//	/**
//	 * Method testGettingFullDetailCostForDepartmentOrder are testing operation 
//	 * get full details cost for department order. That method use test object,
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
//	public void testGettingFullDetailCostForDepartmentOrder(){
//
//		Double actual=departmentOrderDAO.getFullDetailCostForDepartmentOrder(departmentOrder.getIdDepartmentOrder());
//		Double expected=detail.getDetailCost();
//		Assert.assertEquals(expected, actual);
//	}
//
//	/**
//	 * Method testGettingOrderCostForDepartmentOrder are testing operation 
//	 * get order cost for department order. That method use test object,
//	 * which create before test run and destroy test object after method
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
//	public void testGettingOrderCostForDepartmentOrder(){
//
//		Double actual=departmentOrderDAO.getOrderCostForDepartmentOrder(departmentOrder.getIdDepartmentOrder());
//		Double expected=departmentOrder.getOrderCost();
//		Assert.assertEquals(expected, actual);
//	}
//	
//	/**
//	 * Method testGettingListDetailForDepartmentOrder are testing operation 
//	 * get list detail for department order. That method use test object,
//	 * which create before test run and destroy test object after method
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
//	public void testGettingListDetailForDepartmentOrder(){
//		
//		Long idDepartmentOrder=detail.getDepartmentOrder().getIdDepartmentOrder();
//		List<Detail> listDetailForDepartmentOrder=departmentOrderDAO.getListDetailForDepartmentOrder(idDepartmentOrder);
//		Assert.assertFalse(listDetailForDepartmentOrder.isEmpty());
//	}
}
