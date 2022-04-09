package pl.byrka.uczelnia.service.StudentGruop.impl;

import org.springframework.stereotype.Service;
import pl.byrka.uczelnia.model.DTO.StudentGroup.StudentGroupDTO;
import pl.byrka.uczelnia.model.mapper.StudentGroupMapper;
import pl.byrka.uczelnia.repository.StudentGroup.StudentGroupRepository;
import pl.byrka.uczelnia.service.StudentGruop.StudentGroupService;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {
    private final StudentGroupMapper studentMapper;
    private final StudentGroupRepository studentGroupRepository;

    public StudentGroupServiceImpl(StudentGroupMapper studentMapper, StudentGroupRepository studentGroupRepository) {
        this.studentMapper = studentMapper;
        this.studentGroupRepository = studentGroupRepository;
    }

    @Override
    public List<StudentGroupDTO> getAllStudentGroup() {
        var response = studentGroupRepository.findAll();
        List<StudentGroupDTO> dst = new ArrayList<>();
        for (var obj : response){
            dst.add(studentMapper.mapFromEntity(obj));
        }
        return dst;
    }

    @Override
    public List<StudentGroupDTO> getAllGroupsForStudent(long id) {
        var response = studentGroupRepository.getAllGroupsForStudent(id);
        List<StudentGroupDTO> dst = new ArrayList<>();
        for (var obj : response){
            dst.add(studentMapper.mapFromEntity(obj));
        }
        return dst;
    }
}
