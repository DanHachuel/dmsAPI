/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl;

import dao.dms.enums.SwitchesEnum;

/**
 *
 * @author G0042204
 */
public class FactoryManagerDMS {

    public static ManagerDMS create(SwitchesEnum central) {
        return new NortelImpl(central);
    }

}
