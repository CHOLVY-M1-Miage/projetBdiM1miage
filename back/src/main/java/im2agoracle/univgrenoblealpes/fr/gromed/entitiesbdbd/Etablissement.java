package im2agoracle.univgrenoblealpes.fr.gromed.entitiesbdbd;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Etablissement {

    public Etablissement() {
    }

    @Id
    @Column(name="")
    private int idEtab;

    @Column(name="")
    private String nomEtab;

    @Column(name="")
    private String adresse;

    @Column(name="")
    private String typeEtab;

    @OneToMany
    private List<Utilisateur> utilisateurs;

}