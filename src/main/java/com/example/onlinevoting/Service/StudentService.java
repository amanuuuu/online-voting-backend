package com.example.onlinevoting.Service;

import com.example.onlinevoting.Entity.Student;
import com.example.onlinevoting.Entity.User;
import com.example.onlinevoting.Repository.StudentRepository;
import com.example.onlinevoting.dto.StudentAllDto;
import com.example.onlinevoting.dto.StudentDto;
import com.example.onlinevoting.dto.StudentValidation;
import com.example.onlinevoting.dto.ViewStudent;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentsRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    public void addStudent(StudentDto studentsDto){
        Student students=modelMapper.map(studentsDto, Student.class);
        User user = modelMapper.map(studentsDto,User.class);
        user.setRole("student");
        userService.addUser(user);
        studentsRepository.save(students);
    }
    public List<StudentAllDto> getAllStudent(){
        List<Student> students =studentsRepository.findAll();
        List<StudentAllDto> studentDtos=new ArrayList<>();
        for(Student student:students){
            studentDtos.add(modelMapper.map(student, StudentAllDto.class));
        }
        return studentDtos;
    }

    public List<ViewStudent> getAll(){
        return studentsRepository.getall();
    }

    public StudentValidation getstudentByReg_no(String reg_no){
        return studentsRepository.getStudentByRegistration(reg_no);
    }

    public int voted(){
        return studentsRepository.voted();
    }

}

