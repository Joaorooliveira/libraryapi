package io.github.joaorooliveira.libraryapi.service;

import io.github.joaorooliveira.libraryapi.model.Autor;
import io.github.joaorooliveira.libraryapi.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor salvar(Autor autor) {
        return autorRepository.save(autor);
    }

//    public AutorDTO buscarAutor(UUID id) {
//        var autor = autorRepository.findById(id).orElseThrow(()
//                -> new EntityNotFoundException("Autor não encontrado com id: " + id));
//
//        return new AutorDTO(
//                autor.getId(),
//                autor.getNome(),
//                autor.getDataNascimento(),
//                autor.getNacionalidade()
//        );

    public Optional<Autor> obterPorId(UUID id) {
        return autorRepository.findById(id);

    }
}
