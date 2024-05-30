package dev.levimaciell.forum_hub.topico.services;

import dev.levimaciell.forum_hub.topico.dto.CriarTopicoDto;
import dev.levimaciell.forum_hub.topico.entities.Topico;
import dev.levimaciell.forum_hub.topico.repositories.TopicoRepository;
import dev.levimaciell.forum_hub.util.Validacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private List<Validacao<CriarTopicoDto>> validacoesCriarTopico;

    public Topico criarTopico(CriarTopicoDto dto){
        Topico topico = new Topico(dto);

        validacoesCriarTopico.forEach(v -> v.validar(dto));

        topicoRepository.save(topico);
        return topico;
    }

}
