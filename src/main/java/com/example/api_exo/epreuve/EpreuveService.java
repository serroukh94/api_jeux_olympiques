package com.example.api_exo.epreuve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EpreuveService {

    private final EpreuveRepository epreuveRepository;

    @Autowired
    public EpreuveService(EpreuveRepository epreuveRepository) {
        this.epreuveRepository = epreuveRepository;
    }

    public List<Epreuve> findAllEpreuves() {
        return (List<Epreuve>) epreuveRepository.findAll();
    }

    public Optional<Epreuve> findEpreuveById(Integer id) {
        return epreuveRepository.findById(id);
    }

    public Epreuve saveEpreuve(Epreuve epreuve) {
        return epreuveRepository.save(epreuve);
    }

    public void deleteEpreuve(Integer id) {
        epreuveRepository.deleteById(id);
    }

}
