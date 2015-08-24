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
import org.springframework.transaction.annotation.Transactional;

import com.expositds.servicestationmanagementsystem.dao.DetailDAO;
import com.expositds.servicestationmanagementsystem.model.Detail;
/**
 * <p>The class DetailDAOImpl use DAO pattern which describes layer of data access to object.
 * DAO layer perform link between relational and object model. Model for this dao layer
 * describied in class Detail.This class contain methods which intended to access special
 * operation with detail.Class extend AbstractEntity—ommonDAOImpl class, which contain base
 * set of operation(CRUD). Class implements interface DetailDAO located in package which have
 * name com.expositds.servicestationmanagementsystem.dao.All methods are public in class.For
 * logging use framework shell slf4j and framework log4j. Class contain also private, static
 * variable logger, which use to call log message. Class  use Spring framework  to work whith
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
 * @version 1.0 09.08.2015
 * @author Zaerko Denis
 */
@Repository(value="detailDAO")
public class DetailDAOImpl extends AbstractEntity—ommonDAOImpl implements  DetailDAO {

	/**
	 * Variable logger use to get logger level for class DetailDAOImpl.
	 * 
	 * @param DetailDAOImpl
	 * @return logger for class DetailDAOImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(DetailDAOImpl.class);

	/**
	 * Return list of all details(exist or not exist at that momant). If data base contains
	 * any datails method return list of details else return null. List contain serving on
	 * 20 rows and start on 1 row. 
	 * 
	 * @type List
	 * @throw DataAccessException 
	 * @throw NullPointerException
	 * 
	 * @return List<Detail>  
	 */
	@Transactional
	@SuppressWarnings({ "unchecked", "finally" })
	public List<Detail> getListAllDetail(){
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(Detail.class);	
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		
		List<Detail> listDetail = null;
		try{
			listDetail=(List<Detail>)criteria.list();
			logger.info("Detail list with status all loaded successfully");

		}catch(NullPointerException e){
			listDetail=null;
			logger.info("Detail list with all deatain loaded successfully, but is empty.");
			
		}finally{
			return listDetail;
		}
	}
	
	/**
	 * Return list of details which have same status. Status details for search indicated
	 * as parametr. If data base contains datail with status method return list of this 
	 * details else return null. List contain serving on 20 rows and start on 1 row. 
	 * 
	 * @type List
	 * @throw DataAccessException 
	 * @throw NullPointerException
	 * 
	 * @return List<Detail> with status.
	 */
	@Transactional
	@SuppressWarnings({ "unchecked", "finally" })
	public List<Detail> getListDetailWithStausAsParam(String detailStaus){
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(Detail.class);	
		criteria.add(Restrictions.eq("detailStatus", detailStaus));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		
		List<Detail> listDetailWithStausAsParam = null;
		try{
			if(detailStaus.equals("exist") || detailStaus.equals("notexist")){
				listDetailWithStausAsParam=(List<Detail>)criteria.list();	
				
				logger.info("Detail list with status "+detailStaus+" loaded successfully");

			}else{
				listDetailWithStausAsParam=null;
				logger.info("Detail list with status "+detailStaus+" loaded successfully,but empty.");
			}
		}catch(NullPointerException e){
			listDetailWithStausAsParam=null;
			logger.info("Detail list with status "+detailStaus+" loaded successfully,but empty.");
			
		}finally{
			return listDetailWithStausAsParam;
		}
	}
}
