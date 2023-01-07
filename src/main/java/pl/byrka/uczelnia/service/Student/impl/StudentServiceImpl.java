package pl.byrka.uczelnia.service.Student.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.exception.UczelniaException;
import pl.byrka.uczelnia.model.DTO.Student.StudentCreateDTO;
import pl.byrka.uczelnia.model.DTO.Student.StudentDTO;
import pl.byrka.uczelnia.model.Entity.Student.StudentEntity;
import pl.byrka.uczelnia.repository.Student.StudentRepository;
import pl.byrka.uczelnia.service.PersonService;
import pl.byrka.uczelnia.service.Student.StudentService;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static pl.byrka.uczelnia.model.mapper.impl.StudentMapperImpl.mapStudentFromCreate;
import static pl.byrka.uczelnia.model.mapper.impl.StudentMapperImpl.mapStudentFromEntity;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final PersonService personService;

    public StudentServiceImpl(StudentRepository studentRepository, PersonService personService) {
        this.studentRepository = studentRepository;
        this.personService = personService;
    }

    @Override
    public Optional<StudentDTO> getStudentById(Long id) {
        var response = studentRepository.findById(id);
        return response.map(x -> mapStudentFromEntity(x));
    }

    @Override
    public StudentDTO addStudent(StudentCreateDTO studentCreateDTO) {
        var person = personService.addNewPerson(studentCreateDTO.getPerson());
        var studentEntity = mapStudentFromCreate(studentCreateDTO);
        studentEntity.setPerson(person);
        studentEntity.setCreationDate(ZonedDateTime.now());
        return mapStudentFromEntity(studentRepository.save(studentEntity));
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        var response = studentRepository.findAll();
        return response.stream().map(x -> mapStudentFromEntity(x)).collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDTO> updateStudent(StudentDTO studentDTO) {
        StudentEntity existingStudent = studentRepository.findById(studentDTO.getId())
                .orElseThrow(() -> new UczelniaException("Student", "id", studentDTO.getId())
                );
        existingStudent.setActive(studentDTO.isActive());
        existingStudent.setModificationDate(ZonedDateTime.now());

        return Optional.of(mapStudentFromEntity(existingStudent));
    }

    @Override
    public List<StudentDTO> getAllActiveStudents() {
        List<StudentDTO> activeStudents = new ArrayList<>();
        var response = studentRepository.findAll();
        return response.stream().map(x -> mapStudentFromEntity(x)).collect(Collectors.toList());
    }
}
