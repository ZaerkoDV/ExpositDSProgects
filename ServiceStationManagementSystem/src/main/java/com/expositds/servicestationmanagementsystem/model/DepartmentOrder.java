/**
 * @package com.expositds.servicestationmanagementsystem.model
 * 
 * Package com.expositds.servicestationmanagementsystem.model contain set of class
 * which description basic essence in ServiceStationManagementSystem progect.The 
 * project is based on MVC architecture.This class is part of model in MVC architecture.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.
 */
package com.expositds.servicestationmanagementsystem.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * Department order entity describe base characteristics and behavior of order in department.
 * Department get order from clients. Client described in special document (order description)
 * same requirements to work. Employee (mechanic) designate start and end data of work also invoice
 * (order cost).If mechanic need to replacement details he invoice (and correct) and write report
 * about this (order description).If work not finished (status order) after end data, client may
 * cancel order and conclude in other service station (department) or do nothing. Client may have
 * many orders in department. Every client order may have many details which need to repair or
 * replacement. Each order execute only one employee.Department order have relations one-to-many
 *  with entity details, many-to-one with client, many-to-one with employee, many-to-one department.
 *  
 * The class is located in the com.expositds.servicestationmanagementsystem.model and describes part
 * of model in MVC architecture. This class includes a description DepartmentOrder entity.For creating
 * DepartmentOrder model use Hibernate technology (anatations). Class contains exclusively no-static
 * public methods that return fields of entity. Methods intended to access object fields.Class also
 * contain overload methods toString(), hashCode(), equals().
 * 
 * @see Hibernate annotations
 * 
 * @version 1.0 31.07.2015
 * @author Denis Zaerko
 */
@Entity(name="DepartmentOrder")
@Table(name="department_order")
public class DepartmentOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_department_order")
	private Long idDepartmentOrder;

	@Column(name="order_description")
	private String orderDescription;

	@Column(name="order_cost")
	private Double orderCost;
	
	@Column(name="work_cost")
	private Double workCost;

	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="start_order")
	private Date startOrder = new Date();

	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="end_order")
	private Date endOrder;

	@NotEmpty
	@Column(name="order_status", nullable = false, columnDefinition="varchar(45) default 'notcompleted'")
	private String orderStatus;

	@ManyToOne//(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="client_id")
	private Client client;

	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;

	/**
	 * Overloaded constructor of DepartmentOrder class.
	 * 
	 * @type Long
	 * @type String
	 * @type Double
	 * @type Date
	 * @type Client
	 * @type Employee
	 * @type Department
	 * 
	 * @param idDepartmentOrder
	 * @param orderDescription
	 * @param orderCost
	 * @param workCost
	 * @param startOrder
	 * @param endOrder
	 * @param orderStatus
	 * @param client
	 * @param employee
	 * @param department
	 */
	public DepartmentOrder(Long idDepartmentOrder, String orderDescription, Double orderCost, Double workCost,Date startOrder,
			Date endOrder,String orderStatus, Client client, Employee employee, Department department){

		this.idDepartmentOrder=idDepartmentOrder;
		this.orderDescription=orderDescription;
		this.orderCost=orderCost;
		this.workCost=workCost;
		this.startOrder=startOrder;
		this.endOrder=endOrder;
		this.orderStatus=orderStatus;
		this.client=client;
		this.employee=employee;
		this.department=department;
	}

	/**
	 * Empty constructor(default) of DepartmentOrder class.
	 */
	public DepartmentOrder(){
	}

	/**
	 * @type Long
	 * @return idDepartmentOrder attribute of the DepartmentOrder
	 */
	public Long getIdDepartmentOrder() {
		return idDepartmentOrder;
	}

	/**
	 * Method change idDepartmentOrder attribute of the DepartmentOrder
	 * 
	 * @type Long
	 * @param idDepartmentOrder
	 */
	public void setIdDepartmentOrder(Long idDepartmentOrder) {
		this.idDepartmentOrder = idDepartmentOrder;
	}

	/**
	 * @type String
	 * @return orderDescription attribute of the DepartmentOrder
	 */
	public String getOrderDescription() {
		return orderDescription;
	}

	/**
	 * Method change orderDescription attribute of the DepartmentOrder
	 * 
	 * @type String
	 * @param orderDescription
	 */
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	/**
	 * @type Double
	 * @return orderCost attribute of the DepartmentOrder
	 */
	public Double getOrderCost() {
		return orderCost;
	}

	/**
	 * Method change orderCost attribute of the DepartmentOrder
	 * 
	 * @type Double
	 * @param orderCost
	 */
	public void setOrderCost(Double orderCost) {
		this.orderCost = orderCost;
	}

	/**
	 * @type Double
	 * @return workCost attribute of the DepartmentOrder
	 */
	public Double getWorkCost() {
		return workCost;
	}

	/**
	 * Method change workCost attribute of the DepartmentOrder
	 * 
	 * @type Double
	 * @param workCost
	 */
	public void setWorkCost(Double workCost) {
		this.workCost = workCost;
	}
	
	/**
	 * @type Date
	 * @return startOrder attribute of the DepartmentOrder
	 */
	public Date getStartOrder() {
		return startOrder;
	}

	/**
	 * Method change orderCost attribute of the DepartmentOrder
	 * 
	 * @type String
	 * @param orderCost
	 */
	public void setStartOrder(Date startOrder) {
		this.startOrder = startOrder;
	}

	/**
	 * @type String
	 * @return startOrder attribute of the DepartmentOrder
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * Method change orderStatus attribute of the DepartmentOrder
	 * 
	 * @type String
	 * @param orderStatus
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @type Data
	 * @return endOrder attribute of the DepartmentOrder
	 */
	public Date getEndOrder() {
		return endOrder;
	}

	/**
	 * Method change endOrder attribute of the DepartmentOrder
	 * 
	 * @type Data
	 * @param endOrder
	 */
	public void setEndOrder(Date endOrder) {
		this.endOrder = endOrder;
	}

	/**
	 * @type Client
	 * @return client entity.
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Method change client entity
	 * 
	 * @type Client
	 * @param client entity.
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @type Employee
	 * @return Employee entity.
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * Method change employee entity
	 * 
	 * @type Employee
	 * @param employee entity.
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @type Department
	 * @return Department entity.
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * Method change department entity
	 * 
	 * @type Department
	 * @param department entity.
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	/**
	 * Overload basic method hashCode()
	 * 
	 * @type Integer
	 * @return hashCode
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return DepartmentOrder as string.
	 */
	@Override
	public String toString() {
		if(!this.idDepartmentOrder.equals(null)){
			return this.idDepartmentOrder.toString()+" "+this.orderDescription.toString()+" "+this.orderCost.toString()+" "+
		" "+this.startOrder.toString()+" "+this.endOrder.toString()+" "+this.orderStatus;
		}
		return super.toString();
	}
}
