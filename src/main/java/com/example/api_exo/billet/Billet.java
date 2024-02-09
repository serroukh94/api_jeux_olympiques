package com.example.api_exo.billet;

import com.example.api_exo.epreuve.Epreuve;
import com.example.api_exo.spectateur.Spectateur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Billet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "spectateur_id")
    @JsonIgnore
    private Spectateur spectateur;

    @ManyToOne
    @JoinColumn(name = "epreuve_id")
    @JsonIgnore
    private Epreuve epreuve;

    private int quantite;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setSpectateur(Spectateur spectateur) {
        this.spectateur = spectateur;
    }

    public Spectateur getSpectateur() {
        return spectateur;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getQuantite() {
        return quantite;
    }
}
