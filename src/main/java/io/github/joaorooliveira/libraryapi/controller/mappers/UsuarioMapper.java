package io.github.joaorooliveira.libraryapi.controller.mappers;

import io.github.joaorooliveira.libraryapi.controller.dto.UsuarioDTO;
import io.github.joaorooliveira.libraryapi.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO dto);
}
