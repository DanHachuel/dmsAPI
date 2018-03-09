/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl.login;

import util.OSValidator;

/**
 *
 * @author G0042204
 */
public class FactoryLoginStrategy {

    public static LoginTelnetStrategy create() {
        if (OSValidator.isWindows()) {
            return new LoginWindowsCustomDMS();
        } else {
            return new LoginUnixCustomDMS();
        }
    }

}
