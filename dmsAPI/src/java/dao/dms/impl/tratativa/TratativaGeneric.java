/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.tratativa;

import exception.RetornoDMSException;

/**
 *
 * @author G0042204
 */
public class TratativaGeneric {

    protected void validar(String blob) throws RetornoDMSException {
        if (blob == null || blob.isEmpty()) {
            throw new RetornoDMSException();
        }
    }

}
