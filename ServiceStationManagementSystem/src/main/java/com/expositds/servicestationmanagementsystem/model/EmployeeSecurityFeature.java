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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Employee security feature  describe additional security characteristics of the employee.
 * Security feature is part of Employee entity. All employees have security feature (login,
 * password). EmployeeSecurityFeature have only registered employee. Employee password stored
 * in encrypted form. This employee must authorized in system and perform order in department
 * by themselves. Employee security feature have relation one-to-one with employee.All
 * communication is one-way.
 * 
 * The class is located in the com.expositds.servicestationmanagementsystem.model and describes
 * part of model in MVC architecture. This class includes a description EmployeeSecurityFeature 
 * entity as assotitiation with Employee entity.For creating EmployeeSecurityFeature model use
 * Hibernate technology (anatations).Class contain method convertToMD5() which convert client
 * password to to MD5 hash. Class contains exclusively no-static public methods that return
 * fields of entity.Methods intended to access object fields.Class also contain overload methods
 * toString(), hashCode(), equals().
 *
 * @see Hibernate annotations
 * 
 * @version 1.0 31.07.2015
 * @author Denis Zaerko
 */
@Entity(name="EmployeeSecurityFeature")
@Table(name="employee_security_feature")
public class EmployeeSecurityFeature {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_employe_security_feature")
	private Long idEmployeSecurityFeature;

	@NotEmpty
	@Size(min=4)
	@Column(name="employe_login")
	private String employeLogin;

	@NotEmpty
	@Size(min=4)
	@Column(name="employe_password")
	private String employePassword;

	@OneToOne
	@JoinColumn(name="employe_id")
	private Employee employee;
	
	/**
	 * Overloaded constructor of ClientSecurityFeature class.
	 * 
	 * @type Long
	 * @type String
	 * @type Employee
	 * 
	 * @param idEmployeSecurityFeature
	 * @param employeLogin
	 * @param employePassword
	 * @param employee
	 */
	public EmployeeSecurityFeature(Long idEmployeSecurityFeature,String employeLogin, String employePassword, Employee employee){
		this.idEmployeSecurityFeature=idEmployeSecurityFeature;
		this.employeLogin=employeLogin;
		this.employePassword =employePassword;
		this.employee=employee;
	}
	
	/**
	 * Empty constructor(default) of EmployeeSecurityFeature class.
	 */
	public EmployeeSecurityFeature(){
	}

	/**
	 * @type Long
	 * @return idEmployeSecurityFeature attribute of the EmployeSecurityFeature
	 */
	public Long getIdEmployeSecurityFeature() {
		return idEmployeSecurityFeature;
	}

	/**
	 * Method change idEmployeSecurityFeatur attribute of the EmployeeSecurityFeature
	 * 
	 * @param idEmployeSecurityFeature the idEmployeSecurityFeature to set
	 */
	public void setIdEmployeSecurityFeature(Long idEmployeSecurityFeature) {
		this.idEmployeSecurityFeature = idEmployeSecurityFeature;
	}

	/**
	 * @type String
	 * @return employeLogin attribute of the EmployeeSecurityFeature
	 */
	public String getEmployeLogin() {
		return employeLogin;
	}

	/**
	 * Method change employeLogin attribute of the EmployeeSecurityFeature
	 * 
	 * @type String
	 * @param employeLogin
	 */
	public void setEmployeLogin(String employeLogin) {
		this.employeLogin = employeLogin;
	}

	/**
	 * @type String
	 * @return employePassword attribute of the EmployeeSecurityFeature
	 */
	public String getEmployePassword() {
		return employePassword;
	}

	/**
	 * Method change employePassword attribute of the EmployeeSecurityFeature
	 * Password stored in encrypted form. For cript use MD5.
	 * 
	 * @see org.apache.commons.codec.digest.DigestUtils
	 * @type String
	 * @type String
	 * @param employePassword
	 */
	public void setEmployePassword(String employePassword) {
		this.employePassword = DigestUtils.md5Hex(employePassword);
	}

	/**
	 * @type Employee
	 * @return Employee entity.
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * Method change Employee
	 * 
	 * @type Employee
	 * @param employee entity.
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
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
	 * @return EmployeeSecurityFeature as string.
	 */
	@Override
	public String toString() {
		if(!this.idEmployeSecurityFeature.equals(null)){
			return this.idEmployeSecurityFeature.toString()+" "+this.employeLogin.toString()+
					" "+this.employePassword.toString();
		}
		return super.toString();
	}
	
	/**
	 * Calculates the MD5 digest and returns the value as a 32 character hex string.
	 * 
	 * @type String
	 * @param unconfirm
	 * @return Calculates the MD5 digest and returns the value as a 32 character hex string. 
	 */
	public String convertToMD5(String unconfirm){
		return DigestUtils.md5Hex(unconfirm);
	}
}
