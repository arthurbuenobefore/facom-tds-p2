package com.facom.arthurramires.backendpokemonp2.controller;
import com.facom.arthurramires.backendpokemonp2.model.dto.HabilidadeDTO;
import com.facom.arthurramires.backendpokemonp2.model.entity.Habilidade;
import com.facom.arthurramires.backendpokemonp2.model.repository.HabilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/habilidade")
public class HabilidadeController {
    @Autowired
    HabilidadeRepository habilidadeRepository;

    @GetMapping
    public ResponseEntity<Object> getAllHabilidade(){
        return ResponseEntity.status(HttpStatus.OK).body(habilidadeRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> saveHabilidade(@RequestBody HabilidadeDTO habilidade){
        return ResponseEntity.status(HttpStatus.OK).body(habilidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateHabilidade(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body("Invocou o PUT" + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteHabilidade(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body("Invocou o DELETE"+id);
    }
}
