package com.facom.arthurramires.backendpokemonp2.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "treinadores")
public class Treinador {
    private String nome;
	private long xp;
    private Long id;

//    @OneToMany
//    private List<Pokebola> pokebolas;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
}
