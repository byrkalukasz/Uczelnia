package pl.byrka.uczelnia.service.Student.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.exception.UczelniaException;
import pl.byrka.uczelnia.model.DTO.Student.StudentCreateDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentDTO;
import pl.byrka.uczelnia.model.Entity.Person;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;
import pl.byrka.uczelnia.model.mapper.StudentMapper;
import pl.byrka.uczelnia.repository.PersonRepository;
import pl.byrka.uczelnia.repository.Student.StudentRepository;
import pl.byrka.uczelnia.service.Student.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    private final PersonRepository personRepository;

    public StudentServiceImpl(StudentMapper studentMapper, StudentRepository studentRepository, PersonRepository personRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
        this.personRepository = personRepository;
    }

    @Override
    public Optional<StudentDTO> getStudentById(long id) {
        var response = studentRepository.findById(id);
        return response.map(studentMapper::mapFromEntity);
    }

    @Override
    public StudentDTO addStudent(StudentCreateDTO studentCreateDTO) {
        var result = studentRepository.save(studentMapper.mapFromCreate(studentCreateDTO));
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

    @Override
    public Optional<StudentDTO> updateStudent(StudentDTO studentDTO) {
        StudentEntity existingStudent = studentRepository.findById(studentDTO.getId())
                .orElseThrow(() -> new UczelniaException("Student","id", studentDTO.getId())
                );
        existingStudent.setPerson(Person.builder()
                        .name(existingStudent.getPerson().getName())
                        .surname(existingStudent.getPerson().getSurname())
                .build());
        existingStudent.setActive(studentDTO.isActive());

        return Optional.of(studentMapper.mapFromEntity(existingStudent));
    }

    @Override
    public List<StudentDTO> getAllActiveStudents() {
        List<StudentDTO> activeStudents = new ArrayList<>();
        var response = studentRepository.findAll();
        for(var student : response)
        {
            if(student.isActive() == true)
                activeStudents.add(studentMapper.mapFromEntity(student));
        }
        return activeStudents;
    }
}
