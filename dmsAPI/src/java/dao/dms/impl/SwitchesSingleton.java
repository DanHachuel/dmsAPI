/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl;

import dao.dms.enums.SwitchesEnum;
import exception.SwitchNaoEncontradaException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author G0042204
 */
public class SwitchesSingleton {

    private static SwitchesSingleton instance;

    private List<ManagerDMS> switchs;

    private SwitchesSingleton() {
    }

    public static synchronized SwitchesSingleton getInstance() {
        if (instance == null) {
            instance = new SwitchesSingleton();
            instance.prepararCentral();
        }
        return instance;
    }

    /**
     * Método responsável por carregar centrais
     */
    protected void prepararCentral() {
        switchs = new ArrayList<>();
        for (SwitchesEnum v : SwitchesEnum.values()) {
            NortelImpl n = new NortelImpl(v);
            try {
                // n.conectar();
            } catch (Exception e) {
                System.out.println("Falha ao conectar Central: " + n.getCentral().name());
            } finally {
                System.out.println(n.getCentral().name());
                this.adicionarCentral(n);
            }

        }
    }

    public void adicionarCentral(ManagerDMS m) {
        if (!getSwitchs().contains(m)) {
            System.out.println("adicionarCentral -> " + m.getCentral().name());
            getSwitchs().add(m);
        }
    }

    public List<ManagerDMS> getSwitchs() {
        if (switchs == null) {
            switchs = new ArrayList<>();
        }
        return switchs;
    }

    public ManagerDMS getSwitchBySwitch(SwitchesEnum sw) throws SwitchNaoEncontradaException {
        for (ManagerDMS m : getSwitchs()) {
            if (m.isSameSwitch(sw)) {
                return m;
            }
        }
        throw new SwitchNaoEncontradaException();
    }

}
