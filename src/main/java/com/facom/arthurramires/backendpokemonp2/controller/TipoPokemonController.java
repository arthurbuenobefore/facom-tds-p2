package com.facom.arthurramires.backendpokemonp2.controller;
import com.facom.arthurramires.backendpokemonp2.model.dto.TipoPokemonDTO;
import com.facom.arthurramires.backendpokemonp2.model.dto.TreinadorDTO;
import com.facom.arthurramires.backendpokemonp2.model.entity.TipoPokemon;
import com.facom.arthurramires.backendpokemonp2.model.entity.Treinador;
import com.facom.arthurramires.backendpokemonp2.model.repository.TipoPokemonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        TipoPokemon tipoPokemonEntity = new TipoPokemon();
        BeanUtils.copyProperties(tipoPokemon, tipoPokemonEntity);
        return ResponseEntity.status(HttpStatus.OK).body(tipoPokemonRepository.save(tipoPokemonEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTipoPokemon(@PathVariable Long id, @RequestBody TipoPokemonDTO tipoBody){
        Optional<TipoPokemon> tipoExists = tipoPokemonRepository.findById(id);

        if(tipoExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo não Encontrado");
        }

        TipoPokemon tipoEntity = tipoExists.get();
        BeanUtils.copyProperties(tipoBody, tipoEntity);

        return ResponseEntity.status(HttpStatus.OK).body(tipoPokemonRepository.save(tipoEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTipoPokemon(@PathVariable Long id){
        Optional<TipoPokemon> tipoExists = tipoPokemonRepository.findById(id);

        if(tipoExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo não Encontrado");
        }
        tipoPokemonRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Tipo de Pokemon deletado com sucesso!");
    }
}
