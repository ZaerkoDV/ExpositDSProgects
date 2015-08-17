/**
 * @package com.expositds.servicestationmanagementsystem.dao.impl
 * 
 * Package com.expositds.servicestationmanagementsystem.dao.impl contain set of class which
 * description layer of data access object in ServiceStationManagementSystem project. This
 * project is based on MVC architecture.This class is part of dao layer in MVC architecture.
 * This layer offer abstract interface for work with any type data base. This pattern give
 * a chance work with DAO (data-access-object) without matter what kind of storage engine is
 * used and without need for a special way to match this storage engine. All classes which
 * contain word ìDAOî provide to work DAL for Service Station Management System application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.
 */
package com.expositds.servicestationmanagementsystem.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.expositds.servicestationmanagementsystem.dao.ClientSecurityFeatureDAO;
import com.expositds.servicestationmanagementsystem.model.ClientSecurityFeature;
/**
 * <p>The class ClientSecurityFeatureDAOImpl use DAO pattern which describes layer of data access
 * to object. DAO layer perform link between relational and object model.Model for this dao layer
 * describied in class ClientSecurityFeature. This class contain methods which intended to access
 * special operation with client security featur.Class extend AbstractEntity—ommonDAOImpl class,
 * which contain base set of operation(CRUD). Class implements interface ClientSecurityFeatureDAO
 * located in package which have name com.expositds.servicestationmanagementsystem.dao.All methods
 * are public in class.For logging use framework shell slf4j and framework log4j. Class contain
 * also private, static variable logger, which use to call log message. Class use Spring framework
 * to work whith ORM. In particular often use HibernateTemplate for integration Hibernate and Spring
 * technologys. For work with data base use hibernate criteria. This technology provide as object
 * oriented select query in relation to a particular entity, and allows you to query the database
 * without writing SQL code. Use Criteria is the most successful approach to search interface with
 * a variable number of conditions. To create copies of the Criteria used class Session, which acts
 * as a factory.
 * 
 * @see org.springframework.stereotype
 * @see org.springframework.orm
 * @see org.hibernate.Criteria
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 09.08.2015
 * @author Zaerko Denis
 */
@Repository(value = "clientSecurityFeatureDAO")
public class ClientSecurityFeatureDAOImpl extends AbstractEntity—ommonDAOImpl implements ClientSecurityFeatureDAO {

	/**
	 * Variable logger use to get logger level for class ClientSecurityFeatureDAOImpl.
	 * 
	 * @param ClientSecurityFeatureServiceImpl
	 * @return logger for class ClientSecurityFeatureDAOImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(ClientSecurityFeatureDAOImpl.class);
	
	/**
	 * Return result check on unique client login and password. If data base contains transmitted
	 * login or password return false else return true. 
	 * 
	 * @type String
	 * @type Boolean
	 * @param clientLogin
	 * @param clientPassword
	 * @throw NullPointerException 
	 * 
	 * @return true if login and password not exist in data base else false.
	 */
	public Boolean isUniqueLoginPassword(String clientLogin, String clientPassword){

		Boolean isUnique;
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(ClientSecurityFeature.class);
		criteria.add(Restrictions.eq("clientLogin", clientLogin));
		criteria.add(Restrictions.eq("clientPassword", clientPassword));
	
		try{
			if(criteria.list().isEmpty()){
				isUnique=true;
				logger.info("DAO:User login"+clientLogin+" and password "+clientPassword+" is unique.");
				
			}else{
				isUnique=false;
				logger.info("DAO:User login"+clientLogin+" and password "+clientPassword+" is not unique.");
			}	
		}catch(NullPointerException e){
			isUnique=false;
			logger.info("DAO:User login"+clientLogin+" and password "+clientPassword+" is not unique.");
		}
		return isUnique;
	}
}
