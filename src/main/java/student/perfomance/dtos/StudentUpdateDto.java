package student.perfomance.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import student.perfomance.enums.ElementStatus;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentUpdateDto {
    private Long id;
    private ElementStatus status;

    private String firstName;
    private String lastName;
    private String patronymic;
    private String email;
    private Long academicPlanId;
}
