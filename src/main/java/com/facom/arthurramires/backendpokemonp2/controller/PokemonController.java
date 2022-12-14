package com.facom.arthurramires.backendpokemonp2.controller;
import com.facom.arthurramires.backendpokemonp2.model.dto.PokemonDTO;
import com.facom.arthurramires.backendpokemonp2.model.entity.Pokebola;
import com.facom.arthurramires.backendpokemonp2.model.entity.Pokemon;
import com.facom.arthurramires.backendpokemonp2.model.entity.TipoPokemon;
import com.facom.arthurramires.backendpokemonp2.model.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class PokemonController {
    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    TipoPokemonRepository tipoPokemonRepository;

    @Autowired
    HabilidadeRepository habilidadeRepository;

    @Autowired
    FraquezaRepository fraquezaRepository;

    @Autowired
    PokebolaRepository pokebolaRepository;

    @GetMapping("/pokemon")
    public ResponseEntity<Object> getAllPokemon(){
        return ResponseEntity.status(HttpStatus.OK).body(pokemonRepository.findAll());
    }

    @GetMapping("/pokemons")
    public ResponseEntity<Object> getAllPokemonFiltered(@RequestParam String tipo){
        Optional<TipoPokemon> tipoExists = tipoPokemonRepository.findById(Long.parseLong(tipo));
        if(tipoExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Nenhum pokemon encontrado");
        }

        Iterable<Pokemon> pokemons = pokemonRepository.findAll();
        List<Pokemon> pokemonsFiltrados = new ArrayList<>();

        for (Pokemon p : pokemons) {
            if (p.getTipos().contains(tipoExists.get()) ) {
                pokemonsFiltrados.add(p);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(pokemonsFiltrados);
    }

    @GetMapping("/pokemon/{id}")
    public ResponseEntity<Object> getPokemon(@PathVariable String id){
        Optional<Pokemon> pokemon = pokemonRepository.findById(Long.parseLong(id));

        if(pokemon.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Nenhum pokemon encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(pokemon);
    }

    @GetMapping("/pokemons/ranked")
    public ResponseEntity<Object> getPokemonRanked(){
        List<Pokemon> pokemons = pokemonRepository.findAllPokemonOrderByPokebolaIsNotNull();

        return ResponseEntity.status(HttpStatus.OK).body(pokemons);
    }

    @PostMapping("/pokemon")
    public ResponseEntity<Object> savePokemon(@RequestBody PokemonDTO pokemon){
        Pokemon pokemonEntity = new Pokemon();
        BeanUtils.copyProperties(pokemon, pokemonEntity);
        for(Long tipoId: pokemon.getTipos()){
            Optional<TipoPokemon> tipoExists = tipoPokemonRepository.findById(tipoId);

            if(tipoExists.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo do pokemon n??o Encontrado");
            }

            pokemonEntity.addTipos(tipoExists.get());
        }

        Long pokebolaId = pokemon.getPokebola_id();
        Optional<Pokebola> pokebolaExists = pokebolaRepository.findById(pokebolaId);

        if(pokebolaExists.isPresent()){
            Pokebola pokebolaEntity = pokebolaExists.get();
            pokebolaEntity.setPokemon(pokemonEntity);
            pokebolaRepository.save(pokebolaEntity);
        }

        return ResponseEntity.status(HttpStatus.OK).body(pokemonRepository.save(pokemonEntity));
    }

    @PutMapping("/pokemon/{id}")
    public ResponseEntity<Object> updatePokemon(@PathVariable Long id, @RequestBody PokemonDTO pokemonBody){
        Optional<Pokemon> pokemonExists = pokemonRepository.findById(id);

        if(pokemonExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon n??o Encontrado");
        }

        Pokemon pokemonEntity = pokemonExists.get();
        BeanUtils.copyProperties(pokemonBody, pokemonEntity);

        for(Long tipoId: pokemonBody.getTipos()){
            Optional<TipoPokemon> tipoExists = tipoPokemonRepository.findById(tipoId);

            if(tipoExists.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo do pokemon n??o Encontrado");
            }

            pokemonEntity.addTipos(tipoExists.get());
        }

        Long pokebolaId = pokemonBody.getPokebola_id();
        Optional<Pokebola> pokebolaExists = pokebolaRepository.findById(pokebolaId);

        if(pokebolaExists.isPresent()){
            Pokebola pokebolaEntity = pokebolaExists.get();
            pokebolaEntity.setPokemon(pokemonEntity);
            pokebolaRepository.save(pokebolaEntity);
        }

        return ResponseEntity.status(HttpStatus.OK).body(pokemonRepository.save(pokemonEntity));
    }

    @DeleteMapping("/pokemon/{id}")
    public ResponseEntity<Object> deletePokemon(@PathVariable Long id){
        Optional<Pokemon> pokemonExists = pokemonRepository.findById(id);

        if(pokemonExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon n??o Encontrado");
        }

        List<TipoPokemon> pokemonTipos = pokemonExists.get().getTipos();

        for(TipoPokemon tipo: pokemonTipos){
            Optional<TipoPokemon> tipoExists = tipoPokemonRepository.findById(tipo.getId());

            if(tipoExists.isPresent()){
                tipoPokemonRepository.deleteById(tipo.getId());
            }
        }

        pokemonRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pokemon deletado com sucesso!");
    }
}
