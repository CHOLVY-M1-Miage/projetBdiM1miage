package im2agoracle.univgrenoblealpes.fr.gromed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import im2agoracle.univgrenoblealpes.fr.gromed.entities.LigneCommande;
import im2agoracle.univgrenoblealpes.fr.gromed.keys.LigneCommandeKey;

@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, LigneCommandeKey>{
    
}
