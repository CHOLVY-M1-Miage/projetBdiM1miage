package im2agoracle.univgrenoblealpes.fr.gromed.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Utilisateur {

    public Utilisateur() {
    }

    @Id
    @Column(name = "")
    private int id;

    @Column(name = "")
    private String nom;

    @ManyToOne
    @JoinColumn(name = "idEtab")
    private Etablissement etablissement;

}