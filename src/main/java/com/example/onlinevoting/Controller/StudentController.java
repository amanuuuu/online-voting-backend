package com.example.onlinevoting.Controller;

import com.example.onlinevoting.Entity.Position;
import com.example.onlinevoting.Entity.Student;
import com.example.onlinevoting.Repository.StudentRepository;
import com.example.onlinevoting.Service.StudentService;
import com.example.onlinevoting.dto.StudentAllDto;
import com.example.onlinevoting.dto.StudentDto;
import com.example.onlinevoting.dto.StudentValidation;
import com.example.onlinevoting.dto.ViewStudent;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@Data
@RestController
@RequestMapping(path = "api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/addstudent")
    public void registerStudent(@RequestBody StudentDto student){
        studentService.addStudent(student);
    }
    @GetMapping("/getstudent")
    public List<StudentAllDto> getStudent(){
     return studentService.getAllStudent();
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        Student student=studentRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(student);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updatedStudent(@RequestBody Student student){
        Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")Long id){
        studentRepository.deleteById(id);
    }

    @GetMapping("/student")
    public List<ViewStudent> getall(){
        return studentService.getAll();
    }

    @GetMapping("/verify/{reg_no}")
    public StudentValidation getStudentByReg_no(@PathVariable("reg_no") String reg_no) {
        return studentService.getstudentByReg_no(reg_no);
    }

    @GetMapping("voted")
    public int voted(){
       return studentService.voted();
    }
}
