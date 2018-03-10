/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.in;

import model.dms.ConsultaDMS;
import model.entity.LogEntity;
import model.log.ActionsEnum;

/**
 *
 * @author G0042204
 */
public class ResetarPortaIn extends LogEntity {

    private ConsultaDMS dms;

    public ResetarPortaIn() {
        super(ActionsEnum.RESETAR_PORTA);
    }

    public ConsultaDMS getDms() {
        return dms;
    }

    public void setDms(ConsultaDMS dms) {
        this.dms = dms;
    }

}
