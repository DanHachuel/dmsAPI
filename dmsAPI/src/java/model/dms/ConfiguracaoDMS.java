/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms;

import java.util.ArrayList;
import java.util.List;
import model.dms.dto.LineServiceDTO;

/**
 *
 * @author G0042204
 */
public class ConfiguracaoDMS {

    private String dn;

    private String len;

    private String custGrp;

    private String subGrp;

    private Integer ncos;

    private LineStatus status;

    private List<LineServiceDTO> servicos;

    public ConfiguracaoDMS() {
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public String getLen() {
        return len;
    }

    public void setLen(String len) {
        this.len = len;
        if (len.isEmpty()) {
            this.setStatus(LineStatus.NOT_CREATED);

        } else {
            this.setStatus(LineStatus.CREATED);
        }
    }

    public String getCustGrp() {
        return custGrp;
    }

    public void setCustGrp(String custGrp) {
        this.custGrp = custGrp;
    }

    public String getSubGrp() {
        return subGrp;
    }

    public void setSubGrp(String subGrp) {
        this.subGrp = subGrp;
    }

    public Integer getNcos() {
        return ncos;
    }

    public void setNcos(Integer ncos) {
        this.ncos = ncos;
    }

    public LineStatus getStatus() {
        return status;
    }

    public void setStatus(LineStatus status) {
        this.status = status;
    }

    public List<LineServiceDTO> getServicos() {
        if (servicos == null) {
            servicos = new ArrayList<>();

        }
        return servicos;
    }

    public void setServicos(List<LineServiceDTO> servicos) {
        this.servicos = servicos;
    }

    public void add(LineService s) {
        getServicos().add(s.dto());
    }

}
