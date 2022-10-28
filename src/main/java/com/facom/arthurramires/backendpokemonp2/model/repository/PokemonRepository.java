package com.facom.arthurramires.backendpokemonp2.model.repository;

import com.facom.arthurramires.backendpokemonp2.model.entity.Pokebola;
import com.facom.arthurramires.backendpokemonp2.model.entity.Pokemon;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
    List<Pokemon> findAllPokemonOrderByPokebolaIsNotNull();
}
