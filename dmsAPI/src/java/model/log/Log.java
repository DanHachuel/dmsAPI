/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.log;

import java.util.Calendar;

/**
 *
 * @author G0042204
 */
public abstract class Log implements Logger {

    private String entrada;

    private Object saida;

    private String executor;

    private ActionsEnum acao;

    private Calendar dataLogIn;

    private Calendar dataLogOut;

    public Log(ActionsEnum acao) {
        this.acao = acao;
        dataLogIn = Calendar.getInstance();
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public Object getSaida() {
        return saida;
    }

    public void setSaida(Object saida) {
        this.saida = saida;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public ActionsEnum getAcao() {
        return acao;
    }

    public void setAcao(ActionsEnum acao) {
        this.acao = acao;
    }

    public Calendar getDataLogIn() {
        return dataLogIn;
    }

    public void setDataLogIn(Calendar dataLogIn) {
        this.dataLogIn = dataLogIn;
    }

    public Calendar getDataLogOut() {
        return dataLogOut;
    }

    public void setDataLogOut(Calendar dataLogOut) {
        this.dataLogOut = dataLogOut;
    }

}
