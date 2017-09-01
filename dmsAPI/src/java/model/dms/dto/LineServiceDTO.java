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
public class LineServiceDTO {

    private String desc, key;

    public LineServiceDTO() {
    }

    public LineServiceDTO(String desc, String key) {
        this.desc = desc;
        this.key = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
