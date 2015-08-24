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

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.HibernateObjectRetrievalFailureException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.servicestationmanagementsystem.dao.ServiceStationCommentMarkDAO;
import com.expositds.servicestationmanagementsystem.model.ServiceStationCommentMark;
/**
 * <p>The class ServiceStationCommentMarkDAOImpl use DAO pattern which describes layer of data
 * access to object. DAO layer perform link between relational and object model. Model for this
 * dao layer describied in class ServiceStationCommentMark. This class contain methods which
 * intended to access special operation with service station comment and mark.Class extend
 * AbstractEntity—ommonDAOImpl class, which contain base set of operation(CRUD).Class implements
 * interface ServiceStationCommentMarkDAO located in package which have name com.expositds.
 * servicestationmanagementsystem.dao. All methods are public in class.For logging use framework
 * shell slf4j and framework log4j. Class contain also private, static variable logger, which use
 * to call log message. Class use Spring framework to work whith ORM. In particular often use
 * HibernateTemplate for integration Hibernate and Spring technologys. For work with data base use
 * hibernate criteria.This technology provide as object-oriented select query in relation to a
 * particular entity, and allows you to query the database without writing SQL code. Use Criteria
 * is the most successful approach to search interface with a  variable number of conditions. To
 * create copies of the Criteria used class Session, which acts as a factory.
 *  
 * @see Collection
 * @see List
 * @see org.springframework.stereotype
 * @see org.springframework.orm
 * @see org.hibernate.Criteria
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 10.08.2015
 * @author Zaerko Denis
 *
 */
@Repository(value="serviceStationCommentMarkDAO")
public class ServiceStationCommentMarkDAOImpl extends AbstractEntity—ommonDAOImpl implements ServiceStationCommentMarkDAO {

	/**
	 * Variable logger use to get logger level for class ServiceStationCommentMarkDAOImpl.
	 * 
	 * @param ServiceStationCommentMarkDAOImpl
	 * @return logger for class ServiceStationCommentMarkDAOImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(ServiceStationCommentMarkDAOImpl.class);

	/**
	 * Return list of service station mark and comment with status as paremetr
	 * Parametr viewStatus may have next value:all, mechnic, director. List 
	 * contain serving on 20 rows and start on 1 row.If list comments and mark
	 * is empty return null.
	 * 
	 * @type List
	 * @type Long
	 * @type String
	 * @param idServiceStation
	 * @param viewStatus
	 * @throws NullPointerException
	 * @throws HibernateObjectRetrievalFailureException
	 * 
	 * @return List<ServiceStationCommentMark> or null;
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public List<ServiceStationCommentMark> getListCommentMarkStatusAsParamByIdServiceStation(Long idServiceStation,String viewStatus){

		List<ServiceStationCommentMark> listServiceStationCommentMark;
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(ServiceStationCommentMark.class);	
		criteria.createAlias("serviceStation", "s");
		criteria.add(Restrictions.eq("s.idServiceStation", idServiceStation));
		criteria.add(Restrictions.eq("viewStatus", viewStatus));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		
		try{
			listServiceStationCommentMark=(List<ServiceStationCommentMark>)criteria.list();
			logger.info("DAO:List comment mark with view status "+viewStatus+"for department id"+idServiceStation);
			
		}catch(NullPointerException e){
			listServiceStationCommentMark=null;
			logger.info("DAO:List comment mark with view status "+viewStatus+"for department id="+idServiceStation+" is empty.");
		}
		return listServiceStationCommentMark;
	}

	/**
	 * Return list of service station mark and comment in all service stations
	 * which hava any view status and write one client. List  contain serving on
	 * 20 rows and start on 1 row. If list comments and mark is empty return null.
	 * 
	 * @type List
	 * @type Long
	 * @type String
	 * @param idServiceStation
	 * @param viewStatus
	 * @throws NullPointerException
	 * @throws HibernateObjectRetrievalFailureException
	 * 
	 * @return List<ServiceStationCommentMark> or null;
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public List<ServiceStationCommentMark> getListCommentMarkByIdClient(Long idClient){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(ServiceStationCommentMark.class);
		criteria.createAlias("client", "c");
		criteria.add(Restrictions.eq("c.idClient", idClient));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
	
		List<ServiceStationCommentMark> listCommentMarkByClient;
		try{
			listCommentMarkByClient=(List<ServiceStationCommentMark>)criteria.list();
			logger.info("DAO:Client id"+idClient+" comment and mark list load successfully");

		}catch(NullPointerException e){
			listCommentMarkByClient=null;
			logger.info("DAO:Client id"+idClient+" comment and mark list load successfully but list is empty.");
		}
		return listCommentMarkByClient;
	}
	
	/**
	 * Return list of service station mark and comment for service station which
	 * sorted by degerssive mark. List contain serving on 20 rows and start on 1 row.
	 * If list comments and mark is empty return null.
	 * 
	 * @type List
	 * @type Long
	 * @type String
	 * @param idServiceStation
	 * @param viewStatus
	 * @throws NullPointerException
	 * @throws HibernateObjectRetrievalFailureException
	 * 
	 * @return List<ServiceStationCommentMark> or null;
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public List<ServiceStationCommentMark> getListCommentMarkSortByDegressiveMark(Long idServiceStation){
		
		List<ServiceStationCommentMark> listServiceStationCommentMarkSortDegressiveMark;
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(ServiceStationCommentMark.class);	
		criteria.createAlias("serviceStation", "s");
		criteria.add(Restrictions.eq("s.idServiceStation", idServiceStation));
		criteria.addOrder(Order.desc("mark"));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		
		try{
			listServiceStationCommentMarkSortDegressiveMark=(List<ServiceStationCommentMark>)criteria.list();
			logger.info("DAO:List comment and mark which sort by degessive mark load successfully");

		}catch(NullPointerException e){
			listServiceStationCommentMarkSortDegressiveMark=null;
			logger.info("DAO:List comment and mark which sort by degessive mark load successfully, but is empty.");
		}
		return listServiceStationCommentMarkSortDegressiveMark;
	}		
}
