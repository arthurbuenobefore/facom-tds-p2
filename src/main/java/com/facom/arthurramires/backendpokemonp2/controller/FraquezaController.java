package com.facom.arthurramires.backendpokemonp2.controller;
import com.facom.arthurramires.backendpokemonp2.model.dto.FraquezaDTO;
import com.facom.arthurramires.backendpokemonp2.model.entity.Fraqueza;
import com.facom.arthurramires.backendpokemonp2.model.repository.FraquezaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.status(HttpStatus.OK).body(fraqueza);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFraqueza(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body("Invocou o PUT" + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFraqueza(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body("Invocou o DELETE"+id);
    }
}
