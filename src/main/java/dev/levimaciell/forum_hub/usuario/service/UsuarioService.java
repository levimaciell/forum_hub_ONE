package dev.levimaciell.forum_hub.usuario.service;

import dev.levimaciell.forum_hub.usuario.dto.CriarUsuarioDto;
import dev.levimaciell.forum_hub.usuario.entity.Usuario;
import dev.levimaciell.forum_hub.usuario.repository.UsuarioRepository;
import dev.levimaciell.forum_hub.util.Validacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private List<Validacao<CriarUsuarioDto>> validacoesCriarUsuario;

    public void criarUsuario(CriarUsuarioDto dto) {
        validacoesCriarUsuario.forEach(v -> v.validar(dto));

        Usuario usuario = new Usuario(dto);

        repository.save(usuario);
    }
}
