/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.tratativa;

/**
 *
 * @author G0042204
 * @param <T>
 */
public interface Tratativa<T> {

    public T parse(String blob) throws Exception;

}
