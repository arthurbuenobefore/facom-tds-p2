package com.facom.arthurramires.backendpokemonp2.controller;

import com.facom.arthurramires.backendpokemonp2.model.dto.TreinadorDTO;
import com.facom.arthurramires.backendpokemonp2.model.entity.Pokebola;
import com.facom.arthurramires.backendpokemonp2.model.entity.Pokemon;
import com.facom.arthurramires.backendpokemonp2.model.entity.TipoPokemon;
import com.facom.arthurramires.backendpokemonp2.model.entity.Treinador;
import com.facom.arthurramires.backendpokemonp2.model.repository.PokebolaRepository;
import com.facom.arthurramires.backendpokemonp2.model.repository.TreinadorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/treinador")
public class TreinadorController {

    @Autowired
    TreinadorRepository treinadorRepository;

    @Autowired
    PokebolaRepository pokebolaRepository;

    @GetMapping
    public ResponseEntity<Object> getAllTreinadores(){
        return ResponseEntity.status(HttpStatus.OK).body(treinadorRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> saveTreinador(@RequestBody TreinadorDTO treinadorBody){
        Treinador treinadorEntity = new Treinador();
        BeanUtils.copyProperties(treinadorBody, treinadorEntity);
        if(treinadorBody.getPokebolas() != null){
            for(Long pokeBolaId: treinadorBody.getPokebolas()){
                Optional<Pokebola> pokeExists = pokebolaRepository.findById(pokeBolaId);

                pokeExists.ifPresent(treinadorEntity::addPokebola);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(treinadorRepository.save(treinadorEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTreinador(@PathVariable Long id, @RequestBody TreinadorDTO treinadorBody){
        Optional<Treinador> treinadorExists = treinadorRepository.findById(id);

        if(treinadorExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Treinador não Encontrado");
        }

        Treinador treinadorEntity = treinadorExists.get();
        BeanUtils.copyProperties(treinadorBody, treinadorEntity);

        if(treinadorBody.getPokebolas() != null){
            for(Long pokeBolaId: treinadorBody.getPokebolas()){
                Optional<Pokebola> pokeExists = pokebolaRepository.findById(pokeBolaId);
                pokeExists.ifPresent(treinadorEntity::addPokebola);
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(treinadorRepository.save(treinadorEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTreinador(@PathVariable Long id){
        Optional<Treinador> treinadorExists = treinadorRepository.findById(id);

        if(treinadorExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Treinador não Encontrado");
        }
        treinadorRepository.deleteById(id);
        //TODO: fazer o delete das pokebolas vinculadas a este treinador
        return ResponseEntity.status(HttpStatus.OK).body("Treinador deletado com sucesso!");
    }
}
