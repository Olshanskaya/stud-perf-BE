package student.perfomance.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import student.perfomance.dtos.CourseDto;
import student.perfomance.dtos.StudentDto;
import student.perfomance.services.StudentService;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllUsers() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable(required = true, name = "id") String id) {
        return ResponseEntity.ok(studentService.getStudentById(Long.parseLong(id)));
    }

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<String> createStudent(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok("PostMapping user: " + studentDto.getFirstName());
    }

    @PutMapping(consumes = {"application/json"})
    public ResponseEntity<String> updateStudent(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok("PutMapping user: " + studentDto.getFirstName());
    }

    @DeleteMapping(consumes = {"application/json"})
    public ResponseEntity<String> deleteStudent(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok("DeleteMapping user: " + studentDto.getFirstName());
    }
}
