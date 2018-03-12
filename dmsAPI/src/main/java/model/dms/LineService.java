/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import model.dms.dto.LineServiceDTO;

/**
 * CWT 3WC DGT DDN NOAMA
 *
 * @author G0042204
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LineService {

    CONV_TRES("Conversa a Três", "3WC", ServiceType.SERVICO, ServiceLevel.SIMPLE),
    DIGITAL("Digital (TOM / TONE)", "DGT", ServiceType.SERVICO, ServiceLevel.SIMPLE),
    IDENT_CHAM("Identificador de Chamadas", "DDN NOAMA", ServiceType.SERVICO, ServiceLevel.SIMPLE),
    SIGA_ME("Siga-me", "CFU N", ServiceType.SERVICO, ServiceLevel.SIMPLE),
    SIGA_ME_Y("Siga-me", "CFU Y", ServiceType.LEITURA_ONLY, ServiceLevel.SIMPLE),
    SIGA_ME_FORCED("Siga-me (Forçado)", "CFF", ServiceType.SERVICO, ServiceLevel.RMV_ONLY),
    NAO_IDENTIFICAR("Ligar como Anônimo", "SUPPRESS PUBLIC", ServiceType.SERVICO, ServiceLevel.COMPLEX),
    SEC_ELETRONICA("Secretária Eletrônica", "CFD", ServiceType.SERVICO, ServiceLevel.COMPLEX),
    SUSP_TEMP("Suspensão Temporária", "SUS", ServiceType.BLOQUEIO, ServiceLevel.COMPLEX),
    BLOQ_PROG_CEL("Bloqueio Programado Celular", "I976", ServiceType.BLOQUEIO, ServiceLevel.COMPLEX),
    BLOQ_PROG_0500("Bloqueio Programado 0500", "I800", ServiceType.BLOQUEIO, ServiceLevel.COMPLEX),
    BLOQ_PROG_0900("Bloqueio Programado 0900 e 0300", "I900", ServiceType.BLOQUEIO, ServiceLevel.COMPLEX),
    BLOQ_PROG_DDD("Bloqueio Programado DDD", "LDAS", ServiceType.BLOQUEIO, ServiceLevel.COMPLEX),
    BLOQ_PROG_DDI("Bloqueio Programado DDI", "TDAS", ServiceType.BLOQUEIO, ServiceLevel.COMPLEX),
    BLOQ_RECEB("Bloqueio Receber Chamadas", "DTM", ServiceType.BLOQUEIO, ServiceLevel.SIMPLE),
    BLOQ_EFET("Bloqueio Realizar Chamadas", "DOR", ServiceType.BLOQUEIO, ServiceLevel.SIMPLE),
    BLOQ_A_COBRAR("Bloqueio Receber Chamadas a Cobrar", "ACCB", ServiceType.BLOQUEIO, ServiceLevel.SIMPLE),
    LIG_SIMULT("Ligação Simultânea", "CWT", ServiceType.SERVICO, ServiceLevel.SIMPLE);

    private String desc, key;

    private ServiceType tipo;

    private ServiceLevel nivel;

    private LineService(String desc, String key, ServiceType tipo, ServiceLevel nivel) {
        this.desc = desc;
        this.key = key;
        this.tipo = tipo;
        this.nivel = nivel;
    }

    public ServiceLevel getNivel() {
        return nivel;
    }

    public void setNivel(ServiceLevel nivel) {
        this.nivel = nivel;
    }

    public ServiceType getTipo() {
        return tipo;
    }

    public void setTipo(ServiceType tipo) {
        this.tipo = tipo;
    }

    public String getDesc() {
        return desc;
    }

    public String getKey() {
        return key;
    }

    public static LineService findByKey(String key) {
        for (LineService value : values()) {
            if (value.getKey().equalsIgnoreCase(key)) {
                return value;
            }
        }
        return null;
    }

    public LineServiceDTO dto() {
        return new LineServiceDTO(desc, key, tipo, name(), nivel);
    }

    @JsonCreator
    public static LineService fromNode(JsonNode node) {
        if (!node.has("nome")) {
            return null;
        }

        String name = node.get("nome").asText();

        return LineService.valueOf(name);
    }

}
