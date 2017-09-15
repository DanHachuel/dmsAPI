/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.adapter;

import model.dms.ConfiguracaoDMS;
import model.dms.dto.ConfiguracaoDMSDTO;

/**
 *
 * @author G0042204
 */
public class ConfiguracaoDMSAdapter {

    public static ConfiguracaoDMSDTO adapt(ConfiguracaoDMS conf) {
        ConfiguracaoDMSDTO ret = new ConfiguracaoDMSDTO();

        ret.setDn(conf.getDn());
        ret.setLen(conf.getLen());
        ret.setCustGrp(conf.getCustGrp());
        ret.setNcos(conf.getNcos());
        ret.setStatus(conf.getStatus());

        conf.getServicos().forEach((t) -> {
            ret.getServicos().add(t.dto());
        });
        
        ret.setEstado(conf.getEstado());

        return ret;
    }

}
