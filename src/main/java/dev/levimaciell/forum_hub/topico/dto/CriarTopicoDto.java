package dev.levimaciell.forum_hub.topico.dto;

import jakarta.validation.constraints.NotNull;

public record CriarTopicoDto(
        @NotNull
        String titulo,

        @NotNull
        String mensagem,

        @NotNull
        String autor,

        @NotNull
        String curso
){
}
