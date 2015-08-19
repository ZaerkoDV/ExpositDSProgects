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

import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;

/**
 * <p>The interface ClientService contain methods ads which realize in class ClientServiceImpl.
 * Class ClientServiceImpl use Service pattern which describes service layer of application.
 * This class contain general operation to all classes.This interface contain ads methods which
 * perform busness logic all application. Interface extend AbstractEntityCommonService interface
 * which contain ads base operation of any entity.
 * 
 * @version 1.0 18.08.2015
 * @author Zaerko Denis
 */
public interface ClientService extends AbstractEntityCommonService{

	/**
	 * Return list of client by last name. If data base contains client with transmitted
	 * last name return list of clients else return null. List contain serving on 20 rows
	 * and start on 1 row.This methods addresses to method in DAO layer for execution operation.  
	 * 
	 * @type String
	 * @param clientLastName
	 * 
	 * @return List<Client> all client with last name as parametr else null.
	 */
	public List<Client> getListClientByLastName(String clientLastName);
	
	/**
	 * Return identification number of client in data base by login and password.
	 * If login and password exist return idClient which have type Long else return
	 * null.This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type String
	 * @param clientLogin
	 * @param clientPassword
	 * 
	 * @return id client(Long)
	 */
	public Long getIdClientByLoginPassword(String clientLogin, String clientPassword);
	
	/**
	 * Return Client by email if client exist in data base with specify email else null.
	 * Parameter clientEmail is attribute of the Client. Email must be unique else method
	 * generate exeption.This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @param clientEmail
	 * @type Long
	 * 
	 * @return Client or null.
	 */
	public Client getClientByEmail(String clientEmail);
	
	/**
	 * Return result of user sign in(true/false).If client login and password exist in data
	 * base return true else false.Login and password must be unique else method generate
	 * exeption.This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type String
	 * @type Boolean
	 * @param clientLogin
	 * @param clientPassword
	 * 
	 * @return Boolean
	 */
	public Boolean signInClientByLoginPassword(String clientLogin, String clientPassword);
	
	/**
	 * Return amount of clients in data base. If data base contain any clients return amount
	 * client else return zero.This methods addresses to method in DAO layer for execution
	 * operation.
	 * 
	 * @return amount of client(int) 
	 */
	public int getCountClient();
	
	/**
	 * Return list of order which have client in all depatrments and all service stations.List
	 * contain serving on 20 rows and start on 1 row. If list order is empty return null.This
	 * methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type List
	 * @type Long
	 * @param idClient
	 * 
	 * @return List<DepartmentOrder> or null;
	 */
	public List<DepartmentOrder> getListOrderAllServiceStationForClient(Long idClient);
	
	/**
	 * Return list of order with status notcompleted and overdue which have client in all service
	 * stations. List contain serving on 20 rows and start on 1 row. If list order is empty return
	 * null. This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type List
	 * @type Long
	 * @param idClient
	 * 
	 * @return List<DepartmentOrder> or null;
	 */
	public List<DepartmentOrder> getListNotcompletedOverdueOrderForClient(Long idClient);
	
	/**
	 * Return list of order with status done which have client in all service stations. List contain
	 * serving on 20 rows and start on 1 row. If list order is empty return null.This methods addresses
	 * to method in DAO layer for execution operation.
	 * 
	 * @type List
	 * @type Long
	 * @param idClient
	 * 
	 * @return List<DepartmentOrder> or null;
	 */
	public List<DepartmentOrder> getListDoneOrderForClient(Long idClient);
}
