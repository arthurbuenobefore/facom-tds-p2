package com.facom.arthurramires.backendpokemonp2.controller;
import com.facom.arthurramires.backendpokemonp2.model.dto.HabilidadeDTO;
import com.facom.arthurramires.backendpokemonp2.model.dto.PokemonDTO;
import com.facom.arthurramires.backendpokemonp2.model.entity.Fraqueza;
import com.facom.arthurramires.backendpokemonp2.model.entity.Habilidade;
import com.facom.arthurramires.backendpokemonp2.model.entity.Pokemon;
import com.facom.arthurramires.backendpokemonp2.model.repository.HabilidadeRepository;
import com.facom.arthurramires.backendpokemonp2.model.repository.PokemonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/habilidade")
public class HabilidadeController {
    @Autowired
    HabilidadeRepository habilidadeRepository;

    @Autowired
    PokemonRepository pokemonRepository;

    @GetMapping
    public ResponseEntity<Object> getAllHabilidade(){
        return ResponseEntity.status(HttpStatus.OK).body(habilidadeRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> saveHabilidade(@RequestBody HabilidadeDTO habilidade){

        Optional<Pokemon> pokemonExists = pokemonRepository.findById(habilidade.getPokemon_id());

        if(pokemonExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon não Encontrado");
        }
        Habilidade habilidadeEntity = new Habilidade();
        habilidadeEntity.setPokemon(pokemonExists.get());
        BeanUtils.copyProperties(habilidade, habilidadeEntity);
        return ResponseEntity.status(HttpStatus.OK).body(habilidadeRepository.save(habilidadeEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateHabilidade(@PathVariable Long id, @RequestBody HabilidadeDTO habilidadeBody){
        Optional<Habilidade> habExists = habilidadeRepository.findById(id);

        if(habExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Habilidade não Encontrada");
        }

        Habilidade habEntity = habExists.get();
        BeanUtils.copyProperties(habilidadeBody, habEntity);

        return ResponseEntity.status(HttpStatus.OK).body(habilidadeRepository.save(habEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteHabilidade(@PathVariable Long id){
        Optional<Habilidade> habExists = habilidadeRepository.findById(id);

        if(habExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Habilidade não Encontrada");
        }
        habilidadeRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Habilidade deletada com sucesso!");
    }
}
