package com.example.api_exo.stade;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StadeRepository extends CrudRepository<Stade, Integer> {


     List<Stade> findByNom(String nom);
}
