package com.example.api_exo.billet;

import com.example.api_exo.epreuve.Epreuve;
import com.example.api_exo.epreuve.EpreuveRepository;
import com.example.api_exo.spectateur.Spectateur;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BilletService {

    private final BilletRepository billetRepository;

    private final EpreuveRepository epreuveRepository;

    public BilletService(BilletRepository billetRepository, EpreuveRepository epreuveRepository) {
        this.billetRepository = billetRepository;
        this.epreuveRepository = epreuveRepository;
    }

    public Billet acheterBillet(Integer spectateurId, Integer epreuveId, int quantite) {
        // Récupération de l'épreuve pour laquelle le billet est acheté
        Epreuve epreuve = epreuveRepository.findById(epreuveId)
                .orElseThrow(() -> new EntityNotFoundException("Epreuve non trouvée avec l'ID : " + epreuveId));

        // Vérification si le spectateur a déjà des billets pour des épreuves à la même date
        List<Billet> billetsExistant = billetRepository.findBySpectateurId(spectateurId);

        for (Billet billet : billetsExistant) {
            if (billet.getEpreuve().getDateHeure().isEqual(((Epreuve) epreuve).getDateHeure())) {
                throw new IllegalStateException("Vous ne pouvez pas acheter de billet pour deux épreuves se déroulant à la même date.");
            }
        }

        // Création et sauvegarde du nouveau billet
        Billet nouveauBillet = new Billet();
        nouveauBillet.setEpreuve(epreuve);
        Spectateur spectateur = new Spectateur();
        spectateur.setId(spectateurId);
        nouveauBillet.setSpectateur(spectateur);
        nouveauBillet.setQuantite(quantite);

        return billetRepository.save(nouveauBillet);
    }

    public List<Billet> findAllBillets() {
        return (List<Billet>) billetRepository.findAll();
    }

    public Billet getBilletById(Integer id ){
        return billetRepository.findById(id).orElse(null);
    }
}
