package student.perfomance.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseWithMark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String mark;

    @ManyToOne
    private Users user;

    @ManyToOne
    private Course course;
}
