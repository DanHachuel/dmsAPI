/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms;

import java.util.List;

/**
 *
 * @author G0042204
 */
public class ConfiguracoesShelf {

    private List<FacilidadesMapci> fac;

    private ConfiguracaoDMS configBinada;

    public ConfiguracoesShelf() {
    }

    public ConfiguracoesShelf(List<FacilidadesMapci> fac, ConfiguracaoDMS configBinada) {
        this.fac = fac;
        this.configBinada = configBinada;
    }

    public List<FacilidadesMapci> getFac() {
        return fac;
    }

    public void setFac(List<FacilidadesMapci> fac) {
        this.fac = fac;
    }

    public ConfiguracaoDMS getConfigBinada() {
        return configBinada;
    }

    public void setConfigBinada(ConfiguracaoDMS configBinada) {
        this.configBinada = configBinada;
    }

}
