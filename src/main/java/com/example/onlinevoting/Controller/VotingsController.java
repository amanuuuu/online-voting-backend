package com.example.onlinevoting.Controller;

import com.example.onlinevoting.Entity.Votings;
import com.example.onlinevoting.Service.VotingsService;
import com.example.onlinevoting.dto.VoteResult;
import com.example.onlinevoting.dto.VotingsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@Data
@AllArgsConstructor
@RestController
@RequestMapping(path = "voting")
public class VotingsController {

    private VotingsService votingsService;

    @RequestMapping(path = "post",method = RequestMethod.POST)
    public void addVotings(@RequestBody VotingsDto votingsDto){
        votingsService.addVotes(votingsDto);
    }

    @RequestMapping(path = "president",method = RequestMethod.POST)
    public void presidentVote(@RequestBody VotingsDto votingsDto){
        votingsService.presidentVote(votingsDto);
    }

    @RequestMapping(path = "primeminister",method = RequestMethod.POST)
    public void prime_ministersVotings(@RequestBody VotingsDto votingsDto){
        votingsService.primeMinisterVote(votingsDto);
    }

    @RequestMapping(path = "presiVotes/p_id/{positon_id}/date/{date}",method = RequestMethod.GET)
    public List<VoteResult> getPresiResult(@PathVariable("positon_id") long positon_id, @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return votingsService.getPresiResult(positon_id,date);
    }


    @RequestMapping(path = "primeResult/f_id/{faculty_id}/c_id/{campus_id}/p_id/{positon_id}/date/{date}")
    public List<VoteResult> getPrimeResult(@PathVariable("faculty_id") long faculty_id,@PathVariable("campus_id")long campus_id,@PathVariable("positon_id")long position_id,@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate date){
        return votingsService.getPrimeResult(faculty_id,campus_id,position_id,date);
    }
}
