package com.example.onlinevoting.Repository;

import com.example.onlinevoting.Entity.Course;
import com.example.onlinevoting.dto.ViewCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course ,Long> {
    @Query(value = "SELECT course.course_id,course.course_name,campus.campus_name,faculty.faculty_name FROM course,campus,faculty " +
            "WHERE course.faculty_id=faculty.faculty_id AND course.campus_id=campus.campus_id",nativeQuery = true)
    public List<ViewCourse> getCourse();
}
