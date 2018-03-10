/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.credencial;

import br.net.gvt.efika.util.bundle.EfikaResourceBundle;

/**
 *
 * @author G0041775
 */
public class CredencialFinder {

    public static Credencial getLogin() {
        try {
            return new Credencial(EfikaResourceBundle.getString("dms", "login"), EfikaResourceBundle.getString("dms", "senha"));
        } catch (Exception e) {
            return new Credencial();
        }

    }

}
