package modules;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import play.libs.Json;

public class JsonObjectMapper
{
    
    public JsonObjectMapper()
    {
        ObjectMapper mapper = Json.newDefaultMapper()
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        
        Json.setObjectMapper(mapper);
    }
    
}
