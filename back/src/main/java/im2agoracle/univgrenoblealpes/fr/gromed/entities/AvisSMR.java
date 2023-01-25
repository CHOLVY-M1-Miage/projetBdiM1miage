package im2agoracle.univgrenoblealpes.fr.gromed.entities;

import java.time.LocalDateTime;

import im2agoracle.univgrenoblealpes.fr.gromed.keys.AvisSMRKey;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class AvisSMR {

    @EmbeddedId
    private AvisSMRKey id;

    @Column(name = "")
    private String motifEvaluation;

    @Column(name = "")
    private LocalDateTime dateCT;

    @Column(name = "")
    private String valeurSMR;

    @Column(name = "")
    private String libelleSMR;

    @ManyToOne
    @MapsId("codeCIS_Medicament")
    @JoinColumn(name = "codeCIS")
    private Medicament medicament;

    @ManyToOne
    @MapsId("codeHAS_PageCT")
    @JoinColumn(name = "cadeHAS")
    private PageCT pageCT;

    public AvisSMR() {
    }

    public String getMotifEvaluation() {
        return this.motifEvaluation;
    }

    public LocalDateTime getDateCT() {
        return this.dateCT;
    }

    public String getValeurSMR() {
        return this.valeurSMR;
    }

    public String getLibelleSMR() {
        return this.libelleSMR;
    }

    public Medicament getMedicament() {
        return this.medicament;
    }

    public PageCT getPageCT() {
        return this.pageCT;
    }

}
