/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.dto;

/**
 *
 * @author G0042204
 */
public class NcosDTO {

    private Integer ncos;

    private String desc;

    public NcosDTO(Integer ncos, String desc) {
        this.ncos = ncos;
        this.desc = desc;
    }

    public Integer getNcos() {
        return ncos;
    }

    public void setNcos(Integer ncos) {
        this.ncos = ncos;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
