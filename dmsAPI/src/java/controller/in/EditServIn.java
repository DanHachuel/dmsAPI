/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.in;

import java.util.List;
import model.dms.ConsultaDMS;
import model.dms.LineService;
import model.log.ActionsEnum;
import model.log.GenericLog;

/**
 *
 * @author G0041775
 */
public class EditServIn extends GenericLog {

    private ConsultaDMS dms;

    List<LineService> services;

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

    @Override
    public Object entrada() {
        return dms;
    }

}
