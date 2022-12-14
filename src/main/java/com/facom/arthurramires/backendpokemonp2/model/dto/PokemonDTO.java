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
public class PokemonDTO {
    private String nome;
    private long altura;
    private long peso;
    private long ataque;
    private long defesa;
    private long ataque_especial;
    private long defesa_especial;
    private long velocidade;
    private long pokebola_id;
    private List<Long> tipos;
}
