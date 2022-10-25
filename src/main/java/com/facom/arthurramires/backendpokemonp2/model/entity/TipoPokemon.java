package com.facom.arthurramires.backendpokemonp2.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "tipo_pokemon")
public class TipoPokemon {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "pokemon_tipo", joinColumns = @JoinColumn(name = "tipo_id"), inverseJoinColumns = @JoinColumn(name = "pokemon_id"))
    private List<Pokemon> pokemons;
}
