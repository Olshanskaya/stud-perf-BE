package student.perfomance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.perfomance.entitys.Student;
import student.perfomance.entitys.User;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);
}
