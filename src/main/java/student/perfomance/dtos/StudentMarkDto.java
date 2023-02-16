package student.perfomance.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import student.perfomance.enums.ElementStatus;
import student.perfomance.enums.Mark;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentMarkDto {
    private Long studentId;
    private Long courseId;
    private Mark mark;

}
