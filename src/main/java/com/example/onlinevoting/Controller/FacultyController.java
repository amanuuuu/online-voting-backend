package com.example.onlinevoting.Controller;

import com.example.onlinevoting.Entity.Faculty;
import com.example.onlinevoting.Repository.FacultyRepository;
import com.example.onlinevoting.Service.FacultyService;
import com.example.onlinevoting.dto.FacultyAllDto;
import com.example.onlinevoting.dto.FacultyDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Data
@RestController
@RequestMapping(path = "api/faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private FacultyRepository facultyRepository;

    @PostMapping("/addfaculty")
    public void registerFaculty(@RequestBody FacultyDto faculty) {
        facultyService.addFaculty(faculty);
    }

    @GetMapping("/getfaculty")
    public List<FacultyAllDto> getFaculty() {
        return facultyService.getAllFaculty();
    }

    @GetMapping("/faculty/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable long id) {
        Faculty faculty = facultyRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(faculty);
    }

    @PutMapping("/update")
    public ResponseEntity<Faculty> updatedFaculty(@RequestBody Faculty faculty) {
        Faculty updatedFaculty = facultyRepository.save(faculty);
        return ResponseEntity.ok(updatedFaculty);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        facultyRepository.findById(id);
    }
}
