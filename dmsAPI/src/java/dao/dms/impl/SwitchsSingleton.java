/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl;

import java.util.List;

/**
 *
 * @author G0042204
 */
public class SwitchsSingleton {

    private static SwitchsSingleton instance;

    private List<ConsultaDMS> switchs;

    private SwitchsSingleton() {
    }

    public static synchronized SwitchsSingleton getInstance() {
        if (instance == null) {
            instance = new SwitchsSingleton();
            instance.prepararCentral();
        }
        return instance;
    }

    protected void prepararCentral() {
        switchs.add(new NortelImpl("10.141.245.97"));
        switchs.add(new NortelImpl("10.141.0.99"));
    }

    public List<ConsultaDMS> getSwitchs() {
        return switchs;
    }

}
