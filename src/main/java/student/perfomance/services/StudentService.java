package student.perfomance.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import student.perfomance.dtos.AcademicPlanDto;
import student.perfomance.dtos.CourseDto;
import student.perfomance.dtos.CourseWithMarkDto;
import student.perfomance.dtos.StudentDto;
import student.perfomance.dtos.StudentMarkDto;
import student.perfomance.dtos.StudentUpdateDto;
import student.perfomance.entitys.AcademicPlan;
import student.perfomance.entitys.CourseWithMark;
import student.perfomance.entitys.Student;
import student.perfomance.enums.ElementStatus;
import student.perfomance.repository.CourseRepository;
import student.perfomance.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    private final CourseWithMarkService courseWithMarkService;
    private final ModelMapper modelMapper;

    public StudentDto getStudentByEmail(String email) {
        Optional<Student> student = studentRepository.findByEmail(email);
        StudentDto studentDto = new StudentDto();
        if (student.isEmpty()) {
            return studentDto;
        }
        studentDto = modelMapper.map(student, StudentDto.class);
        if (studentDto.getAcademicPlan() == null) {
            return studentDto;
        }
        List<CourseWithMark> courses = courseWithMarkService.getAllCoursesWithMarkByUserId(studentDto.getId());
        if (courses.isEmpty()) {
            return studentDto;
        }

        List<CourseWithMarkDto> dtos = courses
                .stream()
                .map(c -> {
                    CourseWithMarkDto r = modelMapper.map(c, CourseWithMarkDto.class);
                    r.setName(c.getCourse().getName());
                    r.setStatus(ElementStatus.valueOf(c.getCourse().getStatus()));
                    return r;
                })
                .toList();
        studentDto.setCourse(dtos);
        return studentDto;
    }

    public List<StudentDto> getAllStudents() {
        List<StudentDto> dtos = studentRepository.findAll()
                .stream()
                .map(c -> modelMapper.map(c, StudentDto.class))
                .toList();
        return dtos;
    }

    public StudentDto getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        StudentDto studentDto = new StudentDto();
        if (student.isEmpty()) {
            return studentDto;
        }
        studentDto = modelMapper.map(student, StudentDto.class);
        if (studentDto.getAcademicPlan() == null) {
            return studentDto;
        }
        List<CourseWithMark> courses = courseWithMarkService.getAllCoursesWithMarkByUserId(studentDto.getId());
        if (courses.isEmpty()) {
            return studentDto;
        }

        List<CourseWithMarkDto> dtos = courses
                .stream()
                .map(c -> {
                    CourseWithMarkDto r = modelMapper.map(c, CourseWithMarkDto.class);
                    r.setName(c.getCourse().getName());
                    r.setStatus(ElementStatus.valueOf(c.getCourse().getStatus()));
                    return r;
                })
                .toList();
        studentDto.setCourse(dtos);
        return studentDto;
    }

    public boolean createStudent(StudentDto studentDto) {
        if (studentDto.getId() == null || studentRepository.findById(studentDto.getId()).isEmpty()) {
            Student s = studentRepository.save(modelMapper.map(studentDto, Student.class));
            return true;
        }
        return false;
    }


    public boolean updateStudent(StudentUpdateDto studentDto) {
        Optional<Student> ap = studentRepository.findById(studentDto.getId());
        if (ap.isPresent()) {
            Student c = ap.get();
            c = modelMapper.map(studentDto, Student.class);
            studentRepository.save(c);
            return true;
        }
        return false;
    }

    public boolean deleteStudent(Long id) {
        Optional<Student> ap = studentRepository.findById(id);
        if (ap.isPresent()) {
            Student c = ap.get();
            c.setStatus(ElementStatus.DELETED.toString());
            studentRepository.save(c);
            return true;
        }
        return false;
    }

    public boolean updateStudentsMark(StudentMarkDto studentDto) {
        if (studentRepository.findById(studentDto.getStudentId()).isEmpty() || courseRepository.findById(studentDto.getCourseId()).isEmpty()) {
            return false;
        }
        return courseWithMarkService.updateStudentsMark(studentDto);
    }

}
