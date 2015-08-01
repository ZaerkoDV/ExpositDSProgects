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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Detail entity describe base characteristics and behavior of detail. Most of order(department order)
 * include replacement details. Order may include replacement many details. Every detail have status
 * (detail status).This status indicates the presence or absence of detail (exist or not exist). Detail
 * also have other attributes: name, manufacturer, cost (which include in order cost if detail use in order),
 * warranty (day).Detail have relations many-to-one with department order.
 * 
 * The class is located in the com.expositds.servicestationmanagementsystem.model and describes part
 * of model in MVC architecture. This class includes a description Detail entity.For creating
 * Detail model use Hibernate technology (anatations). Class contains exclusively no-static public
 * methods that return fields of entity. Methods intended to access object fields.Class also contain
 * overload methods toString(), hashCode(), equals().
 * 
 * @see Hibernate annotations
 * 
 * @version 1.0 31.07.2015
 * @author Denis Zaerko
 */
@Entity(name="Detail")
@Table(name="detail")
public class Detail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detail")
	private Long idDetail;
	
	@Column(name="detail_name")
	private String detailName;
	
	@Column(name="detail_manufacturer")
	private String detailManufacturer;
	
	@NotEmpty
	@Column(name="detail_status", nullable = false, columnDefinition="varchar(45) default 'exist'")
	private String detailStatus;
	
	@Column(name="detail_cost")
	private Double detailCost;
	
	@Column(name="detail_warranty_day")
	private Long detailWarrantyDay;
	
	@ManyToOne
	@JoinColumn(name="department_order_id")
	private DepartmentOrder departmentOrder;
	
	
	/**
	 * Overloaded constructor of Department class.
	 * 
	 * @type Long
	 * @type String
	 * @type Double
	 * @type DepartmentOrder
	 * 
	 * @param idDepartment
	 * @param detailName
	 * @param detailManufacturer
	 * @param detailStatus
	 * @param detailCost
	 * @param detailWarrantyDay
	 * @param departmentOrder
	 */
	public Detail(Long idDetail, String detailName,String detailManufacturer,String detailStatus,
			Double detailCost,Long detailWarrantyDay,DepartmentOrder departmentOrder){
		this.idDetail=idDetail;
		this.detailName=detailName;
		this.detailManufacturer=detailManufacturer;
		this.detailStatus=detailStatus;
		this.detailCost=detailCost;
		this.detailWarrantyDay=detailWarrantyDay;
		this.departmentOrder=departmentOrder;
	}
	
	/**
	 * Empty constructor(default) of Detail class.
	 */
	public Detail(){
	}

	/**
	 * @type Long
	 * @return idDetail attribute of the Detail
	 */
	public Long getIdDetail() {
		return idDetail;
	}

	/**
	 * Method change idDetail attribute of the Detail
	 * 
	 * @type Long
	 * @param idDetail
	 */
	public void setIdDetail(Long idDetail) {
		this.idDetail = idDetail;
	}

	/**
	 * @type String
	 * @return detailName attribute of the Detail
	 */
	public String getDetailName() {
		return detailName;
	}

	/**
	 * Method change detailName attribute of the Detail
	 * 
	 * @type String
	 * @param detailName
	 */
	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}

	/**
	 * @type String
	 * @return detailManufacturer attribute of the Detail
	 */
	public String getDetailManufacturer() {
		return detailManufacturer;
	}

	/**
	 * Method change detailManufacturer attribute of the Detail
	 * 
	 * @type String
	 * @param detailManufacturer
	 */
	public void setDetailManufacturer(String detailManufacturer) {
		this.detailManufacturer = detailManufacturer;
	}

	/**
	 * @type String
	 * @return detailStatus attribute of the Detail
	 */
	public String getDetailStatus() {
		return detailStatus;
	}

	/**
	 * Method change detailStatus attribute of the Detail
	 * 
	 * @type String
	 * @param detailStatus
	 */
	public void setDetailStatus(String detailStatus) {
		this.detailStatus = detailStatus;
	}

	/**
	 * @type Double
	 * @return detailCost attribute of the Detail
	 */
	public Double getDetailCost() {
		return detailCost;
	}

	/**
	 * Method change detailCost attribute of the Detail
	 * 
	 * @type Double
	 * @param detailCost
	 */
	public void setDetailCost(Double detailCost) {
		this.detailCost = detailCost;
	}

	/**
	 * @type Long
	 * @return detailWarrantyDayt attribute of the Detail
	 */
	public Long getDetailWarrantyDay() {
		return detailWarrantyDay;
	}

	/**
	 * Method change detailWarrantyDay attribute of the Detail
	 * 
	 * @type Long
	 * @param detailWarrantyDay
	 */
	public void setDetailWarrantyDay(Long detailWarrantyDay) {
		this.detailWarrantyDay = detailWarrantyDay;
	}

	/**
	 * @type DepartmentOrder
	 * @return departmentOrder entity
	 */
	public DepartmentOrder getDepartmentOrder() {
		return departmentOrder;
	}

	/**
	 * Method change departmentOrder
	 * 
	 * @type DepartmentOrder
	 * @param departmentOrder entity
	 */
	public void setDepartmentOrder(DepartmentOrder departmentOrder) {
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
	 * @return Detail as string.
	 */
	@Override
	public String toString() {
		if(!this.idDetail.equals(null)){
			return this.idDetail.toString()+" "+this.detailName.toString()+" "+this.detailManufacturer.toString()+
					" "+this.detailStatus.toString()+" "+this.detailCost.toString()+" "+this.detailWarrantyDay.toString();
		}
		return super.toString();
	}
}
