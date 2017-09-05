/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.tratativa;

import model.dms.Len;
import util.Regex;

public class TratativaLenDMS extends TratativaGeneric implements Tratativa<Len> {

    @Override
    public Len parse(String len) throws Exception {
        validar(len);
        Len l = new Len();
        l.setLen(len.trim());

        // Tratativa LenAlternativo
        try {
            String alter = "\\w{4}\\s{0,3}(02\\s{0,3}1)";
            Regex.capture(len, alter);
            Tratativa<Len> trat = new TratativaLenAlternativoDMS();
            return trat.parse(len);
        } catch (Exception e) {

            String regexCln = "(\\w{3})";
            String regexArd = "(?:\\w{3})(\\w{1}\\s{1,5}\\w{0,5})";
            String regexShelf = "(\\d{1})(?:\\s{0,2})(\\d{2}\\s{0,2}\\d{2})";
            String regexPorta = "(\\d{2}\\s{0,2}\\d{2})";

            String cln = Regex.capture(len, regexCln);
            String ard = Regex.capture(len, regexArd).replace("  ", " ");
            String porta = Regex.capture(len, regexPorta).replace(" ", "");
            String shelf = Regex.capture(len, regexShelf);

            l.setCnl(cln);
            l.setArd(ard);
            l.setShelf(new Integer(shelf));
            l.setPorta(new Integer(porta));
            l.setAlternate(Boolean.FALSE);

        }

        return l;
    }

}
