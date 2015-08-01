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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Stead entity describe base characteristics and behavior of stead. Every department
 * locate (part of service station) on the stead. Stead (area) belong same owner. Owner
 * get income from the lease and department get expenses at the same time. One stead may
 * have many departments. One unit (stead area) of rented space have cost on (area cost)
 * in day.Stead have relations one-to-many with department.
 *
 * The class is located in the com.expositds.servicestationmanagementsystem.model and describes part
 * of model in MVC architecture. This class includes a description Stead entity. For creating Stead
 * model use Hibernate technology (anatations). Class contains exclusively no-static public methods
 * that return fields of entity. Methods intended to access object fields.Class also contain overload
 * methods toString(), hashCode(), equals().
 * 
 * @see Hibernate annotations
 * 
 * @version 1.0 31.07.2015
 * @author Denis Zaerko
 */
@Entity(name="Stead")
@Table(name="stead")
public class Stead {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_stead")
	private Long idStead;
	
	@Column(name="stead_area")
	private Double steadArea;	
	
	@Column(name="stead_cost")
	private Double steadCost;	
	
	@OneToMany(targetEntity=Department.class , mappedBy="stead", fetch = FetchType.LAZY)
	private List<Department> department; 
	
	/**
	 * Overloaded constructor of Stead class.
	 * 
	 * @type Long
	 * @type Double
	 * @type List
	 * @type Department
	 * 
	 * @param idStead
	 * @param steadArea
	 * @param steadCost
	 * @param department
	 */
	public Stead(Long idStead, Double steadArea, Double steadCost, List<Department> department){
		this.idStead=idStead;
		this.steadArea=steadArea;
		this.steadCost=steadCost;
		this.department=department;
	}
	
	/**
	 * Empty constructor(default) of the Stead class.
	 */
	public Stead(){
	}

	/**
	 * @type Long
	 * @return idStead attribute of the Stead
	 */
	public Long getIdStead() {
		return idStead;
	}

	/**
	 * Method change idStead attribute of the Stead
	 * 
	 * @type Long
	 * @param idStead
	 */
	public void setIdStead(Long idStead) {
		this.idStead = idStead;
	}

	/**
	 * @type Double
	 * @return steadArea attribute of the Stead
	 */
	public Double getSteadArea() {
		return steadArea;
	}

	/**
	 * Method change steadArea attribute of the Stead
	 * 
	 * @type Double
	 * @param steadArea
	 */
	public void setSteadArea(Double steadArea) {
		this.steadArea = steadArea;
	}

	/**
	 * @type Double
	 * @return steadCost attribute of the Stead
	 */
	public Double getSteadCost() {
		return steadCost;
	}

	/**
	 * Method change steadCost attribute of the Stead
	 * 
	 * @type Double
	 * @param steadCost
	 */
	public void setSteadCost(Double steadCost) {
		this.steadCost = steadCost;
	}

	/**
	 * @type List<Department>
	 * @return department entity
	 */
	public List<Department> getDepartment() {
		return department;
	}

	/**
	 * Method change department entity
	 * 
	 * @type List<Department>
	 * @param department
	 */
	public void setDepartment(List<Department> department) {
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
	 * @return Stead as string.
	 */
	@Override
	public String toString() {
		if(!this.idStead.equals(null)){
			return this.idStead.toString()+" "+this.steadArea.toString()+" "+this.steadCost.toString();
		}
		return super.toString();
	}
}
