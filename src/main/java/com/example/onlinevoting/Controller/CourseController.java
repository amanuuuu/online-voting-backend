package com.example.onlinevoting.Controller;

import com.example.onlinevoting.Entity.Campus;
import com.example.onlinevoting.Entity.Course;
import com.example.onlinevoting.Repository.CourseRepository;
import com.example.onlinevoting.Service.CourseService;
import com.example.onlinevoting.dto.CampusDto;
import com.example.onlinevoting.dto.CourseAllDto;
import com.example.onlinevoting.dto.CourseDto;
import com.example.onlinevoting.dto.ViewCourse;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@Data
@RestController
@RequestMapping(path = "api/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/addcourse")
    public void registerCourse(@RequestBody CourseDto course){
        courseService.addCourse(course);
    }
    @GetMapping("/getcourse")
    public List<CourseAllDto> getCourse(){
        return courseService.getAllCourse();
    }
    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable long id){
        Course course=courseRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(course);
    }

    @PutMapping("/update")
    public ResponseEntity<Course> updatedCourse(@RequestBody Course course){
        Course updatedCourse = courseRepository.save(course);
        return ResponseEntity.ok(updatedCourse);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")Long id){
        this.courseRepository.deleteById(id);
    }

    @GetMapping("/getcourses")
    public List<ViewCourse>getcourses(){
        return courseService.getcourse();
    }
}
