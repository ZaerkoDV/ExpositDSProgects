/**
  * @package com.expositds.servicestationmanagementsystem
 * 
 * Packages located in the directory /src/test/java contains classes which exercise 
 * testing dao and service layer by mvc architecture.Classes used for test jubit 
 * framework. 
 */
package com.expositds.servicestationmanagementsystem;

import java.util.Date;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.expositds.servicestationmanagementsystem.dao.AbstractEntityCommonDAO;
import com.expositds.servicestationmanagementsystem.dao.AbstractEntityCommonDAOTest;
import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.ClientSecurityFeature;
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Detail;
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.model.EmployeeSecurityFeature;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.ServiceStationCommentMark;
import com.expositds.servicestationmanagementsystem.model.Stead;

/**
 * This class are general for all test classes. All test classes use class TestObjectCreator for
 * create new test objects.Class contain set of methods which return test object and create object
 * which need for creating.
 * 
 * @see org.junit
 * @see org.springframework.test
 * @see org.slf4j
 * 
 * @version 1.0 17.08.2015
 * @author Zaerko Denis
 */
public class TestObjectCreator {

	private static final Logger logger = LoggerFactory.getLogger(TestObjectCreator.class);
	
	@Inject
	@Qualifier("abstractEntity—ommonDAO")
	private AbstractEntityCommonDAO abstractEntity—ommonDAO;
	
	public void setAbstractEntity—ommonDAO(AbstractEntityCommonDAO abstractEntity—ommonDAO) {
		this.abstractEntity—ommonDAO = abstractEntity—ommonDAO;
	}
	
	java.util.Date date = new java.util.Date();
	
	/**
	 * Method create new objects for test. 
	 * 
	 * @return ServiceStation(this may any object not till service station)
	 * if operation create new client successfully completed else null and
	 * get exeption.
	 */
	public ServiceStation createServiceStationForTest() {

		ServiceStation serviceStation = new ServiceStation();
		serviceStation.setServiceStationName("serviceStationNameTest");
		//serviceStation.setServiceStationLogotype(serviceStationLogotype);
		serviceStation.setServiceStationAddress("serviceStationAddressTest");
		serviceStation.setServiceStationPhoneNumber("1234221");
		abstractEntity—ommonDAO.saveEntity((ServiceStation)serviceStation);	
		
		return serviceStation;
	}
	
	/**
	 * Method create new objects for test. 
	 * 
	 * @return Stead if operation create new stead
	 * successfully completed else null and get exeption.
	 */
	public Stead createSteadForTest() {

		Stead stead = new Stead();
		stead.setSteadArea((Double)100.0);
		stead.setSteadCost((Double)10.0);
		abstractEntity—ommonDAO.saveEntity(stead);
		
		return stead;
	}
	
	/**
	 * Method create new objects for test. 
	 * 
	 * @return Department if operation create new department
	 * successfully completed else null and get exeption.
	 */
	public Department createDepartmentForTest(){
		
		Stead stead=createSteadForTest();
		ServiceStation serviceStation=createServiceStationForTest();
		
		Department department=new Department();
		department.setDepartmentName("departmentNameTest");
		department.setStead(stead);
		department.setServiceStation(serviceStation);
		abstractEntity—ommonDAO.saveEntity(department);	
		return department;
	}
	
	/**
	 * Method create new objects for test. 
	 * 
	 * @return Client if operation create new client
	 * successfully completed else null and get exeption.
	 */
	public Client createClientForTest(){
		
		Client client = new Client();
		client.setClientFirstName("clientFirstNameTest");
		client.setClientLastName("clientLastNameTest");
		client.setClientMiddleName("clientMiddleNameTest");
		client.setClientBirthday(new Date(date.getTime()-10));
		client.setClientTelephone("12345");
		client.setClientEmail("test@mail.ru");
		abstractEntity—ommonDAO.saveEntity(client);
		
		return client;
	} 
	
	/**
	 * Method create new objects for test. 
	 * 
	 * @return ClientSecurityFeature if operation create new 
	 * clientSecurityFeature successfully completed else null
	 * and get exeption.
	 */
	public ClientSecurityFeature createClientSecurityFeature(){
		
		Client client =createClientForTest();
		
		ClientSecurityFeature clientSecurityFeature = new ClientSecurityFeature();
		clientSecurityFeature.setClientLogin("clientLoginTest");
		clientSecurityFeature.setClientPassword("clientPasswordTest");
		clientSecurityFeature.setClient(client);
		abstractEntity—ommonDAO.saveEntity(clientSecurityFeature);
		
		return clientSecurityFeature;
	}
	
	/**
	 * Method create new objects for test. 
	 * 
	 * @return Employee if operation create new employee
	 * successfully completed else null and get exeption.
	 */
	public Employee createEmployeeForTest(){
		
		Employee employee = new Employee();
		employee.setEmployeFirstName("employeFirstNameTest");
		employee.setEmployeLastName("employeLastNameTest");
		employee.setEmployeMiddleName("employeMiddleNameTest");
		employee.setEmployeFunction("employeFunctionTest");
		employee.setEmployeTelephone("234567");
		employee.setEmployeBirthday(new Date(date.getTime()-10));
		employee.setEmployeEmail("test@mail.ru");
		employee.setWages((Double)1024.1);
		abstractEntity—ommonDAO.saveEntity(employee);
		
		return employee;
	}
	
	/**
	 * Method create new objects for test. 
	 * 
	 * @return  EmployeeSecurityFeature if operation create new 
	 * employeeSecurityFeature successfully completed else null
	 * and get exeption.
	 */
	public EmployeeSecurityFeature createEmployeeSecurityFeatureForTest(){
		
		Employee employee=createEmployeeForTest();
		
		EmployeeSecurityFeature employeeSecurityFeature = new EmployeeSecurityFeature();
		employeeSecurityFeature.setEmployeLogin("employeLoginTest");
		employeeSecurityFeature.setEmployePassword("employePasswordTest");
		employeeSecurityFeature.setEmployee(employee);
		abstractEntity—ommonDAO.saveEntity(employeeSecurityFeature);
		
		return employeeSecurityFeature;
	}
	
	/**
	 * Method create new objects for test. 
	 * 
	 * @return DepartmentOrder if operation create new 
	 * departmentOrder successfully completed else null
	 * and get exeption.
	 */
	public DepartmentOrder createDepartmentOrder(){

		Client client =createClientForTest();
		Employee employee =createEmployeeForTest();
		Department department =createDepartmentForTest();
		
		DepartmentOrder departmentOrder=new DepartmentOrder();
		departmentOrder.setOrderDescription("testOrderDescription");
		departmentOrder.setStartOrder(new Date(date.getTime()));
		departmentOrder.setEndOrder(new Date(date.getTime()+1000));
		departmentOrder.setOrderCost(100.0);
		departmentOrder.setWorkCost((Double)10.0);
		departmentOrder.setOrderStatus("TestStatus");
		departmentOrder.setClient(client);
		departmentOrder.setEmployee(employee);
		departmentOrder.setDepartment(department);
		abstractEntity—ommonDAO.saveEntity(departmentOrder);

		return departmentOrder;
	}
	
	/**
	 * Method create new objects for test. 
	 * 
	 * @return Detail if operation create new detail
	 * successfully completed else null and get exeption.
	 */
	public Detail createDetailForTeat(){
		
		DepartmentOrder departmentOrder =createDepartmentOrder();
		
		Detail detail=new Detail();
		detail.setDetailName("detailNameTest");
		detail.setDetailManufacturer("detailManufacturerTest");
		detail.setDetailStatus("notexist");
		detail.setDetailCost((Double)100.0);		
		detail.setDetailWarrantyDay((long)100);
		detail.setDepartmentOrder(departmentOrder);
		abstractEntity—ommonDAO.saveEntity(detail);
		
		return detail;
	}
	
	/**
	 * Method create new objects for test. 
	 * 
	 * @return ServiceStationCommentMark if operation create new
	 * serviceStationCommentMark successfully completed else null
	 * and get exeption.
	 */
	public ServiceStationCommentMark createServiceStationCommentMarkForTest(){
	
		ServiceStation serviceStation =createServiceStationForTest();
		Client client =createClientForTest();
		
		ServiceStationCommentMark serviceStationCommentMark = new ServiceStationCommentMark();
		serviceStationCommentMark.setComment("SameTestComment");
		serviceStationCommentMark.setViewStatus("all");
		serviceStationCommentMark.setMark((long)100);
		serviceStationCommentMark.setServiceStation(serviceStation);	
		serviceStationCommentMark.setClient(client);
		abstractEntity—ommonDAO.saveEntity(serviceStationCommentMark);
		
		return serviceStationCommentMark;
	}	
}
