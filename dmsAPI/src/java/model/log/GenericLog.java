/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.log;

import model.entity.LogEntity;
import util.GsonUtil;

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
        LogEntity l = new LogEntity();
        l.setAcao(getAcao());
        l.setEntrada(GsonUtil.serialize(entrada()));
        l.setExecutor(getExecutor());
        l.setSaida(getSaida());
        l.setDataLogIn(getDataLogIn());
        l.setDataLogOut(getDataLogOut());
        return l;
    }

    public abstract Object entrada();

}
