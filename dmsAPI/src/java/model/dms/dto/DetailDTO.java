/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.dto;

import dao.dms.credencial.Credencial;
import dao.dms.enums.SwitchesEnum;

/**
 *
 * @author G0042204
 */
public class DetailDTO {

    private SwitchesEnum central;

    private Boolean connected, busy;

    private Credencial credencial;

    public DetailDTO() {
    }

    public DetailDTO(SwitchesEnum central, Boolean connected, Boolean busy, Credencial credencial) {
        this.central = central;
        this.connected = connected;
        this.busy = busy;
        this.credencial = credencial;
    }

    public SwitchesEnum getCentral() {
        return central;
    }

    public void setCentral(SwitchesEnum central) {
        this.central = central;
    }

    public Boolean getConnected() {
        return connected;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

    public Boolean getBusy() {
        return busy;
    }

    public void setBusy(Boolean busy) {
        this.busy = busy;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

}
