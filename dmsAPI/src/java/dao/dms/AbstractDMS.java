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
import dao.dms.impl.NortelImpl;
import dao.dms.impl.login.LoginCustomDMS;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dms.dto.DetailDTO;

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

    @Override
    public DetailDTO getDetail() {
        return new DetailDTO(this.getCentral(), command().isConnected(), command().isBusy());
    }

    @Override
    public void disconnect() {
        try {
            this.command().close();
        } catch (IOException ex) {
            Logger.getLogger(AbstractDMS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void connect() {
        try {
            this.command().conectar();
        } catch (Exception ex) {
            Logger.getLogger(NortelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Boolean isSameSwitch(SwitchesEnum sw) {
        return this.getCentral().isSameIP(sw);
    }

}
