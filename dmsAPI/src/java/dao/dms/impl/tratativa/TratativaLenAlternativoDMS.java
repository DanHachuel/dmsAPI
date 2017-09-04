/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.tratativa;

import model.dms.Len;
import util.Regex;

public class TratativaLenAlternativoDMS extends TratativaGeneric implements Tratativa<Len> {

    @Override
    public Len parse(String len) throws Exception {
        Len l = new Len();
        l.setAlternate(Boolean.TRUE);

        String alter = "(\\w{4}\\s{0,3}02 1)";
        Regex.capture(len, alter);

        return l;
    }

}
