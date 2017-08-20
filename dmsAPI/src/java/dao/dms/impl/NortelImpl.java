/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl;

import dao.dms.credencial.Credencial;
import dao.dms.impl.login.LoginRapido;
import model.dms.ConfiguracaoDMS;

/**
 *
 * @author G0042204
 */
public class NortelImpl extends AbstractTelnetHost implements ConsultaDMS {

    public NortelImpl(String ipDslam) {
        super(ipDslam, Credencial.UM, new LoginRapido());
    }

    @Override
    public ConfiguracaoDMS consultar(String instancia) throws Exception {
        ConfiguracaoDMS c = new ConfiguracaoDMS();
        return c;
    }

    protected ComandoDMS consulta(String instancia) {
        return new ComandoDMS(instancia, 3000);
    }

}
