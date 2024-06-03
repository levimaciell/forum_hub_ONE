package dev.levimaciell.forum_hub.usuario.controller;

import dev.levimaciell.forum_hub.security.TokenDados;
import dev.levimaciell.forum_hub.security.TokenService;
import dev.levimaciell.forum_hub.usuario.dto.DadosUsuarioDto;
import dev.levimaciell.forum_hub.usuario.entity.Usuario;
import dev.levimaciell.forum_hub.usuario.service.SignupService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class UsuarioController {

    @Autowired
    private SignupService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
    private DadosUsuarioDto dto;

    @PostMapping("/signup")
    @Transactional
    public ResponseEntity criarUsuario(@RequestBody @Valid DadosUsuarioDto dto){
        this.dto = dto;
        service.criarUsuario(dto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    @Transactional
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosUsuarioDto dto){
        var authToken = new UsernamePasswordAuthenticationToken(dto.usuario(), dto.senha());
        var authentication = authenticationManager.authenticate(authToken);
        var tokenJwt = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenDados(tokenJwt));
    }

}
