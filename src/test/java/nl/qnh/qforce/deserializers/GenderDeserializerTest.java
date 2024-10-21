package nl.qnh.qforce.deserializers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

import nl.qnh.qforce.domain.Gender;

public class GenderDeserializerTest {

    private GenderDeserializer genderDeserializer;
    private JsonParser jsonParser;
    private DeserializationContext context;

    GenderDeserializerTest() {
        genderDeserializer = new GenderDeserializer();
        jsonParser = mock(JsonParser.class);
        context = mock(DeserializationContext.class);
    }

    /**
     * Unit test to check if the gender "male" is detected correctly
     * @throws IOException
     */
    @Test
    void testDeserializeMale() throws IOException {
        when(jsonParser.getText()).thenReturn("male");
        Gender result = genderDeserializer.deserialize(jsonParser, context);
        assertEquals(Gender.MALE, result);
    }

    /**
     * Unit test to check if the gender "female" is detected correctly
     * @throws IOException
     */
    @Test
    void testDeserializeFemale() throws IOException {
        when(jsonParser.getText()).thenReturn("female");
        Gender result = genderDeserializer.deserialize(jsonParser, context);
        assertEquals(Gender.FEMALE, result);
    }

    /**
     * Unit test to check if the gender "n/a" is detected correctly
     * @throws IOException
     */
    @Test
    void testDeserializeNotApplicable() throws IOException {
        when(jsonParser.getText()).thenReturn("n/a");
        Gender result = genderDeserializer.deserialize(jsonParser, context);
        assertEquals(Gender.NOT_APPLICABLE, result);
    }

    /**
     * Unit test to check if the gender "unknown" is detected correctly
     * @throws IOException
     */
    @Test
    void testDeserializeUnknown() throws IOException {
        when(jsonParser.getText()).thenReturn("unknown");
        Gender result = genderDeserializer.deserialize(jsonParser, context);
        assertEquals(Gender.UNKNOWN, result);
    }

}
