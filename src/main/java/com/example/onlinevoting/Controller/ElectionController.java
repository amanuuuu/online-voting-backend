package com.example.onlinevoting.Controller;

import com.example.onlinevoting.Entity.Election;
import com.example.onlinevoting.Service.ElectionService;
import com.example.onlinevoting.dto.ElectionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin
@Data
@AllArgsConstructor
@RequestMapping(path = "election")
public class ElectionController {
    private ElectionService electionService;

    @RequestMapping(path = "post",method = RequestMethod.POST)
    public void addElection(@RequestBody Election election){
        electionService.AddElection(election);
    }

    @RequestMapping(path = "get",method = RequestMethod.GET)
    public List<Election> getElection(){
        return  electionService.getElection();
    }

    @RequestMapping(path = "president/{position_id}",method = RequestMethod.GET)
    public List<ElectionDto> getPresidCand(@PathVariable("position_id") long position_id){
        return electionService.getPresCand(position_id);
    }

    @RequestMapping(path = "primemin/faculty/{faculty_id}/campus/{campus_id}/position/{position_id}",method = RequestMethod.GET)
    public List<ElectionDto> getPrimeMinCand(@PathVariable("faculty_id") long faculty_id,@PathVariable("campus_id") long campus_id,@PathVariable("position_id") long position_id){
        return electionService.getPrimeMinCand(faculty_id,campus_id,position_id);
    }

    @RequestMapping(path = "date",method = RequestMethod.GET)
    public Election getByCurrentDate(){
        return electionService.getByCurrentDate();
    }
}
