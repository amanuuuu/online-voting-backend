package com.example.onlinevoting.Repository;

import com.example.onlinevoting.Entity.Student;
import com.example.onlinevoting.dto.StudentValidation;
import com.example.onlinevoting.dto.ViewStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>  {
    @Query(value = "SELECT student.*,course.course_name,faculty.faculty_name,campus.campus_name from student,course,faculty,campus where student.course_id=course.course_id and " +
            "course.faculty_id=faculty.faculty_id and course.campus_id=campus.campus_id",
            nativeQuery = true)
    public List<ViewStudent> getall();

    @Query(value = "SELECT student.std_id,student.reg_no,student.first_name,faculty.faculty_id,campus.campus_id," +
            "student.voted_president,student.voted_prime_minister " +
            "FROM student,faculty,campus,course WHERE faculty.faculty_id = course.faculty_id " +
            "and campus.campus_id=course.campus_id and student.course_id = course.course_id and reg_no =?1",nativeQuery = true)
    public StudentValidation getStudentByRegistration(String reg_no);

    @Query(value = "SELECT COUNT(std_id)  FROM `student` WHERE student.voted_president=1 OR student.voted_prime_minister=1",nativeQuery = true)
    public int voted();
}


