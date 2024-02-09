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

    @GetMapping("/{idEpreuve}")
    public ResponseEntity<Epreuve> getEpreuveById(@PathVariable Integer idEpreuve) {
        Epreuve epreuve = epreuveRepository.findById(idEpreuve).orElse(null);
        if (epreuve != null) {
            return new ResponseEntity<>(epreuve, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public Epreuve createEpreuve(@RequestBody Epreuve epreuve) {
        return epreuveService.saveEpreuve(epreuve);
    }

    @PutMapping("/{idEpreuve}")
    public ResponseEntity<Epreuve> updateEpreuve(@PathVariable Integer idEpreuve, @RequestBody Epreuve epreuveDetails) {
        Epreuve epreuveToUpdate = epreuveRepository.findById(idEpreuve).orElse(null);
        if (epreuveToUpdate != null) {
            epreuveToUpdate.setNom(epreuveDetails.getNom());
            epreuveToUpdate.setDateHeure(epreuveDetails.getDateHeure());
            epreuveRepository.save(epreuveToUpdate);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{idEpreuve}")
    public ResponseEntity<?> deleteEpreuve(@PathVariable Integer idEpreuve) {
        if (!epreuveRepository.existsById(idEpreuve)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        epreuveRepository.deleteById(idEpreuve);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
