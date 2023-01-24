package im2agoracle.univgrenoblealpes.fr.gromed.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Medicament {

    public Medicament() {
    }

    @Id
    @Column(name="")
    private int codeCIS;
        
    @Column(name="")
    private String denominationMedicament;
        
    @Column(name="")
    private String formePharmaceutique;
        
    @Column(name="")
    private String voiesAdministration;
        
    @Column(name="")
    private String statutAdministratifAMM;
        
    @Column(name="")
    private String typeProcedureAMM;
        
    @Column(name="")
    private boolean estCommercialise;
        
    @Column(name="")
    private LocalDateTime dateAMM;
        
    @Column(name="")
    private String statutBdm;
        
    @Column(name="")
    private String numeroEuropeen;
        
    @Column(name="")
    private String titutaires;
        
    @Column(name="")
    private boolean estEnSurveillanceRenforcee;

    @OneToMany
    private List<BoiteMedicament> conditionnements;

    @OneToMany
    private List<CompositionMedicament> substances;

    @ManyToOne
    private Generique generique;

    @OneToMany
    private List<Prescription> prescriptions;

    @OneToMany
    private List<InformationSecu> informations;

}