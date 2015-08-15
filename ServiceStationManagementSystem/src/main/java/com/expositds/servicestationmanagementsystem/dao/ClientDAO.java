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

import java.util.List;

import org.hibernate.NonUniqueResultException;

import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;

/**
 * <p>The interface ClientDAO contain methods ads which realize in class  ClientDAOImpl.
 * Class ClientDAOImpl use DAO pattern which describes layer of data access to object.
 * DAO layer perform link between relational and object model. Model for this dao layer
 * describied in class Client.This interface contain ads methods which intended to access
 * operation with object.Interface produce special operation with object.Base operation
 * (for any object) include as separate interface AbstractEntityCommonDAO which extend
 * to this interface. Class use Spring framework to work whith ORM.In particular often
 * use  HibernateTemplate for integration Hibernate and Spring technologys. For work with
 * data base use hibernate criteria. 
 * 
 * @version 1.0 11.08.2015
 * @author Zaerko Denis
 */
public interface ClientDAO extends AbstractEntityCommonDAO {

	/**
	 * Return list of client by last name. If data base contains client with transmitted
	 * last name return list of clients else return null. List contain serving on 20 rows
	 * and start on 1 row. 
	 * 
	 * @type String
	 * @param clientLastName
	 * @throw DataAccessException 
	 * @throw NullPointerException
	 * 
	 * @return List<Client> all client with last name as parametr.
	 */
	public List<Client> getListClientByLastName(String clientLastName);
	
	/**
	 * Return identification number of client in data base by login and password.
	 * If login and password exist return idClient which have type Long else return
	 * null.
	 * 
	 * @type String
	 * @param clientLogin
	 * @param clientPassword
	 * @throws NullPointerException
	 * @throw DataAccessException
	 * 
	 * @return Long
	 */
	public Long getIdClientByLoginPassword(String clientLogin, String clientPassword);
	
	/**
	 * Return Client by email if client exist in data base with specify
	 * email else null. Parameter clientEmail is attribute of the Client.
	 * Email must be unique else method generate exeption NonUniqueResultException.
	 * 
	 * @param clientEmail
	 * @type Long
	 * 
	 * @throws HibernateObjectRetrievalFailureException
	 * @throws NonUniqueResultException
	 * @throws NullPointerException
	 * 
	 * @return Client or null.
	 */
	public Client getClientByEmail(String clientEmail);
	
	/**
	 * Return result of user sign in(true/false).If client login and password
	 * exist in data base return true else false.Login and password must be
	 * unique else method generate exeption NonUniqueResultException.
	 * 
	 * @type String
	 * @type Boolean
	 * @param clientLogin
	 * @param clientPassword
	 * @throw HibernateObjectRetrievalFailureException
	 * 
	 * @return Boolean
	 */
	public Boolean signInClientByLoginPassword(String clientLogin, String clientPassword);
	
	/**
	 * Return amount of clients in data base. If data base contain any clients
	 * return amount client else return zero.
	 * 
	 * @throws HibernateObjectRetrievalFailureException 
	 * @throws NullPointerException
	 * 
	 * @return int
	 */
	public int getCountClient();
	
	/**
	 * Return list of order which have client in all depatrments and all
	 * service stations.List contain serving on 20 rows and start on 1 row.
	 * If list order is empty return null.
	 * 
	 * @type List
	 * @type Long
	 * @param idClient
	 * @throws NullPointerException
	 * @throws HibernateObjectRetrievalFailureException
	 * 
	 * @return List<DepartmentOrder> or null;
	 */
	public List<DepartmentOrder> getListOrderAllServiceStationForClient(Long idClient);
	
	/**
	 * Return list of order with status notcompleted and overdue which have
	 * client in all service stations. List contain serving on 20 rows and
	 * start on 1 row. If list order is empty return null.
	 * 
	 * @type List
	 * @type Long
	 * @param idClient
	 * @throws NullPointerException
	 * @throws HibernateObjectRetrievalFailureException
	 * 
	 * @return List<DepartmentOrder> or null;
	 */
	public List<DepartmentOrder> getListNotcompletedOverdueOrderForClient(Long idClient);
	
	
	/**
	 * Return list of order with status done which have client in all service
	 * stations. List contain serving on 20 rows and start on 1 row. If list
	 * order is empty return null.
	 * 
	 * @type List
	 * @type Long
	 * @param idClient
	 * @throws NullPointerException
	 * @throws HibernateObjectRetrievalFailureException
	 * 
	 * @return List<DepartmentOrder> or null;
	 */
	public List<DepartmentOrder> getListDoneOrderForClient(Long idClient);

}
