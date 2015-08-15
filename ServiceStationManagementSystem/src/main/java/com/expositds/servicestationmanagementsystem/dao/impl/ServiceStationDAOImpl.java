/**
 * @package com.expositds.servicestationmanagementsystem.dao.impl
 * 
 * Package com.expositds.servicestationmanagementsystem.dao.impl contain set of class which
 * description layer of data access object in ServiceStationManagementSystem project. This
 * project is based on MVC architecture.This class is part of dao layer in MVC architecture.
 * This layer offer abstract interface for work with any type data base. This pattern give
 * a chance work with DAO (data-access-object) without matter what kind of storage engine is
 * used and without need for a special way to match this storage engine. All classes which
 * contain word �DAO� provide to work DAL for Service Station Management System application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.
 */
package com.expositds.servicestationmanagementsystem.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.expositds.servicestationmanagementsystem.dao.ServiceStationDAO;
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.Stead;

/**
 * <p>The class ServiceStationDAOImpl use DAO pattern which describes layer of data access to
 * object. DAO layer perform link between relational and object model.Model for this dao layer
 * describied in class ServiceStation.This class contain methods which intended to access special
 * operation with service station.Class extend AbstractEntity�ommonDAOImpl class, which contain
 * base set of operation(CRUD). Class implements interface ServiceStationDAO located in package
 * which have name com.expositds.servicestationmanagementsystem.dao. All methods are public in
 * class.For logging use framework shell slf4j and framework log4j. Class contain also private,
 * static variable logger, which use to call log message. Class  use Spring framework to work
 * whith ORM. In particular often use HibernateTemplate for integration Hibernate and Spring
 * technologys.For work with data base use hibernate criteria. This technology provide as object-
 * -oriented select query in relation to a particular entity, and allows you to query the database
 * without writing SQL code. Use Criteria is the most successful approach to search interface
 * with a variable number of conditions. To create copies of the Criteria used class Session,
 * which acts as a factory.
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
 */
@Repository(value="serviceStationDAO")
public class ServiceStationDAOImpl extends AbstractEntity�ommonDAOImpl implements ServiceStationDAO {

	/**
	 * Variable logger use to get logger level for class ServiceStationDAOImpl.
	 * 
	 * @param ServiceStationDAOImpl
	 * @return logger for class ServiceStationDAOImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(ServiceStationDAOImpl.class);
	
	/**
	 * Return list of stead which use to service station departments rent. If
	 * service station(departments) use stead as rent method return list stead
	 * else return null.    
	 * 
	 * @type Long
	 * @type List
	 * @param idServiceStation)
	 * @throw DataAccessException 
	 * @throw NullPointerException
	 * 
	 * @return List<Stead> which use(include) in service station.
	 */
	@SuppressWarnings("unchecked")
	public List<Stead> getListSteadUseServiceStation(Long idServiceStation){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(Department.class);	
		criteria.createAlias("serviceStation", "s");
		criteria.add(Restrictions.eq("s.idServiceStation", idServiceStation));
		criteria.setProjection(Projections.property("stead"));
		
		List<Stead> listStead;
		try{
			listStead=(List<Stead>)criteria.list();
			logger.info("List stead which use service station "+idServiceStation+" loaded successfully");
			
			for(Stead stead : listStead){
				logger.info("DAO:List service station steads contain ="+stead);
			}
			
		}catch(NullPointerException e){
			listStead= null;
			logger.info("List stead which use service station "+idServiceStation+" loaded successfully but is empty.");
		}
		return listStead;
	}
	
	/**
	 * Return total(sum) area which use service station(departments which 
	 * include in service station). Method return same value if service station
	 * use same stead else return null.
	 * 
	 * @type Long
	 * @type Double
	 * @type List
	 * @param idServiceStation)
	 * @throw DataAccessException 
	 * @throw NullPointerException
	 * 
	 * @return List<Stead> which use(include) in service station.
	 */
	public Double getTotalServiceStationArea(Long idServiceStation){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(Department.class);	
		criteria.createAlias("serviceStation", "ser");
		criteria.add(Restrictions.eq("ser.idServiceStation", idServiceStation));
		
		criteria.createAlias("stead", "st");
		ProjectionList proList = Projections.projectionList();
		proList.add(Projections.sum("st.steadArea"));
		criteria.setProjection(proList);
		
		Double totalServiceStationArea;
		try{
			totalServiceStationArea =(Double)criteria.uniqueResult();
			if(totalServiceStationArea.equals(null)){
				totalServiceStationArea= 0.0;
			}
			
		}catch(NullPointerException e){
			totalServiceStationArea= 0.0;
		}
		logger.info("Total area for service station "+idServiceStation+" is equals="+totalServiceStationArea);
		return totalServiceStationArea;
	}
}