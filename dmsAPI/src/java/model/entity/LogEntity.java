/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import model.log.ActionsEnum;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import util.GsonUtil;

/**
 *
 * @author G0034481
 */
@Entity
@Table(name = "dms_log")
public class LogEntity extends AbstractEntity {

    @Lob
    @Column(columnDefinition = "LONGVARCHAR")
    private String entrada;

    @Lob
    @Column(columnDefinition = "LONGVARCHAR")
    private String saida;

    @NotNull(message = "Campo obrigatório")
    @Size(min = 1)
    private String executor;

    @NotNull(message = "Campo obrigatório")
    @Enumerated(EnumType.STRING)
    private ActionsEnum acao;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar dataLogIn;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar dataLogOut;

    public LogEntity() {
        dataLogIn = Calendar.getInstance();
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(Object entrada) {
        this.entrada = GsonUtil.serialize(entrada);
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(Object saida) {
        this.saida = GsonUtil.serialize(saida);
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
