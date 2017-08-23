/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.service;

import model.dms.ConfiguracaoDMS;
import model.dms.ConsultaDmsIn;

/**
 *
 * @author G0042204
 */
public interface ServiceDMS {
    
    public ConfiguracaoDMS consultar(ConsultaDmsIn in) throws Exception;
    
}
