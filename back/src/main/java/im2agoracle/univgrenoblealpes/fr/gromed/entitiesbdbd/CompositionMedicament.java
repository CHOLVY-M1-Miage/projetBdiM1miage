package im2agoracle.univgrenoblealpes.fr.gromed.entitiesbdbd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CompositionMedicament {

    public CompositionMedicament() {
    }

    @Id
    @Column(name="")
    private int id;

    @Column(name="")
    private String designationPharmaceutique;

    @Column(name="")
    private int codeSubstance;

    @Column(name="")
    private String denominationSubstance;

    @Column(name="")
    private String dosageSubstance;

    @Column(name="")
    private String refDosage;

    @Column(name="")
    private boolean estActif;

    @Column(name="")
    private int numSAST;

    @ManyToOne
    private Medicament medicament;
    
}