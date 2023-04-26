package com.springrest.springrest.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.springrest.springrest.entities.Course;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class CourseServiceImpl implements CourseService{

	List<Course> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(1,"Java","This course contains basics of java"));
		list.add(new Course(2,"Cpp","This course contains basics of cpp"));
		
	}
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}
	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		Course c=null;
		for(Course course:list) {
			if(course.getId()==courseId){
				c=course;
				break;
			}
		}
		return c;
	}
	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		list.add(course);
		return course;
	}
	@Override
	public Course updateCourse(long courseId,Course courseNew) {
		// TODO Auto-generated method stub
		for(Course course:list) {
			if(course.getId()==courseId) {
				course.setTitle(courseNew.getTitle());
				course.setDesciption(courseNew.getDesciption());
				break;
				
			}
		}

		return courseNew;
	}
	@Override
	public List<Course> deleteCourse(long courseId) {
		// TODO Auto-generated method stub
		list=this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
		return list;
	}
	
	public List<Course> generateCourses() {
		List<Course> courselist = new ArrayList<Course>();
		courselist.add(new Course(1,"Java","This course contains basics of java"));
		courselist.add(new Course(2,"Cpp","This course contains basics of cpp"));
		return courselist;
		
//		return Arrays.asList(
//				new Course(1,"Java","This course contains basic of java"),
//				new Course(2,"AWS","This course contains basic of AWS"),
//				new Course(3,"Cpp","This course contains basic of Cpp")
//				
//				);
		
				
	}
	public String exportReport(String format) throws FileNotFoundException, JRException {
		List<Course> courseList=getCourses();		
		String path="C://Users//NEX2IZY//Desktop//Study Material//spring_workspace//JasperReports//";//location where report will be genrated
		File file=ResourceUtils.getFile("classpath:CourseData.jrxml");//load the file from this path
		JasperReport jasper=JasperCompileManager.compileReport(file.getAbsolutePath());//compiling the file
		JRBeanCollectionDataSource ds =new JRBeanCollectionDataSource(courseList);//mapping list of user to the jasper report field
		Map<String, Object> parameter=new HashMap<String, Object>();
		parameter.put("gain java", "Knowledge");
		JasperPrint jasperPrint=JasperFillManager.fillReport(jasper,parameter,ds);//fill the report data into file
		
		if(format.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint,path+"//CourseData.pdf");//format in which we want to generate the report
		}
		if(format.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"//CourseData.html");
		}
	
				return "path: "+path;// return path where file is saved
	}
	
	
		
		



}