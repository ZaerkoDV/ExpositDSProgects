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
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.Stead;

/**
 * @author Zaerko_DV
 *
 */
public class ServiceStationServiceTest {//extends AbstractTest {
	
//	private static final Logger logger = LoggerFactory.getLogger(ServiceStationServiceTest.class);
//	
//	@Inject
//	@Qualifier("serviceStationService")
//	private ServiceStationService serviceStationService;
//	
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//
//	public ServiceStation serviceStation;
//	public Stead stead;
//	public Department department;
//	public DepartmentOrder departmentOrder;
//	public Detail detail;
//	java.util.Date date = new java.util.Date();
//	
//	/**
//	 * Create test object before test start.
//	 */
//	@Before
//	public void initServiceStationBeforeTest(){
//		detail=testObjectCreator.createDetailForTeat();
//		departmentOrder=detail.getDepartmentOrder();
//		department=departmentOrder.getDepartment();
//		stead=department.getStead();
//		serviceStation=department.getServiceStation();
//	}
//
//	/**
//	 * Destroy test object after method finish.
//	 */
//	@After 
//	public void clearServiceStationAfterTest(){
//		serviceStation = null;
//		stead=null;
//		department=null;
//		departmentOrder=null;
//	}
//
//	/**
//	 * Method testSaveServiceStation are testing ServiceStation on
//	 * save operation.That method use test object, which create before
//	 * test run and destroy test object after method is finish. 
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testSaveServiceStation(){
//		Assert.assertFalse(serviceStation.equals(null));
//	}
//
//	/**
//	 * Method testGettingServiceStationById are testing operation get ServiceStation
//	 * by id.That method use test object, which create before test run and destroy
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
//	public void testGettingServiceStationById(){
//		Assert.assertNotNull(serviceStationService.getEntityById(ServiceStation.class, serviceStation
//				.getIdServiceStation()));
//	}
//
//	/**
//	 * Method testUpdateServiceStation are testing update ServiceStation. That
//	 * method use test object, which create before test run and destroy test 
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
//	public void testUpdateServiceStation(){
//
//		serviceStation.setServiceStationName("serviceStationNameTest");
//		serviceStationService.updateEntity(serviceStation);
//
//		final ServiceStation updatedServiceStation =(ServiceStation) serviceStationService
//				.getEntityById(ServiceStation.class,serviceStation.getIdServiceStation());	
//		Assert.assertTrue(updatedServiceStation.getServiceStationName().equals("serviceStationNameTest"));
//	}
//
//	/**
//	 * Method testDeleteServiceStationById are testing operation delete
//	 * ServiceStation by id. That method use test object, which create
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
//	public void testDeleteServiceStationById(){
//
//		serviceStationService.deleteEntityById(ServiceStation.class,serviceStation.getIdServiceStation());
//		Assert.assertNull(serviceStationService.getEntityById(ServiceStation.class, serviceStation.getIdServiceStation()));
//	}
//	
//	/**
//	 * Method testGettiongListSteadUseServiceStation are testing create list
//	 * stead which rent by service station. That method use test object, which
//	 * create before test run and destroy test object after method is finish.   
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettiongListSteadUseServiceStation(){
//
//		//list not empty
//		List<Stead> listStead= serviceStationService.getListSteadUseServiceStation(serviceStation
//				.getIdServiceStation());
//		Assert.assertFalse(listStead.isEmpty());
//		
//		//list is empty because department not exist
//		serviceStationService.deleteEntity(department);
//		listStead= serviceStationService.getListSteadUseServiceStation(serviceStation.getIdServiceStation());
//		Assert.assertTrue(listStead.isEmpty());
//	}
//	
//	/**
//	 * Method testGettiongTotalDepartmentArea are testing actual and expected
//	 * total area service station(area of stead which use departmen of service
//	 * station). That method use test object, which create before test run and
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
//	public void testGettingTotalServiceStationArea(){
//		
//		Double actual=serviceStationService.getTotalServiceStationArea(serviceStation.getIdServiceStation());
//		Double expected=stead.getSteadArea();
//		Assert.assertEquals(expected, actual);
//		
//		serviceStationService.deleteEntity(department);
//		actual=serviceStationService.getTotalServiceStationArea(serviceStation.getIdServiceStation());
//		expected=0.0;
//		Assert.assertEquals(expected, actual);
//	}
//	
//	/**
//	 * Method testGettingAllServiceStation are testing create list of all service
//	 * station. That method use test object, which create before test run and
//	 * destroy test object after method is finish. 
//	 * 
//	 * @type List
//	 */
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingAllServiceStation(){
//
//		List<ServiceStation> listAllServiceStation=serviceStationService.getAllServiceStation();
//		Assert.assertFalse(listAllServiceStation.isEmpty());
//	}
//
//	/**
//	 * Method testGettingListDepartmentForServiceStation are testing create
//	 * list of all departments in service staton by id. That method use test
//	 * object, which create before test run and destroy test object after
//	 * method is finish. 
//	 * 
//	 * @type List
//	 */
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListDepartmentForServiceStation(){
//		Long idServiceStation=department.getServiceStation().getIdServiceStation();
//		List<Department> listDepartments=serviceStationService.getListDepartmentForServiceStation(idServiceStation);
//		Assert.assertFalse(listDepartments.isEmpty());		
//	}
//
//	/**
//	 * Method testGettingListEmployeeForServiceStation are testing create
//	 * list of all employees in service staton by id. That method use test
//	 * object, which create before test run and destroy test object after
//	 * method is finish. 
//	 * 
//	 * @type List
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingListEmployeeForServiceStation(){
//				
//		List<Employee> listEmployeeInServiceStation= serviceStationService
//				.getListEmployeeForServiceStation(serviceStation.getIdServiceStation());
//		Assert.assertFalse(listEmployeeInServiceStation.isEmpty());
//	}
//	
//	/**
//	 * Method testGettingClientForServiceStation are testing create
//	 * list of all clients in service staton by id. That method use test
//	 * object, which create before test run and destroy test object after
//	 * method is finish. 
//	 * 
//	 * @type List
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 */
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingClientForServiceStation(){
//				
//		List<Client> listClientInServiceStation= serviceStationService
//				.getListClientForServiceStation(serviceStation.getIdServiceStation());
//		Assert.assertFalse(listClientInServiceStation.isEmpty());
//	}
//	
//	/**
//	 * Method testGettingFinancialReportForDepartment are testing generate pdf departament
//	 * financial report which save on same path.That method use test object, which create
//	 * before test run and destroy test object after method is finish.   
//	 * 
//	 * @see javax.swing.JFileChooser
//	 * @see com.itextpdf.text
//	 * 
//	 * @return (void)generate pdf file which contain financial report for departmet.
//	 */
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingFinancialReportForDepartment(){
//		
//		Long idDepartment=department.getIdDepartment();
//		
//		Date startDate=new Date(date.getTime()-100000000);
//		Date endDate=new Date(date.getTime());		
//		serviceStationService.getFinancialReportForDepartmet(idDepartment, startDate, endDate);
//	}
//	
//	/**
//	 * Method testGettingFinancialReportForServiceStation are testing generate service station
//	 * financial report with pdf format which save on same path.That method use test object,
//	 * which create before test run and destroy test object after method is finish.   
//	 * 
//	 * @see javax.swing.JFileChooser
//	 * @see com.itextpdf.text
//	 * 
//	 * @return (void)generate pdf file which contain financial report for service station.
//	 */
//	//!!!!!!In hand check change
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testGettingFinancialReportForServiceStation(){
//		
//		Long idServiceStation=serviceStation.getIdServiceStation();
//		//Long idServiceStation=(long)1;
//	
//		Date startDate=new Date(date.getTime()-1000000000);
//		Date endDate=new Date(date.getTime());		
//		serviceStationService.getFinancialReportForServiceStation(idServiceStation, startDate, endDate);
//	}
}
