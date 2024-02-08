package com.example.api_exo.stade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StadeService {

    private final StadeRepository stadeRepository;

    @Autowired
    public StadeService(StadeRepository stadeRepository) {
        this.stadeRepository = stadeRepository;
    }

    public List<Stade> findAllStades() {
        return stadeRepository.findAll();
    }

    public Optional<Stade> findStadeById(Integer id) {
        return stadeRepository.findById(id);
    }

    public Stade saveStade(Stade stade) {
        return stadeRepository.save(stade);
    }

    public void deleteStade(Integer id) {
        stadeRepository.deleteById(id);
    }
}
