package com.facom.arthurramires.backendpokemonp2.model.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fraquezas")
public class Fraqueza {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
}
