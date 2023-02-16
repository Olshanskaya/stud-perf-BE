package student.perfomance.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import student.perfomance.dtos.StudentDto;
import student.perfomance.dtos.StudentMarkDto;
import student.perfomance.dtos.StudentUpdateDto;
import student.perfomance.services.StudentService;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/student")
@AllArgsConstructor
@CrossOrigin
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
        if (studentService.createStudent(studentDto)) {
            return ResponseEntity.ok("StudentDto created");
        }
        return ResponseEntity.badRequest().body("not correct StudentDto");
    }

    @PutMapping(value = "/mark", consumes = {"application/json"})
    public ResponseEntity<String> updateStudent(@RequestBody StudentMarkDto studentDto) {
        if (studentService.updateStudentsMark(studentDto)) {
            return ResponseEntity.ok("StudentDto updated");
        }
        return ResponseEntity.badRequest().body("not correct StudentDto");
    }

    @PutMapping(consumes = {"application/json"})
    public ResponseEntity<String> updateStudentMark(@RequestBody StudentUpdateDto studentDto) {
        if (studentService.updateStudent(studentDto)) {
            return ResponseEntity.ok("StudentDto updated");
        }
        return ResponseEntity.badRequest().body("not correct StudentDto");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable(required = true, name = "id") String id) {
        if (studentService.deleteStudent(Long.parseLong(id))) {
            return ResponseEntity.ok("StudentDto deleted");
        }
        return ResponseEntity.badRequest().body("not correct StudentDto");
    }
}
