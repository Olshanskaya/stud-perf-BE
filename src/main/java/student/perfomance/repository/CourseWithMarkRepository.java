package student.perfomance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import student.perfomance.entitys.CourseWithMark;

import java.util.List;
import java.util.Optional;

public interface CourseWithMarkRepository extends JpaRepository<CourseWithMark, Long> {
//    @Query("select ree from CourseWithMark cwm inner join cwm.course ree")
//    List<CourseWithMark> findAllWithInfoByUserId(@Param("userId") Long userId);

    List<CourseWithMark> findAllByUserId(Long userId);
    Optional<CourseWithMark> findAllByUserIdAndCourseId(Long userId, Long courseId);
}
