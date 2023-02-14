package student.perfomance.services;

import org.springframework.stereotype.Service;
import student.perfomance.dtos.StudentDto;

@Service
public class StudentService {

    public StudentDto getStudentByEmail(String email) {
        StudentDto studentDto = new StudentDto();
        return studentDto;
    }
}
