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

    public static EstadoDaPorta find(String state) {

        if (compare(EstadoDaPorta.IDL, state)) {
            return EstadoDaPorta.IDL;
        }
        if (compare(EstadoDaPorta.LMB, state)) {
            return EstadoDaPorta.LMB;
        }
        if (compare(EstadoDaPorta.PLO, state)) {
            return EstadoDaPorta.PLO;
        }

        if (compare(EstadoDaPorta.INB, state)) {
            return EstadoDaPorta.INB;
        }

        return new EstadoDaPorta(state, "Estado de Porta não mapeado.", Boolean.TRUE);
    }

    public static Boolean compare(EstadoDaPorta state, String stat) {
        return stat.equalsIgnoreCase(state.getNome());
    }
}
