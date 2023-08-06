package com.grade.service;

import com.grade.entity.Course;
import com.grade.entity.Student;
import com.grade.exception.ResourceNotFoundException;
import com.grade.repository.CourseRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    @Autowired
    public CourseService(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
    }
    public Course addCourse(Course course){
        return courseRepository.save(course);

    }
    public List<Course> getAllCourses(){
      return   courseRepository.findAll();
    }
    public Course getCoursesById(Long id){
        return courseRepository.findById(id).orElseThrow
                (()->new ResourceNotFoundException("Course not found with id: " + id));

    }
    public void deleteStudentById(Long id){
        courseRepository.deleteById(id);
    }
    public List<Student>getCourseStudent(Long courseId){
        Course course=getCoursesById(courseId);
        return course.getStudents();
    }
}
