package com.facom.arthurramires.backendpokemonp2.controller;
import com.facom.arthurramires.backendpokemonp2.model.dto.PokemonDTO;
import com.facom.arthurramires.backendpokemonp2.model.entity.Pokemon;
import com.facom.arthurramires.backendpokemonp2.model.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {
    @Autowired
    PokemonRepository pokemonRepository;

    @GetMapping
    public ResponseEntity<Object> getAllPokemon(){
        return ResponseEntity.status(HttpStatus.OK).body(pokemonRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> savePokemon(@RequestBody PokemonDTO pokemon){
        return ResponseEntity.status(HttpStatus.OK).body(pokemon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePokemon(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body("Invocou o PUT" + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePokemon(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body("Invocou o DELETE"+id);
    }
}
