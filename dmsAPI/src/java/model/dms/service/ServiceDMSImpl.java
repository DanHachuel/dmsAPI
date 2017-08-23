/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.service;

import dao.dms.impl.ManagerDMS;
import java.util.List;
import model.dms.ConfiguracaoDMS;
import model.dms.ConsultaDmsIn;

public class ServiceDMSImpl extends GenericService implements ServiceDMS {

    public ServiceDMSImpl() {
    }

    @Override
    public ConfiguracaoDMS consultar(ConsultaDmsIn in) throws Exception {
        if (in.getCentral() != null) {
            return manager(in.getCentral()).consultarPorDn(in.getDn());
        } else {
            return consultaGenerica(in);
        }
    }

    protected ConfiguracaoDMS consultaGenerica(ConsultaDmsIn in) {
        List<ManagerDMS> mgrs = manager(in.getDn().substring(0, 2));

        for (ManagerDMS manager : mgrs) {
            try {
                return manager.consultarPorDn(in.getDn());
            } catch (Exception ex) {
                System.out.println("Proxima Central...");
                System.out.println(ex.getMessage());
            }
        }

        return null;
    }

}
