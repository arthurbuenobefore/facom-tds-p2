package com.facom.arthurramires.backendpokemonp2.controller;
import com.facom.arthurramires.backendpokemonp2.model.dto.PokemonDTO;
import com.facom.arthurramires.backendpokemonp2.model.dto.TipoPokemonDTO;
import com.facom.arthurramires.backendpokemonp2.model.entity.Fraqueza;
import com.facom.arthurramires.backendpokemonp2.model.entity.Habilidade;
import com.facom.arthurramires.backendpokemonp2.model.entity.Pokemon;
import com.facom.arthurramires.backendpokemonp2.model.entity.TipoPokemon;
import com.facom.arthurramires.backendpokemonp2.model.repository.FraquezaRepository;
import com.facom.arthurramires.backendpokemonp2.model.repository.HabilidadeRepository;
import com.facom.arthurramires.backendpokemonp2.model.repository.PokemonRepository;
import com.facom.arthurramires.backendpokemonp2.model.repository.TipoPokemonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {
    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    TipoPokemonRepository tipoPokemonRepository;

    @Autowired
    HabilidadeRepository habilidadeRepository;

    @Autowired
    FraquezaRepository fraquezaRepository;

    @GetMapping
    public ResponseEntity<Object> getAllPokemon(){
        return ResponseEntity.status(HttpStatus.OK).body(pokemonRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> savePokemon(@RequestBody PokemonDTO pokemon){
        Pokemon pokemonEntity = new Pokemon();

        for(Long tipoId: pokemon.getTipos()){
            Optional<TipoPokemon> tipoExists = tipoPokemonRepository.findById(tipoId);

            if(tipoExists.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo do pokemon não Encontrado");
            }

            //pokemonEntity.setTipos(tipoExists.get());
        }
        BeanUtils.copyProperties(pokemon, pokemonEntity);


        return ResponseEntity.status(HttpStatus.OK).body(pokemonRepository.save(pokemonEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePokemon(@PathVariable Long id, @RequestBody PokemonDTO pokemonBody){
        Optional<Pokemon> pokemonExists = pokemonRepository.findById(id);

        if(pokemonExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon não Encontrado");
        }

        Pokemon pokemonEntity = pokemonExists.get();
        BeanUtils.copyProperties(pokemonBody, pokemonEntity);

        return ResponseEntity.status(HttpStatus.OK).body(pokemonRepository.save(pokemonEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePokemon(@PathVariable Long id){
        Optional<Pokemon> pokemonExists = pokemonRepository.findById(id);

        if(pokemonExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon não Encontrado");
        }
        pokemonRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pokemon deletado com sucesso!");
    }
}
