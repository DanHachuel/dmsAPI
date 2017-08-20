/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.tratativa;

import model.dms.ConfiguracaoDMS;
import model.dms.LineService;
import util.Regex;

public class TratativaConfiguracaoDMS implements Tratativa<ConfiguracaoDMS> {

    @Override
    public ConfiguracaoDMS parse(String blob) throws Exception {

        ConfiguracaoDMS conf = new ConfiguracaoDMS();

        String linePattern = "(?:LINE EQUIPMENT NUMBER:\\s{0,5}(.{10,18}))";
        String custGrpPattern = "(?:STATIONCUSTGRP:\\s{0,5}(.{5,12}))";
        String ncosPattern = "(?:NCOS:\\s{0,1}(\\d{1,5}))";
        String servPattern = "(?:OPTIONS:)(.{0,50})[^-]";
        
        String len = Regex.capture(blob, linePattern).trim();
        conf.setLen(len.replaceAll("   ", " "));
        conf.setCustGrp(Regex.capture(blob, custGrpPattern).trim());
        conf.setNcos(new Integer(Regex.capture(blob, ncosPattern)));

        String servs = Regex.capture(blob, servPattern).trim();

        for (String key : servs.split(" ")) {
            LineService serv = LineService.findByKey(key);
            if (serv != null) {
                conf.add(serv);
            }
        }

        return conf;
    }

}
