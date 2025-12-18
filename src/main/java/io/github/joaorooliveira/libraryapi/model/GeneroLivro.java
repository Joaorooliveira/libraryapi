package io.github.joaorooliveira.libraryapi.model;

import jakarta.persistence.Embeddable;

@Embeddable
public enum GeneroLivro {

    FICCAO,
    FANTASIA,
    MISTERIO,
    ROMANCE,
    BIOGRAFIA,
    CIENCIA
}
