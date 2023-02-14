package student.perfomance.controllers;

import lombok.AllArgsConstructor;
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
import student.perfomance.services.AcademicPlanService;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/plan")
@AllArgsConstructor
public class AcademicPlanController {

    private final AcademicPlanService academicPlanService;

    @GetMapping
    public ResponseEntity<List<AcademicPlanDto>> getAllAcademicPlan() {
        return ResponseEntity.ok(academicPlanService.getAllAcademicPlan());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicPlanDto> getAcademicPlanById(@PathVariable(required = true, name = "id") String id) {
        return ResponseEntity.ok(academicPlanService.getAcademicPlanId(Long.parseLong(id)));
    }

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<String> createAcademicPlan(@RequestBody AcademicPlanDto academicPlanDto) {
        if (academicPlanService.createAcademicPlan(academicPlanDto)) {
            return ResponseEntity.ok("AcademicPlanDto created");
        }
        return ResponseEntity.badRequest().body("not correct AcademicPlanDto");
    }

    @PutMapping(consumes = {"application/json"})
    public ResponseEntity<String> updateAcademicPlan(@RequestBody AcademicPlanDto academicPlanDto) {
        if (academicPlanService.updateAcademicPlan(academicPlanDto)) {
            return ResponseEntity.ok("AcademicPlanDto updated");
        }
        return ResponseEntity.badRequest().body("not correct AcademicPlanDto");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAcademicPlan(@PathVariable(required = true, name = "id") String id) {
        if (academicPlanService.deleteAcademicPlan(Long.parseLong(id))) {
            return ResponseEntity.ok("AcademicPlanDto deleted");
        }
        return ResponseEntity.badRequest().body("not correct AcademicPlanDto");
    }
}
