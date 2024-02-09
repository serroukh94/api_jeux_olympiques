package com.example.api_exo.billet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BilletService {

    private final BilletRepository billetRepository;

    @Autowired
    public BilletService(BilletRepository billetRepository) {
        this.billetRepository = billetRepository;
    }

    public Billet acheterBillet(Billet billet) {
        return billetRepository.save(billet);
    }

    public Optional<Billet> findBilletById(Integer id) {
        return billetRepository.findById(id);
    }

    public List<Billet> findAllBillets() {
        return (List<Billet>) billetRepository.findAll();
    }

    public List<Billet> findBilletsBySpectateurId(Integer spectateurId) {
        return billetRepository.findBySpectateurId(spectateurId);
    }

    public List<Billet> findBilletsByEpreuveId(Integer epreuveId) {
        return billetRepository.findByEpreuveId(epreuveId);
    }

    public void deleteBillet(Integer id) {
        billetRepository.deleteById(id);
    }

}
