/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dms;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import util.JsonEnumDeserializer;

/**
 * CWT 3WC DGT DDN NOAMA
 *
 * @author G0042204
 */
@JsonSerialize(using = JsonEnumDeserializer.class)
public enum LineService {

    CONV_TRES("Conversa a Três", "3WC"),
    DIGITAL("Digital (TOM / TONE)", "DGT"),
    IDENT_CHAM_NOAMA("Identificador de Chamadas", "NOAMA"),
    IDENT_CHAM_DDN("Identificador de Chamadas", "DDN"),
    LIG_SIMULT("Ligação Simultânea", "CWT");

    private String desc, key;

    private LineService(String desc, String key) {
        this.desc = desc;
        this.key = key;
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

}
