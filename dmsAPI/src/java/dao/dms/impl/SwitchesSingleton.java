/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl;

import dao.dms.enums.SwitchesEnum;
import java.util.ArrayList;
import java.util.List;
import util.GsonUtil;

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
                this.adicionarCentral(n);
            }

        }
    }

    public void adicionarCentral(ManagerDMS m) {
        if (!switchs.contains(m)) {
            System.out.println("Central Adicionada: " + GsonUtil.serialize(m));
            switchs.add(m);
        }
    }

    public List<ManagerDMS> getSwitchs() {
        if(switchs == null){
            switchs = new ArrayList<>();
        }
        return switchs;
    }

    public ManagerDMS getSwitchBySwitch(SwitchesEnum sw) {
        for (ManagerDMS m : getSwitchs()) {
            if (m.isSameSwitch(sw)) {
                return m;
            }
        }
        return null;
    }

    public List<ManagerDMS> getSwitchByPrefix(String prefix) {
        List<ManagerDMS> lst = new ArrayList<>();
        for (ManagerDMS m : getSwitchs()) {
            if (m.isSamePrefix(prefix)) {
                lst.add(m);
            }
        }
        return lst;
    }

}
