package com.example.onlinevoting.Service;

import com.example.onlinevoting.Entity.Position;
import com.example.onlinevoting.Repository.PositionRepository;
import com.example.onlinevoting.dto.PositionAllDto;
import com.example.onlinevoting.dto.PositionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
@AllArgsConstructor
public class PositionServices {
    private final PositionRepository positionRepository;
    private final ModelMapper modelMapper;

    public void addposition(PositionDto positionDto){
        Position position=modelMapper.map(positionDto,Position.class);
        positionRepository.save(position);
    }

    public List<PositionAllDto> getAllPosition(){
        List<Position> islands=positionRepository.findAll();
        List<PositionAllDto> positionDtos=new ArrayList<>();
        for(Position position :islands) {
            positionDtos.add(modelMapper.map(position, PositionAllDto.class));

        }
        return positionDtos;
    }

}

