package dev.levimaciell.forum_hub.exception;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record ErroApiDtoMultiplosErros(
    LocalDateTime timestamp,
    Integer status_code,
    String error_name,
    String message,
    String path,
    List<ErroCampo> erros
) {
}
