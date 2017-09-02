/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.service;

import dao.dms.enums.SwitchesEnum;
import dao.dms.impl.ManagerDMS;
import dao.dms.impl.NortelImpl;
import exception.SwitchNaoEncontradaException;

/**
 *
 * @author G0042204
 */
public abstract class GenericDMSService {

    public ManagerDMS manager(SwitchesEnum central) throws SwitchNaoEncontradaException {
        return this.managerContexto(central);
//        return this.debugger(central);
    }

    public ManagerDMS managerContexto(SwitchesEnum central) throws SwitchNaoEncontradaException {
        return new NortelImpl(central);
    }

    public ManagerDMS debugger(SwitchesEnum central) throws SwitchNaoEncontradaException {
        return new NortelImpl(central);
    }

}
