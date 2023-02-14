package student.perfomance.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import student.perfomance.entitys.CourseWithMark;
import student.perfomance.repository.CourseWithMarkRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseWithMarkService {

    private final CourseWithMarkRepository courseWithMarkRepository;

    List<CourseWithMark> getAllCoursesWithMarkByUserId(Long userId) {
        return courseWithMarkRepository.findAllByUserId(userId);
    }


}
