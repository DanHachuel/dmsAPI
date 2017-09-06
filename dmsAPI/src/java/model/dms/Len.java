/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms;

import dao.dms.impl.tratativa.Tratativa;
import dao.dms.impl.tratativa.TratativaLenDMS;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * exemplo: - FLAB 15 0 01 00 - A1E0 02 1 04 83
 *
 *
 * @author G0042204
 */
public class Len {

    // FLA
    private String cnl;

    // B 15
    private String ard;
    // 0
    private Integer shelf;

    // 01 00
    private Integer porta;

    // FLAB 15 0 01 00
    private String len;

    private Boolean alternate;

    public Len() {
    }

    public String getCnl() {
        return cnl;
    }

    public void setCnl(String cnl) {
        this.cnl = cnl;
    }

    public String getArd() {
        return ard;
    }

    public void setArd(String ard) {
        this.ard = ard;
    }

    public Integer getShelf() {
        return shelf;
    }

    public void setShelf(Integer shelf) {
        this.shelf = shelf;
    }

    public Integer getPorta() {
        return porta;
    }

    public void setPorta(Integer porta) {
        this.porta = porta;
    }

    public String getLen() {
        this.len = toString();
        return len;
    }

    public void setLen(String len) {
        this.len = len;
    }

    @Override
    public String toString() {
        String ptString = String.format("%04d", porta);
        if (alternate) {
            return ard.concat(shelf.toString()) + " 02 1 " + ptString.substring(0, 2) + " " + ptString.substring(2, 4);
        }
        return cnl + ard + " " + shelf + " " + ptString.substring(0, 2) + " " + ptString.substring(2, 4);
    }

    public String lenParcial() {
        if (alternate) {
            return ard.concat(shelf.toString()) + " 02 1 ";
        }
        return cnl + ard + " " + shelf + " ";
    }

    public Boolean getAlternate() {
        return alternate;
    }

    public void setAlternate(Boolean alternate) {
        this.alternate = alternate;
    }

    @Override
    public boolean equals(Object obj) {
        Len objLen = (Len) obj; 
        return objLen.toString().equalsIgnoreCase(this.toString());
    }
    
    

}
