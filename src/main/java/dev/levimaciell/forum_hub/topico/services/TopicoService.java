package dev.levimaciell.forum_hub.topico.services;

import dev.levimaciell.forum_hub.topico.dto.CriarTopicoDto;
import dev.levimaciell.forum_hub.topico.dto.TopicoDto;
import dev.levimaciell.forum_hub.topico.entities.Topico;
import dev.levimaciell.forum_hub.topico.repositories.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public Topico criarTopico(CriarTopicoDto dto){
        Topico topico = new Topico(dto);
        System.out.println(topico.getTopicoAtivo());
        topicoRepository.save(topico);
        return topico;
    }

}
