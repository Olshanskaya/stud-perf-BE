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
import student.perfomance.dtos.CourseDto;
import student.perfomance.services.CourseService;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/course")
@AllArgsConstructor
@CrossOrigin
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourse() {
        return ResponseEntity.ok(courseService.getAllCourse());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable(required = true, name = "id") String id) {
        return ResponseEntity.ok(courseService.getCourseById(Long.parseLong(id)));
    }

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<String> createCourse(@RequestBody CourseDto courseDto) {
        if (courseService.createCourse(courseDto)) {
            return ResponseEntity.ok("CourseDto created");
        }
        return ResponseEntity.badRequest().body("not correct CourseDto");
    }

    @PutMapping(consumes = {"application/json"})
    public ResponseEntity<String> updateCourse(@RequestBody CourseDto courseDto) {
        if (courseService.updateCourse(courseDto)) {
            return ResponseEntity.ok("CourseDto updated");
        }
        return ResponseEntity.badRequest().body("not correct CourseDto");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable(required = true, name = "id") String id) {
        if (courseService.deleteCourse(Long.parseLong(id))) {
            return ResponseEntity.ok("CourseDto deleted");
        }
        return ResponseEntity.badRequest().body("not correct CourseDto");
    }
}
