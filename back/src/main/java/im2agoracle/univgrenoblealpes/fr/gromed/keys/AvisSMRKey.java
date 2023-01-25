package im2agoracle.univgrenoblealpes.fr.gromed.keys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AvisSMRKey implements Serializable {

    @Column(name = "CODECISMEDICAMENT")
    private int codeCIS_Medicament;

    @Column(name = "CODEHASPAGE")
    private int codeHAS_PageCT;

    private AvisSMRKey() {
    }

    public int getCodeCIS() {
        return this.codeCIS_Medicament;
    }

    public int getCodeHAS() {
        return this.codeHAS_PageCT;
    }

}
