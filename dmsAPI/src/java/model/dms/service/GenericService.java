/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.service;

import dao.dms.enums.SwitchesEnum;
import dao.dms.impl.ManagerDMS;
import dao.dms.impl.SwitchesSingleton;
import exception.SwitchNaoEncontradaException;

/**
 *
 * @author G0042204
 */
public abstract class GenericService {

    public ManagerDMS manager(SwitchesEnum central) throws SwitchNaoEncontradaException {
        return SwitchesSingleton.getInstance().getSwitchBySwitch(central);
    }

}
