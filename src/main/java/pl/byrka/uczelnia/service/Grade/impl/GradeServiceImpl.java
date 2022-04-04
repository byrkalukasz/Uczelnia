package pl.byrka.uczelnia.service.Grade.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.exception.UczelniaException;
import pl.byrka.uczelnia.model.DTO.Grade.GradeCreateDTO;
import pl.byrka.uczelnia.model.DTO.Grade.GradeDTO;
import pl.byrka.uczelnia.model.DTO.Grade.GradeUpdateDTO;
import pl.byrka.uczelnia.model.Emuns.GradeValueEnum;
import pl.byrka.uczelnia.model.Entity.Grade.GradeEntity;
import pl.byrka.uczelnia.model.mapper.GradeMapper;
import pl.byrka.uczelnia.model.mapper.LecturerMapper;
import pl.byrka.uczelnia.model.mapper.StudentMapper;
import pl.byrka.uczelnia.model.mapper.SubjectMapper;
import pl.byrka.uczelnia.repository.Grade.GradeRepository;
import pl.byrka.uczelnia.repository.Lecturer.LecturerRepository;
import pl.byrka.uczelnia.repository.Student.StudentRepository;
import pl.byrka.uczelnia.repository.Subject.SubjectRepository;
import pl.byrka.uczelnia.service.Grade.GradeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    private final GradeRepository gradeRepository;
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;
    private final LecturerRepository lecturerRepository;
    private final GradeMapper gradeMapper;
    private final LecturerMapper lecturerMapper;
    private final SubjectMapper subjectMapper;
    private final StudentMapper studentMapper;

    public GradeServiceImpl(GradeRepository gradeRepository, SubjectRepository subjectRepository, StudentRepository studentRepository, LecturerRepository lecturerRepository, GradeMapper gradeMapper, LecturerMapper lecturerMapper, SubjectMapper subjectMapper, StudentMapper studentMapper) {
        this.gradeRepository = gradeRepository;
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
        this.lecturerRepository = lecturerRepository;
        this.gradeMapper = gradeMapper;
        this.lecturerMapper = lecturerMapper;
        this.subjectMapper = subjectMapper;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<GradeDTO> getAllGrades() {
        List<GradeDTO> result = new ArrayList<>();
        var response = gradeRepository.findAll();
        for(var obj : response)
        {
            result.add(gradeMapper.mapFromEntity(obj));
        }
        return result;
    }

    @Override
    public List<GradeDTO> getAllGradesForStudent(long student_id) {
        List<GradeDTO> result = new ArrayList<>();
        var response = gradeRepository.getAllGradesForUser(student_id);
        for(var obj : response){
            result.add(gradeMapper.mapFromEntity(obj));
        }
        return result;
    }

    @Override
    public GradeDTO createGrade(GradeCreateDTO gradeCreateDTO) {
        var student = studentRepository.getById(gradeCreateDTO.getStudent());
        var lecturer = lecturerRepository.getById(gradeCreateDTO.getLecturer());
        var subject = subjectRepository.getById(gradeCreateDTO.getSubject());

        var toSave = gradeMapper.mapCreatetoEntity(gradeCreateDTO, lecturer, subject, student);
        var response = gradeRepository.save(toSave);
        var result = gradeMapper.mapFromEntity(response);

        return result;
    }

    @Override
    public List<GradeDTO> createListGrades(List<GradeCreateDTO> gradeCreateDTOS) {

        List<GradeEntity> toSave = new ArrayList<>();
        for(var obj : gradeCreateDTOS)
        {
            var student = studentRepository.getById(obj.getStudent());
            var lecturer = lecturerRepository.getById(obj.getLecturer());
            var subject = subjectRepository.getById(obj.getSubject());

            var save = gradeMapper.mapCreatetoEntity(obj, lecturer, subject, student);
            toSave.add(save);
        }
        var response = gradeRepository.saveAll(toSave);
        List<GradeDTO> result = new ArrayList<>();
        for(var obj: response){
            var save = gradeMapper.mapFromEntity(obj);
            result.add(save);
        }
        return result;
    }

    @Override
    public GradeDTO updateGrade(GradeUpdateDTO gradeDTO) {
        long id = gradeDTO.getId();
        GradeEntity existingGrade = gradeRepository.findById(id).orElseThrow(
                () -> new UczelniaException("Grade","Id",id)
        );

        //Wyciągnąć te 3 pierdoły jako osoban metoda bo ciągle używana
        var student = studentRepository.getById(gradeDTO.getStudent());
        var lecturer = lecturerRepository.getById(gradeDTO.getLecturer());
        var subject = subjectRepository.getById(gradeDTO.getSubject());

        existingGrade.setId(gradeDTO.getId());
        existingGrade.setStatus(gradeDTO.getStatus().getGradeStateEnum());
        existingGrade.setGrade(gradeDTO.getGrade().getGradeValueEnum());
        existingGrade.setLecturer(lecturer);
        existingGrade.setSubject(subject);
        existingGrade.setStudent(student);

        var response = gradeMapper.mapFromEntity(gradeRepository.save(existingGrade));

        return response;
    }

    @Override
    public List<GradeDTO> updateListGrades(List<GradeUpdateDTO> GradeDTO) {
        List<GradeEntity> existingGrades = new ArrayList<>();
        List<GradeDTO> returnGrades = new ArrayList<>();
        for(var obj : GradeDTO){
            GradeEntity gradeEntity = gradeRepository.findById(obj.getId()).orElseThrow(
                    () -> new UczelniaException("Grade","Id",obj.getId())
            );

            var student = studentRepository.getById(obj.getStudent());
            var lecturer = lecturerRepository.getById(obj.getLecturer());
            var subject = subjectRepository.getById(obj.getSubject());

            gradeEntity.setId(obj.getId());
            gradeEntity.setStatus(obj.getStatus().getGradeStateEnum());
            gradeEntity.setGrade(obj.getGrade().getGradeValueEnum());
            gradeEntity.setLecturer(lecturer);
            gradeEntity.setSubject(subject);
            gradeEntity.setStudent(student);

            existingGrades.add(gradeEntity);
        }
        gradeRepository.saveAll(existingGrades);
        for(var obj : existingGrades){
            returnGrades.add(gradeMapper.mapFromEntity(obj));
        }
        return returnGrades;
    }

    @Override
    public void deleteGrade(long id) {
        gradeRepository.deleteById(id);
    }
}
