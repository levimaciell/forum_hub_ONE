package dev.levimaciell.forum_hub.usuario.validacoes;

import dev.levimaciell.forum_hub.topico.exceptions.ValidacaoException;
import dev.levimaciell.forum_hub.usuario.dto.CriarUsuarioDto;
import dev.levimaciell.forum_hub.usuario.repository.UsuarioRepository;
import dev.levimaciell.forum_hub.util.Validacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarUsuarioJaExistente implements Validacao<CriarUsuarioDto> {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validar(CriarUsuarioDto dto) {
        if(repository.existsByEmail(dto.email()))
            throw new ValidacaoException("Usuário com email informado já existe!");
    }
}