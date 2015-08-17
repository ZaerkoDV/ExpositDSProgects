/**
 * @package com.expositds.servicestationmanagementsystem.dao
 * 
 * Packages located in the directory /src/test/java contains classes which exercise 
 * testing dao and service layer by mvc architecture. Classes used for test junit 
 * framework. 
 */
package com.expositds.servicestationmanagementsystem.dao;

import java.sql.Date;

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
import com.expositds.servicestationmanagementsystem.model.ClientSecurityFeature;
/**
 * Class ClientSecurityFeatureDAOTest use to testing ClientSecurityFeatureDAOImpl class which belong
 * to dao layer. Class use Junit tests. To create test objects use method createObjectsForTest.That
 * method create new object for test and applying anatation Inject to get dependency injection. This
 * is realization of pattern IoC. All methods return void include initObjectsBeforeTest. All methods
 * use annotation Rollback to roll back transaction which created for test. Also in class use Assert.
 * These methods set assertion methods useful for writing tests.
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
public class ClientSecurityFeatureDAOTest extends AbstractTest { 

	/**
	 * Variable logger use to get logger level for class ClientSecurityFeatureDAOTest.
	 * 
	 * @param ClientSecurityFeatureDAOTest.
	 * @return logger for class ClientSecurityFeatureDAOTest.
	 */
	private static final Logger logger = LoggerFactory.getLogger(ClientSecurityFeatureDAOTest.class);

	/**
	 * Annatation Inject use to get injection of EntityUtilDAOImpl
	 * and ClientSecurityFeatureDAOImpl dependency. This is part of
	 * specification JSR-330.
	 */
	@Inject
	@Qualifier("clientSecurityFeatureDAO")
	private ClientSecurityFeatureDAO clientSecurityFeatureDAO;

	public ClientSecurityFeature clientSecurityFeature;
	
	public Client client;

	/**
	 * Create test object before test start.
	 */
	@Before
	public void initClientSecurityFeatureBeforeTest(){
		clientSecurityFeature = createClientSecurityFeatureForTest();
	}

	/**
	 * Destroy test object after method finish.
	 */
	@After 
	public void clearClientSecurityFeatureAfterTest(){
		client=null;
		clientSecurityFeature = null;
	}
	
	/**
	 * Method create new objects for test. 
	 * 
	 * @return ClientSecurityFeature if operation create new 
	 * clientSecurityFeature successfully completed else null
	 * and get exeption.
	 */
	public ClientSecurityFeature createClientSecurityFeatureForTest() {

		client = new Client();
		client.setClientFirstName("clientFirstNameTest");
		client.setClientLastName("clientLastNameTest");
		client.setClientMiddleName("clientMiddleNameTest");
		java.util.Date date = new java.util.Date();
		client.setClientBirthday(new Date(date.getTime()-10));
		client.setClientTelephone("12345");
		client.setClientEmail("test@mail.ru");
		clientSecurityFeatureDAO.saveEntity(client);

		clientSecurityFeature = new ClientSecurityFeature();
		clientSecurityFeature.setClientLogin("clientLoginTest");
		clientSecurityFeature.setClientPassword("clientPasswordTest");
		clientSecurityFeature.setClient(client);
		clientSecurityFeatureDAO.saveEntity(clientSecurityFeature);
		
		return clientSecurityFeature;
	}
	
	/**
	 * Method testSaveClientSecurityFeature are testing ClientSecurityFeature save
	 * operation.That method use test object, which create before test run and 
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
	public void testSaveClientSecurityFeature(){
		Assert.assertFalse(clientSecurityFeature.equals(null));
	}
	
	/**
	 * Method testGettingClientSecurityFeatureById are testing operation get ClientSecurityFeature
	 * by id.That method use test object,which create before test run and destroy test object
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
	public void testGettingClientSecurityFeatureById(){
		Assert.assertNotNull(clientSecurityFeatureDAO.getEntityById(ClientSecurityFeature.class,
				clientSecurityFeature.getId—lientSecurityFeature()));
	}
	
	/**
	 * Method testUpdateClientSecurityFeature are testing update ClientSecurityFeature.
	 * That method use test object, which create before test run and destroy test object
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
	public void testUpdateClientSecurityFeature(){
		
		clientSecurityFeature.setClientLogin("clientLoginTest2");
		clientSecurityFeatureDAO.updateEntity(clientSecurityFeature);
		
		final ClientSecurityFeature updatedClientSecurityFeature =(ClientSecurityFeature) clientSecurityFeatureDAO
				.getEntityById(ClientSecurityFeature.class,clientSecurityFeature.getId—lientSecurityFeature());	
		Assert.assertTrue(updatedClientSecurityFeature.getClientLogin().equals("clientLoginTest2"));
	}
	
	/**
	 * Method testDeleteClientSecurityFeature are testing operation delete client
	 * by id. That method use test object, which create before test run and destroy
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
	public void testDeleteClientSecurityFeatureById(){

		clientSecurityFeatureDAO.deleteEntityById(ClientSecurityFeature.class,clientSecurityFeature
				.getId—lientSecurityFeature());
		Assert.assertNull(clientSecurityFeatureDAO.getEntityById(ClientSecurityFeature.class, clientSecurityFeature
				.getId—lientSecurityFeature()));
	}
	
	/**
	 * Method testOnConfirmClientPassword are testing operation convert client password
	 * to MD5 and check password. That method use test object, which create before test
	 * run and destroy test object after method is finish.   
	 * 
	 * @see org.springframework.transaction.annotation.Transactional
	 * @see org.springframework.test.annotation.Rollback
	 * @see org.junit.Test
	 * @see org.junit.Assert
	 * @see org.apache.commons.codec.digest.DigestUtils
	 */
	@Transactional
	@Rollback(true)
	@Test
	public void testOnConfirmClientPassword(){
				
		Assert.assertTrue(clientSecurityFeature.getClientPassword().equals(clientSecurityFeature
	.convertToMD5("clientPasswordTest")));
		Assert.assertFalse(clientSecurityFeature.getClientPassword().equals(clientSecurityFeature
	.convertToMD5("clientPasswordTest2")));
	}
	
	/**
	 * Method testOnUniqueClientLoginPassword are testing on unique
	 * variable login and password. That method use test object, which
	 * create before test run and destroy test object after method is
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
	public void testOnUniqueClientLoginPassword(){

		Boolean isUniqueFalse=clientSecurityFeatureDAO.isUniqueLoginPassword(
				clientSecurityFeature.getClientLogin(),clientSecurityFeature.getClientPassword());
		Assert.assertFalse(isUniqueFalse);
		
		Boolean isUniqueTrue=clientSecurityFeatureDAO.isUniqueLoginPassword("loginTest","passTest");
		Assert.assertTrue(isUniqueTrue);
	}
}
