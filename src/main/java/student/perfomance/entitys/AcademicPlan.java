package student.perfomance.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import student.perfomance.enums.ElementStatus;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AcademicPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;

    private String name;
    @ManyToMany
//    @JoinTable(
//            name = "academic_plans_courses",
//            joinColumns = @JoinColumn(name = "academic_plan_id"),
//            inverseJoinColumns = @JoinColumn(name = "couse_id"))
    private Set<Course> courses;
}
