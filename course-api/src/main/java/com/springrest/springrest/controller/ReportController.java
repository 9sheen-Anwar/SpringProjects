//package com.springrest.springrest.controller;
//
//import java.io.FileInputStream;
//import java.util.HashMap;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.springrest.springrest.services.CourseServiceImpl;
//
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.engine.design.JasperDesign;
//
//@RestController
//public class ReportController {
//	
//	@GetMapping("/pdf")
//	public String generatePdf() throws Exception, JRException {
//		JRBeanCollectionDataSource beanCollectionDatasource=new JRBeanCollectionDataSource(CourseServiceImpl.generateCourses());
//		JasperReport compileReport=JasperCompileManager.compileReport(new FileInputStream("src/main/resources/CourseData.jrxml"));
//		
//		HashMap<String, Object> map=new HashMap<>();
//		JasperPrint report=JasperFillManager.fillReport(compileReport, null,beanCollectionDatasource);
//		JasperExportManager.exportReportToPdfFile(report,"CourseData.pdf");
//		return "generated";
//		
//	}
//
//}
