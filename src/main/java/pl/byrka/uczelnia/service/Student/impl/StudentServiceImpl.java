package pl.byrka.uczelnia.service.Student.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.Student.StudentDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudetntCreateDTO;
import pl.byrka.uczelnia.model.mapper.StudentMapper;
import pl.byrka.uczelnia.repository.Student.StudentRepository;
import pl.byrka.uczelnia.service.Student.StudentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentMapper studentMapper, StudentRepository studentRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO getStudentById(long id) {
        var response = studentRepository.getById(id);
        return studentMapper.mapFromEntity(response);
    }

    @Override
    public StudentDTO addStudent(StudetntCreateDTO studetntCreateDTO) {
        var result = studentRepository.save(studentMapper.mapFromCreate(studetntCreateDTO));
        return studentMapper.mapFromEntity(result);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        var response = studentRepository.findAll();
        List<StudentDTO> result = new ArrayList<>();
        for(var src : response)
        {
            result.add(studentMapper.mapFromEntity(src));
        }
        return result;
    }
}
