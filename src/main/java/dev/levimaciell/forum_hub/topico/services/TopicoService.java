package dev.levimaciell.forum_hub.topico.services;

import dev.levimaciell.forum_hub.topico.dto.CriarTopicoDto;
import dev.levimaciell.forum_hub.topico.dto.TopicoDto;
import dev.levimaciell.forum_hub.topico.entities.Topico;
import dev.levimaciell.forum_hub.topico.repositories.TopicoRepository;
import dev.levimaciell.forum_hub.util.Validacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public TopicoDto atualizarTopico(CriarTopicoDto dto, Long id) {

        var topico = topicoRepository.findById(id).orElseThrow(() -> new RuntimeException(
                "Tópico não encontrado!"
        ));

        validacoesCriarTopico.forEach(v -> v.validar(dto));

        topico.setTitulo(dto.titulo());
        topico.setMensagem(dto.mensagem());
        topico.setAutor(dto.autor());
        topico.setCurso(dto.curso());

        return new TopicoDto(topico);
    }

    public TopicoDto buscarPorId(Long id) {
        var topico = topicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Topico não encontrado!"));
        return new TopicoDto(topico);
    }

    public Page<TopicoDto> buscarTodos(Pageable pageable) {
        return topicoRepository.listarPaginacao(pageable);
    }

    public Page<TopicoDto> buscarPorCurso(String curso, Pageable pageable) {
        curso = curso.replace("-", " ");
        return topicoRepository.listarPorCurso(pageable, curso);
    }

    public Page<TopicoDto> buscarPorAno(Integer ano, Pageable pageable) {
        return topicoRepository.listarPorAno(ano, pageable);
    }


    public TopicoDto deletarPorId(Long id) {
        var topico = topicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Topico não encontrado!"));
        topicoRepository.deleteById(id);
        return new TopicoDto(topico);
    }
}
