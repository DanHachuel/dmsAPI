/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms.dto;

import java.util.List;
import model.dms.ConfiguracaoDMS;
import model.dms.Len;
import model.dms.LineService;
import model.dms.LineStatus;

/**
 *
 * @author G0042204
 */
public class ConfiguracaoDMSDTO {

    private String dn;

    private Len len;

    private String custGrp;

    private NcosDTO ncos;

    private LineStatus status;

    private List<LineServiceDTO> servicos;

    private EstadoDaPortaDTO estado;

    public ConfiguracaoDMSDTO() {
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
        return servicos;
    }

    public void setServicos(List<LineServiceDTO> servicos) {
        this.servicos = servicos;
    }

    public EstadoDaPortaDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoDaPortaDTO estado) {
        this.estado = estado;
    }

}
