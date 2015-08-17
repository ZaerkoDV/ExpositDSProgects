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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.orm.hibernate4.HibernateObjectRetrievalFailureException;
import org.springframework.stereotype.Repository;

import com.expositds.servicestationmanagementsystem.dao.AbstractEntityCommonDAO;

/**
 * <p>The class AbstractEntity—ommonDAOImpl use DAO pattern which describes layer of data access
 * to object. DAO layer perform link between relational and object models. This class contain 
 * methods which intended to access to set of CRUD (create, read, update, delete) operation with
 * objects.Class provide operation to any object(entity).This class extend HibernateDaoSupport class
 * which create own HibernateTemplate instance if a SessionFactory is passed in. The "allowCreate"
 * flag on that HibernateTemplate will be "true" by default. A custom HibernateTemplate instance
 * can be used through overriding createHibernateTemplate. Class implements interface  name as
 * AbstractEntity—ommonDAO and located in package which have name com.expositds.servicestationmanagementsystem.dao.
 * All methods are public in class. For logging use framework shell slf4j and framework log4j.Class
 * contain also private, static variable logger, which use to call log message. Class  use Spring
 * framework  to work whith ORM. In particular often use HibernateTemplate for integration Hibernate
 * and Spring technologys.
 *  
 * @see org.springframework.stereotype
 * @see org.springframework.orm
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 09.08.2015
 * @author Zaerko Denis
 */
@Repository(value="abstractEntity—ommonDAO")
public class AbstractEntity—ommonDAOImpl extends HibernateDaoSupport implements AbstractEntityCommonDAO{

	/**
	 * Variable logger use to get logger level for class AbstractEntity—ommonDAOImpl.
	 * 
	 * @param class name: AbstractEntity—ommonDAOImpl
	 * @return logger for class AbstractEntity—ommonDAOImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(AbstractEntity—ommonDAOImpl.class);

	/**
	 * Return entity by id if entity exist in data base with specify id else null.
	 * Parameter idEntity is attribute of any entity. Parameter entityClass provide
	 * type of object which method must return. It is one of the method which realize
	 * of a set of CRUD operations.
	 * 
	 * @type Long
	 * @type Collection
	 * @param idEntity
	 * @param entityClass
	 * @throw HibernateObjectRetrievalFailureException
	 * 
	 * @return Object or null.
	 */
	public <T> Object getEntityById(Class<T> entityClass,Long idEntity) {

		try{
			logger.info("Entity"+entityClass.getName()+" loaded successfully id="+idEntity);
			return this.getHibernateTemplate().get(entityClass, idEntity);
			
		}catch(final HibernateObjectRetrievalFailureException e){
			logger.info("Entity not loaded,becouse successfully delete or never exist before"+e);
			return null;
		}
	}
	
	/**
	 * Save object in data base if object not null else generate
	 * exeption.Parameter author is object which save in data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @type Object
	 * @param entity
	 * 
	 * @throws HibernateObjectRetrievalFailureException
	 */
	public void saveEntity(Object entity){
		
		this.getHibernateTemplate().persist(entity);
		logger.info("Entity save successfully");
		this.getHibernateTemplate().flush();
	}

	/**
	 * Update object in data base if object not null else generate
	 * exeption.Parameter entity is object which update from data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @type Object
	 * @param entity
	 * @throws HibernateObjectRetrievalFailureException
	 */
	public void updateEntity(Object entity){
		
		this.getHibernateTemplate().update(entity);
		logger.info("Entity update successfully");
		this.getHibernateTemplate().flush();
	}

	/**
	 * Remove object in data base if object not null else generate exeption.
	 * Parameter idEntity represents object which remove from data base.Parameter
	 * idEntity is attribute of any entity. Parameter entityClass provide
	 * type of object which remove. It is one of the method which realize of
	 * a set of CRUD operations.
	 * 
	 * @type Long
	 * @type Collection
	 * @param idEntity
	 * @param entityClass
	 * @throws HibernateObjectRetrievalFailureException
	 */
	public <T> void deleteEntityById(Class<T> entityClass,Long idEntity){
		
		logger.info("Entity"+entityClass.getName()+" delete successfully,id="+idEntity);
		Object entity =this.getHibernateTemplate().get(entityClass, idEntity);
		
		this.getHibernateTemplate().delete(entity);
		this.getHibernateTemplate().flush();
	}
	
	/**
	 * Remove object in data base if object not null else generate exeption.
	 * Parameter entity represents object which remove from data base. It is
	 * one of the method which realize of a set of CRUD operations.
	 * 
	 * @type Object
	 * @param entity
	 * @throws HibernateObjectRetrievalFailureException
	 */
	public void deleteEntity(Object entity){
		
		logger.info("Entity delete successfully");
		this.getHibernateTemplate().delete(entity);
		this.getHibernateTemplate().flush();
	}
}
