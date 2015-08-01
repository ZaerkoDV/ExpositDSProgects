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
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Client entity describe base characteristics and behavior of client. Client make order in service station
 * (one of deportments). Not authorized client may do order also, but must indicate their contact information
 * telephone and email. Client may control order execution. If order not finish, client will cancel order
 * (delete order) or conclude with other service station (renew). All client (authorized or not in system)
 * may do comments and exhibit same mark service station. If client log in system, he will have unique login
 * and password. Entity client security feature responsible for security login and password. Client may have
 * only one login and password. Client have relations: one-to-many with department order, one-to-many with
 * entity service station comment and mark, one-to-one with client security feature.
 * 
 * The class is located in the com.expositds.servicestationmanagementsystem.model and describes part of model in
 * MVC architecture. This class includes a description Client entity. For creating Client model use Hibernate
 * technology (anatations). Class contains exclusively no-static public methods that return fields of entity.
 * Methods intended to access object fields.Class also contain overload methods toString(), hashCode(), equals().
 *
 * @see Hibernate annotations
 * 
 * @version 1.0 31.07.2015
 * @author Denis Zaerko
 */
@Entity(name="Client")
@Table(name="client")
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_client")
	private Long idClient;
	
	@Size(min=1, max=15)
	@Column(name="client_first_name")
	private String clientFirstName;
	
	@Size(min=1, max=15)
	@Column(name="clientLastName")
	private String clientLastName;
	
	@Size(min=0, max=15)
	@Column(name="clientMiddleName")
	private String clientMiddleName;

	@Past
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="client_birthday")
	private Date clientBirthday;
	
	@Column(name="client_telephone")
	private String clientTelephone;

	@NotNull
	@Email
	@Column(name="client_e_mail")
	private String clientEmail;
	
	@OneToOne(targetEntity=ClientSecurityFeature.class , mappedBy="client",fetch = FetchType.LAZY)
	private ClientSecurityFeature clientSecurityFeature; 
	
	@OneToMany(targetEntity=ServiceStationCommentMark.class , mappedBy="client",fetch = FetchType.LAZY)
	private List<ServiceStationCommentMark> serviceStationCommentMark; 
	
	@OneToMany(targetEntity=DepartmentOrder.class , mappedBy="client",fetch = FetchType.LAZY)
	private List<DepartmentOrder> departmentOrder; 
	
	/**
	 * Overloaded constructor of Client class.
	 * 
	 * @type Long
	 * @type String
	 * @type Data
	 * @type List
	 * @type ServiceStationCommentMark
	 * @type ClientSecurityFeature
	 * @type DepartmentOrder
	 * 
	 * @param idClient
	 * @param clientFirstName
	 * @param clientLastName
	 * @param clientMiddleName
	 * @param clientBirthday
	 * @param clientTelephone
	 * @param clientEmail
	 * @param clientSecurityFeature
	 * @param serviceStationCommentMark
	 * @param departmentOrder
	 */
	public Client(Long idClient, String clientFirstName, String clientLastName, String clientMiddleName,
			Date clientBirthday, String clientTelephone, String clientEmail,ClientSecurityFeature clientSecurityFeature,
			List<ServiceStationCommentMark> serviceStationCommentMark,List<DepartmentOrder> departmentOrder){
		 
		this.idClient=idClient;
		this.clientFirstName=clientFirstName;
		this.clientLastName=clientLastName;
		this.clientMiddleName=clientMiddleName;
		this.clientBirthday=clientBirthday;
		this.clientTelephone=clientTelephone;
		this.clientEmail=clientEmail;
		this.clientSecurityFeature=clientSecurityFeature;
		this.serviceStationCommentMark=serviceStationCommentMark;
		this.departmentOrder=departmentOrder;	
	}
	
	/**
	 * Empty constructor(default) of Client class.
	 */
	public Client(){
	}

	/**
	 * @type Long
	 * @return idClient attribute of the Client
	 */
	public Long getIdClient() {
		return idClient;
	}

	/**
	 * Method change id—lient attribute of the Client
	 * 
	 * @type Long
	 * @param idAuthor
	 */
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	/**
	 * @type String
	 * @return clientFirstName attribute of the Client
	 */
	public String getClientFirstName() {
		return clientFirstName;
	}

	/**
	 * Method change clientFirstName attribute of the Client
	 * 
	 * @type String
	 * @param clientFirstName
	 */
	public void setClientFirstName(String clientFirstName) {
		this.clientFirstName = clientFirstName;
	}

	/**
	 * @type String
	 * @return clientLastName attribute of the Client
	 */
	public String getClientLastName() {
		return clientLastName;
	}

	/**
	 * Method change clientLastName attribute of the Client
	 * 
	 * @type String
	 * @param clientLastName
	 */
	public void setClientLastName(String clientLastName) {
		this.clientLastName = clientLastName;
	}

	/**
	 * @type String
	 * @return clientMiddleName attribute of the Client
	 */
	public String getClientMiddleName() {
		return clientMiddleName;
	}

	/**
	 * Method change clientMiddleName attribute of the Client
	 * 
	 * @type String
	 * @param clientMiddleName
	 */
	public void setClientMiddleName(String clientMiddleName) {
		this.clientMiddleName = clientMiddleName;
	}

	/**
	 * @type Data
	 * @return clientBirthday attribute of the Client
	 */
	public Date getClientBirthday() {
		return clientBirthday;
	}

	/**
	 * Method change clientMiddleName attribute of the Client
	 * 
	 * @type String
	 * @param clientMiddleName
	 */
	public void setClientBirthday(Date clientBirthday) {
		this.clientBirthday = clientBirthday;
	}

	/**
	 * @type String
	 * @return clientTelephone attribute of the Client
	 */
	public String getClientTelephone() {
		return clientTelephone;
	}

	/**
	 * Method change clientTelephone attribute of the Client
	 * 
	 * @type String
	 * @param clientTelephone
	 */
	public void setClientTelephone(String clientTelephone) {
		this.clientTelephone = clientTelephone;
	}

	/**
	 * @type String
	 * @return clientEmail attribute of the Client
	 */
	public String getClientEmail() {
		return clientEmail;
	}

	/**
	 * Method change clientEmail attribute of the Client
	 * 
	 * @type String
	 * @param clientEmail
	 */
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	/**
	 * @type ClientSecurityFeature
	 * @return ClientSecurityFeature entity
	 */
	public ClientSecurityFeature getClientSecurityFeature() {
		return clientSecurityFeature;
	}

	/**
	 * Method change ClientSecurityFeature entity
	 * 
	 * @type ClientSecurityFeature
	 * @param clientSecurityFeature entity
	 */
	public void setClientSecurityFeature(ClientSecurityFeature clientSecurityFeature) {
		this.clientSecurityFeature = clientSecurityFeature;
	}

	/**
	 * @type List<ServiceStationCommentMark>
	 * @return List of ServiceStationCommentMark entity
	 */
	public List<ServiceStationCommentMark> getServiceStationCommentMark() {
		return serviceStationCommentMark;
	}

	/**
	 * Method change ServiceStationCommentMark entity
	 * 
	 * @type List<ServiceStationCommentMark>
	 * @param List of serviceStationCommentMark entity
	 */
	public void setServiceStationCommentMark(List<ServiceStationCommentMark> serviceStationCommentMark) {
		this.serviceStationCommentMark = serviceStationCommentMark;
	}

	/**
	 * @type List<DepartmentOrder>
	 * @return List of order in department(entity)
	 */
	public List<DepartmentOrder> getDepartmentOrder() {
		return departmentOrder;
	}

	/**
	 * Method change departmentOrder
	 * 
	 * @type List<DepartmentOrder>
	 * @param List of departmentOrder entity
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
	 * @return Client as string.
	 */
	@Override
	public String toString() {
		if(!this.idClient.equals(null)){
			return this.idClient.toString()+" "+this.clientFirstName.toString()+" "+this.clientLastName.toString()+" "
		+this.clientMiddleName.toString()+" "+this.clientBirthday.toString()+" "+this.clientTelephone.toString()+" "
					+this.clientEmail.toString()+" "+this.clientSecurityFeature.getClientLogin().toString()+" "
		+this.clientSecurityFeature.getClientPassword().toString();
		}
		return super.toString();
	}
}
