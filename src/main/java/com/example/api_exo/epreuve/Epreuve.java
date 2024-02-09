package com.example.api_exo.epreuve;

import com.example.api_exo.billet.Billet;
import com.example.api_exo.stade.Stade;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Epreuve {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String nom;

    private LocalDateTime dateHeure;

    @ManyToOne
    @JoinColumn(name = "stade_id")
    private Stade stade;

    @OneToMany(mappedBy = "epreuve")
    private List<Billet> billets = new ArrayList<>();

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateHeure(LocalDateTime dateHeure){
        this.dateHeure = dateHeure;
    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public LocalDateTime getDateHeure(){
        return dateHeure;
    }

    public void setStade(Stade stade) {
        this.stade = stade;
    }

    public Stade getStade() {
        return stade;
    }

    public void setBillets(List<Billet> billets) {
        this.billets = billets;
    }
    public List<Billet> getBillets() {
        return billets;
    }

}
