package com.example.course_registration.repository;

import com.example.course_registration.model.CourseRegistry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRegistryRepo extends JpaRepository<CourseRegistry, Integer> {

}
