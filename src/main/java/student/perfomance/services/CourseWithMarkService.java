package student.perfomance.services;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import student.perfomance.dtos.StudentMarkDto;
import student.perfomance.entitys.CourseWithMark;
import student.perfomance.entitys.Student;
import student.perfomance.repository.CourseRepository;
import student.perfomance.repository.CourseWithMarkRepository;
import student.perfomance.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseWithMarkService {

    private final CourseWithMarkRepository courseWithMarkRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    List<CourseWithMark> getAllCoursesWithMarkByUserId(Long userId) {
        return courseWithMarkRepository.findAllByUserId(userId);
    }

    public boolean updateStudentsMark(StudentMarkDto studentMarkDto) {
        Optional<CourseWithMark> ap = courseWithMarkRepository.findAllByUserIdAndCourseId(studentMarkDto.getStudentId(), studentMarkDto.getCourseId());
        if (ap.isPresent()) {
            CourseWithMark c = ap.get();
            c.setMark(studentMarkDto.getMark().toString());
            courseWithMarkRepository.save(c);
            return true;
        }
        CourseWithMark course = new CourseWithMark();
        course.setMark(studentMarkDto.getMark().toString());
        course.setUser(studentRepository.findById(studentMarkDto.getStudentId()).get());
        course.setCourse(courseRepository.findById(studentMarkDto.getCourseId()).get());
        CourseWithMark s = courseWithMarkRepository.save(course);
        return true;

    }


}
