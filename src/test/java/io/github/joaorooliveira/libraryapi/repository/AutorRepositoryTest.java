package io.github.joaorooliveira.libraryapi.repository;

import io.github.joaorooliveira.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Test
    public void salvarTest() {
        Autor autor = new Autor();
        autor.setNome("Maria");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1951, 1, 31));

        var autorSalvo = repository.save(autor);
        System.out.println("Autor Salvo:" + autorSalvo);
    }

    @Test
    public void atualizarTest() {

        var id = UUID.fromString("326bd3c0-93c6-469c-9519-7408cda7eae5");

        Optional<Autor> possivelAutor = repository.findById(id);


        if (possivelAutor.isPresent()) {
            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Dados do autor:");
            System.out.println(autorEncontrado);

            autorEncontrado.setDataNascimento(LocalDate.of(1960, 1, 30));

            repository.save(autorEncontrado);
        }
    }

    @Test
    public void listarTest() {
        List<Autor> autores = repository.findAll();
        autores.forEach(System.out::println);
    }

    @Test
    public void countTest() {
        System.out.println("Contagem de autores:" + repository.count());
    }

    @Test
    public void deletePorIdTest() {
        var id = UUID.fromString("326bd3c0-93c6-469c-9519-7408cda7eae5");
        var possivelAutor = repository.findById(id);
        if (possivelAutor.isPresent()) {
            repository.deleteById(id);
        }

    }

    @Test
    public void deleteTest() {
        var id = UUID.fromString("326bd3c0-93c6-469c-9519-7408cda7eae5");
        var possivelAutor = repository.findById(id).get();
        repository.delete(possivelAutor);
    }
}
