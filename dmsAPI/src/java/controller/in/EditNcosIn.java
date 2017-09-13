/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.in;

import model.dms.ConsultaDMS;
import model.dms.NcosEnum;
import model.log.ActionsEnum;
import model.log.GenericLog;

/**
 *
 * @author G0041775
 */
public class EditNcosIn extends GenericLog {

    private ConsultaDMS dms;

    private NcosEnum ncos;

    public EditNcosIn() {
        super(ActionsEnum.EDITAR_NCOS);
    }

    public ConsultaDMS getDms() {
        return dms;
    }

    public void setDms(ConsultaDMS dms) {
        this.dms = dms;
    }

    public NcosEnum getNcos() {
        return ncos;
    }

    public void setNcos(NcosEnum ncos) {
        this.ncos = ncos;
    }

    

    @Override
    public Object entrada() {
        return dms;
    }

}
