/**
 * 
 */
package com.expositds.servicestationmanagementsystem.service;

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
import com.expositds.servicestationmanagementsystem.model.ClientSecurityFeature;
import com.expositds.servicestationmanagementsystem.service.impl.ClientSecurityFeatureServiceImpl;

/**
 * @author Zaerko_DV
 *
 */
public class ClientSecurityFeatureServiceTest {//extends AbstractTest {

//	private static final Logger logger = LoggerFactory.getLogger(ClientSecurityFeatureServiceTest.class);
//	
//	@Inject
//	@Qualifier("clientSecurityFeatureService")
//	private ClientSecurityFeatureService clientSecurityFeatureService;
//	
//	@Inject
//	@Qualifier("testObjectCreator")								
//	private TestObjectCreator testObjectCreator;
//	
//	public ClientSecurityFeature clientSecurityFeature;
//	
//	@Before
//	public void initObjectsBeforeTest(){
//		this.clientSecurityFeature=testObjectCreator.createClientSecurityFeature();
//	}
//	
//	@After 
//	public void clearObjectsForTest(){
//		clientSecurityFeature= null;
//	}
//
//	/**
//	 * Method testSaveClientSecurityFeature are testing ClientSecurityFeature save
//	 * operation.That method use test object, which create before test run and 
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
//	public void testSaveClientSecurityFeature(){
//		Assert.assertFalse(clientSecurityFeature.equals(null));
//	}
//	
//	/**
//	 * Method testGettingClientSecurityFeatureById are testing operation get ClientSecurityFeature
//	 * by id.That method use test object,which create before test run and destroy test object
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
//	public void testGettingClientSecurityFeatureById(){
//		Assert.assertNotNull(clientSecurityFeatureService.getEntityById(ClientSecurityFeature.class,
//				clientSecurityFeature.getId—lientSecurityFeature()));
//	}
//	
//	/**
//	 * Method testUpdateClientSecurityFeature are testing update ClientSecurityFeature.
//	 * That method use test object, which create before test run and destroy test object
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
//	public void testUpdateClientSecurityFeature(){
//		
//		clientSecurityFeature.setClientLogin("clientLoginTest2");
//		clientSecurityFeatureService.updateEntity(clientSecurityFeature);
//		
//		final ClientSecurityFeature updatedClientSecurityFeature =(ClientSecurityFeature) clientSecurityFeatureService
//				.getEntityById(ClientSecurityFeature.class,clientSecurityFeature.getId—lientSecurityFeature());	
//		Assert.assertTrue(updatedClientSecurityFeature.getClientLogin().equals("clientLoginTest2"));
//	}
//	
//	/**
//	 * Method testDeleteClientSecurityFeature are testing operation delete client
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
//	public void testDeleteClientSecurityFeatureById(){
//
//		clientSecurityFeatureService.deleteEntityById(ClientSecurityFeature.class,clientSecurityFeature
//				.getId—lientSecurityFeature());
//		Assert.assertNull(clientSecurityFeatureService.getEntityById(ClientSecurityFeature.class, clientSecurityFeature
//				.getId—lientSecurityFeature()));
//	}
//	
//	/**
//	 * Method testOnConfirmClientPassword are testing operation convert client password
//	 * to MD5 and check password. That method use test object, which create before test
//	 * run and destroy test object after method is finish.   
//	 * 
//	 * @see org.springframework.transaction.annotation.Transactional
//	 * @see org.springframework.test.annotation.Rollback
//	 * @see org.junit.Test
//	 * @see org.junit.Assert
//	 * @see org.apache.commons.codec.digest.DigestUtils
//	 */
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void testOnConfirmClientPassword(){
//				
//		Assert.assertTrue(clientSecurityFeature.getClientPassword().equals(clientSecurityFeature
//	.convertToMD5("clientPasswordTest")));
//		Assert.assertFalse(clientSecurityFeature.getClientPassword().equals(clientSecurityFeature
//	.convertToMD5("clientPasswordTest2")));
//	}
//	
//	/**
//	 * Method testOnUniqueClientLoginPassword are testing on unique
//	 * variable login and password. That method use test object, which
//	 * create before test run and destroy test object after method is
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
//	public void testOnUniqueClientLoginPassword(){
//
//		Boolean isUniqueFalse=clientSecurityFeatureService.isUniqueLoginPassword(
//				clientSecurityFeature.getClientLogin(),clientSecurityFeature.getClientPassword());
//		Assert.assertFalse(isUniqueFalse);
//		
//		Boolean isUniqueTrue=clientSecurityFeatureService.isUniqueLoginPassword("loginTest","passTest");
//		Assert.assertTrue(isUniqueTrue);
//	}	
}
