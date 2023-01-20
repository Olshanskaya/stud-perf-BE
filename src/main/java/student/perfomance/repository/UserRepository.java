package student.perfomance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.perfomance.entitys.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
}
