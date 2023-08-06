package com.grade.service;

import com.grade.entity.Grade;
import com.grade.entity.Student;
import com.grade.exception.ResourceNotFoundException;
import com.grade.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;

    }
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }
    public List<Student>getAllStudents(){
        return studentRepository.findAll();
    }
    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student Not found with id "+ id));

    }
    public void deleteStudentsById(Long id){
         studentRepository.deleteById(id);
    }
    public List<Grade>getStudentGrades(Long studentId)  {
        Student student=getStudentById(studentId);
        return student.getGrades();
    }
}
