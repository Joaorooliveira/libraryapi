package io.github.joaorooliveira.libraryapi.controller.mappers;

import io.github.joaorooliveira.libraryapi.controller.dto.AutorDTO;
import io.github.joaorooliveira.libraryapi.model.Autor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    @Mapping(source = "nome", target = "nome")
// quando o campo do dto e diferente do campo da entidade
    Autor toEntity(AutorDTO dto);

    AutorDTO toDTO(Autor autor);
}
