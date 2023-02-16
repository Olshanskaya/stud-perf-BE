package student.perfomance.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import student.perfomance.dtos.StudentDto;
import student.perfomance.services.StudentService;

@RestController
@RequestMapping(value = "/home")
@AllArgsConstructor
@CrossOrigin
public class HomeController {

    private final StudentService studentService;

    @GetMapping("/home")
    public String hello() {
        return "this is a home page";
    }

    @GetMapping("/student")
    public StudentDto getStudentByEmail(@RequestParam(required = true, name = "email") String email) {
        StudentDto studentDto = studentService.getStudentByEmail(email);
        studentDto.setEmail(email);
        return studentDto;
    }

}
