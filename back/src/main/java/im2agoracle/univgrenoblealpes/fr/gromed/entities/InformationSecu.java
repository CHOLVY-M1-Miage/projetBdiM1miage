package im2agoracle.univgrenoblealpes.fr.gromed.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class InformationSecu {

    public InformationSecu() {
    }

    @Id
    @Column(name = "")
    private int id;

    @Column(name = "")
    private LocalDateTime dateDebutInfoSecurite;

    @Column(name = "")
    private LocalDateTime dateFinInfoSecurite;

    @Column(name = "")
    private String information;

    @ManyToOne
    @JoinColumn(name = "codeCIS")
    private Medicament medicament;

    public int getId() {
        return this.id;
    }

    public LocalDateTime getDateDebutInfoSecurite() {
        return this.dateDebutInfoSecurite;
    }

    public LocalDateTime getDateFinInfoSecurite() {
        return this.dateFinInfoSecurite;
    }

    public String getInformation() {
        return this.information;
    }

    public Medicament getMedicament() {
        return this.medicament;
    }

}