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

import com.expositds.servicestationmanagementsystem.dao.DepartmentOrderDAO;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Detail;
/**
 * <p>The class DepartmentOrderDAOImpl use DAO pattern which describes layer of data access
 * to object.DAO layer perform link between relational and object model.Model for this dao layer
 * describied in class DepartmentOrder.This class contain methods which intended to access
 * special operation with department order.Class extend AbstractEntity—ommonDAOImpl class,
 * which contain base set of operation(CRUD). Class implements interface DepartmentOrderDAO
 * located in package which have name com.expositds.servicestationmanagementsystem.dao. All
 * methods are public in class.For logging use framework shell slf4j and framework log4j.
 * Class contain also private, static variable logger, which use to call log message. Class
 * use Spring framework  to work whith ORM. In particular often use HibernateTemplate for
 * integration Hibernate and Spring technologys. For work with data base use hibernate criteria.
 * This technology provide as object-oriented select query in relation to a particular entity,
 * and allows you to query the database without writing SQL code. Use Criteria is the most
 * successful approach to search interface with a variable number of conditions. To create
 * copies of the Criteria used class Session, which acts as a factory.
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
@Repository(value="departmentOrderDAO")
public class DepartmentOrderDAOImpl extends AbstractEntity—ommonDAOImpl implements DepartmentOrderDAO{

	/**
	 * Variable logger use to get logger level for class DepartmentOrderDAOImpl.
	 * 
	 * @param DepartmentOrderDAOImpl
	 * @return logger for class DepartmentOrderDAOImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(DepartmentOrderDAOImpl.class);
	
	/**
	 * Return list of order which employee made in all departments. If employee
	 * hava orders method return listAllEmployeOrder else method return null. 
	 * Parametr idEmployee is attrebute of Employee. List  contain serving on 20
	 * rows and start on 1 row. 
	 * 
	 * @type Long
	 * @param idEmployee
	 * @throws NullPointerException
	 * 	 
	 * @return List<DepartmentOrder> for employee
	 */
	@SuppressWarnings("unchecked")
	public List<DepartmentOrder> getListDepartmentOrderForEmployee(Long idEmployee){
		
		List<DepartmentOrder> listAllEmployeOrder;
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(DepartmentOrder.class);
		criteria.createAlias("employee", "e");
		criteria.add(Restrictions.eq("e.idEmployee", idEmployee));
		criteria.setFirstResult(0);
		criteria.setMaxResults(20);
		
		try{
			logger.info("DAO:DepartmentOrder list for employee loaded successfully.");
			listAllEmployeOrder=(List<DepartmentOrder>)criteria.list();
			
			for(DepartmentOrder order : listAllEmployeOrder){
				logger.info("DAO:DepartmentOrder list for employee contain ="+order);
			}

		}catch(NullPointerException e){
			listAllEmployeOrder=null;
			logger.info("DAO:DepartmentOrder list for employee not loaded, because is empty.");
		}
		return listAllEmployeOrder;
	}

	/**
	 * Return list of order which employee made in all departments with status not
	 * completed or overdue.If employee hava orders method return listAllEmployeOrder
	 * else method return null. Parametr idEmployee is attrebute of Employee.List 
	 * contain serving on 20 rows and start on 1 row. 
	 * 
	 * @type Long
	 * @param idEmployee
	 * @throws NullPointerException
	 * 	 
	 * @return List<DepartmentOrder> for employee.
	 */
	@SuppressWarnings("unchecked")
	public List<DepartmentOrder> getListNotcompletedOverdueDepartmentOrderForEmployee(Long idEmployee){
		
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(DepartmentOrder.class);
		criteria.createAlias("employee", "e");
		criteria.add(Restrictions.and(
						Restrictions.eq("e.idEmployee", idEmployee),
						Restrictions.or(
								Restrictions.eq("orderStatus", "notcompleted"),
								Restrictions.eq("orderStatus", "overdue"))
					)
		);
		criteria.setFirstResult(0);
		criteria.setMaxResults(20);
				
		List<DepartmentOrder> employeNotcompletedOverdueOrderList;
		try{
			employeNotcompletedOverdueOrderList=(List<DepartmentOrder>)criteria.list();
			logger.info("DAO:DepartmentOrder list notcompleted and overdue order for employee loaded successfully.");
			
			for(DepartmentOrder order : employeNotcompletedOverdueOrderList){
				logger.info("DAO:DAO:DepartmentOrder list notcompleted and overdue order for employee contain ="+order);
			}
			
		}catch(NullPointerException e){
			employeNotcompletedOverdueOrderList=null;
			logger.info("DAO:DepartmentOrder list notcompleted and overdue order for employee not loaded because is null.");
		}
		return employeNotcompletedOverdueOrderList;
	}
	
	/**
	 * Return list of order which employee made in all departments with status done.
	 * If employee hava orders method return listAllEmployeOrder else method return
	 * null. Parametr idEmployee is attrebute of Employee. List contain serving on 20
	 * rows and start on 1 row. 
	 * 
	 * @type Long
	 * @param idEmployee
	 * @throws NullPointerException
	 * 	 
	 * @return List<DepartmentOrder> for employee.
	 */
	@SuppressWarnings("unchecked")
	public List<DepartmentOrder> getListDoneDepartmentOrderForEmployee(Long idEmployee){
		
		List<DepartmentOrder> employeDoneDepartmentOrderList;
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(DepartmentOrder.class);
		criteria.createAlias("employee", "e");
		criteria.add(Restrictions.eq("e.idEmployee", idEmployee));
		criteria.add(Restrictions.eq("orderStatus", "done"));
		criteria.setFirstResult(0);
		criteria.setMaxResults(20);
	
		try{
			employeDoneDepartmentOrderList=(List<DepartmentOrder>)criteria.list();
			logger.info("DAO:DepartmentOrder list done order for employee loaded successfully.");
			
			for(DepartmentOrder order : employeDoneDepartmentOrderList){
				logger.info("DAO:DepartmentOrder list done order for employee contain ="+order);
			}

		}catch(NullPointerException e){
			employeDoneDepartmentOrderList=null;
			logger.info("DAO:DepartmentOrder list done order for employee not loaded because is null.");
		}
		return employeDoneDepartmentOrderList;
	}
	
	/**
	 * Return full cost details which use in department orders. If order have
	 * details method return same sum else method return zero. Parametr 
	 * idDepartmentOrder is attrebute of DepartmentOrder.
	 * 
	 * @type Long
	 * @param idDepartmentOrder
	 * @throws NullPointerException
	 * 	 
	 * @return Full detail cost
	 */
	public Double getFullDetailCostForDepartmentOrder(Long idDepartmentOrder){
		
		//cost detail for order
		Criteria criteriaForOrderDetail = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(Detail.class);
		criteriaForOrderDetail.createAlias("departmentOrder", "d");
		criteriaForOrderDetail.add(Restrictions.eq("d.idDepartmentOrder", idDepartmentOrder));
		
		ProjectionList proList = Projections.projectionList();
		proList.add(Projections.sum("detailCost"));
		criteriaForOrderDetail.setProjection(proList);
		
		Double totalDetailsCost;
		try {
			totalDetailsCost = (Double)criteriaForOrderDetail.uniqueResult();
			if(totalDetailsCost.equals(null)){
				totalDetailsCost=0.0;
			}
		} catch (NullPointerException e) {
			totalDetailsCost=0.0;
		}
		logger.info("DAO:Full detail cost for department order id="+idDepartmentOrder+" equals="+totalDetailsCost);
		return totalDetailsCost;
	}
	
	/**
	 * Return order cost(work cost and sum of detail cost). If order have
	 * order method return same value else method return zero. Parametr 
	 * idDepartmentOrder is attrebute of DepartmentOrder.
	 * 
	 * @type Long
	 * @param idDepartmentOrder
	 * @throws NullPointerException
	 * 	 
	 * @return order cost.
	 */
	public Double getOrderCostForDepartmentOrder(Long idDepartmentOrder){
		
		//cost order work
		Criteria criteriaForOrder = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(DepartmentOrder.class);
		criteriaForOrder.setProjection(Projections.property("orderCost"));
		criteriaForOrder.add(Restrictions.eq("idDepartmentOrder", idDepartmentOrder));
		
		Double orderCost;
		try{
			orderCost =(Double)criteriaForOrder.uniqueResult();
			if(orderCost.equals(null)){
				orderCost=0.0;
			}

		}catch(NullPointerException e){
			orderCost=0.0;
		}
		logger.info("DAO:Order cost for department order id="+idDepartmentOrder+" equals="+orderCost);
		return orderCost;
	}
}
