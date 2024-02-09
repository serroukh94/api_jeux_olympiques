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

    @GetMapping("/{idStade}")
    public ResponseEntity<Stade> findStade(@PathVariable Integer idStade) {
        Stade stade = stadeRepository.findById(idStade).orElse(null);
        if (stade != null) {
            return new ResponseEntity<>(stade, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Stade createStade(@RequestBody Stade stade) {
        return stadeService.saveStade(stade);
    }

    @PutMapping("/{idStade}")
    public ResponseEntity<Stade> updateStade(@PathVariable Integer idStade, @RequestBody Stade stadeDetails) {
        Stade stadeAModifier = stadeRepository.findById(idStade).orElse(null);
        if (stadeAModifier != null) {
            stadeAModifier.setNom(stadeDetails.getNom());
            stadeAModifier.setCapacite(stadeDetails.getCapacite());
            stadeAModifier.setAdresse(stadeDetails.getAdresse());
            stadeRepository.save(stadeAModifier);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{idStade}")
    public ResponseEntity<?> deleteStade(@PathVariable Integer idStade) {
        if (!stadeRepository.existsById(idStade)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        stadeRepository.deleteById(idStade);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
