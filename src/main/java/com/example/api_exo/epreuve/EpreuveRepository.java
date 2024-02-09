package com.example.api_exo.epreuve;

import com.example.api_exo.spectateur.Spectateur;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EpreuveRepository extends CrudRepository<Epreuve, Integer> {

    List<Epreuve> findAll();


}
