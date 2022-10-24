package com.facom.arthurramires.backendpokemonp2.controller;
import com.facom.arthurramires.backendpokemonp2.model.dto.FraquezaDTO;
import com.facom.arthurramires.backendpokemonp2.model.dto.HabilidadeDTO;
import com.facom.arthurramires.backendpokemonp2.model.entity.Fraqueza;
import com.facom.arthurramires.backendpokemonp2.model.entity.Habilidade;
import com.facom.arthurramires.backendpokemonp2.model.repository.FraquezaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/fraqueza")
public class FraquezaController {
    @Autowired
    FraquezaRepository fraquezaRepository;

    @GetMapping
    public ResponseEntity<Object> getAllFraqueza(){
        return ResponseEntity.status(HttpStatus.OK).body(fraquezaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> saveFraqueza(@RequestBody FraquezaDTO fraqueza){
        Fraqueza fraquezaEntity = new Fraqueza();
        BeanUtils.copyProperties(fraqueza, fraquezaEntity);
        return ResponseEntity.status(HttpStatus.OK).body(fraquezaRepository.save(fraquezaEntity));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFraqueza(@PathVariable Long id, @RequestBody FraquezaDTO fraquezaBody){
        Optional<Fraqueza> fraqExists = fraquezaRepository.findById(id);

        if(fraqExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fraqueza não Encontrada");
        }

        Fraqueza fraqEntity = fraqExists.get();
        BeanUtils.copyProperties(fraquezaBody, fraqEntity);

        return ResponseEntity.status(HttpStatus.OK).body(fraquezaRepository.save(fraqEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFraqueza(@PathVariable Long id){
        Optional<Fraqueza> fraqExists = fraquezaRepository.findById(id);

        if(fraqExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fraqueza não Encontrada");
        }
        fraquezaRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Fraqueza deletada com sucesso!");
    }
}
