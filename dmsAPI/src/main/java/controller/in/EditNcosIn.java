/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.in;

import model.dms.ConsultaDMS;
import model.dms.Ncos;
import model.entity.LogEntity;
import model.log.ActionsEnum;

/**
 *
 * @author G0041775
 */
public class EditNcosIn extends LogEntity {

    private ConsultaDMS dms;

    private Ncos ncos;

    public EditNcosIn() {
        super(ActionsEnum.EDITAR_NCOS);
    }

    public ConsultaDMS getDms() {
        return dms;
    }

    public void setDms(ConsultaDMS dms) {
        this.dms = dms;
    }

    public Ncos getNcos() {
        return ncos;
    }

    public void setNcos(Ncos ncos) {
        this.ncos = ncos;
    }

}
