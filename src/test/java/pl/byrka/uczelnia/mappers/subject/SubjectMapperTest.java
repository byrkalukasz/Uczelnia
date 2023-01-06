package pl.byrka.uczelnia.mappers.subject;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.byrka.uczelnia.model.DTO.Subject.SubjectDTO;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectEntity;
import pl.byrka.uczelnia.model.mapper.LecturerMapper;
import pl.byrka.uczelnia.model.mapper.impl.SubjectMapperImpl;

public class SubjectMapperTest {
    private SubjectMapperImpl subjectMapper;
    private LecturerMapper lecturerMapper;
    private SubjectEntity subjectEntity;
    private SubjectDTO subjectDTO;


    @BeforeAll
    public void setUp(){
    subjectMapper = new SubjectMapperImpl(lecturerMapper);



    }
    @Test
    public void mapToEntity(){


    }
}
