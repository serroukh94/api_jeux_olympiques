package com.example.api_exo.stade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StadeRepository extends JpaRepository<Stade, Integer> {

    // méthode de recherche personnalisée
     List<Stade> findByNomContaining(String nom);
}
