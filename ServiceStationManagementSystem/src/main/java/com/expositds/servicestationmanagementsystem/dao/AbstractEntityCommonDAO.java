/**
* @package com.expositds.servicestationmanagementsystem.dao
 * 
 * Package com.expositds.servicestationmanagementsystem.dao contain set of classes and
 * interfaces which description layer of data access object in ServiceStationManagementSystem
 * project. This project is based on MVC architecture.This class is part of dao layer in MVC
 * architecture. This layer offer abstract interface for work with any type data base. This 
 * pattern give a chance work with DAO (data-access-object) without matter what kind of storage
 * engine is used and without need for a special way to match this storage engine. All classes
 * which contain word"DAO"provide to work DAL for Service Station Management System application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions. 
 */
package com.expositds.servicestationmanagementsystem.dao;

/**
 * <p>The interface AbstractEntityCommonDAO contain methods ads which realize in class
 * AbstractEntityCommonDAOImpl. Class AbstractEntityCommonDAO use DAO pattern which 
 * describes layer of data access to object. This class contain general operation to
 * all model.This interface contain ads methods which intended to access to operation
 * with objects.Class use Spring framework to work whith ORM. In particular often use
 * HibernateTemplate for integration Hibernate and Spring technologys. For work with data
 * base use hibernate criteria. 
 * 
 * @version 1.0 11.08.2015
 * @author Zaerko Denis
 */
public interface AbstractEntityCommonDAO {
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
	public <T> Object getEntityById(Class<T> entityClass,Long idEntity);
	
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
	public void saveEntity(Object entity);
	
	/**
	 * Update object in data base if object not null else generate
	 * exeption.Parameter entity is object which update from data base.
	 * It is one of the method which realize of a set of CRUD operations.
	 * 
	 * @type Object
	 * @param entity
	 * @throws HibernateObjectRetrievalFailureException
	 */
	public void updateEntity(Object entity);
	
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
	public <T> void deleteEntityById(Class<T> entityClass,Long idEntity);
	
	/**
	 * Remove object in data base if object not null else generate exeption.
	 * Parameter entity represents object which remove from data base. It is
	 * one of the method which realize of a set of CRUD operations.
	 * 
	 * @type Object
	 * @param entity
	 * @throws HibernateObjectRetrievalFailureException
	 */
	public void deleteEntity(Object entity);
}
