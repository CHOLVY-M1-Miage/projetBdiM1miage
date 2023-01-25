package im2agoracle.univgrenoblealpes.fr.gromed.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Generique {

    public Generique() {
    }

    @Id
    @Column(name="")
    int idGenerique;

    @Column(name="")
    String libelleGenerique;

    @Column(name="")
    int typeGenerique;

    @Column(name="")
    int groupeGenerique;

    @ManyToOne
    Medicament medicament;
    
}