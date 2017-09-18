/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.log;

import model.entity.LogEntity;

/**
 *
 * @author G0042204
 */
public abstract class GenericLog extends Log {

    public GenericLog(ActionsEnum acao) {
        super(acao);
    }

    @Override
    public LogEntity log() {

        try {
            LogEntity l = new LogEntity();
            l.setAcao(getAcao());
            l.setEntrada(entrada());
            l.setSaida(getSaida());
            l.setExecutor(getExecutor());
            l.setDataLogIn(getDataLogIn());
            l.setDataLogOut(getDataLogOut());
            return l;

        } catch (Exception e) {
            System.out.println("erro");
            return null;
        }
    }

    public abstract Object entrada();

}
