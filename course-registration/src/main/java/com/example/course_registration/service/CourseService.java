package com.example.course_registration.service;

import com.example.course_registration.model.Course;
import com.example.course_registration.model.CourseRegistry;
import com.example.course_registration.repository.CourseRegistryRepo;
import com.example.course_registration.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepo courseRepo ;

    @Autowired
    CourseRegistryRepo courseRegistryRepo;

    public List<Course> availableCourses(){
        return courseRepo.findAll();
    }

    public void addStudent(Course course) {
        courseRepo.save(course);
    }

    public void addAllStudents(List<Course> courses) {
        courseRepo.saveAll(courses);
    }

    public void deleteAllStudents() {
        courseRepo.deleteAll();
    }

    public List<CourseRegistry> enrolledStudents() {
        return courseRegistryRepo.findAll();
    }

    public void enrollCourse(String name, String email, String courseName) {
        CourseRegistry courseRegistry = new CourseRegistry(name, email, courseName);
        courseRegistryRepo.save(courseRegistry);
    }
}
