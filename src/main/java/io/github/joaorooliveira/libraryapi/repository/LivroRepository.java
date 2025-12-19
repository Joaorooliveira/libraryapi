package io.github.joaorooliveira.libraryapi.repository;

import io.github.joaorooliveira.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
}
