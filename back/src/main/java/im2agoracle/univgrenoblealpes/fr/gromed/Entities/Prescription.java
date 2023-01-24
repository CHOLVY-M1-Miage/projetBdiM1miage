package im2agoracle.univgrenoblealpes.fr.gromed.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Prescription {

    public Prescription() {
    }

    @Id
    @Column(name="")
    private int id;

    @Column(name="")
    private String conditionPD;

    @ManyToOne
    private Medicament medicament;
    
}