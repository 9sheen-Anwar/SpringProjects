package com.springrest.springrest.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
@RequestMapping("/course-api")
public class MyController {
	
	@Autowired 
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to Courses Application";
	}
	
	//get the courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseService.getCourses();		
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
		
	}
	
	@PutMapping("/courses/{courseId}")
	public Course updateCourse(@PathVariable String courseId,@RequestBody Course course) {
		
		return this.courseService.updateCourse(Long.parseLong(courseId),course);
	}
	
	/*@DeleteMapping("/courses/{courseId}")
	public List<Course> deleteCourse(@PathVariable String courseId) {
		return this.courseService.deleteCourse(Long.parseLong(courseId));
	}*/
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping(value = "courses/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<byte[]> downloadReport() throws JRException, IOException {

		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(courseService.getCourses());

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("courses", "Data");

		JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/Report.jrxml"));
				

		JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters, beanCollectionDataSource);

		// JasperExportManager.exportReportToPdfFile(jasperPrint,
		// System.currentTimeMillis() + ".pdf");

		byte data[] = JasperExportManager.exportReportToPdf(jasperPrint);//to load the pdf file in browser, it return byte array

		System.err.println(data);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=coursesreportnew.pdf");//forcing browser to download the pdf file

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
	}
}
