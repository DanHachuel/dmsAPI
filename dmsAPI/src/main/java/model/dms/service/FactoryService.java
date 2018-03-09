/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.service;

/**
 *
 * @author G0042204
 */
public class FactoryService {

    public static ServiceDMS create() {
        return new ServiceDMSImpl();
    }
    
    public static ServiceContextDMS createContext(){
        return new ServiceContextDMSImpl();
    }
    
    

}
