package im2agoracle.univgrenoblealpes.fr.gromed.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @JoinColumn(name = "codeCIS")
    private Medicament medicament;
    

    public int getId() {
        return this.id;
    }

    public String getDesignationPharmaceutique() {
        return this.designationPharmaceutique;
    }

    public int getCodeSubstance() {
        return this.codeSubstance;
    }

    public String getDenominationSubstance() {
        return this.denominationSubstance;
    }

    public String getDosageSubstance() {
        return this.dosageSubstance;
    }

    public String getRefDosage() {
        return this.refDosage;
    }

    public boolean getEstActif() {
        return this.estActif;
    }

    public int getNumSAST() {
        return this.numSAST;
    }

    public Medicament getMedicament() {
        return this.medicament;
    }

}