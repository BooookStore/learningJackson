package annotations.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertThat;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs;

public class JsonUnwrapped_BookTest {

    @Test
    public void test() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        String bookJson = objectMapper.writeValueAsString(new JsonUnwrapped_Book(
                1L,
                "DomainDrivenDesign",
                new ISBN("12345")
        ));
        System.out.println(bookJson);

        assertThat(bookJson, sameJSONAs("{" +
                "\"id\":1," +
                "\"title\":\"DomainDrivenDesign\"," +
                "\"isbn\":\"12345\"" +
                "}"));

        // check for deserialize
        objectMapper.readValue(bookJson, JsonUnwrapped_Book.class);
    }

}