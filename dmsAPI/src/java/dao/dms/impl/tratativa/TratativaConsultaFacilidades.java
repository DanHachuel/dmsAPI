/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.tratativa;

import model.dms.ConsultaFacilidades;
import util.Regex;

public class TratativaConsultaFacilidades extends TratativaGeneric implements Tratativa<ConsultaFacilidades> {

    @Override
    public ConsultaFacilidades parse(String blob) throws Exception {
        validar(blob);

        String regex = "(?:\\s{1})(\\w{4}.{3,14})(?:\\s{1,50})(\\d{3}(?:\\s)\\d{3}\\s\\d{4}|NO DIRN)(?:\\s{5,20})(\\w{3,4})";
        String len = Regex.capture(blob, regex);
        String dn = Regex.capture(blob, regex, 2).replace(" ", "");
        String state = Regex.capture(blob, regex, 3);
        TratativaLenDMS trat = new TratativaLenDMS();
        ConsultaFacilidades c = new ConsultaFacilidades();
        c.setDn(dn);
        c.setLen(trat.parse(len));
        c.setState(state);

        return c;
    }

}
