package im2agoracle.univgrenoblealpes.fr.gromed.entitiesbdbd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PageCT {
    
    public PageCT() {
    }

    @Id
    @Column(name="")
    private int codeHAS;
    
    @Column(name="")
    private String lienPageCT;


    public int getCodeHAS() {
        return this.codeHAS;
    }

    public String getLienPageCT() {
        return this.lienPageCT;
    }

}
