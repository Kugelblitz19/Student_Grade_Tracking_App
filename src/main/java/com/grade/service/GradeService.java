package com.grade.service;

import com.grade.entity.Grade;
import com.grade.exception.ResourceNotFoundException;
import com.grade.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GradeService {
    private final GradeRepository gradeRepository;
    @Autowired
    private GradeService(GradeRepository gradeRepository)   {
        this.gradeRepository=gradeRepository;

    }
    public Grade addGrade(Grade grade){
        return gradeRepository.save(grade);
    }
    public List<Grade>getAllGrades(){
        return gradeRepository.findAll();
    }
public Grade getGradeById(Long id){
        return gradeRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Grade Not found with id " + id));

}
public void deleteGradeById(Long studentId){
        gradeRepository.deleteById(studentId);
}
public List<Grade>getGradesByCourseId(Long courseId){
        return gradeRepository.findByCourseId(courseId);
}
public List<Grade>getGradeByStudentId(Long studentId){
        return gradeRepository.findByStudentId(studentId);
}


}
