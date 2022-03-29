package pl.byrka.uczelnia.model.mapper.impl;

import pl.byrka.uczelnia.model.DTO.Subject.SubjectDTO;
import pl.byrka.uczelnia.model.Entity.Lecturer.LecturerEntity;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectCreate;
import pl.byrka.uczelnia.model.Entity.Subject.SubjectEntity;
import pl.byrka.uczelnia.model.mapper.LecturerMapper;

public class SubjectMapperImpl  {
    private final LecturerMapper lecturerMapper;
    public SubjectMapperImpl(LecturerMapper lecturerMapper) {
        this.lecturerMapper = lecturerMapper;
    }

    private SubjectDTO mapSubjectToDTO(SubjectEntity src)
    {
        SubjectDTO dts = new SubjectDTO();

        dts.setId(src.getId());
        dts.setName(src.getName());
        dts.setEcts(src.getEcts());
        dts.setType(src.getType());
        dts.setLecturer(lecturerMapper.mapFromEntity(src.getLecturer()));
        return dts;
    }
    private SubjectEntity mapSubjectToEntity(SubjectCreate src, LecturerEntity lecturer)
    {
        SubjectEntity dst = new SubjectEntity();
        dst.setEcts(src.getEcts());
        dst.setName(src.getName());
        dst.setType(src.getType().getTypeEnum());
        dst.setLecturer(lecturer);

        return dst;
    }
}
