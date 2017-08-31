/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.in;

import model.dms.ConsultaDMS;
import model.log.ActionsEnum;
import model.log.GenericLog;

/**
 *
 * @author G0042204
 */
public class ConsultaDMSIn extends GenericLog {

    private ConsultaDMS dms;

    public ConsultaDMSIn() {
        super(ActionsEnum.CONSULTAR_DN);
    }

    public ConsultaDMS getDms() {
        return dms;
    }

    public void setDms(ConsultaDMS dms) {
        this.dms = dms;
    }

    @Override
    public Object entrada() {
        return dms;
    }
    
    

}
