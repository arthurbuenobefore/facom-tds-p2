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
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
	private long xp;
//    @OneToMany
//    private List<Pokebola> pokebolas;
}
