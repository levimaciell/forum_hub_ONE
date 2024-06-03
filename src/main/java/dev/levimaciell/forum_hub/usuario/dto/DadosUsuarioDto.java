package dev.levimaciell.forum_hub.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosUsuarioDto(
        @NotBlank(message = "Campo email não pode ser nulo!")
        @Email(message = "Por favor, digite um email válido!")
        String email,

        @NotBlank(message = "Campo senha não pode ser nulo!")
        @Size(min = 6, message = "Senha não pode ser menor que 6 caracteres")
        String senha
) {
}
