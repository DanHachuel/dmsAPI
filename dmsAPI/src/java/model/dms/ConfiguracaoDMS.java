/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms;

import java.util.ArrayList;
import java.util.List;
import model.dms.dto.LineServiceDTO;
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

    private List<LineServiceDTO> servicos;

    private EstadoDaPorta estado;

    public ConfiguracaoDMS() {
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
        } else {
            this.setStatus(LineStatus.NOT_CREATED);
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

    public EstadoDaPorta getEstado() {
        return estado;
    }

    public void setEstado(EstadoDaPorta estado) {
        this.estado = estado;
    }

}
