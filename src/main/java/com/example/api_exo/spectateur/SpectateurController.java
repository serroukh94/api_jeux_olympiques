package com.example.api_exo.spectateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spectateurs")
public class SpectateurController {

    private final SpectateurService spectateurService;
    private final SpectateurRepository spectateurRepository;

    @Autowired
    public SpectateurController(SpectateurService spectateurService, SpectateurRepository spectateurRepository) {
        this.spectateurService = spectateurService;
        this.spectateurRepository = spectateurRepository;
    }

    @GetMapping
    public List<Spectateur> getAllSpectateurs() {
        return spectateurService.findAllSpectateurs();
    }

    @GetMapping("/{idSpectateur}")
    public ResponseEntity<Spectateur> findSpectateur(@PathVariable Integer idSpectateur) {
        Spectateur spectateur = spectateurRepository.findById(idSpectateur).orElse(null);
        if(spectateur != null) {
            return new ResponseEntity<>(spectateur, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Spectateur createSpectateur(@RequestBody Spectateur spectateur) {
        return spectateurService.save(spectateur);
    }

    @PutMapping("/{idSpectateur}")
    public ResponseEntity<Spectateur> updateSpectateur(@PathVariable Integer idSpectateur, @RequestBody Spectateur spectateur) {
        Spectateur spectateurAModifier = spectateurRepository.findById(idSpectateur).orElse(null);
        if (spectateurAModifier != null) {
            spectateurAModifier.setNom(spectateur.getNom());
            spectateurAModifier.setEmail(spectateur.getEmail());
            spectateurRepository.save(spectateurAModifier);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{idSpectateur}")
    public ResponseEntity<?> deleteSpectateur(@PathVariable Integer idSpectateur) {
        if(!spectateurRepository.existsById(idSpectateur)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        spectateurRepository.deleteById(idSpectateur);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
