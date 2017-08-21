/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms;

import dao.dms.credencial.Credencial;
import dao.dms.impl.AbstractTelnetHost;
import dao.dms.impl.login.LoginCustomDMS;

/**
 *
 * @author G0042204
 */
public abstract class AbstractDMS extends AbstractTelnetHost {

    public AbstractDMS(String ipDslam) {
        super(ipDslam, Credencial.UM, new LoginCustomDMS());
    }

}
