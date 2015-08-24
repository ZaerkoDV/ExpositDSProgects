/**
 * @package com.expositds.servicestationmanagementsystem.service.impl
 * 
 * Package com.expositds.servicestationmanagementsystem.service.impl contain set of class
 * which description service layer in ServiceStationManagementSystem project. This project
 * is based on MVC architecture.This class is part of service layer in MVC architecture.This
 * layer defines the boundary of the application and a set of permitted operations. It
 * encapsulates the business logic of the application and controls the answers in the
 * implementation of operations. All classes which contain postfix “Service” provide to
 * work Service for Service Station Management System application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions. 
 */
package com.expositds.servicestationmanagementsystem.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.swing.JFileChooser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import com.expositds.servicestationmanagementsystem.dao.DepartmentDAO;
import com.expositds.servicestationmanagementsystem.dao.ServiceStationDAO;
import com.expositds.servicestationmanagementsystem.model.Client;
import com.expositds.servicestationmanagementsystem.model.Department;
import com.expositds.servicestationmanagementsystem.model.Employee;
import com.expositds.servicestationmanagementsystem.model.ServiceStation;
import com.expositds.servicestationmanagementsystem.model.Stead;
import com.expositds.servicestationmanagementsystem.service.ServiceStationService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * <p>The class ServiceStationServiceImpl use Service pattern which describes business logic application
 * ServiceStationManagemrntSystem. Service layer perform link between, presentation layer and DAO layer.
 * This layer is the main role becouse layer contents(set of methods in classes) affect on functionality
 * of all application.
 * This class contain methods which describes specific operation for ServiceStation.This class perform
 * service layer to ServiceStation.Class extend base class AbstractEntityCommonServiceImpl and implement
 * ServiceStationService interface which perform all methods of this class.
 * For logging use framework shell slf4j and framework log4j.Class contain also private, static variable
 * logger, which use to call log message. Class use Spring framework anatation to work with service layer. 
 *  
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * @see com.itextpdf.text
 * @see javax.swing.JFileChooser
 * 
 * @version 1.0 19.08.2015
 * @author Zaerko Denis
 */
public class ServiceStationServiceImpl extends AbstractEntityCommonServiceImpl implements ServiceStationService {

	/**
   	 * Fonts value,style and color for department and service station report.
   	 */
	private Paragraph paragraph;
    private static Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font textFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
    private static Font textFontBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    
    /**
     * Variable for department report
     */
    private Double detailExpenses;
    private Double wagesExpenses;
    private Double rentExpenses;
    private Double sumDepartmentExpenses;
    private Double procentExpensesOnDetail;
    private Double procentExpensesOnWages;
    private Double procentExpensesOnRent;
    private Double departmentIncome;
    private Double departmentBalance;
	
    /**
	 * Variable for service station report
	 */
    private Double sumDetailExpenses;
    private Double sumWagesExpenses;
    private Double sumRentExpenses;
    private Double totalServiceStationExpenses;
    private Double procentExpensesServiceStationOnDetail;
    private Double procentExpensesServiceStationOnWages;
    private Double procentExpensesServiceStationOnRent;
    private Double serviceStationIncome;
    private Double serviceStationBalance;
    
	/**
	 * Variable logger use to get logger level for class ServiceStationServiceImpl.
	 * 
	 * @param class name: ServiceStationServiceImpl.
	 * @return logger for class ServiceStationServiceImpl.
	 */
	private static final Logger logger = LoggerFactory.getLogger(ServiceStationServiceImpl.class);

	/**
	 * Annatation Inject use to get injection ServiceStationDAO
	 * dependency. This is part of specification JSR-330.
	 */
	@Inject
	@Qualifier("serviceStationDAO")
	private ServiceStationDAO serviceStationDAO;
	
	/**
	 * Annatation Inject use to get injection DepartmentDAO
	 * dependency. This is part of specification JSR-330.
	 */
	@Inject
	@Qualifier("departmentDAO")
	private DepartmentDAO departmetDAO;

	/**
	 * This is set method of injection ServiceStationDAO dependency.
	 * This methods permit operation set(writeable) serviceStationDAO.
	 */
	public void setServiceStationDAO(ServiceStationDAO serviceStationDAO) {
		this.serviceStationDAO = serviceStationDAO;
	}
	
	/**
	 * This is set method of injection DepartmentDAO dependency.
	 * This methods permit operation set(writeable) departmnetDAO.
	 */
	public void setDepartmentDAO(DepartmentDAO departmnetDAO) {
		this.departmetDAO = departmnetDAO;
	}
	
	/**
	 * Return list of stead which use to service station departments rent. If
	 * service station(departments) use stead as rent method return list stead
	 * else return null.This method addresses to method in DAO layer for execution
	 * operation.   
	 * 
	 * @type Long
	 * @type List
	 * @param idServiceStation)
	 * 
	 * @return List<Stead> which use(include) in service station.
	 */
	public List<Stead> getListSteadUseServiceStation(Long idServiceStation){
		logger.info("Service:Create list stead which use service station by service station id="+idServiceStation);
		return serviceStationDAO.getListSteadUseServiceStation(idServiceStation);
	}
	
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
	public Double getTotalServiceStationArea(Long idServiceStation){
		logger.info("Service:Count total area which use service station by service station id="+idServiceStation);
		return serviceStationDAO.getTotalServiceStationArea(idServiceStation);
	}
	
	/**
	 * Return list of all service sattion which exist in data base else return null.
	 * This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type List
	 * @return List<ServiceStation> or null.
	 */
	public List<ServiceStation> getAllServiceStation(){
		logger.info("Service:Create list with all service statons.");
		return serviceStationDAO.getAllServiceStation();
	}
	
	/**
	 * Return all departments in service station by id service station
	 * which exist in data base else return null.This methods addresses
	 * to method in DAO layer for execution operation.
	 * 
	 * @type List
	 * @param idServiceStation
	 * @return List<Department> or null.
	 */
	public List<Department> getListDepartmentForServiceStation(Long idServiceStation){
		logger.info("Service:Create list with all departments in service staton.");
		return serviceStationDAO.getListDepartmentForServiceStation(idServiceStation);
	}
	
	/**
	 * Return all employees which work in service station by id service station
	 * else return null.
	 * 
	 * @type Long
	 * @type List
	 * @param idServiceStation
	 * 
	 * @return List<Employee> or null.
	 */
	public List<Employee>getListEmployeeForServiceStation(Long idServiceStation){
		logger.info("Service:Create list with all employees in service staton.");
		return serviceStationDAO.getListEmployeeForServiceStation(idServiceStation);
	}
	
	/**
	 * Return all clients which work in service station by id service station
	 * else return null.
	 * 
	 * @type Long
	 * @type List
	 * @param idServiceStation
	 * 
	 * @return List<Employee> or null.
	 */
	public List<Client>getListClientForServiceStation(Long idServiceStation){
		logger.info("Service:Create list with all clients in service staton.");
		return serviceStationDAO.getListClientForServiceStation(idServiceStation);
	}
	
	/**
	 * Return sum of department expenses on detail which use in departments order
	 * This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type Long
	 * @type Date
	 * @param idDepartment
	 * @param startDate
	 * @param endDate
	 * @return Double sum expenses of the  department on detail form startDate to endDate or zero.
	 */
	public Double getSumExpensesDepartmentOnDetail(Long idDepartment,Date startDate,Date endDate){
		logger.info("Service:Sum expenses on detail for department load.");
		return departmetDAO.getTotalDetailCostForDoneDepartmentOrder(idDepartment, startDate, endDate);
	}
	
	/**
	 * Return sum of department expenses on employee wages. This methods
	 * addresses to method in DAO layer for execution operation.
	 * 
	 * @type Long
	 * @param idDepartment
	 * 
	 * @return Double sum expenses of the  department on employee wages or zero.
	 */
	public Double getSumExpensesDepartmentOnWages(Long idDepartment){
		logger.info("Service:Sum expenses on wages for department load.");
		return departmetDAO.getSumEmployeeWagesForDeportment(idDepartment);
	}
	
	/**
	 * Return sum of department expenses on rent stead. This methods
	 * addresses to method in DAO layer for execution operation.
	 * 
	 * @type Long
	 * @param idDepartment
	 * 
	 * @return Double sum expenses of the department on rent stead.
	 */
	public Double getDepartmentRentExpense(Long idDepartment){
		
		logger.info("Service:Expenses on rent stead for department load.");
		Department department=(Department)departmetDAO.getEntityById(Department.class, idDepartment);
		return department.getStead().getSteadArea()*department.getStead().getSteadCost();
	}
	
	/**
	 * Return sum of department expenses (rent stead and employee wages and
	 * detail. 
	 * 
	 * @type Double
	 * @param detailExpenses
	 * @param wagesExpenses
	 * @param rentExpenses
	 * 
	 * @return (Double) sum expenses of the department on all
	 */
	public Double getSumDepartmentExpenses(Double detailExpenses, Double wagesExpenses,Double rentExpenses){
		logger.info("Service:Sum expenses for department load.");
		return detailExpenses+wagesExpenses+rentExpenses;
	}
	
	/**
	 * Return department income(whithout excluding the departments expenses)
	 * This methods addresses to method in DAO layer for execution operation.
	 * 
	 * @type Long
	 * @type Date
	 * @param idDepartment
	 * @param startDate
	 * @param endDate
	 * 
	 * @return (Double) Department income form startDate to endDate or zero.
	 */
	public Double getDepartamentIncome(Long idDepartment,Date startDate,Date endDate){
		logger.info("Service:Income for department load.");
		return departmetDAO.getFullIncomeForDoneDepartmentOrder(idDepartment, startDate, endDate);
	}
	
	/**
	 * Return department balance(with excluding the departments expenses)
	 * 
	 * @type Double
	 * @param income
	 * @param totalExpenses
	 * 
	 * @return (Double) Department financial balance or zero
	 */
	public Double getDepartmentBalance(Double income, Double totalExpenses){
		logger.info("Service:Balance for department load.");
		Double balance=income-totalExpenses;
		return balance;
	}
	
	/**
	 * Return sum expenses of service station on detail which use in departments orders.
	 * 
	 * @type List<Department>
	 * @type Date
	 * @param listDepartmentsOfServiceStation
	 * @param startDate
	 * @param endDate
	 * 
	 * @return (Double) Service station sum Expenses on detail which use in departments orders or zero.
	 */
	public Double getSumExpensesServiceStationOnDetail(List<Department> listDepartmentsOfServiceStation,Date startDate,Date endDate){
		
		logger.info("Service:Sum expenses on detail for service station load.");
		Double sumExpenseServiceStationOnDetail=0.0;
		for(Department department : listDepartmentsOfServiceStation){
			sumExpenseServiceStationOnDetail+=getSumExpensesDepartmentOnDetail(department.getIdDepartment(), startDate, endDate);
		}
		return sumExpenseServiceStationOnDetail;
	}
	
	/**
	 * Return sum expenses of service station on employee wages.
	 * 
	 * @type List<Department>
	 * @param listDepartmentsOfServiceStation
	 * 
	 * @return (Double) Service station sum Expenses on employee wages or zero.
	 */
	public Double getSumExpensesServiceStationOnWages(List<Department> listDepartmentsOfServiceStation){
		
		logger.info("Service:Sum expenses on wages for service station load.");
		Double sumExpenseServiceStationOnWages=0.0;		
		for(Department department : listDepartmentsOfServiceStation){
			sumExpenseServiceStationOnWages+=getSumExpensesDepartmentOnWages(department.getIdDepartment());
		}
		return sumExpenseServiceStationOnWages;
	}
	
	/**
	 * Return sum expenses of service station on rent.
	 * 
	 * @type List<Department>
	 * @type Date
	 * @param listDepartmentsOfServiceStation
	 * @param startDate
	 * @param endDate
	 * 
	 * @return (Double) sum expenses service station on stead rent or zero.
	 */
	public Double getSumExpensesServiceStationOnRent(List<Department> listDepartmentsOfServiceStation,Date startDate,Date endDate){
		
		logger.info("Service:Sum expenses on stead area for service station load.");
		Double sumExpensesServiceStationRent=0.0;		
		for(Department department : listDepartmentsOfServiceStation){
			sumExpensesServiceStationRent+=getDepartmentRentExpense(department.getIdDepartment());
		}
		return sumExpensesServiceStationRent;
	}
	
	/**
	 * Total expenses of service station.
	 * 
	 * @type Double
	 * @param sumDetailExpenses
	 * @param sumWagesExpenses
	 * @param sumRentExpenses
	 * 
	 * @return (Double) total expenses service station or zero.
	 */
	public Double getTotalServiceStationExpenses(Double sumDetailExpenses, Double sumWagesExpenses,Double sumRentExpenses){
		logger.info("Service:Total sum expenses for service station load.");
		return sumDetailExpenses+sumWagesExpenses+sumRentExpenses;
	}
	
	/**
	 * Return service station income(whithout excluding the service station expenses) .
	 * 
	 * @type List<Department>
	 * @type Date
	 * @param listDepartmentsOfServiceStation
	 * @param startDate
	 * @param endDate
	 * 
	 * @return (Double)service station income or zero.
	 */
	public Double getServiceStationIncome(List<Department> listDepartmentsOfServiceStation,Date startDate,Date endDate){
		
		logger.info("Service: Income for service station load.");
		Double serviceStationIncome=0.0;		
		for(Department department : listDepartmentsOfServiceStation){
			serviceStationIncome+=getDepartamentIncome(department.getIdDepartment(), startDate, endDate);
		}
		return serviceStationIncome;
	}
	
	/**
	 * Return service station financial balance(with excluding the service station expenses) .
	 * 
	 * @type Double
	 * @param serviceStationIncome
	 * @param totalServiceStationExpenses
	 * 
	 * @return (Double) service station financial balance or zero.
	 */
	public Double getServiceStationBalance(Double serviceStationIncome,Double totalServiceStationExpenses){
		logger.info("Service:Balance for service station load.");
		return serviceStationIncome-totalServiceStationExpenses;
	} 
	
	/**
	 * Return procent of same expenses regarding total expenses value
	 * (department or service station).
	 * 
	 * @type Double
	 * @param sameExpense
	 * @param totalExpenses
	 * 
	 * @return (Double) procent of same expenses regarding total expenses value.
	 */
	public Double getProcentExpensesRegardingTotalExpenses(Double sameExpense, Double totalExpenses){
		
		Double procent;
		try{
			procent=(sameExpense/totalExpenses)*100;
		}catch(ArithmeticException e){
			procent=0.0;
			
		}catch(NullPointerException e){
			procent=0.0;
		}
		logger.info("Service:Procent expense "+sameExpense+" of total expense"+totalExpenses+" is "+procent);
		return procent;
	}
	
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
	//show not full path?
	//style?
	public void getFinancialReportForDepartmet(Long idDepartment,Date startDate,Date endDate){
		
		Department department=(Department)departmetDAO.getEntityById(Department.class, idDepartment);
		
		ServiceStation serviceStation=(ServiceStation)serviceStationDAO.getEntityById(ServiceStation.class,
				department.getServiceStation().getIdServiceStation());
		
		//cteate data for table cell
		detailExpenses=getSumExpensesDepartmentOnDetail(idDepartment, startDate, endDate);
		wagesExpenses=getSumExpensesDepartmentOnWages(idDepartment);
		rentExpenses=getDepartmentRentExpense(idDepartment);
		sumDepartmentExpenses=getSumDepartmentExpenses(detailExpenses,wagesExpenses,rentExpenses);
		
		procentExpensesOnDetail=getProcentExpensesRegardingTotalExpenses(detailExpenses,sumDepartmentExpenses);
		procentExpensesOnWages=getProcentExpensesRegardingTotalExpenses(wagesExpenses,sumDepartmentExpenses);
		procentExpensesOnRent=getProcentExpensesRegardingTotalExpenses(rentExpenses,sumDepartmentExpenses);
		
		departmentIncome=getDepartamentIncome(idDepartment, startDate, endDate);
		departmentBalance=getDepartmentBalance(departmentIncome, sumDepartmentExpenses);
		
		String path=null;
		try {
			Document document = new Document(PageSize.TABLOID);
			
			// add document dialog to change path for save.
			JFileChooser chooser = new JFileChooser();
			chooser.setDialogTitle("Select path to save report");
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			chooser.setAcceptAllFileFilterUsed(false);

			if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
				path=chooser.getCurrentDirectory().getAbsolutePath().toString()+"\\"+"DepartmentReport.pdf";
				System.out.println(path);
			}
			
            FileOutputStream fos = new FileOutputStream(path);  
            PdfWriter.getInstance(document, fos);
            document.open();

            //create formete date in document title
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
            
            //create document title
            paragraph = new Paragraph("Financial report for department "+department.getDepartmentName()+"\n"
            +"of service station "+serviceStation.getServiceStationName()+"\n"
            		+"From:"+sdf.format(startDate)+" to "+sdf.format(endDate)+"", titleFont);
            
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            
            //add Correspondence data
            paragraph = new Paragraph(" ");
            document.add(paragraph);
            
            paragraph = new Paragraph("Correspondence data.", textFontBold);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            paragraph.setFirstLineIndent(25);
            document.add(paragraph);

            paragraph = new Paragraph("Address:"+serviceStation.getServiceStationAddress(), textFont);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            paragraph.setFirstLineIndent(25);
            document.add(paragraph);

            paragraph = new Paragraph("Phone:"+serviceStation.getServiceStationPhoneNumber(), textFont);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            paragraph.setFirstLineIndent(25);
            document.add(paragraph);

            paragraph = new Paragraph(" ");
            document.add(paragraph);
       
            //create name to column
            PdfPTable table = new PdfPTable(11);
            PdfPCell cell = null;
       
            cell = new PdfPCell(new Phrase("Department",textFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Detail expenses",textFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("%",textFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Wages expenses",textFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("%",textFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Rent expenses",textFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("%",textFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Total expenses",textFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("%",textFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Income",textFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Balance",textFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            //create date in cell
            table.setHeaderRows(1);
            table.addCell(new PdfPCell(new Phrase(department.getDepartmentName(),textFont)) );
              
            table.addCell(detailExpenses.toString());
            table.addCell(String.format("%.2f", procentExpensesOnDetail));

            table.addCell(wagesExpenses.toString());
            table.addCell(String.format("%.2f", procentExpensesOnWages));
            
            table.addCell(rentExpenses.toString());
            table.addCell(String.format("%.2f", procentExpensesOnRent));
            
            table.addCell(sumDepartmentExpenses.toString());
            table.addCell("100");
            
            table.addCell(departmentIncome.toString());
            table.addCell(departmentBalance.toString());
            
            document.add(table);
            document.close();

        } catch (FileNotFoundException e) {
        	logger.info("Sevice:Department report file not found.");
        } catch (DocumentException e) {
        	logger.info("Service:Department report have error when forming document form.");
        }
	}
	
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
	public void getFinancialReportForServiceStation(Long idServiceStation,Date startDate,Date endDate){

		ServiceStation serviceStation=(ServiceStation)serviceStationDAO.getEntityById(ServiceStation.class,
				idServiceStation);

		List<Department> listDepartmentsOfServiceStation=serviceStationDAO
				.getListDepartmentForServiceStation(idServiceStation);

		String path=null;
		try {
			Document document = new Document(PageSize.TABLOID);
			
			// add document dialog to change path for save.
			JFileChooser chooser = new JFileChooser();
			chooser.setDialogTitle("Select path to save service station report");
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			chooser.setAcceptAllFileFilterUsed(false);

			if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
				path=chooser.getCurrentDirectory().getAbsolutePath().toString()+"\\"+"ServiceStationReport.pdf";
			}
			
			FileOutputStream fos = new FileOutputStream(path);  
			PdfWriter.getInstance(document, fos);
			document.open();

			// create format date in title.
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			
			// add document title.
			paragraph = new Paragraph("Financial report for "+serviceStation.getServiceStationName()+"\n"
					+"From:"+sdf.format(startDate)+" to "+sdf.format(endDate)+"", titleFont);

			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);

			// add correspondence data.
			paragraph = new Paragraph(" ");
			document.add(paragraph); 

			paragraph = new Paragraph("Correspondence data.", textFontBold);
			paragraph.setAlignment(Element.ALIGN_LEFT);
			paragraph.setFirstLineIndent(25);
			document.add(paragraph);

			paragraph = new Paragraph("Address:"+serviceStation.getServiceStationAddress(), textFont);
			paragraph.setAlignment(Element.ALIGN_LEFT);
			paragraph.setFirstLineIndent(25);
			document.add(paragraph);

			paragraph = new Paragraph("Phone:"+serviceStation.getServiceStationPhoneNumber(), textFont);
			paragraph.setAlignment(Element.ALIGN_LEFT);
			paragraph.setFirstLineIndent(25);
			document.add(paragraph);
			
			paragraph = new Paragraph(" ");
			document.add(paragraph);
			
			PdfPTable table = new PdfPTable(11);
			PdfPCell cell = null;

			//add title for columne
			cell = new PdfPCell(new Phrase("Dep. name",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Detail expenses",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("%",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Wages expenses",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("%",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Rent expenses",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("%",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Sum dep.expenses",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("%",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Dep. income",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Dep. balance",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			//create service station data for each department
			table.setHeaderRows(1);     
			for(Department department : listDepartmentsOfServiceStation){

				detailExpenses=getSumExpensesDepartmentOnDetail(department.getIdDepartment(), startDate, endDate);
				wagesExpenses=getSumExpensesDepartmentOnWages(department.getIdDepartment());
				rentExpenses=getDepartmentRentExpense(department.getIdDepartment());
				sumDepartmentExpenses=getSumDepartmentExpenses(detailExpenses,wagesExpenses,rentExpenses);

				procentExpensesOnDetail=getProcentExpensesRegardingTotalExpenses(detailExpenses,sumDepartmentExpenses);
				procentExpensesOnWages=getProcentExpensesRegardingTotalExpenses(wagesExpenses,sumDepartmentExpenses);
				procentExpensesOnRent=getProcentExpensesRegardingTotalExpenses(rentExpenses,sumDepartmentExpenses);

				departmentIncome=getDepartamentIncome(department.getIdDepartment(), startDate, endDate);
				departmentBalance=getDepartmentBalance(departmentIncome, sumDepartmentExpenses);

				table.addCell(new PdfPCell(new Phrase(department.getDepartmentName().toString(),textFont)));
				table.addCell(detailExpenses.toString());
				table.addCell(String.format("%.2f", procentExpensesOnDetail));
				table.addCell(wagesExpenses.toString());
				table.addCell(String.format("%.2f", procentExpensesOnWages));
				table.addCell(rentExpenses.toString());
				table.addCell(String.format("%.2f", procentExpensesOnRent));
				table.addCell(sumDepartmentExpenses.toString());
				table.addCell("100");
				table.addCell(departmentIncome.toString());
				table.addCell(departmentBalance.toString());
			}
			
			///
			///
			///Total value for service station.
			//
			//add empty string for good view
			table.addCell("");
			table.addCell("");
			table.addCell("");
			table.addCell("");
			table.addCell("");
			table.addCell("");
			table.addCell("");
			table.addCell("");
			table.addCell("");
			table.addCell("");
			table.addCell("");
		
			//add title for columne
			cell = new PdfPCell(new Phrase("Service station",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Sum Detail expenses",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("%",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Sum Wages expenses",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("%",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Sum Rent expenses",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("%",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Total expenses",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("%",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Station income",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Station. balance",textFont));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			
			//create service station data for table
			sumDetailExpenses=getSumExpensesServiceStationOnDetail(listDepartmentsOfServiceStation, startDate, endDate);
			sumWagesExpenses=getSumExpensesServiceStationOnWages(listDepartmentsOfServiceStation);
			sumRentExpenses=getSumExpensesServiceStationOnRent(listDepartmentsOfServiceStation, startDate, endDate);
			totalServiceStationExpenses=getTotalServiceStationExpenses(sumDetailExpenses, sumWagesExpenses, sumRentExpenses);
			
			procentExpensesServiceStationOnDetail=getProcentExpensesRegardingTotalExpenses(sumDetailExpenses,totalServiceStationExpenses);
			procentExpensesServiceStationOnWages=getProcentExpensesRegardingTotalExpenses(sumWagesExpenses,totalServiceStationExpenses);
			procentExpensesServiceStationOnRent=getProcentExpensesRegardingTotalExpenses(sumRentExpenses,totalServiceStationExpenses);
			
			serviceStationIncome=getServiceStationIncome(listDepartmentsOfServiceStation, startDate, endDate);
			serviceStationBalance=getServiceStationBalance(serviceStationIncome, totalServiceStationExpenses);
			
			table.addCell(new PdfPCell(new Phrase(serviceStation.getServiceStationName().toString(),textFont)));
			table.addCell(sumDetailExpenses.toString());
			table.addCell(String.format("%.2f", procentExpensesServiceStationOnDetail));
			table.addCell(sumWagesExpenses.toString());
			table.addCell(String.format("%.2f", procentExpensesServiceStationOnWages));
			table.addCell(sumRentExpenses.toString());
			table.addCell(String.format("%.2f", procentExpensesServiceStationOnRent));
			table.addCell(totalServiceStationExpenses.toString());
			table.addCell("100");
			table.addCell(serviceStationIncome.toString());
			table.addCell(serviceStationBalance.toString());
	
			document.add(table);
			document.close();

		} catch (FileNotFoundException e) {
			logger.info("Sevice:Department report file not found.");
		} catch (DocumentException e) {
			logger.info("Service:Department report have error when forming document form.");
		}
	}

}
