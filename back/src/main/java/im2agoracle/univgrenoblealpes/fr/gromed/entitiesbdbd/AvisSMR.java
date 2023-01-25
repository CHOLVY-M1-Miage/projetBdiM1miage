package im2agoracle.univgrenoblealpes.fr.gromed.entitiesbdbd;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AvisSMR {
    
    public AvisSMR() {
    }

    @Id
    @Column(name="")
    private int codeCIS_Medicament;

    @Id
    @Column(name="")
    private int codeHAS_PageCT;

    @Column(name="")
    private String motifEvaluation;

    @Column(name="")
    private LocalDateTime dateCT;

    @Column(name="")
    private String valeurSMR;

    @Column(name="")
    private String libelleSMR;


    public int getCodeCIS() {
        return this.codeCIS_Medicament;
    }

    public int getCodeHAS() {
        return this.codeHAS_PageCT;
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

}
