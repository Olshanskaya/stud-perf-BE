package student.perfomance.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import student.perfomance.dtos.CourseDto;
import student.perfomance.entitys.Course;
import student.perfomance.enums.ElementStatus;
import student.perfomance.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public List<CourseDto> getAllCourse() {
        List<CourseDto> dtos = courseRepository.findAll()
                .stream()
                .map(c -> modelMapper.map(c, CourseDto.class))
                .toList();
        return dtos;
    }

    public CourseDto getCourseById(Long id) {
        return modelMapper.map(courseRepository.findById(id), CourseDto.class);
    }

    public boolean createCourse(CourseDto courseDto) {
        if (courseDto.getId() == null || courseRepository.findById(courseDto.getId()).isEmpty()) {
            Course cc = courseRepository.save(modelMapper.map(courseDto, Course.class));
            return true;
        }
        return false;
    }

    public boolean updateCourse(CourseDto courseDto) {
        Optional<Course> course = courseRepository.findById(courseDto.getId());
        if (course.isPresent()) {
            Course c = course.get();
            c = modelMapper.map(courseDto, Course.class);
            courseRepository.save(c);
            return true;
        }
        return false;
    }

    public boolean deleteCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            Course c = course.get();
            c.setStatus(ElementStatus.DELETED.toString());
            courseRepository.save(c);
            return true;
        }
        return false;
    }
}
