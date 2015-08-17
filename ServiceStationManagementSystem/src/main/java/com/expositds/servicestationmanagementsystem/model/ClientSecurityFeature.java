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
 * Client security feature  describe additional security characteristics of the client.
 * Security feature is part of Client entity. Not all clients have security feature (login,
 * password). ClientSecurityFeature have only registered client.This client may authorized
 * in system and do order in department by themselves.Client password stored in encrypted
 * form. Client security feature have relation one-to-one with client.All communication is
 * one-way.
 * 
 * The class is located in the com.expositds.servicestationmanagementsystem.model and describes
 * part of model in MVC architecture. This class includes a description ClientSecurityFeature 
 * entity as assotitiation with Client entity.For creating ClientSecurityFeature model use Hibernate
 * technology (anatations). Class contain method convertToMD5() which convert client password
 * to to MD5 hash. Class contains exclusively no-static public methods that return fields of
 * entity.Methods intended to access object fields.Class also contain overload methods toString(),
 * hashCode(), equals().
 *
 * @see Hibernate annotations
 * @see org.apache.commons.codec.digest.DigestUtils
 * 
 * @version 1.0 31.07.2015
 * @author Denis Zaerko
 */
@Entity(name="ClientSecurityFeature")
@Table(name="client_security_feature")
public class ClientSecurityFeature {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_client_security_feature")
	private Long id—lientSecurityFeature;

	@NotEmpty
	@Size(min=4)
	@Column(name="client_login")
	private String clientLogin;

	@NotEmpty
	@Size(min=4)
	@Column(name="client_password")
	private String clientPassword;

	@OneToOne
	@JoinColumn(name="client_id")
	private Client client;

	/**
	 * Overloaded constructor of ClientSecurityFeature class.
	 * 
	 * @type Long
	 * @type String
	 * @type Client
	 * 
	 * @param id—lientSecurityFeature
	 * @param clientLogin
	 * @param clientPassword
	 * @param client
	 */
	public ClientSecurityFeature(Long id—lientSecurityFeature,String clientLogin, String clientPassword, Client client){
		this.id—lientSecurityFeature=id—lientSecurityFeature;
		this.clientLogin=clientLogin;
		this.clientPassword=clientPassword;
		this.client=client;
	}

	/**
	 * Empty constructor(default) of ClientSecurityFeature class.
	 */
	public ClientSecurityFeature(){
	}

	/**
	 * 
	 * @type Long
	 * @return id—lientSecurityFeature attribute of the ClientSecurityFeature
	 */
	public Long getId—lientSecurityFeature() {
		return id—lientSecurityFeature;
	}

	/**
	 * Method change id—lientSecurityFeature attribute of the ClientSecurityFeature
	 * 
	 * @type Long
	 * @param id—lientSecurityFeature
	 */
	public void setId—lientSecurityFeature(Long id—lientSecurityFeature) {
		this.id—lientSecurityFeature = id—lientSecurityFeature;
	}

	/**
	 * @type String
	 * @return clientLogin attribute of the ClientSecurityFeature
	 */
	public String getClientLogin() {
		return clientLogin;
	}

	/**
	 * Method change clientLogin attribute of the ClientSecurityFeature
	 * 
	 * @type String
	 * @param clientLogin
	 */
	public void setClientLogin(String clientLogin) {
		this.clientLogin = clientLogin;
	}

	/**
	 * @type String
	 * @return clientPassword attribute of the ClientSecurityFeature in
	 * encrypted form.
	 */
	public String getClientPassword() {
		return clientPassword;
	}

	/**
	 * Method change clientPassword attribute of the ClientSecurityFeature
	 * Password stored in encrypted form. For cript use MD5.
	 * 
	 * @see org.apache.commons.codec.digest.DigestUtils
	 * @type String
	 * @param clientPassword
	 */
	public void setClientPassword(String clientPassword) {
		this.clientPassword = DigestUtils.md5Hex(clientPassword);
	}

	/**
	 * @type Client
	 * @return Client entity.
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Method change Client
	 * 
	 * @type Client
	 * @param client entity.
	 */
	public void setClient(Client client) {
		this.client = client;
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
	 * @return ClientSecurityFeature as string.
	 */
	@Override
	public String toString() {
		if(!this.id—lientSecurityFeature.equals(null)){
			return this.id—lientSecurityFeature.toString()+" "+this.clientLogin.toString()+
					" "+this.clientPassword.toString();
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
