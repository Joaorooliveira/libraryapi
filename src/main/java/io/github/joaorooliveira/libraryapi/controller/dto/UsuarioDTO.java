package io.github.joaorooliveira.libraryapi.controller.dto;

import jakarta.validation.constraints.Email;

import java.util.List;

public record UsuarioDTO(String login, @Email String email, String senha, List<String> roles) {
}
