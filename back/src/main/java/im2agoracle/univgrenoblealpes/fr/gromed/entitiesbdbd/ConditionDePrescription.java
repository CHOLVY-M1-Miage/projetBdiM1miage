package im2agoracle.univgrenoblealpes.fr.gromed.entitiesbdbd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ConditionDePrescription {

    public ConditionDePrescription() {
    }

    @Id
    @Column(name="")
    private int id;

    @Column(name="")
    private String conditionPD;

    @ManyToOne
    private Medicament medicament;
    
}