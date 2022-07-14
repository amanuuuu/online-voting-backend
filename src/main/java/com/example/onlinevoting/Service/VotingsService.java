package com.example.onlinevoting.Service;

import com.example.onlinevoting.Entity.Student;
import com.example.onlinevoting.Entity.Votings;
import com.example.onlinevoting.Repository.StudentRepository;
import com.example.onlinevoting.Repository.VotingsRepository;
import com.example.onlinevoting.dto.VoteResult;
import com.example.onlinevoting.dto.VotingsDto;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Data
@Service
public class VotingsService {
    private final VotingsRepository votingsRepository;
    private final StudentRepository studentsRepository;
    private  final ModelMapper modelMapper;
    public void addVotes(VotingsDto votingsDto){
        Votings votings = modelMapper.map(votingsDto,Votings.class);
        votingsRepository.save(votings);
    }

    public void primeMinisterVote(VotingsDto votingsDto){
        Student student = studentsRepository.getById(votingsDto.getStd_id());
        Votings votings = modelMapper.map(votingsDto,Votings.class);
        votings.setVoteDate(LocalDate.now());
        votingsRepository.save(votings);
        student.setVoted_prime_minister(true);
        studentsRepository.save(student);
    }

    public void presidentVote(VotingsDto votingsDto){
        Student student = studentsRepository.getById(votingsDto.getStd_id());
        Votings votings = modelMapper.map(votingsDto,Votings.class);
        votings.setVoteDate(LocalDate.now());
        votingsRepository.save(votings);
        student.setVoted_president(true);
        studentsRepository.save(student);
    }

    public List<VoteResult> getPresiResult(long position_id,LocalDate date){
        return votingsRepository.getPresiResult(position_id,date);
    }

    public List<VoteResult> getPrimeResult(long faculty_id,long campus_id,long position_id,LocalDate date){
        return votingsRepository.getPrimeResult(faculty_id,campus_id,position_id,date);
    }
}
