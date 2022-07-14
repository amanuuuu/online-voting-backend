package com.example.onlinevoting.Controller;

import com.example.onlinevoting.Entity.Candidate;
import com.example.onlinevoting.Repository.CandidateRepository;
import com.example.onlinevoting.Service.CandidateService;
import com.example.onlinevoting.dto.CandidateAllDto;
import com.example.onlinevoting.dto.CandidateDto;
import com.example.onlinevoting.dto.Candidate_information;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(path = "api/candidate")

public class CandidateController {
    @Autowired
    private  CandidateService candidateService;
    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping("/addcandidate")

    public void registerCandidate(@ModelAttribute CandidateDto candidate) throws IOException {
        candidateService.addCandidate(candidate);
    }
    @GetMapping("/getcandidate")
    public List<CandidateAllDto> getCandidate(){
        return candidateService.getAllCandidate();
    }
    @GetMapping("/candidate/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable long id){
        Candidate candidate=candidateRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(candidate);
    }

    @PutMapping("/update")
    public ResponseEntity<Candidate> updatedCandidate(@RequestBody Candidate candidate){
        Candidate updatedCandidate = candidateRepository.save(candidate);
        return ResponseEntity.ok(updatedCandidate);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")Long id){
        candidateRepository.deleteById(id);
    }

    @GetMapping("/candidate")
    public List<Candidate_information>getInformation(){
        return candidateService.getAll();
    }

}

