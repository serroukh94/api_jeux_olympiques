package com.example.api_exo.billet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BilletRepository extends CrudRepository<Billet, Integer> {

    // méthode personnalisée pour trouver des billets par l'ID du spectateur
    List<Billet> findBySpectateurId(Integer spectateurId);

    // Exemple de méthode personnalisée pour trouver des billets par l'ID de l'épreuve
    List<Billet> findByEpreuveId(Integer epreuveId);
}
