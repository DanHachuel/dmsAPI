/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.service;

import dao.dms.enums.SwitchesEnum;
import dao.dms.impl.ManagerDMS;
import dao.dms.impl.NortelImpl;
import dao.dms.impl.SwitchesContextSingleton;
import exception.SwitchNaoEncontradaException;

/**
 *
 * @author G0042204
 */
public abstract class GenericDMSService {

    private ManagerDMS manager;

    public ManagerDMS manager(SwitchesEnum central) throws SwitchNaoEncontradaException {
        if (manager == null) {
            manager = this.managerContexto(central);
        }
        return manager;
//        return this.debugger(central);
    }

    public ManagerDMS managerContexto(SwitchesEnum central) throws SwitchNaoEncontradaException {
        return context().getSwitchBySwitch(central);
    }

    public SwitchesContextSingleton context() {
        return SwitchesContextSingleton.getInstance();
    }

    public ManagerDMS debugger(SwitchesEnum central) throws SwitchNaoEncontradaException {
        return new NortelImpl(central);
    }

}
