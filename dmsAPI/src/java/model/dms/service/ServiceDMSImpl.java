/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.service;

import dao.dms.enums.SwitchesEnum;
import java.util.List;
import model.dms.ConfiguracaoDMS;
import model.dms.ConsultaDMS;
import model.dms.ConfiguracoesShelf;
import model.dms.FacilidadesMapci;

public class ServiceDMSImpl extends GenericDMSService implements ServiceDMS {

    public ServiceDMSImpl() {
    }

    @Override
    public ConfiguracaoDMS consultar(ConsultaDMS in) throws Exception {
        SwitchesEnum enu = SwitchesEnum.findByName(in.getCentral());
        return manager(enu).consultarPorDn(in.getDn());
    }

    @Override
    public ConfiguracoesShelf consultarConfiguracoesShelf(ConsultaDMS in) throws Exception {
        SwitchesEnum enu = SwitchesEnum.findByName(in.getCentral());
        ConfiguracaoDMS conf = manager(enu).consultarPorDn(in.getDn());
        List<FacilidadesMapci> listarLensLivres = manager(enu).listarLensLivres(conf.getLen());
        return new ConfiguracoesShelf(listarLensLivres, conf);
    }

}
