package com.facom.arthurramires.backendpokemonp2.model.repository;

import com.facom.arthurramires.backendpokemonp2.model.entity.Pokebola;
import com.facom.arthurramires.backendpokemonp2.model.entity.Treinador;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PokebolaRepository extends CrudRepository<Pokebola, Long> {
    List<Pokebola> getPokebolaByTreinador(Treinador treinador);
}
