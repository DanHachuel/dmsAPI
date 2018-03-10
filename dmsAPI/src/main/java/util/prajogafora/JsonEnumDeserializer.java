/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.prajogafora;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import model.dms.LineService;

/**
 *
 * @author G0042204
 */
public class JsonEnumDeserializer extends JsonSerializer<LineService> {

    public JsonEnumDeserializer() {
    }

    @Override
    public void serialize(LineService t, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException {

        jg.writeStartObject();
        jg.writeFieldName("name");
        jg.writeString(t.name());
        jg.writeFieldName("desc");
        jg.writeString(t.getDesc());
        jg.writeFieldName("key");
        jg.writeNumber(t.getKey());
        jg.writeEndObject();
    }

}
