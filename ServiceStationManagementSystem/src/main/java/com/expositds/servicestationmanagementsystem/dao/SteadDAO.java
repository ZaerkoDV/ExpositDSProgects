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

import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.Stead;

/**
 * <p>The interface SteadDAO contain methods ads which realize in class SteadDAOImpl. Class
 * SteadDAOImpl use DAO pattern which describes layer of data access to object. DAO layer 
 * perform link between relational and object model.Model for this dao layer describied in
 * class Stead.This interface contain ads methods which intended to access operation with
 * object.Interface produce special operation with object.Base operation(for any object)
 * include as separate interface AbstractEntityCommonDAO which extend to this interface.
 * Class use Spring framework to work whith ORM. In particular often use HibernateTemplate
 * for integration Hibernate and Spring technologys.For work with data base use hibernate
 * criteria. 
 * 
 * @version 1.0 11.08.2015
 * @author Zaerko Denis
 */
public interface SteadDAO extends AbstractEntityCommonDAO {

	/**
	 * <p>The interface SteadDAO contain methods ads which realize in class SteadDAOImpl. Class
	 * SteadDAOImpl use DAO pattern which describes layer of data access to object. DAO layer 
	 * perform link between relational and object model.Model for this dao layer describied in
	 * class Stead.This interface contain ads methods which intended to access to operation with
	 * objects.
	 * Class  use Spring framework to work whith ORM. In particular often use HibernateTemplate
	 * for integration Hibernate and Spring technologys.For work with data base use hibernate
	 * criteria. 
	 * 
	 * @version 1.0 11.08.2015
	 * @author Zaerko Denis.
	 */
	public List<Stead> getListStead();
	
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
	public List<Department> getListDepartmentUseCurrentStead(Long idStead);
}
