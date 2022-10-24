package com.facom.arthurramires.backendpokemonp2.controller;
import com.facom.arthurramires.backendpokemonp2.model.dto.TipoPokemonDTO;
import com.facom.arthurramires.backendpokemonp2.model.entity.TipoPokemon;
import com.facom.arthurramires.backendpokemonp2.model.repository.TipoPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tipo-pokemon")
public class TipoPokemonController {
    @Autowired
    TipoPokemonRepository tipoPokemonRepository;

    @GetMapping
    public ResponseEntity<Object> getAllTipoPokemon(){
        return ResponseEntity.status(HttpStatus.OK).body(tipoPokemonRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> saveTipoPokemon(@RequestBody TipoPokemonDTO tipoPokemon){
        return ResponseEntity.status(HttpStatus.OK).body(tipoPokemon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTipoPokemon(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body("Invocou o PUT" + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTipoPokemon(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body("Invocou o DELETE"+id);
    }
}
