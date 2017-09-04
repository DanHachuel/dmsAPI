/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.viewmodel;

import java.util.List;
import model.dms.ConfiguracaoDMS;
import model.dms.Len;

/**
 *
 * @author G0042204
 */
public class CriacaoLinha {
    
    private ConfiguracaoDMS dms;
    
    private List<Len> lens;

    public CriacaoLinha() {
    }

    public ConfiguracaoDMS getDms() {
        return dms;
    }

    public void setDms(ConfiguracaoDMS dms) {
        this.dms = dms;
    }

    public List<Len> getLens() {
        return lens;
    }

    public void setLens(List<Len> lens) {
        this.lens = lens;
    }
    
    
    
}
