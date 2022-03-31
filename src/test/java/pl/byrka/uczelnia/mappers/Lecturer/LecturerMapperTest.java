package pl.byrka.uczelnia.mappers.Lecturer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.byrka.uczelnia.model.DTO.Lecturer.LecturerDTO;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;
import pl.byrka.uczelnia.model.mapper.LecturerMapper;
import pl.byrka.uczelnia.model.mapper.impl.LecturerMapperImpl;

import static org.junit.jupiter.api.Assertions.*;

class LecturerMapperTest {

    LecturerMapperImpl lecturerMapper = new LecturerMapperImpl();
    public static LecturerDTO lecturerDTO;
    public static LecturerEntity lecturerEntity;

    @BeforeAll
    static void setup(){
        lecturerDTO = new LecturerDTO();
        lecturerDTO.setId(1);
        lecturerDTO.setFullName("dr. Json Connor");
        lecturerDTO.setEmail("Json.Connor@uczelnia.pl");

        lecturerEntity = new LecturerEntity();
        lecturerEntity.setId(1);
        lecturerEntity.setName("Json");
        lecturerEntity.setSurname("Connor");
        lecturerEntity.setTitle("Doktor");

    }
    @Test
    void mapFromEntity() {
        var actual = lecturerMapper.mapFromEntity(lecturerEntity);

        Assertions.assertEquals(lecturerEntity.getEmail(), actual.getEmail());
        Assertions.assertEquals(lecturerEntity.getId(), actual.getId());
    }

    @Test
    void mapFromCreateEntity() {
        //var actual = lecturerMapper.mapFromCreateEntity(lec);
    }
}