package com.facom.arthurramires.backendpokemonp2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PokemonDTO {
    private String nome;
    private long altura;
    private long peso;
    private long ataque;
    private long defesa;
    private long ataque_especial;
    private long defesa_especial;
    private long velocidade;
}
