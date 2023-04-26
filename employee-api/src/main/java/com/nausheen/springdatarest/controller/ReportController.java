package com.nausheen.springdatarest.controller;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
public class ReportController {
	@Autowired
	private DataSource dataSource;
	@GetMapping("/employee/pdf")
	public ResponseEntity<byte[]> getEmployeeReport() throws FileNotFoundException, JRException, SQLException{
	JasperPrint empReport=JasperFillManager.fillReport
			(
					JasperCompileManager.compileReport(
							ResourceUtils.getFile("classpath:testReport.jrxml").
								getAbsolutePath()), null, dataSource.getConnection()
					
					);
	HttpHeaders headers = new HttpHeaders();
	//set the PDF format
	headers.setContentType(MediaType.APPLICATION_PDF);
	headers.setContentDispositionFormData("filename", "employeesReport.pdf");
	//create the report in PDF format
	return new ResponseEntity<byte[]>
			(JasperExportManager.exportReportToPdf(empReport), headers, HttpStatus.OK);


}
}
