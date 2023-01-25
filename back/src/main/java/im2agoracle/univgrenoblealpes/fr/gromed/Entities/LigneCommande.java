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
    private int idPresentation;

    @Id
    @Column(name="")
    private int idCommande;

    @Column(name="")
    private int quantite;


    @ManyToOne
    private Presentation presentation;

    @ManyToOne
    private Commande commande;


    public int getIdPresentation() {
        return this.idPresentation;
    }

    public int getIdCommande() {
        return this.idCommande;
    }

    public int getQuantite() {
        return this.quantite;
    }

    public void setQuantite(int newQuantite) {
        if (newQuantite > 0){
            this.quantite = newQuantite;
        }
    }

    public Presentation getPresentation() {
        return this.presentation;
    }

    public Commande getCommande() {
        return this.commande;
    }
}