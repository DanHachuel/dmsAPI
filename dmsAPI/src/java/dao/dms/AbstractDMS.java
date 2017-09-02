/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms;

import dao.dms.credencial.Credencial;
import dao.dms.enums.SwitchesEnum;
import dao.dms.impl.AbstractHost;
import dao.dms.impl.ManagerDMS;
import dao.dms.impl.login.LoginCustomDMS;

/**
 *
 * @author G0042204
 */
public abstract class AbstractDMS extends AbstractHost implements ManagerDMS {

    private final SwitchesEnum central;

    public AbstractDMS(SwitchesEnum central) {
        super(central.getIp(), Credencial.DOIS, new LoginCustomDMS());
        this.central = central;
    }

    @Override
    public SwitchesEnum getCentral() {
        return central;
    }

}
