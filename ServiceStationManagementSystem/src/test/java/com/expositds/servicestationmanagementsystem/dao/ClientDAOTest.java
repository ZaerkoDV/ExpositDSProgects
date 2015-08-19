/**
 * @package com.expositds.servicestationmanagementsystem.dao
 * 
 * Packages located in the directory /src/test/java contains classes which exercise 
 * testing dao and service layer by mvc architecture. Classes used for test junit 
 * framework.
 */
package com.expositds.servicestationmanagementsystem.dao;

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
import com.expositds.servicestationmanagementsystem.model.ClientSecurityFeature;
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.model.EmployeeSecurityFeature;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.Stead;

/**
 * Class ClientDAOTest use to testing ClientDAOImpl class which belong to dao layer. Class use Junit
 * tests. To create test objects use method createObjectsForTest.That method create new object for
 * test and applying anatation Inject to get dependency injection. This is realization of pattern IoC.
 * All methods return void include initObjectsBeforeTest.All methods use annotation Rollback to roll
 * back transaction which created for test. Also in class use Assert. These methods set assertion
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
public class ClientDAOTest {//extends AbstractTest {

//	/**
//	 * Variable logger use to get logger level for class ClientDAOTest.
//	 * 
//	 * @param ClientDAOTest
//	 * @return logger for class ClientDAOTest.
//	 */
//	private static final Logger logger = LoggerFactory.getLogger(ClientDAOTest.class);
//
//	/**
//	 * Annatation Inject use to get injection of EntityUtilDAOImpl
//	 * and ClientDAOImpl dependency. This is part of specification
//	 * JSR-330.
//	 */
//	@Inject
//	@Qualifier("clientDAO")
//	private ClientDAO clientDAO;
//	
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//
//	public ServiceStation serviceStation;
//	public Stead stead;
//	public Department department;
//	public Client client;
//	public ClientSecurityFeature clientSecurityFeature;
//	public Employee employee;
//	public DepartmentOrder departmentOrder;
//	public EmployeeSecurityFeature employeeSecurityFeature;
//
//	/**
//	 * Create test object before test start.
//	 */
//	@Before
//	public void initClientBeforeTest(){
//		
//		departmentOrder=testObjectCreator.createDepartmentOrder();
//		department=departmentOrder.getDepartment();
//		client=departmentOrder.getClient();
//		employee=departmentOrder.getEmployee();
//		stead=department.getStead();
//		serviceStation=department.getServiceStation();
//		
//		clientSecurityFeature=testObjectCreator.createClientSecurityFeature();
//		employeeSecurityFeature=testObjectCreator.createEmployeeSecurityFeatureForTest();
//	}
//
//	/**
//	 * Destroy test object after method finish.
//	 */
//	@After 
//	public void clearClientSecurityFeatureAfterTest(){
//		serviceStation= null;
//		stead= null;
//		department= null;
//		client= null;
//		clientSecurityFeature = null;
//		clientSecurityFeature= null;
//		employee= null;
//		employeeSecurityFeature=null;
//		departmentOrder= null;
//	}
//
//	/**
//	 * Method testSaveClient are testing client on save operation.That method use test
//	 * object, which create before test run and destroy test object after method is
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
//	public void testSaveClient(){
//		Assert.assertFalse(client.equals(null));
//	}
//
//	/**
//	 * Method testGettingClientById are testing operation get client by his id.That
//	 * method use test object,which create before test run and destroy test object
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
//	public void testGettingClientById(){
//		Assert.assertNotNull(clientDAO.getEntityById(Client.class,client.getIdClient()));
//	}
//
//	/**
//	 * Method testUpdateClient are testing update client. That method use test object,
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
//	public void testUpdateClient(){
//
//		client.setClientFirstName("clientFirstNameTest2");
//		clientDAO.updateEntity(client);
//
//		final Client updatedClient =(Client) clientDAO.getEntityById(Client.class, client.getIdClient());	
//		Assert.assertTrue(updatedClient.getClientFirstName().equals("clientFirstNameTest2"));
//	}
//
//	/**
//	 * Method testDeleteClient are testing operation delete client by id. That method
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
//	public void testDeleteClientById(){
//
//		clientDAO.deleteEntity(client);
//		Assert.assertNull(clientDAO.getEntityById(Client.class, client.getIdClient()));
//	}
//
//	/**
//	 * Method testGettingListClientByLastName are testing create list client by last
//	 * name. That method use test object, which create before test run and destroy
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
//	public void testGettingListClientByLastName(){
//
//		List<Client> clientList=clientDAO.getListClientByLastName(client.getClientLastName());
//		Assert.assertFalse(clientList.isEmpty());
//
//		clientList=clientDAO.getListClientByLastName("sameTestLastName");
//		Assert.assertTrue(clientList.isEmpty());
//	}
//
//	/**
//	 * Method testGettingIdClientByLoginPassword are testing operation get client by
//	 * login and password. That method use test object, which create before test run
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
//	public void testGettingIdClientByLoginPassword(){
//
//		//login and password exist.
//		String clientLogin=clientSecurityFeature.getClientLogin();
//		String clientPassword=clientSecurityFeature.getClientPassword();
//		Long idClient=clientDAO.getIdClientByLoginPassword(clientLogin,clientPassword);
//		Assert.assertNotNull(idClient);
//
//		//login and password not exist
//		clientLogin="falseTestClientLogin";
//		clientPassword="falseTestClientPassword";
//		idClient=clientDAO.getIdClientByLoginPassword(clientLogin,clientPassword);
//		Assert.assertNull(idClient);
//	}
//
//	/**
//	 * Method testGettingClientByEmail are testing operation get client by client 
//	 * email. That method use test object, which create before test run and destroy
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
//	public void testGettingClientByEmail(){
//
//		clientDAO.deleteEntity(clientSecurityFeature.getClient());
//		
//		//client with email exist.
//		String clientEmail=client.getClientEmail();
//		Assert.assertNotNull(clientDAO.getClientByEmail(clientEmail));
//
//		//client with email not exist.
//		clientEmail="falseClientEmail@mail.ru";
//		Assert.assertNull(clientDAO.getClientByEmail(clientEmail));
//	}
//
//	/**
//	 * Method testOnSignInClientByLoginPassword are testing sign in client by login
//	 * and password. That method use test object, which create before test run and
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
//	public void testOnSignInClientByLoginPassword(){
//
//		//login and password exist.
//		String clientLogin=clientSecurityFeature.getClientLogin();
//		String clientPassword=clientSecurityFeature.getClientPassword();
//		Assert.assertTrue(clientDAO.signInClientByLoginPassword(clientLogin,clientPassword));
//
//		//login and password not exist
//		clientLogin="falseTestClientLogin";
//		clientPassword="falseTestClientPassword";
//		Assert.assertFalse(clientDAO.signInClientByLoginPassword(clientLogin,clientPassword));
//	}
//
//	/**
//	 * Method getCountClien are testing operation coun client in data base.
//	 * That method use test object, which create before test run and
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
//	public void getCountClient(){
//		
//		clientDAO.deleteEntity(clientSecurityFeature.getClient());
//		
//		int countClient= clientDAO.getCountClient();
//		Assert.assertEquals(1, countClient);
//	}
//
//	/**
//	 * Method testGettingListOrderAllServiceStationForClient are testing create
//	 * list of order which client have in all service station.That method use test
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
//	public void testGettingListOrderAllServiceStationForClient(){
//
//		//client exist.
//		Long idClient=client.getIdClient();
//		Assert.assertFalse(clientDAO.getListOrderAllServiceStationForClient(idClient).isEmpty());
//
//		//client not exist.
//		idClient=(long)2;
//		Assert.assertTrue(clientDAO.getListOrderAllServiceStationForClient(idClient).isEmpty());
//	}
//
//	/**
//	 * Method testGettingListNotcompletedOverdueOrderForClient are testing create
//	 * list of order with status not completed or overdue which client have in all
//	 * service station.That method use test object, which create before test run and
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
//	public void testGettingListNotcompletedOverdueOrderForClient(){
//		
//		//notcomplited order exist.
//		Long idClient=client.getIdClient();
//		Assert.assertFalse(clientDAO.getListNotcompletedOverdueOrderForClient(idClient).isEmpty());
//
//		//notcomplited order not exist.
//		departmentOrder.setOrderStatus("done");
//		clientDAO.updateEntity(departmentOrder);
//		Assert.assertTrue(clientDAO.getListNotcompletedOverdueOrderForClient(idClient).isEmpty());
//	}
//
//	/**
//	 * Method testGettingListNotcompletedOverdueOrderForClient are testing create
//	 * list of order with status done which client have in all service station.That
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
//	public void testGettingListDoneOrderForClient(){
//
//		Long idClient=client.getIdClient();
//		
//		//done order exist.
//		departmentOrder.setOrderStatus("done");
//		clientDAO.updateEntity(departmentOrder);
//		Assert.assertFalse(clientDAO.getListDoneOrderForClient(client.getIdClient()).isEmpty());
//
//		//done order not exist.
//		departmentOrder.setOrderStatus("notcompleted");
//		clientDAO.deleteEntity(departmentOrder);
//		Assert.assertTrue(clientDAO.getListDoneOrderForClient(idClient).isEmpty());
//	}
}
