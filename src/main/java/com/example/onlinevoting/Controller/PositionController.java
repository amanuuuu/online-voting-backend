package com.example.onlinevoting.Controller;

import com.example.onlinevoting.Entity.Position;
import com.example.onlinevoting.Repository.PositionRepository;
import com.example.onlinevoting.Service.PositionServices;
import com.example.onlinevoting.dto.PositionAllDto;
import com.example.onlinevoting.dto.PositionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@Data
@RestController
@AllArgsConstructor
@RequestMapping(path = "api/position")
public class PositionController {
    @Autowired
    private PositionServices positionServices;
    @Autowired
    private PositionRepository positionRepository;

    @PostMapping("/addposition")
    public void registerPosition(@RequestBody PositionDto position){
        positionServices.addposition(position);
    }

    @GetMapping("/getposition")
    public List<PositionAllDto> getPosition() {
        return positionServices.getAllPosition();
    }

    @GetMapping("/position/{id}")
    public ResponseEntity<Position>getPositionById(@PathVariable long id){
        Position position=positionRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(position);
    }

    @PutMapping("/update")
    public ResponseEntity<Position> updatedPosition(@RequestBody Position position){
        Position updatedPosition = positionRepository.save(position);
        return ResponseEntity.ok(updatedPosition);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")Long id){
        positionRepository.deleteById(id);
    }
}

