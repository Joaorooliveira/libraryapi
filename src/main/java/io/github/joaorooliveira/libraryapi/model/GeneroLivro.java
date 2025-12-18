package io.github.joaorooliveira.libraryapi.model;

import jakarta.persistence.Embeddable;

@Embeddable
public enum Genero {

    FICCAO,
    FANTASIA,
    MISTERIO,
    ROMANCE,
    BIOGRAFIA,
    CIENCIA
}
