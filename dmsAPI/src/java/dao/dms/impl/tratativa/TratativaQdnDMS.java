/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.tratativa;

import exception.LinhaNaoPertenceCentralException;
import model.dms.ConfiguracaoDMS;
import model.dms.Len;
import model.dms.LineService;
import model.dms.LineStatus;
import model.dms.Ncos;
import util.Regex;

public class TratativaQdnDMS extends TratativaGeneric implements Tratativa<ConfiguracaoDMS> {

    @Override
    public ConfiguracaoDMS parse(String blob) throws Exception {
        validar(blob);

        ConfiguracaoDMS conf = new ConfiguracaoDMS();

        if (blob.toUpperCase().contains("INVALID FOR THIS OFFICE")) {
            throw new LinhaNaoPertenceCentralException();
        }

        if (blob.toUpperCase().contains("UNASSIGNED")) {
            conf.setStatus(LineStatus.NOT_CREATED);
            return conf;
        }

        String linePattern = "(?:LINE EQUIPMENT NUMBER:\\s{0,5}(.{10,18}))";
        String custGrpPattern = "(?:STATIONCUSTGRP:\\s{0,20}(\\w{6,10}))";
        String ncosPattern = "(?:NCOS:\\s{0,1}(\\d{1,5}))";
        String servPattern = "(?:OPTIONS:)(.{0,500})[^-]";

        String len = Regex.capture(blob, linePattern).trim();

        Tratativa<Len> t = new TratativaLenDMS();
        conf.setLen(t.parse(len));

        conf.setCustGrp(Regex.capture(blob, custGrpPattern).trim());
        conf.setNcos(Ncos.findByInt(new Integer(Regex.capture(blob, ncosPattern))).dto());

        String servs = Regex.capture(blob, servPattern).trim();

        for (LineService value : LineService.values()) {
            if (servs.contains(value.getKey())) {
                conf.add(value);
            }
        }

        return conf;
    }

}
