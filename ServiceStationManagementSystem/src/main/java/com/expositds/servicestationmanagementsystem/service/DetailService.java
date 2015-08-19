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

import com.expositds.servicestationmanagementsystem.model.Detail;

/**
 * <p>The interface DetailService contain methods ads which realize in class DetailServiceImpl.
 * Class DetailServiceImpl use Service pattern which describes service layer of application.
 * This class contain general operation to all classes.This interface contain ads methods which
 * perform busness logic all application. Interface extend AbstractEntityCommonService interface
 * which contain ads base operation of any entity.
 * 
 * @version 1.0 19.08.2015
 * @author Zaerko Denis
 */
public interface DetailService extends  AbstractEntityCommonService {

	/**
	 * Return list of all details(exist or not exist at that momant). If data base contains
	 * any datails method return list of details else return null. List contain serving on
	 * 20 rows and start on 1 row. This methods addresses to method in DAO layer for execution
	 * operation.
	 * 
	 * @type List
	 * 
	 * @return List<Detail> or null
	 */
	public List<Detail> getListAllDetail();
	
	/**
	 * Return list of details which have same status. Status details for search indicated
	 * as parametr. If data base contains datail with status method return list of this 
	 * details else return null. List contain serving on 20 rows and start on 1 row. 
	 * This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type List
	 * @type String
	 * @param detailStaus
	 * 
	 * @return List<Detail> with status or null.
	 */
	public List<Detail> getListDetailWithStausAsParam(String detailStaus);
}
