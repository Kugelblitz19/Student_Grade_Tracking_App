package com.grade.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private LocalDate dob;
    private String email;
    private LocalDate enrollmentDate;
    @ManyToMany
    @JoinTable(name = "student_course",joinColumns = @JoinColumn(name = "student_id"),inverseJoinColumns =
    @JoinColumn(name = "course_id"))
    private List<Course>courses;
    @OneToMany(mappedBy = "student")
    private List<Grade>grades;
}
