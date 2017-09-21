/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms;

import model.dms.adapter.Adapter;
import model.dms.dto.EstadoDaPortaDTO;

/**
 *
 * @author G0042204
 */
public enum EstadoDaPortaEnum implements Adapter<EstadoDaPortaDTO> {

    CPB("Call Process Busy - Chamada em Curso, Linha Ocupada.", Boolean.TRUE),
    IDL("Idle - Assinante Livre.", Boolean.TRUE),
    INB("Intallation Busy - Assinante Bloqueado na Instalação (PORTA VAGA).", Boolean.FALSE),
    CPD("Call Process Deload - Assinante Bloqueado com Chamada em Curso.", Boolean.FALSE),
    DEL("Deload - Assinante Previamente em CPD, Bloqueado pelo Processador.", Boolean.TRUE),
    INI("Initializing - Assinante em Inicialização após System Restart.", Boolean.FALSE),
    MB("Manual Bloqued - Assinante Bloqueado Manualmente.", Boolean.FALSE),
    NEQ("Not Equipped - Assinante Não Definido.", Boolean.FALSE),
    PMB("Peripheral Module Busy - Falha no Periférico.", Boolean.FALSE),
    SB("System Busy - Falha de Continuidade.", Boolean.FALSE),
    LMB("Falha de energia ou falha na porta.", Boolean.FALSE),
    PLO("Falha na porta (Curto).", Boolean.FALSE),
    NOP("Estado não mapeado.", Boolean.FALSE);

    private String desc;

    private Boolean valid;

    private EstadoDaPortaEnum(String desc, Boolean valid) {
        this.desc = desc;
        this.valid = valid;
    }

    @Override
    public EstadoDaPortaDTO adapt() {
        try {
            EstadoDaPortaDTO dto = new EstadoDaPortaDTO();
            dto.setKey(name());
            dto.setDesc(desc);
            dto.setValid(valid);
            dto.setNome(name());
            return dto;
        } catch (Exception e) {
            return null;
        }
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Boolean isValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

}
