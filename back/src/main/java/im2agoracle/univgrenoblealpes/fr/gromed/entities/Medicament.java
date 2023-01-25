package im2agoracle.univgrenoblealpes.fr.gromed.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Medicament {

    @Id
    @Column(name = "")
    private int codeCIS;

    @Column(name = "")
    private String denominationMedicament;

    @Column(name = "")
    private String formePharmaceutique;

    @Column(name = "")
    private String statutAdministratifAMM;

    @Column(name = "")
    private String typeProcedureAMM;

    @Column(name = "")
    private boolean estCommercialise;

    @Column(name = "")
    private LocalDateTime dateAMM;

    @Column(name = "")
    private String statutBdm;

    @Column(name = "")
    private String numeroEuropeen;

    @Column(name = "")
    private String titulaires;

    @Column(name = "")
    private boolean estEnSurveillanceRenforcee;

    @OneToMany
    private List<AvisSMR> avisSMRs;

    @OneToMany
    private List<Presentation> presentations;

    @OneToMany
    private List<CompositionMedicament> substances;

    @OneToMany
    private List<VoieAdministration> voiesAdministration;

    @OneToMany
    private List<Generique> generiques;

    @OneToMany
    private List<InformationSecu> informations;

    @OneToMany
    private List<ConditionDePrescription> ConditionsDePrescription;

    public Medicament() {
    }

    public int getCodeCIS() {
        return this.codeCIS;
    }

    public String getDenominationMedicament() {
        return this.denominationMedicament;
    }

    public String getFormePharmaceutique() {
        return this.formePharmaceutique;
    }

    public String getStatutAdministratifAMM() {
        return this.statutAdministratifAMM;
    }

    public String getTypeProcedureAMM() {
        return this.typeProcedureAMM;
    }

    public boolean getEstCommercialise() {
        return this.estCommercialise;
    }

    public LocalDateTime getDateAMM() {
        return this.dateAMM;
    }

    public String getStatutBdm() {
        return this.statutBdm;
    }

    public String getNumeroEuropeen() {
        return this.numeroEuropeen;
    }

    public String getTitulaires() {
        return this.titulaires;
    }

    public boolean getEstEnSurveillanceRenforcee() {
        return this.estEnSurveillanceRenforcee;
    }

    public List<AvisSMR> getAvisSMRs() {
        return this.avisSMRs;
    }

    public List<Presentation> getPresentations() {
        return this.presentations;
    }

    public List<CompositionMedicament> getSubstances() {
        return this.substances;
    }

    public List<VoieAdministration> getVoiesAdministration() {
        return this.voiesAdministration;
    }

    public List<Generique> getGeneriques() {
        return this.generiques;
    }

    public List<InformationSecu> getInformations() {
        return this.informations;
    }

    public List<ConditionDePrescription> getConditionsDePrescription() {
        return this.ConditionsDePrescription;
    }

}