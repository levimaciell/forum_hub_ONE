package dev.levimaciell.forum_hub.usuario.service;

import dev.levimaciell.forum_hub.usuario.dto.DadosUsuarioDto;
import dev.levimaciell.forum_hub.usuario.entity.Usuario;
import dev.levimaciell.forum_hub.usuario.repository.UsuarioRepository;
import dev.levimaciell.forum_hub.util.Validacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignupService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private List<Validacao<DadosUsuarioDto>> validacoesCriarUsuario;

    public void criarUsuario(DadosUsuarioDto dto) {
        validacoesCriarUsuario.forEach(v -> v.validar(dto));

        Usuario usuario = new Usuario(new DadosUsuarioDto(dto.email(), passwordEncoder.encode(dto.senha())));

        repository.save(usuario);
    }
}
