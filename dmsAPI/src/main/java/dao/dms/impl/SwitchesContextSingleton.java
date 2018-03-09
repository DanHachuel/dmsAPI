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
public class SwitchesContextSingleton {

    private static SwitchesContextSingleton instance;

    private List<ManagerDMS> switchs;

    public static SwitchesContextSingleton getInstance() {
        if (instance == null) {
            instance = new SwitchesContextSingleton();
            instance.prepararCentral();
        }
        return instance;
    }

    /**
     * Método responsável por carregar centrais
     */
    protected void prepararCentral() {
        for (SwitchesEnum v : SwitchesEnum.values()) {
            ManagerDMS n = new NortelImpl(v);
            try {
                // n.conectar();
            } catch (Exception e) {
                System.out.println("Falha ao conectar Central: " + n.getCentral().name());
            } finally {
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
