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
import org.hibernate.NonUniqueResultException;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.expositds.servicestationmanagementsystem.dao.EmployeeDAO;
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.model.EmployeeSecurityFeature;
/**
 * <p>The class EmployeeDAOImpl use DAO pattern which describes layer of data access to object.
 * DAO layer perform link between relational and object model. Model for this dao layer
 * describied in class Employee. This class contain methods which intended to access special 
 * operation with employee.Class extend AbstractEntity—ommonDAOImpl class, which contain base
 * set of operation(CRUD). Class implements interface EmployeeDAO located in package which have
 * name com.expositds.servicestationmanagementsystem.dao. All methods are public in class.For
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
@Repository(value="employeeDAO")
public class EmployeeDAOImpl extends AbstractEntity—ommonDAOImpl implements EmployeeDAO {

	/**
	 * Variable logger use to get logger level for class ClientDAOImpl.
	 * 
	 * @param EmployeeDAOImpl
	 * @return logger for class EmployeeDAOImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);
	
	/**
	 * Return list of employee by last name. If data base contains employee with transmitted
	 * last name return list of employes else return null. List contain serving on 20 rows
	 * and start on 1 row. 
	 * 
	 * @type String
	 * @param employeLastName
	 * @throw DataAccessException 
	 * @throw NullPointerException
	 * 
	 * @return List<Employee> all employee with last name as parametr.
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getListEmployeByLastName(String employeLastName){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("employeLastName", employeLastName));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);

		List<Employee> listEmployee;
		try {
			listEmployee=(List<Employee>)criteria.list();
			logger.info("Employee list loaded successfully");
			
			for(Employee employee : listEmployee){
				logger.info("DAO:Employee list by last name"+employeLastName+" contain ="+employee);
			}
			
		} catch (NullPointerException e) {
			listEmployee=null;
			logger.info("Employee list loaded successfully but is empty.");
		}
		return listEmployee;
	}
	
	/**
	 * Return identification number of employee in data base by login and password.
	 * If login and password exist return idEmployee which have type Long else return
	 * null.
	 * 
	 * @type String
	 * @param employeLogin
	 * @param employePassword
	 * @throws NullPointerException
	 * @throw DataAccessException
	 * 
	 * @return Long
	 */
	@SuppressWarnings("finally")
	public Long getIdEmployeByLoginPassword(String employeLogin, String employePassword){

		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(EmployeeSecurityFeature.class);
		criteria.add(Restrictions.eq("employeLogin", employeLogin));
		criteria.add(Restrictions.eq("employePassword", employePassword));
		criteria.setProjection(Projections.property("employee"));

		Employee employee;
		Long idEmployee = null;
		try {
			employee = (Employee)criteria.uniqueResult();
			idEmployee= employee.getIdEmployee();
			 logger.info("Employee loaded successfully, idEmplyee="+idEmployee);

		}catch (final NullPointerException e) {
			idEmployee = null;
			logger.info("Employee not load successfully.");
			
		}catch(NonUniqueResultException e){
			logger.info("Employee with login and password not unique.");
		}
		finally{
			return idEmployee;
		}
	}
	
	/**
	 * Return result of user sign in(true/false).If employee login and password
	 * exist in data base return true else false. Login and password must be
	 * unique else method generate exeption NonUniqueResultException.
	 * 
	 * @type String
	 * @type Boolean
	 * @param employeLogin
	 * @param employePassword
	 * @throw HibernateObjectRetrievalFailureException
	 * 
	 * @return Boolean
	 */
	@SuppressWarnings("finally")
	public Boolean signInEmployeByLoginPassword(String employeLogin, String employePassword){
	
		Boolean signIn = false;
		Employee employee=null;
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(EmployeeSecurityFeature.class);
		criteria.add(Restrictions.eq("employeLogin", employeLogin));
		criteria.add(Restrictions.eq("employePassword", employePassword));
		criteria.setProjection(Projections.property("employee"));
		
		try {
			employee = (Employee)criteria.uniqueResult();
			
			if(!employee.equals(null)){
				signIn=true;
				logger.info("Employee sign in successfully, idEmplyee="+employee.getIdEmployee());
				
			}else{
				logger.info("Employee sign in is failed.");
				signIn=false;
			}
			
		}catch (NullPointerException e) {
			logger.info("Client sign in is failed"+e);
			
		}catch(NonUniqueResultException e){
			logger.info("Client sign in is failed because nonunique result "+e);
			
		}finally{
			return signIn;
		}
	}
	
	/**
	 * Return list of employee which have function as mechanic.If data base
	 * contains mechanic return list of mechanics else return null. List 
	 * contain serving on 20 rows and start on 1 row. 
	 * 
	 * @type List
	 * @throw DataAccessException 
	 * @throw NullPointerException
	 * 
	 * @return List<Employee> all employee which have function as mechanic.
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	public List<Employee> getListMechanic(){

		List<Employee> listMechanic = null ;
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("employeFunction", "mechanic"));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		
		try {
			listMechanic=(List<Employee>)criteria.list();
			logger.info("Mechanic list loaded successfully");
			
			for(Employee employee : listMechanic){
				logger.info("DAO:Mechanic list contain ="+employee);
			}
		}catch (NullPointerException e) {
			listMechanic=null;
			logger.info("Mechanic list not loaded successfully because is empty.");
			
		}finally{
			return listMechanic;
		}
	}
	
	/**
	 * Return list of departments in which employee work.If employee work
	 * in departments method return list of work places else return null.
	 * List  contain serving on 20 rows and start on 1 row. 
	 * 
	 * @type Long
	 * @type List
	 * @param idEmployee
	 * @throw DataAccessException 
	 * @throw NullPointerException
	 * 
	 * @return List<Department> all department in which employee work.
	 */
	@SuppressWarnings({ "unchecked" })
	public List<Department> getListDepartmentForEmployee(Long idEmployee){
		
		List<Department> listDepartment;
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(DepartmentOrder.class);	
		criteria.createAlias("employee", "e");
		criteria.add(Restrictions.eq("e.idEmployee",idEmployee));
		criteria.setProjection(Projections.property("department"));
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);
		
		try {
			listDepartment=(List<Department>)criteria.list();
			
			logger.info("Department list for employee with id="+idEmployee+"loaded successfully");
			
			for(Department department : listDepartment){
				logger.info("DAO:Department list for employee contain ="+department);
			}
		}catch (NullPointerException e) {
			listDepartment=null;
		}
		return listDepartment;
	}
}
