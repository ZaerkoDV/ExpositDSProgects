/**
 * @package com.expositds.servicestationmanagementsystem.service
 * 
 * Package com.expositds.servicestationmanagementsystem.service contain set of interfaces
 * which description service layer in ServiceStationManagementSystem project. This project
 * is based on MVC architecture.This inerface perform class which is part of service layer in
 * MVC architecture.This layer defines the boundary of the application and a set of permitted
 * operations. It encapsulates the business logic of the application and controls the answers
 * in the implementation of operations. All classes which contain postfix “Service” provide to
 * work Service  for Service Station Management System application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions. 
 */
package com.expositds.servicestationmanagementsystem.service;

import java.util.List;

import com.expositds.servicestationmanagementsystem.model.ServiceStationCommentMark;

/**
 * <p>The interface ServiceStationCommentMarkService contain methods ads which realize in class
 * ServiceStationCommentMarkServiceImpl. Class ServiceStationCommentMarkServiceImpl use Service
 * pattern which describes service layer of application. This class contain general operation to
 * all classes.This interface contain ads methods which perform busness logic all application.
 * Interface extend AbstractEntityCommonService interface which contain ads base operation of any
 * entity.
 * 
 * @version 1.0 19.08.2015
 * @author Zaerko Denis
 */
public interface ServiceStationCommentMarkService extends  AbstractEntityCommonService {

	/**
	 * Return list of service station mark and comment with status as paremetr
	 * Parametr viewStatus may have next value:all, mechnic, director. List 
	 * contain serving on 20 rows and start on 1 row.If list comments and mark
	 * is empty return null.This methods addresses to method in DAO layer for
	 * execution operation.
	 * 
	 * @type List
	 * @type Long
	 * @type String
	 * @param idServiceStation
	 * @param viewStatus
	 * 
	 * @return List<ServiceStationCommentMark> or null;
	 */
	public List<ServiceStationCommentMark> getListCommentMarkStatusAsParamByIdServiceStation(Long idServiceStation,String viewStatus);
	
	/**
	 * Return list of service station mark and comment in all service stations
	 * which hava any view status and write one client. List  contain serving on
	 * 20 rows and start on 1 row. If list comments and mark is empty return null.
	 * This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type List
	 * @type Long
	 * @type String
	 * @param idServiceStation
	 * @param viewStatus
	 * 
	 * @return List<ServiceStationCommentMark> or null;
	 */
	public List<ServiceStationCommentMark> getListCommentMarkByIdClient(Long idClient);
	
	/**
	 * Return list of service station mark and comment for service station which
	 * sorted by degerssive mark. List contain serving on 20 rows and start on 1 row.
	 * If list comments and mark is empty return null.This methods addresses to method
	 * in DAO layer for execution operation.
	 * 
	 * @type List
	 * @type Long
	 * @type String
	 * @param idServiceStation
	 * @param viewStatus
	 * 
	 * @return List<ServiceStationCommentMark> or null;
	 */
	public List<ServiceStationCommentMark> getListCommentMarkSortByDegressiveMark(Long idServiceStation);
}
