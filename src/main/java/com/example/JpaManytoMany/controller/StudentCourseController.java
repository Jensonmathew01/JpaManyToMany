package com.example.JpaManytoMany.controller;

import java.util.List;

import javax.management.loading.ClassLoaderRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JpaManytoMany.entity.Course;
import com.example.JpaManytoMany.entity.Student;
import com.example.JpaManytoMany.repo.Courserepository;
import com.example.JpaManytoMany.repo.Studentrepository;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {

    private Studentrepository studentRepository;

    private Courserepository courseRepository;

    public StudentCourseController(Studentrepository studentRepository,
                                   Courserepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @PostMapping
    public Student saveStudentWithCourse(@RequestBody Student student){
      return   studentRepository.save(student);
    }

    @GetMapping
    public List<Student> findALlStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/{studentId}")
    public Student findStudent(@PathVariable Long studentId){
        return studentRepository.findById(studentId).orElse(null);
    }
    @GetMapping("/find/{name}")
    public List<Student> findStudentsContainingByName(@PathVariable String name){
        return studentRepository.findByNameContaining(name);
    }

    @GetMapping("/search/{price}")
    public List<Course> findCourseLessThanPrice(@PathVariable double price){
        return courseRepository.findByFeeLessThan(price);
    }

}