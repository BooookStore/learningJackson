package annotations.naming;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs;

public class JsonProperty_BookTest {

    @Test
    public void test() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        String bookJson = objectMapper.writeValueAsString(new JsonProperty_Book(1L, "123-456-78"));
        System.out.println(bookJson);

        assertThat(bookJson, sameJSONAs("{" +
                "\"BOOK-ID\":1," +
                "\"BOOK-ISBN\":\"123-456-78\"" +
                "}"));

        // check for deserialize
        objectMapper.readValue(bookJson, JsonProperty_Book.class);
    }

}
