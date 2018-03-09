/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.in;

import model.dms.ConfiguracaoDMS;
import model.dms.ConsultaDMS;
import model.dms.Len;
import model.log.ActionsEnum;
import model.log.GenericLog;

/**
 *
 * @author G0042204
 */
public class ManobrarLinhaIn extends GenericLog {

    private ConsultaDMS dms;
    
    private Len len;
    
    private ConfiguracaoDMS confBinada;

    public ManobrarLinhaIn() {
        super(ActionsEnum.MANOBRAR_LINHA);
    }

    public ConsultaDMS getDms() {
        return dms;
    }

    public void setDms(ConsultaDMS dms) {
        this.dms = dms;
    }

    public Len getLen() {
        return len;
    }

    public void setLen(Len len) throws Exception {
        this.len = len;
    }

    public ConfiguracaoDMS getConfBinada() {
        return confBinada;
    }

    public void setConfBinada(ConfiguracaoDMS confBinada) {
        this.confBinada = confBinada;
    }

    @Override
    public Object entrada() {
        return dms;
    }

}
