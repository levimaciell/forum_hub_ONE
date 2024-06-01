package dev.levimaciell.forum_hub.topico.validacoes;

import dev.levimaciell.forum_hub.topico.dto.CriarTopicoDto;
import dev.levimaciell.forum_hub.topico.entities.Topico;
import dev.levimaciell.forum_hub.topico.exceptions.ValidacaoException;
import dev.levimaciell.forum_hub.topico.repositories.TopicoRepository;
import dev.levimaciell.forum_hub.util.Validacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidarTopicoDuplicado implements Validacao<CriarTopicoDto> {

    @Autowired
    private TopicoRepository repository;

    @Override
    public void validar(CriarTopicoDto dto) {
        Optional<Topico> topicoEncontrado = repository.buscarTopicoPorTituloEMensagem(dto.titulo(), dto.mensagem());

        if(topicoEncontrado.isPresent())
            throw new ValidacaoException("Tópico duplicado! Já existe um com o mesmo título e a mesma mensagem!");
    }
}
