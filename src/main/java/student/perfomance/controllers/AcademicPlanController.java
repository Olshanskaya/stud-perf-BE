package student.perfomance.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import student.perfomance.dtos.AcademicPlanDto;
import student.perfomance.dtos.CourseDto;

@RestController
@RequestMapping(value = "/plan")
public class AcademicPlanController {

    @GetMapping
    public ResponseEntity<String> getAllAcademicPlan() {
        return ResponseEntity.ok("GetMapping all Course");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getAcademicPlanById(@PathVariable(required = true, name = "id") String id) {
        return ResponseEntity.ok("GetMapping Current AcademicPlan: " + id);
    }

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<String> createAcademicPlan(@RequestBody AcademicPlanDto academicPlanDto) {
        return ResponseEntity.ok("PostMapping AcademicPlan: " + academicPlanDto.getName());
    }

    @PutMapping(consumes = {"application/json"})
    public ResponseEntity<String> updateAcademicPlan(@RequestBody AcademicPlanDto academicPlanDto) {
        return ResponseEntity.ok("PutMapping AcademicPlan: " + academicPlanDto.getName());
    }

    @DeleteMapping(consumes = {"application/json"})
    public ResponseEntity<String> deleteAcademicPlan(@RequestBody AcademicPlanDto academicPlanDto) {
        return ResponseEntity.ok("DeleteMapping AcademicPlan: " + academicPlanDto.getName());
    }
}
