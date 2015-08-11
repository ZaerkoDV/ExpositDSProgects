/**
 * @package com.expositds.servicestationmanagementsystem.dao.impl
 * 
 * Package com.expositds.servicestationmanagementsystem.dao.impl contain set of class which
 * description layer of data access object in ServiceStationManagementSystem project. This
 * project is based on MVC architecture.This class is part of dao layer in MVC architecture.
 * This layer offer abstract interface for work with any type data base. This pattern give
 * a chance work with DAO (data-access-object) without matter what kind of storage engine is
 * used and without need for a special way to match this storage engine. All classes which
 * contain word “DAO” provide to work DAL for Service Station Management System application.
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
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.expositds.servicestationmanagementsystem.dao.DepartmentDAO;
import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Detail;
import com.expositds.servicestationmanagementsystem.model.Employee;
/**
 *<p>The class DepartmentDAOImpl use DAO pattern which describes layer of data access to object.
 * DAO layer perform link between relational and object model.Model for this dao layer describied
 * in class Department. This class contain methods which intended to access to operation with
 * objects. Class implements interface DepartmentDAO located in package which have name
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
@Repository(value = "departmentDAO")
public class DepartmentDAOImpl extends HibernateDaoSupport implements DepartmentDAO{

	/**
	 * Variable logger use to get logger level for class DepartmentDAOImpl.
	 * 
	 * @param DepartmentDAOImpl
	 * @return logger for class DepartmentDAOImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(DepartmentDAOImpl.class);

	/**
	 * Method return list of order in department by department id. Parametr
	 * (department id) must be not null and exist in data base. 
	 * 
	 * @type Long
	 * @param idDepartment
	 * @throw NullPointerException
	 * 
	 * @return List<DepartmentOrder> in department.
	 */
	@SuppressWarnings("unchecked")
	public List<DepartmentOrder> getListDepartmentOrderByIdDepartment(Long idDepartment){
		
		List<DepartmentOrder>listDepartmentOrder;
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(DepartmentOrder.class);	
		criteria.createAlias("department", "d");
		criteria.add(Restrictions.eq("d.idDepartment", idDepartment));
		
		try{
			listDepartmentOrder=(List<DepartmentOrder>)criteria.list();

		}catch(NullPointerException e){
			listDepartmentOrder = null;
		}
		return listDepartmentOrder;
	}

	/**
	 * Method return list of client in department by id department.Parametr
	 * (department id) must be not null and exist in data base. 
	 * 
	 * @type Long
	 * @param idDepartment
	 * @throw NullPointerException
	 * 
	 * @return List<Client> in department.
	 */
	@SuppressWarnings("unchecked")
	public List<Client> getListClientByIdDepartment(Long idDepartment){
		
		List<Client> listDepartmentClient;
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(DepartmentOrder.class);	
		criteria.createAlias("department", "dep");
		criteria.add(Restrictions.eq("dep.idDepartment", idDepartment));
		criteria.setProjection(Projections.property("client"));
		
		try{
			listDepartmentClient=(List<Client>)criteria.list();

		}catch(NullPointerException e){
			listDepartmentClient = null;
		}
		return listDepartmentClient;
	}
	
	/**
	 * Method return list of employee in department by id department.Parametr
	 * (department id) must be not null and exist in data base. 
	 * 
	 * @type Long
	 * @param idDepartment
	 * @throw NullPointerException
	 * 
	 * @return List<Employee> in department.
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getListEmployeByIdDepartment(Long idDepartment){

		List<Employee> listDepartmentEmployee;
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(DepartmentOrder.class);	
		criteria.createAlias("department", "dep");
		criteria.add(Restrictions.eq("dep.idDepartment", idDepartment));
		criteria.setProjection(Projections.property("employee"));

		try{
			listDepartmentEmployee=(List<Employee>)criteria.list();
			
		}catch(NullPointerException e){
			listDepartmentEmployee = null;
		}
		return listDepartmentEmployee;
	}
	
	/**
	 * Method return total cost detail which use in department orders and 
	 * have status notcompleted or overdue.  
	 * 
	 * @type Long
	 * @param idDepartment
	 * @throw NullPointerException
	 * 
	 * @return Total sum(double type) detail cost in department. 
	 */
	public Double getTotalDetailCostForNotcompletedOverdueDepartmentOrder(Long idDepartment){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(Detail.class);	
		criteria.createAlias("departmentOrder", "ord");
		criteria.add(Restrictions.and(
				Restrictions.eq("ord.department.idDepartment", idDepartment),
						Restrictions.or(
								Restrictions.eq("ord.orderStatus", "notcompleted"),
								Restrictions.eq("ord.orderStatus", "overdue"))
					)
				);
		ProjectionList proList = Projections.projectionList();
		proList.add(Projections.sum("detailCost"));
		criteria.setProjection(proList);

		Double totalDetailCostForDepartment;
		try{
			totalDetailCostForDepartment = (Double)criteria.uniqueResult();
			if(totalDetailCostForDepartment.equals(null)){
				totalDetailCostForDepartment =0.0;
			}
			
		}catch(NullPointerException e){
			totalDetailCostForDepartment=0.0;	
		}
		return totalDetailCostForDepartment;
	}

	
	/**
	 * Method return full income(work cost and detail cost) which have department.  
	 * 
	 * @type Long
	 * @param idDepartment
	 * @throw NullPointerException
	 * 
	 * @return Total sum(double type) detail cost in department. 
	 */
	public Double getFullIncomeForNotcompletedOverdueDepartmentOrder(Long idDepartment){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(DepartmentOrder.class);	
		criteria.createAlias("department", "dep");
		criteria.add(Restrictions.and(
						Restrictions.eq("dep.idDepartment", idDepartment),
						Restrictions.or(
								Restrictions.eq("orderStatus", "notcompleted"),
								Restrictions.eq("orderStatus", "overdue"))
						)
				);
		ProjectionList proList = Projections.projectionList();
		proList.add(Projections.sum("orderCost"));
		criteria.setProjection(proList);

		Double income;
		try{
			income = (Double)criteria.uniqueResult();
			if(income.equals(null)){
				income =0.0;	
			}
		}catch(NullPointerException e){
			income=0.0;	
		}
		return income;
	}
}
