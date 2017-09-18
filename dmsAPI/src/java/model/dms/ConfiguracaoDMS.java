/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms;

import java.util.ArrayList;
import java.util.List;
import model.dms.dto.EstadoDaPortaDTO;
import model.dms.dto.NcosDTO;

/**
 *
 * @author G0042204
 */
public class ConfiguracaoDMS {

    private String dn;

    private Len len;

    private String custGrp;

    private NcosDTO ncos;

    private LineStatus status;

    private List<LineService> servicos;

    private EstadoDaPortaDTO estado;

    public ConfiguracaoDMS() {
        status = LineStatus.NOT_CREATED;
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public Len getLen() {
        return len;
    }

    public void setLen(Len len) {
        this.len = len;
        if (len != null) {
            this.setStatus(LineStatus.CREATED);
        }
    }

    public String getCustGrp() {
        return custGrp;
    }

    public void setCustGrp(String custGrp) {
        this.custGrp = custGrp;
    }

    public NcosDTO getNcos() {
        return ncos;
    }

    public void setNcos(NcosDTO ncos) {
        this.ncos = ncos;
    }

    public LineStatus getStatus() {
        return status;
    }

    public void setStatus(LineStatus status) {
        this.status = status;
    }

    public List<LineService> getServicos() {
        if (servicos == null) {
            servicos = new ArrayList<>();
        }
        return servicos;
    }

    public void setServicos(List<LineService> servicos) {
        this.servicos = servicos;
    }

    public void add(LineService s) {
        getServicos().add(s);
    }

    public EstadoDaPortaDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoDaPortaDTO estado) {
        this.estado = estado;
    }

}
