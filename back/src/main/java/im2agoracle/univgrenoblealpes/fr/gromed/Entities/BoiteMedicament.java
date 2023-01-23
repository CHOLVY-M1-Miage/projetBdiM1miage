package im2agoracle.univgrenoblealpes.fr.gromed.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class BoiteMedicament {
    public BoiteMedicament() {

    }

    @Id
    int id;
    int codeCIP7;
    String libellePresentation;
    String statutAdministratifPresentation;
    String etatCommercialisation;
    LocalDateTime dateDeclarationCommercialisation;
    int codeCIP13;
    String agrementCollectivites;
    String tauxRemboursement;
    double prix;
    String droitRemboursement;

    @ManyToOne
    Medicament medicament;

}