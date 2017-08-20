/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.impl;

import model.dms.ConfiguracaoDMS;

/**
 *
 * @author G0042204
 */
interface ConsultaDMS {
    
    public ConfiguracaoDMS consultar(String instancia) throws Exception;
    
}
