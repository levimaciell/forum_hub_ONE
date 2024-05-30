package dev.levimaciell.forum_hub.topico.repositories;

import dev.levimaciell.forum_hub.topico.entities.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    @Query("""
            select t from Topico t
            where t.titulo = :titulo and
            t.mensagem = :mensagem
            """)
    Optional<Topico> buscarTopicoPorTituloEMensagem(String titulo, String mensagem);
}
