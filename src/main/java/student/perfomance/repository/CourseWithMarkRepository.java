package student.perfomance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.perfomance.entitys.CourseWithMark;

public interface CourseWithMarkRepository extends JpaRepository<CourseWithMark, Long> {
}
