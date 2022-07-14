package com.example.onlinevoting.Repository;

import com.example.onlinevoting.Entity.Votings;
import com.example.onlinevoting.dto.VoteResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface VotingsRepository extends JpaRepository<Votings,Long> {
    @Query(value = "SELECT student.first_name,student.middle_name,student.last_name,position.position_name,COUNT(votings.std_id)as votes,campus.campus_name from student,candidate,position,votings,campus,course,election WHERE election.election_id = candidate.election_id and student.std_id=candidate.student_id and candidate.position_id=position.position_id and votings.candidate_id =candidate.candidate_id and campus.campus_id=course.campus_id and student.course_id=course.course_id and position.position_id=?1 and election.election_date=?2 GROUP BY votings.candidate_id",nativeQuery = true)
    public List<VoteResult> getPresiResult(long position_id, LocalDate date);

    @Query(value = "SELECT student.first_name,student.middle_name,student.last_name,position.position_name,COUNT(votings.std_id)as votes,campus.campus_name from student,candidate,position,votings,campus,course,election,faculty WHERE election.election_id = candidate.election_id and student.std_id=candidate.student_id and candidate.position_id=position.position_id and votings.candidate_id =candidate.candidate_id and campus.campus_id=course.campus_id and student.course_id=course.course_id and faculty.faculty_id=?1 and course.course_id=?2 and position.position_id=?3 and election.election_date=?4 GROUP BY votings.candidate_id",nativeQuery = true)
    public List<VoteResult> getPrimeResult(long faculty_id,long campus_id,long position_id,LocalDate date);
}
