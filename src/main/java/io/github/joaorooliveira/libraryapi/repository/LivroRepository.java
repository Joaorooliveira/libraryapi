package io.github.joaorooliveira.libraryapi.repository;

import io.github.joaorooliveira.libraryapi.model.Autor;
import io.github.joaorooliveira.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {


    //Query method
    //select * from livro where id_autor = id
    List<Livro> findByAutor(Autor autor);
}
