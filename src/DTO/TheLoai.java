/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Magic
 */
public class TheLoai {
    String tentl,matl;

    public TheLoai() {
    }

    public TheLoai(String matl, String tentl) {
        this.matl = matl;
        this.tentl = tentl;
    }

    public String getTentl() {
        return tentl;
    }

    public void setTentl(String tentl) {
        this.tentl = tentl;
    }

    public String getMatl() {
        return matl;
    }

    public void setMatl(String matl) {
        this.matl = matl;
    }
    
    public String[] ToListString() {
        
        return new String[]{this.matl, this.tentl};
    }
}
