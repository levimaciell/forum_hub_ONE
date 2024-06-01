package dev.levimaciell.forum_hub.exception;

import org.springframework.validation.FieldError;

public record ErroCampo(String campo, String erro) {
    public ErroCampo(FieldError error){
        this(error.getField(), error.getDefaultMessage());
    }
}
