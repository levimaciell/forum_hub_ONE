package dev.levimaciell.forum_hub.topico.entities;

import dev.levimaciell.forum_hub.topico.dto.CriarTopicoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String mensagem;
    private LocalDateTime dataCriacao;
    private Boolean topicoAtivo;
    private String autor;
    private String curso;

    public Topico(CriarTopicoDto dto) {
        this.titulo = dto.titulo();
        this.mensagem = dto.mensagem();
        this.dataCriacao = LocalDateTime.now();
        this.topicoAtivo = true;
        this.autor = dto.autor();
        this.curso = dto.curso();
    }
}
