/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dms.enums;

/**
 *
 * @author G0042204
 */
public enum SwitchesEnum {

    PRCTA_PVS01("10.141.245.97", "41"),
    PRCTA_LPS01("10.141.0.99", "41"),
    GOGNA_DOS01("10.161.88.100", "62");

    private final String ip;
    private final String prefix;

    private SwitchesEnum(String ip, String prefix) {
        this.ip = ip;
        this.prefix = prefix;
    }

    public String getIp() {
        return ip;
    }

    public String getPrefix() {
        return prefix;
    }

}
