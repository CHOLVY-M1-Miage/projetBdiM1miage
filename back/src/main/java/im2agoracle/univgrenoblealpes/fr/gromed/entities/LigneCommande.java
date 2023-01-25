package im2agoracle.univgrenoblealpes.fr.gromed.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class LigneCommande {

    public LigneCommande() {
    }

    @Id
    @Column(name="")
    private int id;

    @Column(name="")
    private int quantite;

    @ManyToOne
    private Presentation presentation;

    @ManyToOne
    private Commande commande;

}