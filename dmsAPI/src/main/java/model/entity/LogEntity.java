/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import br.net.gvt.efika.mongo.model.entity.AbstractMongoEntity;
import model.log.ActionsEnum;
import java.util.Calendar;
import java.util.Date;
import org.mongodb.morphia.annotations.Entity;

/**
 *
 * @author G0034481
 */
@Entity(value = "dms", noClassnameStored = true)
public class LogEntity extends AbstractMongoEntity {

    private Object saida;

    private String executor;

    private ActionsEnum acao;

    private Date dataLogIn;

    private Date dataLogOut;

    public LogEntity(ActionsEnum acao) {
        this.acao = acao;
        dataLogIn = Calendar.getInstance().getTime();
    }

    public Object getSaida() {
        return saida;
    }

    public void setSaida(Object saida) {
        this.saida = saida;
    }

    public Date getDataLogIn() {
        return dataLogIn;
    }

    public void setDataLogIn(Date dataLogIn) {
        this.dataLogIn = dataLogIn;
    }

    public Date getDataLogOut() {
        return dataLogOut;
    }

    public void setDataLogOut(Date dataLogOut) {
        this.dataLogOut = dataLogOut;
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

}
