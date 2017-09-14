/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms;

import model.dms.dto.LineServiceDTO;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import util.JsonEnumDeserializer;

/**
 * CWT 3WC DGT DDN NOAMA
 *
 * @author G0042204
 */
@JsonSerialize(using = JsonEnumDeserializer.class)
public enum LineService {

    CONV_TRES("Conversa a Três", "3WC", ServiceType.SERVICO),
    DIGITAL("Digital (TOM / TONE)", "DGT", ServiceType.SERVICO),
    IDENT_CHAM("Identificador de Chamadas", "DDN NOAMA", ServiceType.SERVICO),
    LIG_SIMULT("Ligação Simultânea", "CWT", ServiceType.SERVICO);

    private String desc, key;
    
    private ServiceType tipo;

    private LineService(String desc, String key, ServiceType tipo) {
        this.desc = desc;
        this.key = key;
        this.tipo = tipo;
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
    
    public LineServiceDTO dto(){
        return new LineServiceDTO(desc, key, tipo, name());
    }

}
