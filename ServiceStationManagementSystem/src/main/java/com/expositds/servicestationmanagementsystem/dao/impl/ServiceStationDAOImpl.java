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
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.servicestationmanagementsystem.dao.ServiceStationDAO;
import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Detail;
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.Stead;

/**
 * <p>The class ServiceStationDAOImpl use DAO pattern which describes layer of data access to
 * object. DAO layer perform link between relational and object model.Model for this dao layer
 * describied in class ServiceStation.This class contain methods which intended to access special
 * operation with service station.Class extend AbstractEntity—ommonDAOImpl class, which contain
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
public class ServiceStationDAOImpl extends AbstractEntity—ommonDAOImpl implements ServiceStationDAO {

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
	@Transactional
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
			logger.info("DAO:List stead which use service station "+idServiceStation+" loaded successfully");
			
		}catch(NullPointerException e){
			listStead= null;
			logger.info("DAO:List stead which use service station "+idServiceStation+" loaded successfully but is empty.");
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
	@Transactional
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
		logger.info("DAO:Total area for service station "+idServiceStation+" is equals="+totalServiceStationArea);
		return totalServiceStationArea;
	}
	
	/**
	 * Return all service sattion which exist in data base else return null.
	 * 
	 * @type List
	 * @throw DataAccessException 
	 * @throw NullPointerException
	 * 
	 * @return List<ServiceStation> or null.
	 */
	@Transactional
	@SuppressWarnings({ "unchecked", "finally" })
	public List<ServiceStation> getAllServiceStation(){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(ServiceStation.class);
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		
		List<ServiceStation> listServiceStation = null;
		try{
			listServiceStation =(List<ServiceStation>)criteria.list();
			logger.info("ServiceStation list loaded successfully");

		}catch(NullPointerException e){
			listServiceStation=null;
			logger.info("ServiceStation list loaded successfully,but is empty.");
			
		}finally{
			return listServiceStation;
		}
	}
	
	/**
	 * Return all departments in service station by id service station
	 * which exist in data base else return null.
	 * 
	 * @type List
	 * @throw DataAccessException 
	 * @throw NullPointerException
	 * 
	 * @return List<Department> or null.
	 */
	@Transactional
	@SuppressWarnings({ "finally", "unchecked" })
	public List<Department> getListDepartmentForServiceStation(Long idServiceStation){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(Department.class);
		criteria.createAlias("serviceStation", "ser");
		criteria.add(Restrictions.eq("ser.idServiceStation", idServiceStation));

		List<Department> listDepartment;
		try{
			listDepartment =(List<Department>)criteria.list();
			logger.info("Department list for service station loaded successfully");

		}catch(NullPointerException e){
			listDepartment=null;
			logger.info("Department list for service station loaded successfully but is empty.");	
		}
		return listDepartment;
	}
	
	/**
	 * Return all employees which work in service station by id service station
	 * else return null.
	 * 
	 * @type Long
	 * @type List
	 * @param idServiceStation
	 * @throw DataAccessException 
	 * @throw NullPointerException
	 * 
	 * @return List<Employee> or null.
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Employee> getListEmployeeForServiceStation(Long idServiceStation){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(DepartmentOrder.class);		
		criteria.createAlias("department", "dep");
		criteria.createAlias("dep.serviceStation", "ser");
		criteria.add(Restrictions.eq("ser.idServiceStation", idServiceStation));

		criteria.setProjection(Projections.distinct(Projections.property("employee")));
				
		List<Employee> listEmployee;
		try{
			listEmployee=(List<Employee>)criteria.list();	
			
		}catch(NullPointerException e){
			listEmployee=null;
		}
		return listEmployee;
	}
	
	/**
	 * Return all clients which use service station by id service station
	 * else return null.
	 * 
	 * @type Long
	 * @type List
	 * @param idServiceStation
	 * @throw DataAccessException 
	 * @throw NullPointerException
	 * 
	 * @return List<Client> or null.
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Client> getListClientForServiceStation(Long idServiceStation){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(DepartmentOrder.class);
		criteria.createAlias("department", "dep");
		criteria.createAlias("dep.serviceStation", "ser");
		criteria.add(Restrictions.eq("ser.idServiceStation", idServiceStation));
		criteria.setProjection(Projections.property("client"));
		
		List<Client> listClient;
		try{
			listClient=(List<Client>)criteria.list();	
			
		}catch(NullPointerException e){
			listClient=null;
		}
		return listClient;
	}
}
