package com.example.onlinevoting.Repository;

import com.example.onlinevoting.Entity.Candidate;
import com.example.onlinevoting.dto.Candidate_information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface
CandidateRepository extends JpaRepository<Candidate,Long> {
    @Query(value = "SELECT candidate.candidate_id ,candidate.gpa, candidate.image,position.position_name,student.reg_no,student.first_name,student.middle_name,student.last_name,student.gender, student.phone_number,course.course_name,faculty.faculty_name,campus.campus_name from candidate,position,student,course,faculty,campus where candidate.student_id=student.std_id and faculty.faculty_id=course.faculty_id and campus.campus_id=course.campus_id and position.position_id = candidate.position_id and course.course_id =student.course_id",nativeQuery = true)
    public List<Candidate_information> getInformation();
}
