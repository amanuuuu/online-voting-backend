package com.example.onlinevoting.Service;

import com.example.onlinevoting.Entity.Campus;
import com.example.onlinevoting.Entity.Candidate;
import com.example.onlinevoting.Repository.CampusRepository;
import com.example.onlinevoting.dto.CampusAllDto;
import com.example.onlinevoting.dto.CampusDto;
import com.example.onlinevoting.dto.CandidateAllDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
@AllArgsConstructor
public class CampusService {
    private final CampusRepository campusRepository;
    private final ModelMapper modelMapper;

    public void addCampus(CampusDto campusDto){
        Campus campus=modelMapper.map(campusDto ,Campus.class);
        campusRepository.save(campus);
    }
    public List<CampusAllDto> getAllCampus(){
        List<Campus> campuses =campusRepository.findAll();
        List<CampusAllDto> campusDtos=new ArrayList<>();
        for(Campus campus:campuses){
            campusDtos.add(modelMapper.map(campus,CampusAllDto.class));
        }
        return campusDtos;
    }
}
