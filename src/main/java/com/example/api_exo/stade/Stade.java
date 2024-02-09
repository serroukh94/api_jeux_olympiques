package com.example.api_exo.stade;

import com.example.api_exo.epreuve.Epreuve;
import jakarta.persistence.*;
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

    @OneToOne
    private Epreuve epreuve;

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

    public void setEpreuves(Epreuve epreuve) {
        this.epreuve = epreuve;
    }
    public Epreuve getEpreuve() {
        return epreuve;
    }
}
