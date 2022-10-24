package com.facom.arthurramires.backendpokemonp2.controller;

import com.facom.arthurramires.backendpokemonp2.model.dto.TreinadorDTO;
import com.facom.arthurramires.backendpokemonp2.model.entity.Treinador;
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

    @GetMapping
    public ResponseEntity<Object> getAllTreinadores(){
        return ResponseEntity.status(HttpStatus.OK).body(treinadorRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> saveTreinador(@RequestBody TreinadorDTO treinadorBody){
        Treinador treinadorEntity = new Treinador();
        BeanUtils.copyProperties(treinadorBody, treinadorEntity);
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

        return ResponseEntity.status(HttpStatus.OK).body(treinadorRepository.save(treinadorEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTreinador(@PathVariable Long id){
        Optional<Treinador> treinadorExists = treinadorRepository.findById(id);

        if(treinadorExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Treinador não Encontrado");
        }
        treinadorRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Treinador deletado com sucesso!");
    }
}
