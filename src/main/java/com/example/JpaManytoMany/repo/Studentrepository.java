package com.example.JpaManytoMany.repo;


import com.example.JpaManytoMany.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Studentrepository extends JpaRepository<Student,Long> {

    List<Student> findByNameContaining(String name);
}
