package com.example.JpaManytoMany.repo;

import com.example.JpaManytoMany.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Courserepository extends JpaRepository<Course, Long> {

    List<Course> findByFeeLessThan(double fee);
}
