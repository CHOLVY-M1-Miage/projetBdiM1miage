package im2agoracle.univgrenoblealpes.fr.gromed.entitiesbdbd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Presentation {

    public Presentation() {
    }

    @Id
    @Column(name="")
    private int id; 

    @Column(name="")
    private int codeCIS_Medicament;

    @Column(name="")
    private int codeCIP7;

    @Column(name="")
    private String libellePresentation; 

    @Column(name="")
    private boolean estAuthorise;
        
    @Column(name="")
    private String etatCommercialisation;
        
    @Column(name="")
    private LocalDateTime dateDeclarationCommercialisation;
        
    @Column(name="")
    private int codeCIP13;
        
    @Column(name="")
    private boolean agrementCollectivites;
        
    @Column(name="")
    private int tauxRemboursement;
        
    @Column(name="")
    private float prix;
        
    @Column(name="")
    private String droitRemboursement;


    @ManyToOne
    private Medicament medicament;

    @OneToMany
    private List<LigneCommande> lignesCommande;


    public int getId() {
        return this.id;
    }

    public int getCodeCIS() {
        return this.codeCIS_Medicament;
    }

    public int getCodeCIP7() {
        return this.codeCIP7;
    }

    public String getLibellePresentation() {
        return this.libellePresentation;
    }

    public boolean getEstAuthorise() {
        return this.estAuthorise;
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