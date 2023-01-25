package im2agoracle.univgrenoblealpes.fr.gromed.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Etablissement {

    public Etablissement() {
    }

    @Id
    @Column(name="")
    private int idEtab;

    @Column(name="")
    private String nomEtab;

    @Column(name="")
    private String adresse;

    @Column(name="")
    private String typeEtab;


    @OneToMany
    private List<Commande> commandes;

    @OneToMany
    private List<Utilisateur> utilisateurs;


    public int getIdEtab() {
        return this.idEtab;
    }

    public String getNomEtab() {
        return this.nomEtab;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public String getTypeEtab() {
        return this.typeEtab;
    }

    public List<Commande> getCommandes() {
        return this.commandes;
    }

    public void addCommande() {
        Commande newCommande = new Commande();
        this.commandes.add(newCommande);
    }

    public List<Utilisateur> getUtilisateurs() {
        return this.utilisateurs;
    }
}