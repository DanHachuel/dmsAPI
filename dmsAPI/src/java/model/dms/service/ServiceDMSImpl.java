/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.service;

import dao.dms.enums.SwitchesEnum;
import model.dms.ConfiguracaoDMS;
import model.dms.ConsultaDMS;

public class ServiceDMSImpl extends GenericDMSService implements ServiceDMS {

    public ServiceDMSImpl() {
    }

    @Override
    public ConfiguracaoDMS consultar(ConsultaDMS in) throws Exception {
        SwitchesEnum enu = SwitchesEnum.findByName(in.getCentral());;
        return manager(enu).consultarPorDn(in.getDn());
    }
}
