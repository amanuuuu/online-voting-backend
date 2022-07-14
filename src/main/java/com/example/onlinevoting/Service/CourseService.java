package com.example.onlinevoting.Service;

import com.example.onlinevoting.Entity.Campus;
import com.example.onlinevoting.Entity.Course;
import com.example.onlinevoting.Repository.CourseRepository;
import com.example.onlinevoting.dto.CampusAllDto;
import com.example.onlinevoting.dto.CourseAllDto;
import com.example.onlinevoting.dto.CourseDto;
import com.example.onlinevoting.dto.ViewCourse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public void addCourse(CourseDto courseDto){
        Course course=modelMapper.map(courseDto,Course.class);
        courseRepository.save(course);
    }
    public List<CourseAllDto> getAllCourse(){
        List<Course> courses=courseRepository.findAll();
        List<CourseAllDto> courseDtos=new ArrayList<>();
        for(Course course:courses){
            courseDtos.add(modelMapper.map(courses,CourseAllDto.class));
        }
        return courseDtos;
    }
    public List<ViewCourse>getcourse(){
        return courseRepository.getCourse();
    }
}
