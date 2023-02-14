package student.perfomance.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import student.perfomance.entitys.Course;
import student.perfomance.enums.ElementStatus;
import student.perfomance.enums.Mark;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDto {
    private Long id;
    private ElementStatus status;

    private String firstName;
    private String lastName;
    private String patronymic;
    private String email;
    private AcademicPlanDto academicPlan;
    //private HashMap<CourseDto, Mark> courseMarks;
    private List<CourseWithMarkDto> course;
}
