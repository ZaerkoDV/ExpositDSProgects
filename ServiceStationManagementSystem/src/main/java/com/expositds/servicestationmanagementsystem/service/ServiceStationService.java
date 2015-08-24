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

import java.util.Date;
import java.util.List;

import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.Stead;

/**
 * <p>The interface ServiceStationService contain methods ads which realize in class ServiceStationServiceImpl.
 * Class ServiceStationServiceImpl use Service pattern which describes service layer of application. This class
 * contain general operation to all classes.This interface contain ads methods which perform busness logic all
 * application. Interface extend AbstractEntityCommonService interface which contain ads base operation of any
 * entity.
 * 
 * @version 1.0 19.08.2015
 * @author Zaerko Denis
 */
public interface ServiceStationService extends AbstractEntityCommonService{

	/**
	 * Return list of stead which use to service station departments rent. If
	 * service station(departments) use stead as rent method return list stead
	 * else return null.This method addresses to method in DAO layer for execution
	 * operation.   
	 * 
	 * @type Long
	 * @type List
	 * @param idServiceStation
	 * 
	 * @return List<Stead> which use(include) in service station.
	 */
	public List<Stead> getListSteadUseServiceStation(Long idServiceStation);
	
	/**
	 * Return total(sum) area which use service station(departments which include in
	 * service station). Method return same value if service station use same stead else
	 * return null.This method addresses to method in DAO layer for execution operation.   
	 * 
	 * @type Long
	 * @type Double
	 * @type List
	 * @param idServiceStation
	 * 
	 * @return List<Stead> which use(include) in service station.
	 */
	public Double getTotalServiceStationArea(Long idServiceStation);
	
	/**
	 * Return list of all service sattion which exist in data base else return null.
	 * This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type List
	 * @return List<ServiceStation> or null.
	 */
	public List<ServiceStation> getAllServiceStation();
	
	/**
	 * Return all departments in service station by id service station
	 * which exist in data base else return null.
	 * 
	 * @type List
	 * 
	 * @return List<Department> or null.
	 */
	public List<Department> getListDepartmentForServiceStation(Long idServiceStation);
	
	/**
	 * Generate pdf file which contain financial report for departmet
	 * This method addresses to method in DAO layer for execution
	 * operation.   
	 * 
	 * @type Long
	 * @type Date
	 * @param idDepartment
	 * @param startDate
	 * @param endDate
	 * @see javax.swing.JFileChooser
	 * @see com.itextpdf.text
	 * 
	 * @return generate pdf file which contain financial report for departmet.
	 */
	public void getFinancialReportForDepartmet(Long idDepartment,Date startDate,Date endDate);
	
	/**
	 * Generate pdf file which contain financial report for service station.
	 * This method addresses to method in DAO layer for execution operation.   
	 * 
	 * @type Long
	 * @type Date
	 * @param idDepartment
	 * @param startDate
	 * @param endDate
	 * @see javax.swing.JFileChooser
	 * @see com.itextpdf.text
	 * 
	 * @return generate pdf file which contain financial report for service station.
	 */
	public void getFinancialReportForServiceStation(Long idServiceStation,Date startDate,Date endDate);
	
}
