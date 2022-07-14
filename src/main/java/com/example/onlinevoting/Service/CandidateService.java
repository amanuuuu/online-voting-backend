package com.example.onlinevoting.Service;


import com.example.onlinevoting.Entity.Candidate;
import com.example.onlinevoting.Repository.CandidateRepository;
import com.example.onlinevoting.dto.CandidateAllDto;
import com.example.onlinevoting.dto.CandidateDto;
import com.example.onlinevoting.dto.Candidate_information;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Data
@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;
    private final ModelMapper modelMapper;

    public void addCandidate(CandidateDto candidateDto) throws IOException {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        Candidate candidate =modelMapper.map(candidateDto,Candidate.class);
        candidate.setImage(Base64.getEncoder().encodeToString(candidateDto.getImage().getBytes()));
        candidateRepository.save(candidate);
    }
    public List<CandidateAllDto> getAllCandidate(){
        List<Candidate> candidates =candidateRepository.findAll();
        List<CandidateAllDto> candidateDtos=new ArrayList<>();
        for(Candidate candidate:candidates){
            candidateDtos.add(modelMapper.map(candidate,CandidateAllDto.class));
        }
        return candidateDtos;
    }
    public List<Candidate_information> getAll(){
        return candidateRepository.getInformation();
    }
}
