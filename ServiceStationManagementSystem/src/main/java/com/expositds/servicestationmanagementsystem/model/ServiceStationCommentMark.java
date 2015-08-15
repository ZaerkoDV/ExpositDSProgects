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
 * Service station comment and mark entity describe base characteristics and behavior of comment
 * (and mark). All client, which have order (one or more) in service station (one of departments)
 * may do comments and exhibit same mark of service station. Client may change comment view status.
 * If client want to show comment only director, client will change view status on ìdirectorî. If
 * client want to show comment director and mechanic, client change view status on ìmechanicî. Else
 * client want show comment director, mechanic and all other clients, client change status on ìallî.
 * Service station rating (mark) varies between 1-10.Service station comment and mark have next
 * relations: many-to-one with client, many-to-one with service station.All communication is one-way.
 * 
 * The class is located in the com.expositds.servicestationmanagementsystem.model and describes part
 * of model in MVC architecture. This class includes a description ServiceStationCommentMark entity.
 * For creating ServiceStationCommentMark model use Hibernate technology (anatations). Class contains
 * exclusively no-static public methods that return fields of entity. Methods intended to access object
 * fields.Class also contain overload methods toString(), hashCode(), equals().
 * 
 * @see Hibernate annotations
 * 
 * @version 1.0 31.07.2015
 * @author Denis Zaerko
 */
@Entity(name="ServiceStationCommentMark")
@Table(name="service_station_comment_mark")
public class ServiceStationCommentMark {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_service_station_comment_mark")
	private Long idServiceStation—ommentMark;

	@Column(name="comment")
	private String comment;

	@NotEmpty
	@Column(name="view_status" , nullable = false, columnDefinition="varchar(15) default 'all'")
	private String viewStatus;

	@Column(name="mark", nullable = false, columnDefinition="integer(11) default '0'")
	private Long mark;

	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	@ManyToOne
	@JoinColumn(name="service_station_id")
	private ServiceStation serviceStation;

	/**
	 * Overloaded constructor of ServiceStationCommentMark class.
	 * 
	 * @type Long
	 * @type String
	 * @type Client
	 * @type ServiceStation
	 * 
	 * @param idServiceStation—ommentMark
	 * @param comment
	 * @param viewStatus
	 * @param mark
	 * @param client
	 * @param serviceStation
	 */
	public ServiceStationCommentMark(Long idServiceStation—ommentMark, String comment, String viewStatus, Long mark,
			Client client, ServiceStation serviceStation){

		this.idServiceStation—ommentMark=idServiceStation—ommentMark;
		this.comment=comment;
		this.viewStatus=viewStatus;
		this.mark=mark;
		this.client=client;
		this.serviceStation=serviceStation;
	}

	/**
	 * Empty constructor(default) of the ServiceStationCommentMark class.
	 */
	public ServiceStationCommentMark(){
	}

	/**
	 * @type Long
	 * @return idServiceStation—ommentMark attribute of the ServiceStationCommentMark
	 */
	public Long getIdServiceStation—ommentMark() {
		return idServiceStation—ommentMark;
	}

	/**
	 * Method change idServiceStation—ommentMark attribute of the ServiceStation—ommentMark
	 * 
	 * @type Long
	 * @param idServiceStation—ommentMark
	 */
	public void setIdServiceStation—ommentMark(Long idServiceStation—ommentMark) {
		this.idServiceStation—ommentMark = idServiceStation—ommentMark;
	}

	/**
	 * @type String
	 * @return comment attribute of the ServiceStation—ommentMark
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Method change comment attribute of the ServiceStation—ommentMark
	 * 
	 * @type String
	 * @param comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @type String
	 * @return viewStatus attribute of the ServiceStation—ommentMark
	 */
	public String getViewStatus() {
		return viewStatus;
	}

	/**
	 * Method change viewStatus attribute of the ServiceStation—ommentMark
	 * 
	 * @type String
	 * @param viewStatus
	 */
	public void setViewStatus(String viewStatus) {
		this.viewStatus = viewStatus;
	}

	/**
	 * @type Long
	 * @return mark attribute of the ServiceStation—ommentMark
	 */
	public Long getMark() {
		return mark;
	}

	/**
	 * Method change mark attribute of the ServiceStation—ommentMark
	 * 
	 * @type Long
	 * @param mark
	 */
	public void setMark(Long mark) {
		this.mark = mark;
	}

	/**
	 * @type Client
	 * @return client entity.
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Method change client entity.
	 * 
	 * @type Client
	 * @param client
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @type ServiceStation
	 * @return serviceStation entity.
	 */
	public ServiceStation getServiceStation() {
		return serviceStation;
	}

	/**
	 * Method change serviceStation entity.
	 * 
	 * @type ServiceStation
	 * @param serviceStation
	 */
	public void setServiceStation(ServiceStation serviceStation) {
		this.serviceStation = serviceStation;
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
	 * @return ServiceStation—ommentMark as string.
	 */
	@Override
	public String toString() {
		if(!this.idServiceStation—ommentMark.equals(null)){
			return this.idServiceStation—ommentMark.toString()+" "+this.comment.toString()+" "+
					this.viewStatus.toString()+" "+this.mark.toString();

		}
		return super.toString();
	}

}
