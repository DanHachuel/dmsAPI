/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.service;

import br.net.gvt.efika.util.thread.EfikaThread;
import dao.dms.impl.ManagerDMS;
import dao.dms.impl.filter.FilterConnectedSwitches;
import java.util.ArrayList;
import java.util.List;
import model.dms.dto.DetailDTO;

public class ServiceContextDMSImpl extends GenericDMSService implements ServiceContextDMS {

    @Override
    public List<DetailDTO> contextDetail() {
        List<DetailDTO> as = new ArrayList<>();
        context().getSwitchs().forEach((aSwitch) -> {
            as.add(aSwitch.getDetail());
        });
        return as;
    }

    @Override
    public void connectSwitches() {
        context().getSwitchs().forEach((ManagerDMS t) -> {
            if (!t.getDetail().getConnected()) {
                new EfikaThread(() -> {
                    try {
                        t.connect();
                    } catch (Exception e) {
                    }
                });
            }
        });
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
        }
    }

    @Override
    public void disconnectSwitches() {
        context().getSwitchs().forEach((t) -> {
            new EfikaThread(() -> {
                t.disconnect();
            });
        });
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
    }

    @Override
    public void keepAlive() {
        List<ManagerDMS> con = new FilterConnectedSwitches(Boolean.TRUE).filter(context().getSwitchs());
        con.forEach((ManagerDMS t) -> {
            new EfikaThread(() -> {
                t.keepAliveCommand();
            });
        });

    }

    @Override
    public DetailDTO connectSwitch(String ip) throws Exception {
        ManagerDMS dms = findInContext(ip);
        dms.connect();
        return dms.getDetail();
    }

    @Override
    public DetailDTO disconnectSwitch(String ip) throws Exception {
        ManagerDMS dms = findInContext(ip);
        dms.disconnect();
        return dms.getDetail();
    }

    @Override
    public ManagerDMS findInContext(String ip) throws Exception {
        for (ManagerDMS t : context().getSwitchs()) {
            if (t.getDetail().getIp().equalsIgnoreCase(ip)) {
                return t;
            }
        }
        throw new Exception("Central não encontrada.");
    }

}
