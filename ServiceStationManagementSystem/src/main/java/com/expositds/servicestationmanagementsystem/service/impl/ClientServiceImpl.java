/**
 * @package com.expositds.servicestationmanagementsystem.service.impl
 * 
 * Package com.expositds.servicestationmanagementsystem.service.impl contain set of class
 * which description service layer in ServiceStationManagementSystem project. This project
 * is based on MVC architecture.This class is part of service layer in MVC architecture.This
 * layer defines the boundary of the application and a set of permitted operations. It
 * encapsulates the business logic of the application and controls the answers in the
 * implementation of operations. All classes which contain postfix “Service” provide to
 * work Service  for Service Station Management System application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions. 
 */
package com.expositds.servicestationmanagementsystem.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.servicestationmanagementsystem.dao.ClientDAO;
import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.DepartmentOrder;
import com.expositds.servicestationmanagementsystem.service.ClientService;

/**
 * <p>The class ClientServiceImpl use Service pattern which describes business logic application
 * ServiceStationManagemrntSystem. Service layer perform link between, presentation layer and DAO
 * layer.This layer is the main role becouse layer contents(set of methods in classes) affect on
 * functionality of all application.
 * This class contain methods which describes specific operation for Client.This class perform
 * service layer to Client.Class extend base class AbstractEntityCommonServiceImpl and implement
 * ClientService interface which perform all methods of this class.
 * For logging use framework shell slf4j and framework log4j.Class contain also private, static
 * variable logger, which use to call log message. Class use Spring framework anatation to work
 * with service layer. 
 *  
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 18.08.2015
 * @author Zaerko Denis
 */
@Service(value="clientService")
public class ClientServiceImpl extends AbstractEntityCommonServiceImpl implements ClientService {

	/**
	 * Variable logger use to get logger level for class ClientServiceImpl.
	 * 
	 * @param class name: ClientServiceImpl.
	 * @return logger for class ClientServiceImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

	/**
	 * Annatation Inject use to get injection ClientDAO
	 * dependency. This is part of specification JSR-330.
	 */
	@Inject
	@Qualifier("clientDAO")
	private ClientDAO clientDAO;

	/**
	 * This is set method of injection ClientDAO dependency. This methods
	 * permit operation set(writeable) clientDAO.
	 */
	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}
	
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
	public List<Client> getListClientByLastName(String clientLastName){
		logger.info("Service: create list client by last name"+clientLastName);
		return clientDAO.getListClientByLastName(clientLastName);
	}

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
	public Long getIdClientByLoginPassword(String clientLogin, String clientPassword){
		logger.info("Service: Get id client by login"+clientLogin+" and password"+clientPassword);
		return clientDAO.getIdClientByLoginPassword(clientLogin, clientPassword);
	}

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
	public Client getClientByEmail(String clientEmail){
		logger.info("Service: Get client by email"+clientEmail);
		return clientDAO.getClientByEmail(clientEmail);
	}

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
	public Boolean signInClientByLoginPassword(String clientLogin, String clientPassword){
		logger.info("Service: Client sign in by login="+clientLogin+" and password="+clientPassword);
		return clientDAO.signInClientByLoginPassword(clientLogin, clientPassword);
	}

	/**
	 * Return amount of clients in data base. If data base contain any clients return amount
	 * client else return zero.This methods addresses to method in DAO layer for execution
	 * operation.
	 * 
	 * @return amount of client(int) 
	 */
	public int getCountClient(){
		logger.info("Service: Count client in data base.");
		return clientDAO.getCountClient();	
	}

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
	public List<DepartmentOrder> getListOrderAllServiceStationForClient(Long idClient){
		logger.info("Service: Create list client order in all service station by client id="+idClient);
		return clientDAO.getListDoneOrderForClient(idClient);
	}
	
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
	public List<DepartmentOrder> getListNotcompletedOverdueOrderForClient(Long idClient){
		logger.info("Service: Create list client order with status not completed or overdue by client id="+idClient);
		return clientDAO.getListNotcompletedOverdueOrderForClient(idClient);
	}
	
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
	public List<DepartmentOrder> getListDoneOrderForClient(Long idClient){
		logger.info("Service: Create list client order with status done by client id="+idClient);
		return clientDAO.getListDoneOrderForClient(idClient);
	}
}
