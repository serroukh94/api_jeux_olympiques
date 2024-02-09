package com.example.api_exo.spectateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpectateurService {

    private final SpectateurRepository spectateurRepository;

    @Autowired
    public SpectateurService(SpectateurRepository spectateurRepository) {
        this.spectateurRepository = spectateurRepository;
    }

    public List<Spectateur> findAllSpectateurs() {
        return spectateurRepository.findAll();
    }

    public Optional<Spectateur> findSpectateurById(Integer id) {
        return spectateurRepository.findById(id);
    }

    public Spectateur save(Spectateur spectateur) {
        return spectateurRepository.save(spectateur);
    }

    public void delete(Integer id) {
        spectateurRepository.deleteById(id);
    }

    public List<Spectateur> findAllSpectateursByIds(List<Integer> ids) {
        return spectateurRepository.findAllByIdIn(ids);
    }

}
