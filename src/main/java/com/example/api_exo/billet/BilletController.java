package com.example.api_exo.billet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billets")
public class BilletController {

    private final BilletService billetService;
    private final BilletRepository billetRepository;

    @Autowired
    public BilletController(BilletService billetService, BilletRepository billetRepository) {
        this.billetService = billetService;
        this.billetRepository = billetRepository;
    }

    @GetMapping
    public List<Billet> getAllEpreuves() {
        return billetService.findAllBillets();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Billet> getBilletById(@PathVariable Integer id) {
        Billet billet = billetRepository.findById(id).orElse(null);
        if (billet != null) {
            return new ResponseEntity<>(billet, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/acheter")
    public Billet acheterBillet(@RequestBody Billet billet) {
        return billetService.acheterBillet(
                billet.getSpectateur().getId(),
                billet.getEpreuve().getId(),
                billet.getQuantite()
        );
    }

}
