/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms;

/**
 *
 * @author G0042204
 */
public class FacilidadesMapci {

    private Len len;

    private String dn;

    private EstadoDaPorta state;

    public FacilidadesMapci() {
    }

    public Len getLen() {
        return len;
    }

    public void setLen(Len len) {
        this.len = len;
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public EstadoDaPorta getState() {
        return state;
    }

    public void setState(EstadoDaPorta state) {
        this.state = state;
    }

}
