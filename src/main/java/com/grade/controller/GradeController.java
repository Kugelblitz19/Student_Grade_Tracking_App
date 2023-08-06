package com.grade.controller;

import com.grade.entity.Grade;
import com.grade.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.RedisSessionProperties;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {
    private final GradeService gradeService;
    @Autowired
    public GradeController(GradeService gradeService){
        this.gradeService=gradeService;
    }
    @PostMapping
    public ResponseEntity<Grade>addGrade(@RequestBody Grade grade){
        Grade newGrade=gradeService.addGrade(grade);
        return new ResponseEntity<>(newGrade, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Grade>> getAllGrades() {
        List<Grade> grades = gradeService.getAllGrades();
        return new ResponseEntity<>(grades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Long id) {
        Grade grade = gradeService.getGradeById(id);
        return new ResponseEntity<>(grade, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGradeById(@PathVariable Long id) {
        gradeService.deleteGradeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Additional endpoints based on application requirements:

    @GetMapping("/students/{studentId}")
    public ResponseEntity<List<Grade>> getGradesByStudentId(@PathVariable Long studentId) {
        List<Grade> grades = gradeService.getGradeByStudentId(studentId);
        return new ResponseEntity<>(grades, HttpStatus.OK);
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<List<Grade>> getGradesByCourseId(@PathVariable Long courseId) {
        List<Grade> grades = gradeService.getGradesByCourseId(courseId);
        return new ResponseEntity<>(grades, HttpStatus.OK);
    }
}
