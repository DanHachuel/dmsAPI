/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.service;

import java.util.List;
import model.dms.dto.DetailDTO;

/**
 *
 * @author G0042204
 */
public interface ServiceContextDMS {

    public List<DetailDTO> contextDetail();
    
    public void connect();
    
    public void disconnect();

}
