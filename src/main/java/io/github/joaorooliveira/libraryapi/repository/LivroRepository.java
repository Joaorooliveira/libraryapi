package io.github.joaorooliveira.libraryapi.repository;

import io.github.joaorooliveira.libraryapi.model.Autor;
import io.github.joaorooliveira.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


/*
 * @see LivroRepositoryTest
 */
public interface LivroRepository extends JpaRepository<Livro, UUID> {


    //Query method
    //select * from livro where id_autor = id
    List<Livro> findByAutor(Autor autor);


    //select *from livro where titulo = 'titulo'
    List<Livro> findByTitulo(String titulo);

    List<Livro> findByIsbn(String isbn);

    List<Livro> findByTituloAndPreco(String titulo, BigDecimal preco);

    // select *from livro where titulo = 'titulo' or isbn = 'isbn'
    List<Livro> findByTituloOrIsbn(String titulo, String isbn);

    //select * from livro where data_publicacao between 'inicio' and 'fim'
    List<Livro> findByDataPublicacaoBetween(LocalDate inicio, LocalDate fim);

    // JPQL -> referencia as entidades e as propriedades
    // select l.* from livro as l order by l.titulo
    @Query("select l from Livro as l order by l.titulo, l.preco")
    List<Livro> listarTodosOrdenadoPorTituloEPreco();

    /**
     * select a.*
     * from livro l
     * join autor a on a.id = l.id_autor
     */
    @Query("select l.autor from Livro l join l.autor a")
    List<Autor> listarAutoresDosLivros();
}