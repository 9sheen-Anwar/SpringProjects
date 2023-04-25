package com.springrest.springrest.services;

import java.io.FileNotFoundException;
import java.util.List;

import com.springrest.springrest.entities.Course;

import net.sf.jasperreports.engine.JRException;

public interface CourseService {
	
	public List<Course> getCourses();
	public Course getCourse(long courseId);
	public Course addCourse(Course course);
	public Course updateCourse(long courseId,Course course);
	public List<Course> deleteCourse(long courseId);
	public List<Course> generateCourses();
	public String exportReport(String format) throws FileNotFoundException, JRException;
	

}
