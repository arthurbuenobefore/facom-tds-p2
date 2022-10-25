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

    @OneToMany(mappedBy="treinador", cascade=CascadeType.ALL)
    private List<Pokebola> pokebolas;

    public void addPokebola(Pokebola pokebola) {
        pokebola.setTreinador(this);
        pokebolas.add(pokebola);
    }
}
