package student.perfomance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import student.perfomance.entitys.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
