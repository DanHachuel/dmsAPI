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

        String regexArd = "(\\w{3})(\\d{1})\\s{0,3}(?:02\\s{0,3}1)";
        String regexPorta = "(\\d{2}\\s{0,2}\\d{2})";
        
        String ard = Regex.capture(len, regexArd);
        String shelf = Regex.capture(len, regexArd, 2);
        String porta = Regex.capture(len, regexPorta).replace(" ", "");

        l.setCnl(null);
        l.setArd(ard);
        l.setShelf(new Integer(shelf));
        l.setPorta(new Integer(porta));

        return l;
    }

}
