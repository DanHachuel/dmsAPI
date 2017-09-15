/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms;

/**
 *
 * @author G0042204
 */
public class FactoryEstadoDaPorta {

    public static EstadoDaPortaEnum find(String state) {

        for (EstadoDaPortaEnum e : EstadoDaPortaEnum.values()) {
            if (e.name().equalsIgnoreCase(state)) {
                return e;
            }
        }

        return null;
    }

}
