package dev.levimaciell.forum_hub.usuario.controller;

import dev.levimaciell.forum_hub.usuario.dto.CriarUsuarioDto;
import dev.levimaciell.forum_hub.usuario.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/signup")
    @Transactional
    public ResponseEntity criarUsuario(@RequestBody @Valid CriarUsuarioDto dto){
        service.criarUsuario(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }


}
