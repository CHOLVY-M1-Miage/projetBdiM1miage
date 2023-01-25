package im2agoracle.univgrenoblealpes.fr.gromed.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CompositionMedicament {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "DESIGNATIONPHARMACEUTIQUE")
    private String designationPharmaceutique;

    @Column(name = "CODESUBSTANCE")
    private int codeSubstance;

    @Column(name = "DENOMINATIONSUBSTANCE")
    private String denominationSubstance;

    @Column(name = "DOSAGESUBSTANCE")
    private String dosageSubstance;

    @Column(name = "REFDOSAGE")
    private String refDosage;

    @Column(name = "ESTACTIF")
    private boolean estActif;

    @Column(name = "NUMSAST")
    private int numSAST;

    @ManyToOne
    @JoinColumn(name = "codeCIS")
    private Medicament medicament;

    public CompositionMedicament() {
    }

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