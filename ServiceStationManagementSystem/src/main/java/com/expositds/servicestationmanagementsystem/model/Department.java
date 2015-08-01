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

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Department entity contain base characteristics and behavior of department. Department have same
 * client orders, and use same stead (which have square, cost for day rent). Department is part of
 * service station and performs the same work as other in service station. Department have set of
 * order which perform employee. Department have relations one-to-many with his orders, many-to-one
 * with stead, many-to-one with service station. Employees work under the control of the department.
 * Employee may work in couple of departments and even in other service station at the same time.
 * 
 * The class is located in the com.expositds.servicestationmanagementsystem.model and describes part
 * of model in MVC architecture. This class includes a description Department entity. For creating
 * Department model use Hibernate technology (anatations). Class contains exclusively no-static public
 * methods that return fields of entity. Methods intended to access object fields.Class also contain
 * overload methods toString(), hashCode(), equals().
 *
 * @see Hibernate annotations
 * 
 * @version 1.0 31.07.2015
 * @author Denis Zaerko
 */
@Entity(name="Department")
@Table(name="department")
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_department")
	private Long idDepartment;

	@Column(name="department_name")
	private String departmentName;
	
	@ManyToOne
	@JoinColumn(name="stead_id")
	private Stead stead;
	
	@ManyToOne
	@JoinColumn(name="service_station_id")
	private ServiceStation serviceStation;
	
	@OneToMany(targetEntity=DepartmentOrder.class , mappedBy="department", fetch = FetchType.LAZY)
	private List<DepartmentOrder> departmentOrder;
	
	/**
	 * Overloaded constructor of Department class.
	 * 
	 * @type Long
	 * @type String
	 * @type List
	 * @type ServiceStation
	 * @type DepartmentOrder
	 * 
	 * @param idDepartment
	 * @param departmentName
	 * @param stead
	 * @param serviceStation
	 * @param departmentOrder
	 */
	public Department(Long idDepartment, String departmentName, Stead stead,
			ServiceStation serviceStation, List<DepartmentOrder> departmentOrder){
		this.idDepartment=idDepartment;
		this.departmentName=departmentName;
		this.stead=stead;
		this.serviceStation=serviceStation;
		this.departmentOrder=departmentOrder;
	}
	
	/**
	 * Empty constructor(default) of Department class.
	 */
	public Department(){
	}

	/**
	 * @type Long
	 * @return idDepartment attribute of the Department
	 */
	public Long getIdDepartment() {
		return idDepartment;
	}

	/**
	 * Method change idDepartment attribute of the Department
	 * 
	 * @type Long
	 * @param idDepartment
	 */
	public void setIdDepartment(Long idDepartment) {
		this.idDepartment = idDepartment;
	}

	/**
	 * @type String
	 * @return departmentName attribute of the Department
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * Method change departmentName attribute of the Employee
	 * 
	 * @type String
	 * @param departmentName
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @type Stead
	 * @return stead entity
	 */
	public Stead getStead() {
		return stead;
	}

	/**
	 * Method change stead
	 * 
	 * @type Stead
	 * @param stead
	 */
	public void setStead(Stead stead) {
		this.stead = stead;
	}

	/**
	 * @type ServiceStation
	 * @return serviceStation entity
	 */
	public ServiceStation getServiceStation() {
		return serviceStation;
	}

	/**
	 * Method change ServiceStation entity
	 * 
	 * @type ServiceStation
	 * @param serviceStation
	 */
	public void setServiceStation(ServiceStation serviceStation) {
		this.serviceStation = serviceStation;
	}

	/**
	 * @type DepartmentOrder
	 * @return departmentOrder entity
	 */
	public List<DepartmentOrder> getDepartmentOrder() {
		return departmentOrder;
	}

	/**
	 * Method change DepartmentOrder entity
	 * 
	 * @type List<DepartmentOrder>
	 * @param departmentOrder
	 */
	public void setDepartmentOrder(List<DepartmentOrder> departmentOrder) {
		this.departmentOrder = departmentOrder;
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
	 * @return Department as string.
	 */
	@Override
	public String toString() {
		if(!this.idDepartment.equals(null)){
			return this.idDepartment.toString()+" "+this.departmentName.toString();
		}
		return super.toString();
	}
}
