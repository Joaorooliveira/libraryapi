package io.github.joaorooliveira.libraryapi.service;

import io.github.joaorooliveira.libraryapi.model.Autor;
import io.github.joaorooliveira.libraryapi.model.GeneroLivro;
import io.github.joaorooliveira.libraryapi.model.Livro;
import io.github.joaorooliveira.libraryapi.repository.AutorRepository;
import io.github.joaorooliveira.libraryapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class TransacaoService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LivroRepository livroRepository;


    public void atualizacaoSemAtualizar() {
        var livro = livroRepository.findById(UUID.fromString(""));
    }

    @Transactional
    public void executar() {

        // salva o autor
        Autor autor = new Autor();
        autor.setNome("Teste Francisco");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1951, 1, 31));

        autorRepository.save(autor);

        // salva o livro
        Livro livro = new Livro();
        livro.setIsbn("9201-2129");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("Teste Livro do Francisco");
        livro.setDataPublicacao(LocalDate.of(1980, 1, 2));

        livro.setAutor(autor);

        livroRepository.save(livro);

        if (autor.getNome().equals("Teste Francisco")) {
            throw new RuntimeException("Rollback!");
        }
    }
}
