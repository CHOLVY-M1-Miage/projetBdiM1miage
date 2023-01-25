package im2agoracle.univgrenoblealpes.fr.gromed.entities;

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
        this.estPanier = true;
        this.estConfirme = false;
        this.estTermine = false;
        this.estCommandeType = false;
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

    @Column(name="")
    private boolean estCommandeType;

    
    @OneToMany
    private List<LigneCommande> lignesCommande;

    @ManyToOne
    private Etablissement etablissement;


    public int getId() {
        return this.id;
    }

    public LocalDateTime getDateCommande() {
        return this.dateCommande;
    }

    public void setDateCommande(LocalDateTime newDateCommande) {
        this.dateCommande = newDateCommande;
    }

    public boolean getEstPanier() {
        return this.estPanier;
    }

    public void setEstPanier(boolean newEstPanier) {
        this.estPanier = newEstPanier;
    }

    public boolean getEstConfirme() {
        return this.estConfirme ;
    }

    public void setEstConfirme(boolean newEstConfirme) {
        this.estConfirme = newEstConfirme;
    }

    public boolean getEstTermine() {
        return this.estTermine;
    }

    public void setEstTermine(boolean newEstTermine) {
        this.estTermine = newEstTermine;
    }

    public boolean getEstCommandeType() {
        return this.estCommandeType;
    }

    public void setEstCommandeType(boolean newEstCommandeType) {
        this.estCommandeType = newEstCommandeType;
    }

    public List<LigneCommande> getLignesCommande() {
        return this.lignesCommande;
    }

    public void addLigneCommande(int idPresentation) {
        LigneCommande newLigneCommande = new LigneCommande(idPresentation);
        this.lignesCommande.add(newLigneCommande);
    }

    public Etablissement getEtablissement() {
        return this.etablissement;
    }

    public void setEtablissement(Etablissement newEtablissement) {
        this.etablissement = newEtablissement;
    }

}