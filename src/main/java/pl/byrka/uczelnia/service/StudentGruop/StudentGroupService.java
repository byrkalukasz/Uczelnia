package pl.byrka.uczelnia.service.StudentGruop;

import pl.byrka.uczelnia.model.DTO.StudentGroup.StudentGroupDTO;

import java.util.List;

public interface StudentGroupService {
    List<StudentGroupDTO> getAllStudentGroup();
    List<StudentGroupDTO> getAllGroupsForStudent(long id);
}
