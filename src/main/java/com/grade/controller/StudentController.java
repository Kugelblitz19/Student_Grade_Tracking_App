package com.grade.controller;

import com.grade.entity.Grade;
import com.grade.entity.Student;
import com.grade.service.StudentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    private StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @PostMapping
    public ResponseEntity<Student>addStudent(@RequestBody Student student){
        Student newStudent=studentService.addStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }
    @GetMapping
public  ResponseEntity<List<Student>>getAllStudents(){
        List<Student>students=studentService.getAllStudents();
        return new ResponseEntity<>(students,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student>getStudentById(@PathVariable Long id){
        Student student=studentService.getStudentById(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteStudentsById(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{id}/grades")
    public ResponseEntity<List<Grade>>getStudentsGrades(@PathVariable Long id){
        List<Grade>grades=studentService.getStudentGrades(id);
        return new ResponseEntity<>(grades,HttpStatus.OK);
    }
}
