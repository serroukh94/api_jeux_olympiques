package com.example.api_exo.billet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BilletRepository extends CrudRepository<Billet, Integer> {

    List<Billet> findBySpectateurId(Integer spectateurId);

    List<Billet> findByEpreuveId(Integer epreuveId);
}
