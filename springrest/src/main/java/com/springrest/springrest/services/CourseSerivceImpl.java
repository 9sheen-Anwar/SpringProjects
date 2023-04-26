 package com.springrest.springrest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseSerivceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	//List<Course> list;
	public CourseSerivceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(1,"Java","This course contains basic of java"));
//		list.add(new Course(2,"Cpp","This course contains basic of cpp"));
//		
	}
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}
	
	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
//		Course c=null;
//		for(Course course:list) {
//			if(course.getId()==courseId){
//				c=course;
//				break;
//			}
//		}
		return courseDao.findById(courseId).get();
		
	}
	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
//		list.add(course);
		courseDao.save(course);
		return course;
	}
	@Override
	public Course updateCourse(long courseId,Course courseNew) {
		// TODO Auto-generated method stub
//		for(Course course:list) {
//			if(course.getId()==courseId) {
//				course.setTitle(courseNew.getTitle());
//				course.setDesciption(courseNew.getDesciption());
//				break;
//				
//			}
//		}
		courseDao.save(courseNew);
		return courseNew;
	}

	@Override
	public void deleteCourse(long courseId) {
//		// TODO Auto-generated method stub
//		list=this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
		Course entity=courseDao.findById(courseId).get();
		courseDao.delete(entity);
	}

}
