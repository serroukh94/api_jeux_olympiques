package com.example.api_exo.epreuve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/epreuves")
public class EpreuveController {

    private final EpreuveService epreuveService;
    private final EpreuveRepository epreuveRepository;

    @Autowired
    public EpreuveController(EpreuveService epreuveService, EpreuveRepository epreuveRepository) {
        this.epreuveService = epreuveService;
        this.epreuveRepository = epreuveRepository;
    }

    @GetMapping
    public List<Epreuve> getAllEpreuves() {
        return epreuveService.findAllEpreuves();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Epreuve> getEpreuveById(@PathVariable Integer id) {
        Epreuve epreuve = epreuveRepository.findById(id).orElse(null);
        if (epreuve != null) {
            return new ResponseEntity<>(epreuve, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Epreuve createEpreuve(@RequestBody Epreuve epreuve) {
        return epreuveService.saveEpreuve(epreuve);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Epreuve> updateEpreuve(@PathVariable Integer id, @RequestBody Epreuve epreuveDetails) {
        Epreuve epreuveToUpdate = epreuveRepository.findById(id).orElse(null);
        if (epreuveToUpdate != null) {
            epreuveToUpdate.setNom(epreuveDetails.getNom());
            epreuveToUpdate.setDateHeure(epreuveDetails.getDateHeure());
            epreuveToUpdate.setStade(epreuveDetails.getStade());
            epreuveRepository.save(epreuveToUpdate);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEpreuve(@PathVariable Integer id) {
        if (!epreuveRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        epreuveRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
