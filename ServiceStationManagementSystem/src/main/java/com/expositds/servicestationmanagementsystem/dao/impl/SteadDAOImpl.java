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
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.expositds.servicestationmanagementsystem.dao.SteadDAO;
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.Stead;
/**
 * <p>The class SteadDAOImpl use DAO pattern which describes layer of data access to object.
 * DAO layer perform link between relational and object model.Model for this dao layer
 * describied in class Stead. This class contain methods which intended to access special
 * operation with stead.Class extend AbstractEntity—ommonDAOImpl class, which contain base
 * set of operation(CRUD). Class implements interface SteadDAO located in package which have
 * name com.expositds.servicestationmanagementsystem.dao. All methods are public in class.For
 * logging use framework shell slf4j and framework log4j. Class contain also private, static
 * variable logger, which use to call log message. Class  use Spring framework to work whith
 * ORM.In particular often use HibernateTemplate for integration Hibernate and Spring technologys.
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
 * @version 1.0 10.08.2015
 * @author Zaerko Denis
 */
@Repository(value="steadDAO")
public class SteadDAOImpl extends AbstractEntity—ommonDAOImpl implements SteadDAO {

	/**
	 * Variable logger use to get logger level for class SteadDAOImpl.
	 * 
	 * @param SteadDAOImpl
	 * @return logger for class SteadDAOImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(SteadDAOImpl.class);
	
	/**
	 * Return list of stead if steads exist in data base else return null.
	 * 
	 * @type List
	 * @throw DataAccessException 
	 * @throw NullPointerException
	 * 
	 * @return List<Stead> all stead if steads exist else null.
	 */
	@SuppressWarnings({"unchecked"})
	public List<Stead> getListStead(){
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(Stead.class);
		List<Stead> steadList;
		try{
			steadList=(List<Stead>)criteria.list();
			
			logger.info("DAO:List of stead loaded successfully");
			for(Stead stead : steadList){
				logger.info("DAO:List steads contain="+stead);
			}

		}catch(NullPointerException e){
			logger.info("DAO:Stead list loaded successfully but is empty.");
			steadList=null;		
		}
		return steadList;
	}
	
	/**
	 * Return list of departments which use current stead if steads exist in data base
	 * else return null.
	 * 
	 * @type List
	 * @type Long
	 * @param idStead
	 * @throw DataAccessException 
	 * @throw NullPointerException
	 * 
	 * @return List<Department> which use current stead else return null.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Department> getListDepartmentUseCurrentStead(Long idStead){

		List<Department> listDepartmetUseCurrentStead;
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(Department.class);
		criteria.createAlias("stead", "s");
		criteria.add(Restrictions.eq("s.idStead", idStead));
		
		try{
			listDepartmetUseCurrentStead=(List<Department>)criteria.list();
			
			logger.info("DAO:List of departments which use current stead="+idStead+" loaded successfully");
			for(Department department : listDepartmetUseCurrentStead){
				logger.info("DAO:List departments contain="+department);
			}

		}catch(NullPointerException e){
			listDepartmetUseCurrentStead = null;
			logger.info("DAO:List of departments which use current stead="+idStead+" loaded successfully but is empty.");
		}
		return listDepartmetUseCurrentStead;
	}
}
