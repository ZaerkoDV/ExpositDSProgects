/**
 * @package com.expositds.servicestationmanagementsystem.service.impl
 * 
 * Package com.expositds.servicestationmanagementsystem.service.impl contain set of class
 * which description service layer in ServiceStationManagementSystem project. This project
 * is based on MVC architecture.This class is part of service layer in MVC architecture.This
 * layer defines the boundary of the application and a set of permitted operations. It
 * encapsulates the business logic of the application and controls the answers in the
 * implementation of operations. All classes which contain postfix ìServiceî provide to
 * work Service  for Service Station Management System application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions. 
 */
package com.expositds.servicestationmanagementsystem.service.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.expositds.servicestationmanagementsystem.dao.AbstractEntityCommonDAO;
import com.expositds.servicestationmanagementsystem.service.AbstractEntityCommonService;

/**
 * <p>The class AbstractEntityCommonServiceImpl use Service pattern which describes business
 * logic application ServiceStationManagemrntSystem. Service layer perform link between,
 * presentation layer and DAO layer.This layer is the main role becouse layer contents(set of
 * methods in classes) affect on functionality of all application.
 * This class contain methods which describes base operation with any entity.This class is general
 * for all classes in service layer.All classes in this layer extend this class and expand base
 * operation which contain in. Class implements interface AbstractEntityCommonService which perform
 * all methods of this class.
 * For logging use framework shell slf4j and framework log4j.Class contain also private, static
 * variable logger, which use to call log message. Class use Spring framework anatation to work
 * with service layer. 
 *  
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 18.08.2015
 * @author Zaerko Denis
 */
@Service(value="abstractEntity—ommonService")
public class AbstractEntityCommonServiceImpl implements AbstractEntityCommonService{

	/**
	 * Variable logger use to get logger level for class AbstractEntityCommonServiceImpl.
	 * 
	 * @param class name: AbstractEntityCommonServiceImpl
	 * @return logger for class AbstractEntityCommonServiceImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(AbstractEntityCommonServiceImpl.class);
	
	/**
	 * Annatation Inject use to get injection AbstractEntityCommonDAO
	 * dependency. This is part of specification JSR-330.
	 */
	@Inject
	@Qualifier("abstractEntity—ommonDAO")
	private AbstractEntityCommonDAO abstractEntity—ommonDAO;
	
	/**
	 * This is set method of injection AbstractEntityCommonDAO* dependency.
	 * This methods give the right set(writeable) abstractEntity—ommonDAO
	 */
	public void setAbstractEntity—ommonDAO(AbstractEntityCommonDAO abstractEntity—ommonDAO) {
		this.abstractEntity—ommonDAO = abstractEntity—ommonDAO;
	}
	
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
	public <T> Object getEntityById(Class<T> entityClass,Long idEntity) {
		logger.info("Service:Entity load by entity id"+idEntity);
		return abstractEntity—ommonDAO.getEntityById(entityClass, idEntity);
	}
	
	/**
	 * Save object in data base if object not null else generate exeption.Parameter
	 * author is object which save in data base. It is one of the method which realize
	 * of a set of CRUD operations. This methods addresses to method in DAO layer for
	 * execution operation.
	 * 
	 * @type Object
	 * @param entity
	 */
	public void saveEntity(Object entity){
		logger.info("Service:Entity save successful.");
		abstractEntity—ommonDAO.saveEntity(entity);
	}
	
	/**
	 * Update object in data base if object not null else generate* exeption.Parameter
	 * entity is object which update from data base. It is one of the method which realize
	 * of a set of CRUD operations. This methods addresses to method in DAO layer for
	 * execution operation.
	 * 
	 * @type Object
	 * @param entity
	 */
	public void updateEntity(Object entity){
		logger.info("Service:Entity update atributte successful.");
		abstractEntity—ommonDAO.updateEntity(entity);
	}
	
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
	public <T> void deleteEntityById(Class<T> entityClass,Long idEntity){
		logger.info("Service:Entity delite by id="+idEntity+" successful.");
		abstractEntity—ommonDAO.deleteEntityById(entityClass, idEntity);
	}
	
	/**
	 * Remove object in data base if object not null else generate exeption. Parameter entity
	 * represents object which remove from data base. It is one of the method which realize of
	 * a set of CRUD operations.This methods addresses to method in DAO layer for execution
	 * operation.
	 * 
	 * @type Object
	 * @param entity
	 */
	public void deleteEntity(Object entity){
		logger.info("Service:Entity delete successful.");
		abstractEntity—ommonDAO.deleteEntity(entity);
	}
}
