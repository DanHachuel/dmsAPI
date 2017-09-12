/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.tratativa;

import model.dms.ConfiguracaoDMS;
import model.dms.Len;
import model.dms.LineService;
import model.dms.NcosEnum;
import util.Regex;

public class TratativaQlenDMS extends TratativaGeneric implements Tratativa<ConfiguracaoDMS> {

    @Override
    public ConfiguracaoDMS parse(String blob) throws Exception {
        validar(blob);

        ConfiguracaoDMS conf = new ConfiguracaoDMS();

        String lenPattern = "(?:LEN:\\s{0,5}(.{10,18}))";
        String prefixPattern = "(?:LINESNPA:\\s{0,5}(\\d{1,10}))";
        String dnPattern = "(?:DIRECTORY NUMBER:\\s{0,10}(\\d{1,10}))";
        String custGrpPattern = "(?:STATIONCUSTGRP:\\s{0,20}(\\w{6,10}))";
        String ncosPattern = "(?:NCOS:\\s{0,1}(\\d{1,5}))";
        String servPattern = "(?:OPTIONS:)(.{0,50})[^-]";

        String len = Regex.capture(blob, lenPattern).trim();
        Tratativa<Len> t = new TratativaLenDMS();
        conf.setLen(t.parse(len));

        String prefix = Regex.capture(blob, prefixPattern).trim();
        String dn = Regex.capture(blob, dnPattern).trim();

        conf.setDn(prefix.concat(dn));
        conf.setCustGrp(Regex.capture(blob, custGrpPattern).trim());
        conf.setNcos(NcosEnum.findByInt(new Integer(Regex.capture(blob, ncosPattern))).dto());

        String servs = Regex.capture(blob, servPattern).trim();

        if (servs.contains(LineService.IDENT_CHAM.getKey())) {
            conf.add(LineService.IDENT_CHAM);
        }

        for (String key : servs.split(" ")) {
            LineService serv = LineService.findByKey(key);
            if (serv != null) {
                conf.add(serv);
            }
        }

        return conf;
    }

}
