package com.example.api_exo.stade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stades")
public class StadeController {

    private final StadeService stadeService;
    private final StadeRepository stadeRepository;

    @Autowired
    public StadeController(StadeService stadeService, StadeRepository stadeRepository) {
        this.stadeService = stadeService;
        this.stadeRepository = stadeRepository;
    }

    @GetMapping
    public List<Stade> getAllStades() {
        return stadeService.findAllStades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stade> findStade(@PathVariable Integer id) {
        Stade stade = stadeRepository.findById(id).orElse(null);
        if (stade != null) {
            return new ResponseEntity<>(stade, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Stade createStade(@RequestBody Stade stade) {
        return stadeService.saveStade(stade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stade> updateStade(@PathVariable Integer id, @RequestBody Stade stadeDetails) {
        Stade stadeAModifier = stadeRepository.findById(id).orElse(null);
        if (stadeAModifier != null) {
            stadeAModifier.setNom(stadeDetails.getNom());
            stadeAModifier.setCapacite(stadeDetails.getCapacite());
            stadeAModifier.setAdresse(stadeDetails.getAdresse());
            stadeRepository.save(stadeAModifier);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStade(@PathVariable Integer id) {
        if (!stadeRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        stadeRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
