package io.github.joaorooliveira.libraryapi.controller;

import io.github.joaorooliveira.libraryapi.controller.dto.UsuarioDTO;
import io.github.joaorooliveira.libraryapi.controller.mappers.UsuarioMapper;
import io.github.joaorooliveira.libraryapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    private final UsuarioMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // retorno fixo 201 Created(nao dinamico)
    public void salvar(@RequestBody UsuarioDTO dto) {
        var usuario = mapper.toEntity(dto);
        service.salvar(usuario);
    }


}
