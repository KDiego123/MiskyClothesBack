package com.upc.miskyclothes.controller;

import com.upc.miskyclothes.entities.Opinion;
import com.upc.miskyclothes.repository.OpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/opiniones")
public class OpinionController {
    @Autowired
    private OpinionRepository opinionRepository;

    @PostMapping("/crear")
    public ResponseEntity<Opinion> crearOpinion(@RequestBody Opinion opinion) {
        Opinion nuevaOpinion = opinionRepository.save(opinion);
        return ResponseEntity.ok(nuevaOpinion);
    }

    @DeleteMapping("/borrar")
    public ResponseEntity<Void> eliminarOpinion(@PathVariable Long opinionId) {
        opinionRepository.deleteById(opinionId);
        return ResponseEntity.noContent().build();
    }
}
