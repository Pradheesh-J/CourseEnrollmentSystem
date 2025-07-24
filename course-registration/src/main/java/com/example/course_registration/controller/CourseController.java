package com.example.course_registration.controller;

import com.example.course_registration.model.Course;
import com.example.course_registration.model.CourseRegistry;
import com.example.course_registration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500" )
public class CourseController {
    @Autowired
    CourseService courseService;
    @GetMapping("courses")
    public List<Course> availableCourses(){
        return courseService.availableCourses();
    }
    @GetMapping("courses/enrolled")
    public List<CourseRegistry> enrolledStudents(){
        return courseService.enrolledStudents();
    }
    @PostMapping("courses/register")
    public ResponseEntity<String> enrollCourse(@RequestParam("name") String name ,
                                               @RequestParam("emailId") String email,
                                               @RequestParam("courseName") String courseName){
        courseService.enrollCourse(name, email, courseName);
        return new ResponseEntity<>("Successfully enrolled "+ name + " for "+ courseName, HttpStatus.CREATED);
    }


}
