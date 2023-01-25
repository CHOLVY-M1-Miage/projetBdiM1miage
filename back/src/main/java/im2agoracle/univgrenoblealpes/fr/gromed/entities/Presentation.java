package im2agoracle.univgrenoblealpes.fr.gromed.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Presentation {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "CODECIP7")
    private int codeCIP7;

    @Column(name = "LIBELLEPRESTATION")
    private String libellePresentation;

    @Column(name = "ESTAUTORISE")
    private boolean estAutorise;

    @Column(name = "ETATCOMMERCIALISATION")
    private String etatCommercialisation;

    @Column(name = "DATEDECLARATIONCOMMERCIALISATION")
    private LocalDateTime dateDeclarationCommercialisation;

    @Column(name = "CODECIP13")
    private int codeCIP13;

    @Column(name = "AGREMENTCOLLECTIVITES")
    private boolean agrementCollectivites;

    @Column(name = "TAUXREMBOURSEMENT")
    private int tauxRemboursement;

    @Column(name = "PRIX")
    private float prix;

    @Column(name = "DROITREMBOURSEMENT")
    private String droitRemboursement;

    @ManyToOne
    @JoinColumn(name = "codeCIS")
    private Medicament medicament;

    @OneToMany(mappedBy = "presentation")
    private List<LigneCommande> lignesCommande;

    public Presentation() {
    }

    public int getId() {
        return this.id;
    }

    public int getCodeCIP7() {
        return this.codeCIP7;
    }

    public String getLibellePresentation() {
        return this.libellePresentation;
    }

    public boolean getEstAutorise() {
        return this.estAutorise;
    }

    public String getEtatCommercialisation() {
        return this.etatCommercialisation;
    }

    public LocalDateTime getDateDeclarationCommercialisation() {
        return this.dateDeclarationCommercialisation;
    }

    public int getCodeCIP13() {
        return this.codeCIP13;
    }

    public boolean getAgrementCollectivites() {
        return this.agrementCollectivites;
    }

    public int getTauxRemboursement() {
        return this.tauxRemboursement;
    }

    public float getPrix() {
        return this.prix;
    }

    public String getDroitRemboursement() {
        return this.droitRemboursement;
    }

    public Medicament getMedicament() {
        return this.medicament;
    }

    public List<LigneCommande> getLignesCommande() {
        return this.lignesCommande;
    }

}