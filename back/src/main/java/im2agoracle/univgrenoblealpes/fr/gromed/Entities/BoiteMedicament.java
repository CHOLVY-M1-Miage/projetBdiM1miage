package im2agoracle.univgrenoblealpes.fr.gromed.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class BoiteMedicament {

    public BoiteMedicament() {
    }

    @Id
    @Column(name="")
    private int id; 

    @Column(name="")
    private int codeCIP7;

    @Column(name="")
    private String libellePresentation; 

    @Column(name="")
    private String statutAdministratifPresentation;
        
    @Column(name="")
    private String etatCommercialisation;
        
    @Column(name="")
    private LocalDateTime dateDeclarationCommercialisation;
        
    @Column(name="")
    private int codeCIP13;
        
    @Column(name="")
    private String agrementCollectivites;
        
    @Column(name="")
    private String tauxRemboursement;
        
    @Column(name="")
    private double prix;
        
    @Column(name="")
    private String droitRemboursement;

    @ManyToOne
    private Medicament medicament;

    @OneToMany
    private List<LigneCommande> lignesCommandes;

}