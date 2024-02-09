package com.example.api_exo.spectateur;

import com.example.api_exo.billet.Billet;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Spectateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String nom;

    @Email
    private String email;

    @OneToMany(mappedBy = "spectateur")
    private List<Billet> billets = new ArrayList<>();

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public void setBillets(List<Billet> billets) {
        this.billets = billets;
    }
    public List<Billet> getBillets() {
        return billets;
    }

}
