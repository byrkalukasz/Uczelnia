package pl.byrka.uczelnia.model.mapper;

import pl.byrka.uczelnia.model.DTO.File.DocumentDTO;
import pl.byrka.uczelnia.model.Entity.File.DocumentEntity;

public interface DocumentMapper {
    DocumentDTO mapFromEntity(DocumentEntity src);
    DocumentEntity mapFromDTO(DocumentDTO src);
}
