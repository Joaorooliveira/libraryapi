package io.github.joaorooliveira.libraryapi.controller;

import io.github.joaorooliveira.libraryapi.controller.dto.CadastroLivroDTO;
import io.github.joaorooliveira.libraryapi.controller.mappers.LivroMapper;
import io.github.joaorooliveira.libraryapi.model.Livro;
import io.github.joaorooliveira.libraryapi.service.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("livros")
@RequiredArgsConstructor
public class LivroController implements GenericController {

    private final LivroService service;
    private final LivroMapper mapper;


    @PostMapping
    public ResponseEntity<Object> salvar(
            @RequestBody @Valid CadastroLivroDTO dto) {

        Livro livro = mapper.toEntity(dto);
        service.salvar(livro);
        var url = gerarHeaderLocation(livro.getId());
        return ResponseEntity.created(url).build();
    }
}
