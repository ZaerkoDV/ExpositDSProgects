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
import com.expositds.servicestationmanagementsystem.model.Detail;
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.model.EmployeeSecurityFeature;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.Stead;

/**
 * @author Zaerko_DV
 *
 */
public class DepartmentOrderServiceTest {//extends AbstractTest {

//	private static final Logger logger = LoggerFactory.getLogger(DepartmentOrderServiceTest.class);
//	
//	@Inject
//	@Qualifier("departmentOrderService")
//	private DepartmentOrderService departmentOrderService;
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
//		Assert.assertNotNull(departmentOrderService.getEntityById(DepartmentOrder.class,departmentOrder
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
//		departmentOrderService.updateEntity(departmentOrder);
//
//		final DepartmentOrder updatedDepartmentOrder =(DepartmentOrder) departmentOrderService
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
//		departmentOrderService.deleteEntityById(DepartmentOrder.class,departmentOrder.getIdDepartmentOrder());
//		Assert.assertNull(departmentOrderService.getEntityById(DepartmentOrder.class,departmentOrder
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
//		listEmployeOrder=departmentOrderService.getListDepartmentOrderForEmployee(employee.getIdEmployee());
//		Assert.assertFalse(listEmployeOrder.isEmpty());
//
//		departmentOrderService.deleteEntity(employee);
//		listEmployeOrder=departmentOrderService.getListDepartmentOrderForEmployee(employee.getIdEmployee());
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
//		departmentOrderService.updateEntity(departmentOrder);
//		
//		employeNotcompletedOverdueOrderList=departmentOrderService
//				.getListNotcompletedOverdueDepartmentOrderForEmployee(employee.getIdEmployee());
//		Assert.assertFalse(employeNotcompletedOverdueOrderList.isEmpty());
//
//		//notcomplited order not exist.
//		departmentOrder.setOrderStatus("done");
//		departmentOrderService.updateEntity(departmentOrder);
//
//		employeNotcompletedOverdueOrderList=departmentOrderService
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
//		departmentOrderService.updateEntity(departmentOrder);
//		
//		List<DepartmentOrder> employeDoneDepartmentOrderList=departmentOrderService
//				.getListDoneDepartmentOrderForEmployee(employee.getIdEmployee());
//		Assert.assertFalse(employeDoneDepartmentOrderList.isEmpty());
//
//		//notcomplited order not exist.
//		departmentOrder.setOrderStatus("notcomplited");
//		departmentOrderService.updateEntity(departmentOrder);
//		
//		employeDoneDepartmentOrderList=departmentOrderService
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
//		Double actual=departmentOrderService.getFullDetailCostForDepartmentOrder(departmentOrder
//				.getIdDepartmentOrder());
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
//		Double actual=departmentOrderService.getOrderCostForDepartmentOrder(departmentOrder.getIdDepartmentOrder());
//		Double expected=departmentOrder.getOrderCost();
//		Assert.assertEquals(expected, actual);
//	}
}
