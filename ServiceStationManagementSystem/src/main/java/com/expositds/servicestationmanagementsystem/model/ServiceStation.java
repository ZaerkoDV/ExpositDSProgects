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
import javax.persistence.Table;
/**
 * Service station entity contain base characteristics (fields) and behavior of service station
 * (methods).Service station have same departments (which have same orders), clients (who do order
 * in departments and write comments, exhibits mark). Also service station have same employee
 * (mechanics and directors).Service station use relations one-to-many with service station comment
 * and mark entity and one-to-many with department entity.Service station may generate reports about
 * income and expenses. Report compiled on same date and include financial characteristics of each
 * department or all service station.Every service station have same comments, which may see other
 * clients, mechanics, director. Service station have unequal name and logotype for differ from other
 * service stations.
 * 
 * The class is located in the com.expositds.servicestationmanagementsystem.model and describes part
 * of model in MVC architecture. This class includes a description ServiceStation entity.For creating
 * ServiceStation model use Hibernate technology (anatations). Class contains exclusively no-static public
 * methods that return fields of entity. Methods intended to access object fields.Class also contain
 * overload methods toString(), hashCode(), equals().
 * 
 * @see Hibernate annotations
 * 
 * @version 1.0 31.07.2015
 * @author Denis Zaerko
 */
@Entity(name="ServiceStation")
@Table(name="service_station")
public class ServiceStation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_service_station")
	private Long idServiceStation;
	
	@Column(name="service_station_name")
	private String serviceStationName;	
	
	@Column(name="service_station_logotype")
	private String serviceStationLogotype;	

	@Column(name="service_station_address")
	private String serviceStationAddress;	
	
	@Column(name="service_station_phone_number")
	private String serviceStationPhoneNumber;
	
	/**
	 * Overloaded constructor of ServiceStation class.
	 * 
	 * @type Long
	 * @type String
	 * @type byte
	 * @type Array
	 * @type List
	 * @type Department
	 * @type ServiceStationCommentMark
	 * 
	 * @param idServiceStation
	 * @param serviceStationName
	 * @param serviceStationLogotype
	 * @param serviceStationAddress
	 * @param serviceStationPhoneNumber
	 */
	public ServiceStation(Long idServiceStation,String serviceStationName,String serviceStationLogotype,
			String serviceStationAddress,String serviceStationPhoneNumber){
		this.idServiceStation=idServiceStation;
		this.serviceStationName=serviceStationName;
		this.serviceStationLogotype=serviceStationLogotype;
		this.serviceStationAddress=serviceStationAddress;
		this.serviceStationPhoneNumber=serviceStationPhoneNumber;	
	}
	
	/**
	 * Empty constructor(default) of ServiceStation class.
	 */
	public ServiceStation(){	
	}

	/**
	 * @type Long
	 * @return idServiceStation attribute of the ServiceStation
	 */
	public Long getIdServiceStation() {
		return idServiceStation;
	}

	/**
	 * Method change idServiceStation attribute of the ServiceStation
	 * 
	 * @type Long
	 * @param idServiceStation
	 */
	public void setIdServiceStation(Long idServiceStation) {
		this.idServiceStation = idServiceStation;
	}

	/**
	 * @type String
	 * @return serviceStationName attribute of the ServiceStation
	 */
	public String getServiceStationName() {
		return serviceStationName;
	}

	/**
	 * Method change serviceStationName attribute of the ServiceStation
	 * 
	 * @type String
	 * @param serviceStationName
	 */
	public void setServiceStationName(String serviceStationName) {
		this.serviceStationName = serviceStationName;
	}

	/**
	 * @type String
	 * @return serviceStationLogotype attribute of the ServiceStation
	 */
	public String getServiceStationLogotype() {
		return serviceStationLogotype;
	}

	/**
	 * Method change serviceStationLogotype attribute of the ServiceStation
	 * 
	 * @type String
	 * @param serviceStationLogotype
	 */
	public void setServiceStationLogotype(String serviceStationLogotype) {
		this.serviceStationLogotype = serviceStationLogotype;
	}

	/**
	 * @type String 
	 * @return serviceStationAddress attribute of the ServiceStation
	 */
	public String getServiceStationAddress() {
		return serviceStationAddress;
	}

	/**
	 * Method change serviceStationAddress attribute of the ServiceStation
	 * 
	 * @type String
	 * @param serviceStationAddress
	 */
	public void setServiceStationAddress(String serviceStationAddress) {
		this.serviceStationAddress = serviceStationAddress;
	}

	/**
	 * @type String 
	 * @return serviceStationPhoneNumber attribute of the ServiceStation
	 */
	public String getServiceStationPhoneNumber() {
		return serviceStationPhoneNumber;
	}

	/**
	  * Method change serviceStationPhoneNumber attribute of the ServiceStation
	 * 
	 * @type String
	 * @param serviceStationPhoneNumber
	 */
	public void setServiceStationPhoneNumber(String serviceStationPhoneNumber) {
		this.serviceStationPhoneNumber = serviceStationPhoneNumber;
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
	 * @return ServiceStation as string.
	 */
	@Override
	public String toString() {
		if(!this.idServiceStation.equals(null)){
			return this.idServiceStation.toString()+" "+this.serviceStationName.toString()+" "+this.serviceStationLogotype.toString()
					+" "+this.serviceStationAddress.toString()+" "+this.serviceStationPhoneNumber.toString();
		}
		return super.toString();
	}
}
