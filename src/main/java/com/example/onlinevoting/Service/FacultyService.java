package com.example.onlinevoting.Service;

import com.example.onlinevoting.Entity.Campus;
import com.example.onlinevoting.Entity.Faculty;
import com.example.onlinevoting.Repository.FacultyRepository;
import com.example.onlinevoting.dto.CampusAllDto;
import com.example.onlinevoting.dto.FacultyAllDto;
import com.example.onlinevoting.dto.FacultyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
@AllArgsConstructor
public class FacultyService {
    private final FacultyRepository facultyRepository;
    private final ModelMapper modelMapper;

    public void addFaculty(FacultyDto facultyDto) {
        Faculty faculty = modelMapper.map(facultyDto, Faculty.class);
        facultyRepository.save(faculty);
    }

    public List<FacultyAllDto> getAllFaculty() {
        List<Faculty> faculties = facultyRepository.findAll();
        List<FacultyAllDto> facultyDtos = new ArrayList<>();
        for (Faculty faculty : faculties) {
            facultyDtos.add(modelMapper.map(faculty, FacultyAllDto.class));
        }
        return facultyDtos;
    }
}
