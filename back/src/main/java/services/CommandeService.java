package services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import im2agoracle.univgrenoblealpes.fr.gromed.entities.Commande;
import im2agoracle.univgrenoblealpes.fr.gromed.repository.CommandeRepository;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public Optional<Commande> getCommande(int idCommande) {
        return commandeRepository.findById(idCommande);
    }
    
}
