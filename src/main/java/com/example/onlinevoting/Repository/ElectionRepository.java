package com.example.onlinevoting.Repository;

import com.example.onlinevoting.Entity.Election;
import com.example.onlinevoting.dto.ElectionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ElectionRepository extends JpaRepository<Election,Long> {

    @Query(value = "SELECT candidate.candidate_id, candidate.image,student.first_name,student.middle_name,student.last_name FROM " +
            "election,candidate,student,faculty,campus,course " +
            "WHERE election.election_id = candidate.election_id " +
            "and student.std_id = candidate.student_id and" +
            " faculty.faculty_id = course.faculty_id and campus.campus_id=course.campus_id and " +
            "student.course_id =course.course_id AND candidate.position_id =?1 AND election.election_date= ?2",nativeQuery = true)
    public List<ElectionDto> getPesidentsCand(long position_id,LocalDate date);


    @Query(value = "SELECT candidate.candidate_id, candidate.image,student.first_name,student.middle_name," +
            "student.last_name FROM election,candidate,student,faculty,campus,course" +
            " WHERE election.election_id = candidate.election_id " +
            "and student.std_id = candidate.student_id and faculty.faculty_id = course.faculty_id and" +
            " campus.campus_id=course.campus_id and student.course_id =course.course_id " +
            "and faculty.faculty_id = ? AND campus.campus_id = ? AND candidate.position_id =? AND election.election_date=?",nativeQuery = true)
    public List<ElectionDto> getPrimeMinistersCand(long faculty_id,long campus_id,long position_id,LocalDate date);
    @Query(value = "SELECT * FROM `election` WHERE election_date = ?",nativeQuery = true)
    public Election findByElection_date(LocalDate date);


}
