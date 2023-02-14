package student.perfomance.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import student.perfomance.entitys.AcademicPlan;
import student.perfomance.enums.ElementStatus;

import java.util.Set;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseDto {
    private Long id;
    private ElementStatus status;
    private String name;
    //private Set<AcademicPlan> academicPlans;
}
