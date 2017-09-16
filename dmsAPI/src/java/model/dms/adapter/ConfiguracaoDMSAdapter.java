/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.adapter;

import java.util.ArrayList;
import java.util.List;
import model.dms.ConfiguracaoDMS;
import model.dms.dto.ConfiguracaoDMSDTO;
import model.dms.dto.LineServiceDTO;

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
        
        List<LineServiceDTO> dtos = new ArrayList<>();
        
        conf.getServicos().forEach((t) -> {
            dtos.add(t.dto());
        });
        
        ret.setServicos(dtos);
        ret.setEstado(conf.getEstado());
        
        return ret;
    }
    
}
