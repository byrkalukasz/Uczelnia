package pl.byrka.uczelnia.service.Student.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.exception.UczelniaException;
import pl.byrka.uczelnia.model.DTO.Student.StudentCreateDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentDTO;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;
import pl.byrka.uczelnia.model.mapper.StudentMapper;
import pl.byrka.uczelnia.repository.PersonRepository;
import pl.byrka.uczelnia.repository.Student.StudentRepository;
import pl.byrka.uczelnia.service.PersonService;
import pl.byrka.uczelnia.service.Student.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static pl.byrka.uczelnia.model.mapper.impl.PersonMapper.mapPersonFromDto;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;
    private final PersonService personService;

    public StudentServiceImpl(StudentMapper studentMapper, StudentRepository studentRepository, PersonService personService) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
        this.personService = personService;
    }

    @Override
    public Optional<StudentDTO> getStudentById(long id) {
        var response = studentRepository.findById(id);
        return response.map(studentMapper::mapFromEntity);
    }

    @Override
    public StudentDTO addStudent(StudentCreateDTO studentCreateDTO) {
        var person = personService.addNewPerson(studentCreateDTO.getPerson());
        var studentEntity = studentMapper.mapFromCreate(studentCreateDTO);
        studentEntity.setPerson(person);
        return studentMapper.mapFromEntity(studentRepository.save(studentEntity));
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        var response = studentRepository.findAll();
        List<StudentDTO> result = new ArrayList<>();
        response.stream().map(studentMapper::mapFromEntity);

        return result;
    }

    @Override
    public Optional<StudentDTO> updateStudent(StudentDTO studentDTO) {
        StudentEntity existingStudent = studentRepository.findById(studentDTO.getId())
                .orElseThrow(() -> new UczelniaException("Student","id", studentDTO.getId())
                );
        existingStudent.setActive(studentDTO.isActive());

        return Optional.of(studentMapper.mapFromEntity(existingStudent));
    }

    @Override
    public List<StudentDTO> getAllActiveStudents() {
        List<StudentDTO> activeStudents = new ArrayList<>();
        var response = studentRepository.findAll();
        response.stream().map(studentMapper::mapFromEntity);

        return activeStudents;
    }
}
