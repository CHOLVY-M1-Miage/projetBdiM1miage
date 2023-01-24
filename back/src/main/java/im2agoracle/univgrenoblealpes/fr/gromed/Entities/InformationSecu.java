package im2agoracle.univgrenoblealpes.fr.gromed.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class InformationSecu {

    public InformationSecu() {
    }

    @Id
    @Column(name="")
    private int id;

    @Column(name="")
    private LocalDateTime dateDebutInfoSecurite;

    @Column(name="")
    private LocalDateTime dateFinInfoSecurite;

    @Column(name="")
    private String information;

    @ManyToOne
    private Medicament medicament;
}