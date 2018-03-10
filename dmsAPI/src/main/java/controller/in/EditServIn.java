/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.in;

import java.util.List;
import model.dms.ConsultaDMS;
import model.dms.LineService;
import model.entity.LogEntity;
import model.log.ActionsEnum;

/**
 *
 * @author G0041775
 */
public class EditServIn extends LogEntity {

    private ConsultaDMS dms;

    private String instancia;

    private List<LineService> services;

    public EditServIn() {
        super(ActionsEnum.EDITAR_SERVICOS);
    }

    public ConsultaDMS getDms() {
        return dms;
    }

    public void setDms(ConsultaDMS dms) {
        this.dms = dms;
    }

    public List<LineService> getServices() {
        return services;
    }

    public void setServices(List<LineService> services) {
        this.services = services;
    }

    public String getInstancia() {
        return instancia;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

}
