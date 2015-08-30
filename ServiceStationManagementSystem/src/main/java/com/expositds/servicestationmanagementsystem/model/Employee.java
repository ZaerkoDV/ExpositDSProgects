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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * Employee entity describe base characteristics and behavior of employee. Employee execute
 * orders (mechanic) or govern service station (director). Role (function) in service station
 * indicated as position. Employee have unique login and password. Employee get same salary
 * (wage) per working day. Employee (mechanic) may work in couple of departments and even in
 * other service station at the same time. Mechanic have right to change start and end data
 * order, correct cost and purchase new detail. Mechanic change order status which signal of
 * the end of work. Also mechanic may watch client comments and marks. Director have right to
 * generate report about financial result and create (or delete) new department. Employee have
 * relations one-to-many with department order and one-to-one with employee security order. All
 * communication is one-way.
 * 
 * The class is located in the com.expositds.servicestationmanagementsystem.model and describes
 * part of model in MVC architecture. This class includes a description Employee entity. For
 * creating Employee model use Hibernate technology (anatations). Class contains exclusively
 * no-static public methods that return fields of entity. Methods intended to access object
 * fields.Class also contain overload methods toString(), hashCode(), equals().
 *
 * @see Hibernate annotations
 * 
 * @version 1.0 31.07.2015
 * @author Denis Zaerko
 */
@Entity(name="Employee")
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_employee")
	private Long idEmployee;

	@NotNull
	@Size(min=2)
	@Column(name="employe_first_name")
	private String employeFirstName;

	@NotNull
	@Size(min=2)
	@Column(name="employe_last_name")
	private String employeLastName;

	@Size(min=0)
	@Column(name="employe_middle_name")
	private String employeMiddleName;

	@NotNull
	@Size(min=3)
	@Column(name="employe_function")
	private String employeFunction;

	@Column(name="employe_telephone")
	private String employeTelephone;	

	@NotNull
	@Past
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="employe_birthday")
	private Date employeBirthday;

	@Email
	@Column(name="employe_e_mail")
	private String employeEmail;

	@NotNull
	@Column(name="wages")
	private Double wages;
		
	@Column(name="director_of_id_service_station")
	private Long directorOfServiceStation;
	
	/**
	 * Overloaded constructor of Employee class.
	 * 
	 * @type Long
	 * @type Double
	 * @type String
	 * @type Data
	 * 
	 * @param idEmployee
	 * @param employeFirstName
	 * @param employeLastName
	 * @param employeMiddleName
	 * @param employeFunction
	 * @param employeTelephone
	 * @param employeBirthday
	 * @param employeEmail
	 * @param wages
	 * @param directorOfServiceStation
	 */
	public Employee(Long idEmployee, String employeFirstName, String employeLastName, String employeMiddleName,
			String employeFunction,String employeTelephone, Date employeBirthday, String employeEmail, Double wages,
			Long directorOfServiceStation){
	
		this.idEmployee=idEmployee;
		this.employeFirstName=employeFirstName;
		this.employeLastName=employeLastName;
		this.employeMiddleName=employeMiddleName;
		this.employeFunction=employeFunction;
		this.employeTelephone=employeTelephone;
		this.employeBirthday=employeBirthday;
		this.employeEmail=employeEmail;
		this.wages=wages;
		this.directorOfServiceStation=directorOfServiceStation;
	}
	
	/**
	 * Empty constructor(default) of Employee class.
	 */
	public Employee(){
	}

	/**
	 * @type Long
	 * @return idEmployee attribute of the Employee
	 */
	public Long getIdEmployee() {
		return idEmployee;
	}

	/**
	 * Method change idEmployee attribute of the Employee
	 * 
	 * @type Long
	 * @param idEmployee
	 */
	public void setIdEmployee(Long idEmployee) {
		this.idEmployee = idEmployee;
	}

	/**
	 * @type String
	 * @return employeFirstName attribute of the Employee
	 */
	public String getEmployeFirstName() {
		return employeFirstName;
	}

	/**
	 * Method change employeeFirstName attribute of the Employee
	 * 
	 * @type String
	 * @param employeeFirstName
	 */
	public void setEmployeFirstName(String employeFirstName) {
		this.employeFirstName = employeFirstName;
	}

	/**
	 * @type String
	 * @return employeLastName attribute of the Employee
	 */
	public String getEmployeLastName() {
		return employeLastName;
	}

	/**
	 * Method change employeLastName attribute of the Employee
	 * 
	 * @type String
	 * @param employeLastName
	 */
	public void setEmployeLastName(String employeLastName) {
		this.employeLastName = employeLastName;
	}

	/**
	 * @type String
	 * @return employeMiddleName attribute of the Employee
	 */
	public String getEmployeMiddleName() {
		return employeMiddleName;
	}

	/**
	 * Method change employeMiddleName attribute of the Employee
	 * 
	 * @type String
	 * @param employeMiddleName
	 */
	public void setEmployeMiddleName(String employeMiddleName) {
		this.employeMiddleName = employeMiddleName;
	}

	/**
	 * @type String
	 * @return employeFunction attribute of the Employee
	 */
	public String getEmployeFunction() {
		return employeFunction;
	}

	/**
	 * Method change employeFunction attribute of the Employee
	 * 
	 * @type String
	 * @param employeFunction
	 */
	public void setEmployeFunction(String employeFunction) {
		this.employeFunction = employeFunction;
	}

	/**
	 * @type String
	 * @return employeTelephone attribute of the Employee
	 */
	public String getEmployeTelephone() {
		return employeTelephone;
	}

	/**
	 * Method change employeTelephone attribute of the Employee
	 * 
	 * @type String
	 * @param employeTelephone
	 */
	public void setEmployeTelephone(String employeTelephone) {
		this.employeTelephone = employeTelephone;
	}

	/**
	 * @type Date
	 * @return employeBirthday attribute of the Employee
	 */
	public Date getEmployeBirthday() {
		return employeBirthday;
	}

	/**
	 * Method change employeBirthday attribute of the Employee
	 * 
	 * @type Date
	 * @param employeBirthday
	 */
	public void setEmployeBirthday(Date employeBirthday) {
		this.employeBirthday = employeBirthday;
	}

	/**
	 * @type String
	 * @return employeEmail attribute of the Employee
	 */
	public String getEmployeEmail() {
		return employeEmail;
	}

	/**
	 * Method change employeEmail attribute of the Employee
	 * 
	 * @type String
	 * @param employeEmail
	 */
	public void setEmployeEmail(String employeEmail) {
		this.employeEmail = employeEmail;
	}

	/**
	 * @type Double
	 * @return wages attribute of the Employee
	 */
	public Double getWages() {
		return wages;
	}

	/**
	 * Method change wages attribute of the Employee
	 * 
	 * @type Double
	 * @param wages
	 */
	public void setWages(Double wages) {
		this.wages = wages;
	}
	
	/**
	 * @type Long
	 * @return directorOfServiceStation attribute of the Employee
	 */
	public Long getDirectorOfServiceStation() {
		return directorOfServiceStation;
	}

	/**
	 * Method change id service station which lead director
	 * 
	 * @type Long
	 * @param directorOfServiceStation
	 */
	public void setDirectorOfServiceStation(Long directorOfServiceStation) {
		this.directorOfServiceStation = directorOfServiceStation;
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
	 * @return Employee as string.
	 */
	@Override
	public String toString() {
		if(!this.idEmployee.equals(null)){
			return this.idEmployee.toString()+" "+this.employeFirstName.toString()+" "+this.employeLastName.toString()+" "
		+this.employeMiddleName.toString()+" "+this.employeTelephone.toString()+" "+this.employeFunction.toString()+" "
					+this.employeBirthday.toString()+" "+this.employeEmail.toString()+" "+this.wages.toString()+" "
		+this.directorOfServiceStation.toString();
		}
		return super.toString();
	}
}
