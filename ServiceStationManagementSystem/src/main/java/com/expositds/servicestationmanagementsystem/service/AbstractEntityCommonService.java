/**
 * @package com.expositds.servicestationmanagementsystem.service
 * 
 * Package com.expositds.servicestationmanagementsystem.service contain set of interfaces
 * which description service layer in ServiceStationManagementSystem project. This project
 * is based on MVC architecture.This inerface perform class which is part of service layer in
 * MVC architecture.This layer defines the boundary of the application and a set of permitted
 * operations. It encapsulates the business logic of the application and controls the answers
 * in the implementation of operations. All classes which contain postfix “Service” provide to
 * work Service  for Service Station Management System application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions. 
 */
package com.expositds.servicestationmanagementsystem.service;

/**
 * <p>The interface AbstractEntityCommonServiceO contain methods ads which realize in class
 * AbstractEntityCommonServiceImpl. Class AbstractEntityCommonService use Service pattern
 * which describes service layer of application. This class contain general operation to
 * all classes.This interface contain ads methods which perform busness logic all application.
 * 
 * @version 1.0 18.08.2015
 * @author Zaerko Denis
 */
public interface AbstractEntityCommonService {

	/**
	 * Return entity by id if entity exist in data base with specify id else null.
	 * Parameter idEntity is attribute of any entity. Parameter entityClass provide
	 * type of object which method must return. It is one of the method which realize
	 * of a set of CRUD operations.This methods addresses to method in DAO layer for
	 * execution operation.
	 * 
	 * @type Long
	 * @type Collection
	 * @param idEntity
	 * @param entityClass
	 * 
	 * @return Object or null.
	 */
	public <T> Object getEntityById(Class<T> entityClass,Long idEntity);
	
	/**
	 * Save object in data base if object not null else generate exeption.Parameter
	 * author is object which save in data base. It is one of the method which realize
	 * of a set of CRUD operations. This methods addresses to method in DAO layer for
	 * execution operation.
	 * 
	 * @type Object
	 * @param entity
	 */
	public void saveEntity(Object entity);
	
	/**
	 * Update object in data base if object not null else generate* exeption.Parameter
	 * entity is object which update from data base. It is one of the method which realize
	 * of a set of CRUD operations. This methods addresses to method in DAO layer for
	 * execution operation.
	 * 
	 * @type Object
	 * @param entity
	 */
	public void updateEntity(Object entity);
	
	/**
	 * Remove object in data base if object not null else generate exeption. Parameter
	 * idEntity represents object which remove from data base.Parameter idEntity is attribute
	 * of any entity. Parameter entityClass provide type of object which remove. It is one of
	 * the method which realize of a set of CRUD operations.This methods addresses to method
	 * in DAO layer for execution operation.
	 * 
	 * @type Long
	 * @type Collection
	 * @param idEntity
	 * @param entityClass
	 */
	public <T> void deleteEntityById(Class<T> entityClass,Long idEntity);
	
	/**
	 * Remove object in data base if object not null else generate exeption. Parameter entity
	 * represents object which remove from data base. It is one of the method which realize of
	 * a set of CRUD operations.This methods addresses to method in DAO layer for execution
	 * operation.
	 * 
	 * @type Object
	 * @param entity
	 */
	public void deleteEntity(Object entity);
}
