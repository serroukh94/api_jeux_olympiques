package com.example.api_exo.stade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Stade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String nom;

    @Positive
    @Max(100000)
    private int capacite;

    @NotBlank
    private String adresse;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCapacite(int capacite){
        this.capacite = capacite;
    }

    public void setAdresse(String adresse){
        this.adresse = adresse;
    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getCapacite(){
        return capacite;
    }

    public String getAdresse(){
        return adresse;
    }
}
