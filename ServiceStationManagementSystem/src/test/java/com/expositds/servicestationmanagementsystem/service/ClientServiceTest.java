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
import com.expositds.servicestationmanagementsystem.model.ClientSecurityFeature;
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
public class ClientServiceTest {//extends AbstractTest {
	
//	private static final Logger logger = LoggerFactory.getLogger(ClientServiceTest.class);
//	
//	@Inject
//	@Qualifier("clientService")
//	private ClientService clientService;
//	
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//	
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
//	@Before
//	public void initObjectsBeforeTest(){
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
//	@After 
//	public void clearObjectsForTest(){
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
//		Assert.assertNotNull(clientService.getEntityById(Client.class,client.getIdClient()));
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
//		clientService.updateEntity(client);
//
//		final Client updatedClient =(Client) clientService.getEntityById(Client.class, client.getIdClient());	
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
//		clientService.deleteEntity(client);
//		Assert.assertNull(clientService.getEntityById(Client.class, client.getIdClient()));
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
//		List<Client> clientList=clientService.getListClientByLastName(client.getClientLastName());
//		Assert.assertFalse(clientList.isEmpty());
//
//		clientList=clientService.getListClientByLastName("sameTestLastName");
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
//		Long idClient=clientService.getIdClientByLoginPassword(clientLogin,clientPassword);
//		Assert.assertNotNull(idClient);
//
//		//login and password not exist
//		clientLogin="falseTestClientLogin";
//		clientPassword="falseTestClientPassword";
//		idClient=clientService.getIdClientByLoginPassword(clientLogin,clientPassword);
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
//		clientService.deleteEntity(clientSecurityFeature.getClient());
//		
//		//client with email exist.
//		String clientEmail=client.getClientEmail();
//		Assert.assertNotNull(clientService.getClientByEmail(clientEmail));
//
//		//client with email not exist.
//		clientEmail="falseClientEmail@mail.ru";
//		Assert.assertNull(clientService.getClientByEmail(clientEmail));
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
//		Assert.assertTrue(clientService.signInClientByLoginPassword(clientLogin,clientPassword));
//
//		//login and password not exist
//		clientLogin="falseTestClientLogin";
//		clientPassword="falseTestClientPassword";
//		Assert.assertFalse(clientService.signInClientByLoginPassword(clientLogin,clientPassword));
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
//		clientService.deleteEntity(clientSecurityFeature.getClient());
//		
//		int countClient= clientService.getCountClient();
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
//		Assert.assertFalse(clientService.getListOrderAllServiceStationForClient(idClient).isEmpty());
//
//		//client not exist.
//		idClient=(long)2;
//		Assert.assertTrue(clientService.getListOrderAllServiceStationForClient(idClient).isEmpty());
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
//		Assert.assertFalse(clientService.getListNotcompletedOverdueOrderForClient(idClient).isEmpty());
//
//		//notcomplited order not exist.
//		departmentOrder.setOrderStatus("done");
//		clientService.updateEntity(departmentOrder);
//		Assert.assertTrue(clientService.getListNotcompletedOverdueOrderForClient(idClient).isEmpty());
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
//		clientService.updateEntity(departmentOrder);
//		Assert.assertFalse(clientService.getListDoneOrderForClient(client.getIdClient()).isEmpty());
//
//		//done order not exist.
//		departmentOrder.setOrderStatus("notcompleted");
//		clientService.deleteEntity(departmentOrder);
//		Assert.assertTrue(clientService.getListDoneOrderForClient(idClient).isEmpty());
//	}
}
