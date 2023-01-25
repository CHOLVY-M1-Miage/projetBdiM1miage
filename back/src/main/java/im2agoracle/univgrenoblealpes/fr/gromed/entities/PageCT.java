package im2agoracle.univgrenoblealpes.fr.gromed.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class PageCT {

    @Id
    @Column(name = "CODEHAS")
    private int codeHAS;

    @Column(name = "LIENPAGECT")
    private String lienPageCT;

    @OneToMany
    private List<AvisSMR> avisSMRs;

    public PageCT() {
    }

    public int getCodeHAS() {
        return this.codeHAS;
    }

    public String getLienPageCT() {
        return this.lienPageCT;
    }

    public List<AvisSMR> getAvisSMRs() {
        return this.avisSMRs;
    }

}
