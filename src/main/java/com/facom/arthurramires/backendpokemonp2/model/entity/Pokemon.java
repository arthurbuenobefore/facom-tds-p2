package com.facom.arthurramires.backendpokemonp2.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pokemons")
public class Pokemon {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
	private long altura;
	private long peso;
	private long ataque;
    private long defesa;
    private long ataque_especial;
    private long defesa_especial;
    private long velocidade;

    @OneToOne(mappedBy = "pokemon")
    private Pokebola pokebola;

    @JsonManagedReference
    @ManyToMany(mappedBy = "pokemons", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<TipoPokemon> tipos = new ArrayList<TipoPokemon>();

    public void addTipos(TipoPokemon tipo) {
        tipos.add(tipo);
        tipo.getPokemons().add(this);
    }
}
