package io.github.joaorooliveira.libraryapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "livro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "autor")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;

    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;

    @Column(name = "data_publicacao", nullable = false)
    private LocalDate dataPublicacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero", nullable = false, length = 30)
    private GeneroLivro genero;

    @Column(name = "preco", precision = 18, scale = 2)
    private BigDecimal preco;

    @ManyToOne(fetch = FetchType.LAZY)//(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_autor")
    private Autor autor;
}
