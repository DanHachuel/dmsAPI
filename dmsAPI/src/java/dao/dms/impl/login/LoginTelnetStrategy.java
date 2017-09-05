/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.login;

import dao.dms.impl.SocketDMS;

/**
 *
 * @author G0042204
 */
public interface LoginTelnetStrategy {

    public void conectar(SocketDMS cs) throws Exception;

}
