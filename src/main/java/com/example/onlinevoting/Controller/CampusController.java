package com.example.onlinevoting.Controller;

import com.example.onlinevoting.Entity.Campus;
import com.example.onlinevoting.Repository.CampusRepository;
import com.example.onlinevoting.Service.CampusService;
import com.example.onlinevoting.dto.CampusAllDto;
import com.example.onlinevoting.dto.CampusDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Data
@RestController
@RequestMapping(path = "api/campus")
public class CampusController {

    @Autowired
    private CampusService campusService;
    @Autowired
    private CampusRepository campusRepository;

    @PostMapping("/addcampus")
        public void registerCampus(@RequestBody CampusDto campus){
        campusService.addCampus(campus);
    }
    @GetMapping("/getcampus")
      public List<CampusAllDto> getCampus(){
        return campusService.getAllCampus();
    }
    @GetMapping("/campus/{id}")
    public ResponseEntity<Campus> getCampusById(@PathVariable long id){
        Campus campus=campusRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(campus);
    }

    @PutMapping("/update")
    public ResponseEntity<Campus> updatedCampus(@RequestBody Campus campus){
        Campus updatedCampus = campusRepository.save(campus);
        return ResponseEntity.ok(updatedCampus);
    }
    @DeleteMapping("/delete/{id}")
     public void delete(@PathVariable("id")Long id){
        campusRepository.deleteById(id);
    }

}
