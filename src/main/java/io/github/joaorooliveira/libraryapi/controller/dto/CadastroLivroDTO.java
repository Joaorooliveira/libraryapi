package io.github.joaorooliveira.libraryapi.controller.dto;

import io.github.joaorooliveira.libraryapi.model.GeneroLivro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.ISBN;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CadastroLivroDTO(

        @NotBlank(message = "campo obrigatório")
        @ISBN
        String isbn,

        @NotBlank(message = "campo obrigatório")
        @Size(min = 1, message = "campo fora do tamanho padrao")
        String titulo,

        @Past(message = "Data nao pode ser futura")
        @NotNull
        LocalDate dataPublicacao,

        GeneroLivro genero,

        BigDecimal preco,

        @NotNull(message = "campo obrigatório")
        UUID idAutor
) {
}
