package io.github.joaorooliveira.libraryapi.service;

import io.github.joaorooliveira.libraryapi.exceptions.OperacaoNaoPermitidaException;
import io.github.joaorooliveira.libraryapi.model.Autor;
import io.github.joaorooliveira.libraryapi.repository.AutorRepository;
import io.github.joaorooliveira.libraryapi.repository.LivroRepository;
import io.github.joaorooliveira.libraryapi.validador.AutorValidator;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AutorService {

    private final AutorRepository autorRepository;
    private final LivroRepository livroRepository;
    private final AutorValidator validator;

    public AutorService(AutorRepository autorRepository, ResourcePatternResolver resourcePatternResolver, LivroRepository livroRepository, AutorValidator validator) {
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
        this.validator = validator;
    }

    public Autor salvar(Autor autor) {
        validator.validar(autor);
        return autorRepository.save(autor);
    }

    public void atualizar(Autor autor) {
        if (autor.getId() == null) {
            throw new IllegalArgumentException("Para atualizar, e necessario que o autor ja esteja salvo na base");
        }
        validator.validar(autor);
        autorRepository.save(autor);
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

//    public void excluirAutor(UUID id) {
//        var autor = autorRepository.findById(id).orElseThrow(
//                () -> new EntityNotFoundException("Autor não encontrado com id: " + id));
//        autorRepository.deleteById(id);
//    }

    public void deletar(Autor autor) {
        if (possuiLivro(autor)) {
            throw new OperacaoNaoPermitidaException(
                    "Nao e permitido excluir um Autor que possui livros cadastrados!");
        }
        autorRepository.delete(autor);
    }

    public List<Autor> pesquisa(String nome, String nacionalidade) {
        if (nome != null && nacionalidade != null) {
            return autorRepository.findByNomeAndNacionalidade(nome, nacionalidade);
        }
        if (nome != null) {
            return autorRepository.findByNome(nome);
        }
        if (nacionalidade != null) {
            return autorRepository.findByNacionalidade(nacionalidade);
        } else {
            return autorRepository.findAll();
        }
    }

    public boolean possuiLivro(Autor autor) {
        return livroRepository.existsByAutor(autor);
    }


}
