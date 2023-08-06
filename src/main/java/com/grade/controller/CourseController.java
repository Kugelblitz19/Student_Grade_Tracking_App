package com.grade.controller;

import com.grade.entity.Course;
import com.grade.entity.Student;
import com.grade.repository.CourseRepository;
import com.grade.service.CourseService;
import lombok.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService){
        this.courseService=courseService;
    }
    @PostMapping
    public ResponseEntity<Course>addCourse(@RequestBody Course course){
        Course newCourse=courseService.addCourse(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }
    @GetMapping
   public ResponseEntity<List<Course>>getAllCourse(){
        List<Course>courses=courseService.getAllCourses();
        return new ResponseEntity<>(courses,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Course>getCourseById(@PathVariable Long id){
        Course course=courseService.getCoursesById(id);
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void>deleteCourseById(@PathVariable Long id){
        courseService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{id}/students")
    public ResponseEntity<List<Student>>getCourseStudents(@PathVariable Long id){
        List<Student>students=courseService.getCourseStudent(id);
        return new ResponseEntity<>(students,HttpStatus.OK);
    }
}
