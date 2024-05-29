package dev.levimaciell.forum_hub.topico.repositories;

import dev.levimaciell.forum_hub.topico.entities.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
