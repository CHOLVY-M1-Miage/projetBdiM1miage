package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import im2agoracle.univgrenoblealpes.fr.gromed.entities.LigneCommande;
import im2agoracle.univgrenoblealpes.fr.gromed.repository.LigneCommandeRepository;

@Service
public class LigneCommandeService {

    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;

    public List<LigneCommande> getLignesCommandeOfCommande(int idCommande) {
        return ligneCommandeRepository.findByIdCommande(idCommande);
    }

    
}
