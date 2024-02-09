package com.example.api_exo.spectateur;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpectateurRepository extends
        CrudRepository<Spectateur, Integer> {
    List<Spectateur> findAll();

    List<Spectateur> findAllByIdIn(List<Integer> ids);

}
