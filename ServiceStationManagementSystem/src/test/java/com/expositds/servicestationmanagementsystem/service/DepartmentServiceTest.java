/**
 * 
 */
package com.expositds.servicestationmanagementsystem.service;

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
 * @author Zaerko_DV
 *
 */
public class DepartmentServiceTest {//extends AbstractTest {
	
//	private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceTest.class);
//	
//	@Inject
//	@Qualifier("departmentService")
//	private DepartmentService departmentService;
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
//	java.util.Date date = new java.util.Date();
//
//	/**
//	 * Create test object before test start.
//	 */
//	@Before
//	public void initDepartmentBeforeTest(){
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
//	/**
//	 * Destroy test object after method finish.
//	 */
//	@After 
//	public void clearDepartmentAfterTest(){
//		serviceStation=null;
//		stead=null;
//		department=null;
//		client= null;
//		employee=null;
//		employeeSecurityFeature=null;
//		departmentOrder=null;
//		detail=null;
//	}
//
//	/**
//	 * Method testSaveDepartment are testing department save operation.That method 
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
//	public void testSaveDepartment(){
//		Assert.assertFalse(department.equals(null));
//	}
//
//	/**
//	 * Method testGettingDepartmentById are testing operation get department by his
//	 * id.That method use test object,which create before test run and destroy test
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
//	public void testGettingDepartmentById(){
//		Assert.assertNotNull(departmentService.getEntityById(Department.class,department.getIdDepartment()));
//	}
//
//	/**
//	 * Method testUpdateDepartment are testing operation update department. That
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
//	public void testUpdateDepartment(){
//		department.setDepartmentName("departmentNameTest2");
//		departmentService.updateEntity(department);
//
//		Department updatedDepartment =(Department)departmentService
//				.getEntityById(Department.class,department.getIdDepartment());	
//		Assert.assertTrue(updatedDepartment.getDepartmentName().equals("departmentNameTest2"));
//	}
//
//	/**
//	 * Method testDeleteDepartmentById are testing operation delete department by id.
//	 * That method use test object, which create before test run and destroy test
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
//	public void testDeleteDepartmentById(){
//
//		departmentService.deleteEntityById(Department.class,department.getIdDepartment());
//		Assert.assertNull(departmentService.getEntityById(Department.class, department.getIdDepartment()));
//	}
//	
//	/**
//	 * Method testGettingListDepartmentOrderByIdDepartment are testing operation
//	 * create list of department order which belong department. That method use
//	 * test object, which create before test run and destroy test object after 
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
//	public void testGettingListDepartmentOrderByIdDepartment(){
//
//		//department order exist
//		List<DepartmentOrder> listDepartmentOrder=departmentService
//				.getListDepartmentOrderByIdDepartment(department.getIdDepartment());
//		Assert.assertFalse(listDepartmentOrder.isEmpty());
//		
//		//department order not exist
//		departmentService.deleteEntity(departmentOrder);
//		listDepartmentOrder=departmentService
//				.getListDepartmentOrderByIdDepartment(department.getIdDepartment());
//		Assert.assertTrue(listDepartmentOrder.isEmpty());
//	}
//	
//	/**
//	 * Method testGettingListClientByIdDepartment are testing operation
//	 * create list of client which use department. That method use test
//	 * object, which create before test run and destroy test object after 
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
//	public void testGettingListClientByIdDepartment(){
//		//department have client
//		List<Client> listDepartmentClient=departmentService
//				.getListClientByIdDepartment(department.getIdDepartment());
//		Assert.assertFalse(listDepartmentClient.isEmpty());
//		
//		//department 
//		departmentService.deleteEntity(client);
//		listDepartmentClient=departmentService
//				.getListClientByIdDepartment(department.getIdDepartment());
//		Assert.assertTrue(listDepartmentClient.isEmpty());
//	}
//	
//	/**
//	 * Method testGettingListEmployeByIdDepartment are testing operation
//	 * create list of employee which work in department.That method use test
//	 * object, which create before test run and destroy test object after 
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
//	public void testGettingListEmployeByIdDepartment(){
//		
//		//department have employee
//		List<Employee> listDepartmentEmployee=departmentService
//				.getListEmployeByIdDepartment(department.getIdDepartment());
//		Assert.assertFalse(listDepartmentEmployee.isEmpty());
//		
//		//department have not employee
//		departmentService.deleteEntity(employee);
//		System.out.println(employee.getIdEmployee());
//		
//		listDepartmentEmployee=departmentService
//				.getListEmployeByIdDepartment(department.getIdDepartment());
//		Assert.assertTrue(listDepartmentEmployee.isEmpty());
//	}
//	
//	/**
//	 * Method testGettingTotalDetailCostForNotcompletedOverdueDepartmentOrder
//	 * are testing operation get total sum costs detail in clients orders which
//	 * have status notcompleted or overdue and which belong samedepartment.
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
//	public void testGettingTotalDetailCostForNotcompletedOverdueDepartmentOrder(){
//		
//		//Total details cost not zero becouse order have detail.
//		Double actual =departmentService
//				.getTotalDetailCostForNotcompletedOverdueDepartmentOrder(department.getIdDepartment());
//		Double expected=detail.getDetailCost();
//		Assert.assertEquals(expected, actual);
//		
//		//Total details cost equals zero becouse order haven't detail.
//		departmentService.deleteEntity(detail);
//		actual =departmentService
//				.getTotalDetailCostForNotcompletedOverdueDepartmentOrder(department.getIdDepartment());
//		expected=0.0;
//		System.out.println(actual);
//		Assert.assertEquals(expected, actual);
//	}
//	
//	/**
//	 * Method testGettingFullIncomeForNotcompletedOverdueDepartmentOrder
//	 * are testing operation get full income for not completed and overdue
//	 * clients orders and which belong department.That method use test object,
//	 * which create before test run and destroy test object after method is
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
//	public void testGettingFullIncomeForNotcompletedOverdueDepartmentOrder(){
//		
//		Double actual =departmentService.getFullIncomeForNotcompletedOverdueDepartmentOrder(department
//				.getIdDepartment());
//		Double expected=departmentOrder.getOrderCost();
//		Assert.assertEquals(expected, actual);
//		
//		departmentService.deleteEntity(departmentOrder);
//		actual =departmentService.getFullIncomeForNotcompletedOverdueDepartmentOrder(department.getIdDepartment());
//		expected=0.0;
//		Assert.assertEquals(expected, actual);
//	}
//	
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingSumEmployeeWagesForDeportment(){
//		
//		Double actual =departmentService.getSumEmployeeWagesForDeportment(department.getIdDepartment());
//		Double expected=1024.1;
//		Assert.assertEquals(expected, actual);
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingTotalDetailCostForDoneDepartmentOrder(){
//		
//		//set order status
//		departmentOrder.setOrderStatus("done");
//		departmentService.updateEntity(departmentOrder);
//		
//		Double expected=detail.getDetailCost();
//		Double actual=departmentService.getTotalDetailCostForDoneDepartmentOrder(
//				department.getIdDepartment(),
//				new Date(date.getTime()-100000000),
//				new Date(date.getTime()));
//		
//		Assert.assertEquals(expected, actual);		
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingFullIncomeForDoneDepartmentOrder(){
//		
//		//set order status
//		departmentOrder.setOrderStatus("done");
//		departmentService.updateEntity(departmentOrder);
//		
//		Double expected=departmentOrder.getOrderCost();
//		Double actual=departmentService.getFullIncomeForDoneDepartmentOrder(
//				department.getIdDepartment(),
//				new Date(date.getTime()-100000000),
//				new Date(date.getTime()));
//		
//		Assert.assertEquals(expected, actual);		
//	}
}
