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
@Table(name = "pokebolas")
public class Pokebola {
    @Id
    @GeneratedValue
    private Long id;}
