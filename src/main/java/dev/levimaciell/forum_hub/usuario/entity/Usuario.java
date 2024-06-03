package dev.levimaciell.forum_hub.usuario.entity;

import dev.levimaciell.forum_hub.usuario.dto.CriarUsuarioDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;

    public Usuario(CriarUsuarioDto dto){
        this.email = dto.email();
        this.senha = dto.senha();
    }
}
