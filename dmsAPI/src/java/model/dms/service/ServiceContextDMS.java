/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.service;

import dao.dms.impl.ManagerDMS;
import java.util.List;
import model.dms.dto.DetailDTO;

/**
 *
 * @author G0042204
 */
public interface ServiceContextDMS {

    public List<DetailDTO> contextDetail();

    public void connectSwitches();

    public DetailDTO connectSwitch(String ip) throws Exception;

    public DetailDTO disconnectSwitch(String ip) throws Exception;

    public void disconnectSwitches();

    public void keepAlive();

    public ManagerDMS findInContext(String ip) throws Exception;

}
