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

import org.springframework.orm.hibernate4.HibernateObjectRetrievalFailureException;

import com.expositds.servicestationmanagementsystem.model.ServiceStationCommentMark;

/**
  * <p>The interface ServiceStationCommentMarkDAO contain methods ads which realize in class 
  * ServiceStationCommentMarkDAOImpl. Class ServiceStationCommentMarkDAOImpl use DAO pattern which
  * describes layer of data access to object. DAO layer perform link between relational and object
  * model.Model for this dao layer describied in class ServiceStationCommentMark.This interface contain
  * ads methods which intended to access to operation with objects.Class  use Spring framework to
  * work whith ORM.In particular often use HibernateTemplate for integration Hibernate and Spring
  * technologys. For work with data base use hibernate criteria. 
 * 
 * @version 1.0 11.08.2015
 * @author Zaerko Denis
 */
public interface ServiceStationCommentMarkDAO {

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
	public List<ServiceStationCommentMark> getListCommentMarkStatusAsParamByIdServiceStation(Long idServiceStation,
			String viewStatus);
	
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
	public List<ServiceStationCommentMark> getListCommentMarkByIdClient(Long idClient);
	
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
	public List<ServiceStationCommentMark> getListCommentMarkSortByDegressiveMark(Long idServiceStation);
}
