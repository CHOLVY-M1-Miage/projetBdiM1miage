package im2agoracle.univgrenoblealpes.fr.gromed.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Utilisateur {

    public Utilisateur() {
    }

    @Id
    @Column(name="")
    private int id;

    @Column(name="")
    private String nom;

    @ManyToOne
    private Etablissement etablissement;

}