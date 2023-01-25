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
    @Column(name="NUMEROFINESSEET")
    private int idEtab;

    private String raisonSociale;

    private String raisonSocialeLongue;

    private int numeroVoie;

    private String typeVoie;

    private String libelleVoie;

    private String complementVoie;

    private int codeCommune;

    private int departement;

    private String libDepartement;

    private int telephone;

    private int categorieEtablissement;

    private String libelleCategEtab;

    private int categAgregateEtab;

    private String libelleCategAgregEtab;

    private int numeroSiret;

    @OneToMany
    private List<Commande> commandes;

    @OneToMany
    private List<Utilisateur> utilisateurs;

    public int getIdEtab() {
        return this.idEtab;
    }

    public String getNomEtab() {
        return this.raisonSociale;
    }

    public String getAdresse() {
        return this.libDepartement;
    }

    public String getTypeEtab() {
        return this.libelleCategEtab;
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