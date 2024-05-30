package dev.levimaciell.forum_hub.topico.dto;

import jakarta.validation.constraints.NotBlank;

public record CriarTopicoDto(
        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotBlank
        String autor,

        @NotBlank
        String curso
){
}
