package im2agoracle.univgrenoblealpes.fr.gromed.entitiesbdbd;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Commande {

    public Commande() {
    }

    @Id
    @Column(name="")
    private int id;

    @Column(name="")
    private LocalDateTime dateCommande;

    @Column(name="")
    private boolean estPanier;

    @Column(name="")
    private boolean estConfirme;

    @Column(name="")
    private boolean estTermine;

    
    @OneToMany
    private List<LigneCommande> lignesCommandes;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Etablissement etablissement;

}