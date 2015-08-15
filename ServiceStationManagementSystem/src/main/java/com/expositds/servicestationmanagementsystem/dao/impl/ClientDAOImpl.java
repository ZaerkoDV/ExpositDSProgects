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

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.NonUniqueResultException;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.expositds.servicestationmanagementsystem.dao.ClientDAO;
import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.ClientSecurityFeature;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;

/**
 * <p>The class ClientDAOImpl use DAO pattern which describes layer of data access to object.
 * DAO layer perform link between relational and object model.Model for this dao layer
 * describied in class Client. This class contain methods which intended to access to special
 * operation with client.Class extend AbstractEntity—ommonDAOImpl class, which contain base set
 * of operation(CRUD). Class implements interface ClientDAO located in package which have name
 * com.expositds.servicestationmanagementsystem.dao. All methods are public in class.For logging
 * use framework shell slf4j and framework log4j. Class contain also private, static variable
 * logger, which use to call log message. Class  use Spring framework  to work whith ORM. In
 * particular often use HibernateTemplate for integration Hibernate and Spring technologys.
 * For work with data base use hibernate criteria. This technology provide as object-oriented
 * select query in relation to a particular entity, and allows you to query the database without
 * writing SQL code. Use Criteria is the most successful approach to search interface with a 
 * variable number of conditions. To create copies of the Criteria used class Session, which
 * acts as a factory.
 *  
 * @see Collection
 * @see List
 * @see org.springframework.stereotype
 * @see org.springframework.orm
 * @see org.hibernate.Criteria
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 09.08.2015
 * @author Zaerko Denis
 */
@Repository(value = "clientDAO")
public class ClientDAOImpl extends AbstractEntity—ommonDAOImpl implements ClientDAO {

	/**
	 * Variable logger use to get logger level for class ClientDAOImpl.
	 * 
	 * @param ClientDAOImpl
	 * @return logger for class ClientDAOImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(ClientDAOImpl.class);

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
	 * @return List<Client> all client with last name as parametr else null.
	 */
	@SuppressWarnings("unchecked")
	public List<Client> getListClientByLastName(String clientLastName){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(Client.class);
		criteria.add(Restrictions.eq("clientLastName", clientLastName));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		
		List<Client> listClient;
		try {
			listClient= (List<Client>)criteria.list();
			logger.info("Client list loaded successfully");
			
			for(Client client : listClient ){
				logger.info("DAO:Client list by last name"+clientLastName+" contain ="+client);
			}
			
		} catch (NullPointerException e) {
			logger.info("Client list not loaded.");
			listClient=null;
		}
		return listClient;
	}

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
	@SuppressWarnings("finally")
	public Long getIdClientByLoginPassword(String clientLogin, String clientPassword){

		Criteria criteria =this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(ClientSecurityFeature.class);
		 criteria.setProjection(Projections.property("client"));
		 criteria.add(Restrictions.eq("clientLogin", clientLogin));
		 criteria.add(Restrictions.eq("clientPassword", clientPassword));

		 Client client;
		 Long idClient = null;
		 try {
			 client = (Client)criteria.uniqueResult();
			 idClient= client.getIdClient();	
			 logger.info("Client loaded successfully, idClient="+idClient);

		 }catch (final NullPointerException e) {
			 logger.info("Client not loaded successfully");
			 idClient = null;

		 }catch(NonUniqueResultException e){
			 logger.info("Client with login and password not unique.");
			 idClient = null;
		 }
		 finally{
			 return idClient;
		 }
	}

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
	public Client getClientByEmail(String clientEmail){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(Client.class);
		criteria.add(Restrictions.eq("clientEmail", clientEmail));
		
		Client client = null;
		try {
			client=(Client)criteria.uniqueResult();
			logger.info("Client loaded successfully, idClient="+client.getIdClient());

		}catch (NullPointerException e){
			client= null;
			logger.info("Client not loaded successfully.");

		}catch(NonUniqueResultException e){
			 logger.info("Client with email not unique.");
		}
		return client;
	}
	
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
	@SuppressWarnings("finally")
	public Boolean signInClientByLoginPassword(String clientLogin, String clientPassword){
	
		Boolean signIn = null;
		Client client=null;
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(ClientSecurityFeature.class);
		criteria.setProjection(Projections.property("client"));
		criteria.add(Restrictions.eq("clientLogin", clientLogin));
		criteria.add(Restrictions.eq("clientPassword", clientPassword));
		
		try {
			client = (Client)criteria.uniqueResult();
			logger.info("Client sign in is successfully id="+client.getIdClient());
			signIn=true;		

		}catch (NullPointerException e) {
			logger.info("Client sign is failed"+e);
			signIn=false;

		}catch(NonUniqueResultException e){
			logger.info("Client sign in is failed because nonunique result "+e);
			signIn=false;

		}finally{
			return signIn;
		}
	}
	
	/**
	 * Return amount of clients in data base. If data base contain any clients
	 * return amount client else return zero.
	 * 
	 * @throws HibernateObjectRetrievalFailureException 
	 * @throws NullPointerException
	 * 
	 * @return int
	 */
	public int getCountClient(){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(Client.class);	
		int clientListSize;	
		try{
			clientListSize=(int)criteria.list().size();
			logger.info("Client count is equals="+clientListSize);
			
		}catch(NullPointerException e){
			clientListSize= 0;
			logger.info("Client count is equals="+clientListSize);
		}
		return clientListSize;
	}
	
	
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
	@SuppressWarnings("unchecked")
	public List<DepartmentOrder> getListOrderAllServiceStationForClient(Long idClient){
		
		List<DepartmentOrder> clientOrderList;
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(DepartmentOrder.class);	
		criteria.createAlias("client", "c");
		criteria.add(Restrictions.eq("c.idClient", idClient));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		
		try{
			clientOrderList=(List<DepartmentOrder>)criteria.list();
			logger.info("List order for client loaded successfully");
			
			for(DepartmentOrder order : clientOrderList){
				logger.info("DAO:Client order list contain ="+order);
			}
			
		}catch(NullPointerException e){
			clientOrderList=null;
			logger.info("List order for client is empty");
		}
		return clientOrderList;
	}
	
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
	@SuppressWarnings("unchecked")
	public List<DepartmentOrder> getListNotcompletedOverdueOrderForClient(Long idClient){
		
		List<DepartmentOrder> clientNotcompletedOverdueOrderList;
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(DepartmentOrder.class);	
		criteria.createAlias("client", "c");
		criteria.add(Restrictions.and(
						Restrictions.eq("c.idClient", idClient),
						Restrictions.or(
								Restrictions.eq("orderStatus", "notcompleted"),
								Restrictions.eq("orderStatus", "overdue"))
					)
		);
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		
		try{
			clientNotcompletedOverdueOrderList=(List<DepartmentOrder>)criteria.list();
			logger.info("List not completed and overdue order loaded successfully");
			
			for(DepartmentOrder order : clientNotcompletedOverdueOrderList){
				logger.info("DAO:Client not completed and overdue order list contain ="+order.toString());
			}

		}catch(NullPointerException e){
			clientNotcompletedOverdueOrderList=null;
			logger.info("List not completed and overdue order loaded successfully but empty");
		}
		return clientNotcompletedOverdueOrderList;
	}
	
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
	@SuppressWarnings("unchecked")
	public List<DepartmentOrder> getListDoneOrderForClient(Long idClient){
		
		List<DepartmentOrder> clientDoneOrderList;
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(DepartmentOrder.class);	
		criteria.createAlias("client", "c");
		criteria.add(Restrictions.eq("c.idClient", idClient));
		criteria.add(Restrictions.eq("orderStatus", "done"));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		
		try{
			clientDoneOrderList=(List<DepartmentOrder>)criteria.list();
			
			logger.info("List done order loaded successfully");
			
			for(DepartmentOrder order : clientDoneOrderList){
				logger.info("DAO:Client done order list contain ="+order.toString());
			}

		}catch(NullPointerException e){
			clientDoneOrderList=null;
			logger.info("List done order loaded successfully");
		}
		return clientDoneOrderList;
	}
}
