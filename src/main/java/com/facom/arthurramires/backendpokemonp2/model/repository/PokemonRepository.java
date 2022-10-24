package com.facom.arthurramires.backendpokemonp2.model.repository;

import com.facom.arthurramires.backendpokemonp2.model.entity.Pokemon;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {

}
