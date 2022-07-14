package com.example.onlinevoting.Service;

import com.example.onlinevoting.Entity.Election;
import com.example.onlinevoting.Repository.ElectionRepository;
import com.example.onlinevoting.dto.ElectionDto;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Data
public class ElectionService {
    private final ElectionRepository electionRepository;

    public void AddElection(Election election){
        electionRepository.save(election);
    }

    public List<Election> getElection(){
        return electionRepository.findAll();
    }

    public List<ElectionDto> getPresCand(long postion_id){
        return electionRepository.getPesidentsCand(postion_id,LocalDate.now());
    }

    public List<ElectionDto> getPrimeMinCand(long faculty_id,long campus_id,long position_id){
        return electionRepository.getPrimeMinistersCand(faculty_id,campus_id,position_id,LocalDate.now());
    }

    public Election getByCurrentDate(){
        return electionRepository.findByElection_date(LocalDate.now());
    }
}
