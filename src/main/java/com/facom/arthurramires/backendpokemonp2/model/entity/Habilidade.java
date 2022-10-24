package com.facom.arthurramires.backendpokemonp2.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "habilidades")
public class Habilidade {
    private String nome;
    private Long id;

//    @JsonBackReference
//    @ManyToMany
//    @JoinTable(name = "pokemon_habilidade", joinColumns = @JoinColumn(name = "habilidade_id"), inverseJoinColumns = @JoinColumn(name = "pokemon_id"))
//    private List<Habilidade> habilidades;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
}
