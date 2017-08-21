/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import model.dms.LineService;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

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
