/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms;

import dao.dms.enums.SwitchesEnum;

/**
 *
 * @author G0042204
 */
public class ConsultaDMS {

    private String dn;

    private SwitchesEnum central;

    public ConsultaDMS() {
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public SwitchesEnum getCentral() {
        return central;
    }

    public void setCentral(SwitchesEnum central) {
        this.central = central;
    }

}
