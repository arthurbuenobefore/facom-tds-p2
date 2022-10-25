package com.facom.arthurramires.backendpokemonp2.controller;
import com.facom.arthurramires.backendpokemonp2.model.dto.FraquezaDTO;
import com.facom.arthurramires.backendpokemonp2.model.dto.PokebolaDTO;
import com.facom.arthurramires.backendpokemonp2.model.entity.Fraqueza;
import com.facom.arthurramires.backendpokemonp2.model.entity.Pokebola;
import com.facom.arthurramires.backendpokemonp2.model.entity.Pokemon;
import com.facom.arthurramires.backendpokemonp2.model.entity.Treinador;
import com.facom.arthurramires.backendpokemonp2.model.repository.FraquezaRepository;
import com.facom.arthurramires.backendpokemonp2.model.repository.PokebolaRepository;
import com.facom.arthurramires.backendpokemonp2.model.repository.PokemonRepository;
import com.facom.arthurramires.backendpokemonp2.model.repository.TreinadorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/pokebola")
public class PokebolaController {
    @Autowired
    PokebolaRepository pokebolaRepository;

    @Autowired
    TreinadorRepository treinadorRepository;
    @GetMapping
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(pokebolaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody PokebolaDTO pokebola){
        Optional<Treinador> treinadorExists = treinadorRepository.findById(pokebola.getTreinador_id());

        if(treinadorExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Treinador não Encontrado");
        }
        Pokebola pokebolaEntity = new Pokebola();
        pokebolaEntity.setTreinador(treinadorExists.get());
        BeanUtils.copyProperties(pokebola, pokebolaEntity);
        return ResponseEntity.status(HttpStatus.OK).body(pokebolaRepository.save(pokebolaEntity));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody PokebolaDTO pokebola){
        Optional<Pokebola> pokeExists = pokebolaRepository.findById(id);

        if(pokeExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokebola não Encontrada");
        }

        Optional<Treinador> treinadorExists = treinadorRepository.findById(pokebola.getTreinador_id());

        if(treinadorExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Treinador não Encontrado");
        }
        Pokebola pokebolaEntity = new Pokebola();
        pokebolaEntity.setTreinador(treinadorExists.get());
        BeanUtils.copyProperties(pokebola, pokebolaEntity);
        return ResponseEntity.status(HttpStatus.OK).body(pokebolaRepository.save(pokebolaEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        Optional<Pokebola> pokeExists = pokebolaRepository.findById(id);

        if(pokeExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokebola não Encontrada");
        }
        pokebolaRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pokebola deletada com sucesso!");
    }
}
