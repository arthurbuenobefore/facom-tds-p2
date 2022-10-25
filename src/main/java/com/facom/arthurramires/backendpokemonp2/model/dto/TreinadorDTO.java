package com.facom.arthurramires.backendpokemonp2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TreinadorDTO {
    private String nome;
    private long xp;
    private List<Long> pokebolas;
}
