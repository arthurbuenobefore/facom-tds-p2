package com.facom.arthurramires.backendpokemonp2.controller;

import com.facom.arthurramires.backendpokemonp2.model.dto.TreinadorDTO;
import com.facom.arthurramires.backendpokemonp2.model.entity.Treinador;
import com.facom.arthurramires.backendpokemonp2.model.repository.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/treinador")
public class TreinadorController {

    @Autowired
    TreinadorRepository treinadorRepository;

    @GetMapping
    public ResponseEntity<Object> getAllTreinadores(){
        return ResponseEntity.status(HttpStatus.OK).body(treinadorRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> saveTreinador(@RequestBody TreinadorDTO treinadorBody){
        return ResponseEntity.status(HttpStatus.OK).body(treinadorBody);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTreinador(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body("Invocou o PUT" + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTreinador(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body("Invocou o DELETE"+id);
    }
}
