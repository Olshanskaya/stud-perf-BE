package student.perfomance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.perfomance.entitys.AcademicPlan;

public interface AcademicPlanRepository extends JpaRepository<AcademicPlan, Long> {
}
