/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms;

import dao.dms.credencial.Credencial;
import dao.dms.enums.SwitchesEnum;
import dao.dms.impl.AbstractTelnetHost;
import dao.dms.impl.login.LoginCustomDMS;

/**
 *
 * @author G0042204
 */
public abstract class AbstractDMS extends AbstractTelnetHost {

    private final SwitchesEnum central;

    public AbstractDMS(SwitchesEnum central) {
        super(central.getIp(), Credencial.UM, new LoginCustomDMS());
        this.central = central;
    }

    public SwitchesEnum getCentral() {
        return central;
    }

}
