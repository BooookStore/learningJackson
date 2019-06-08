package annotations.inclusion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs;

public class JsonIgnore_BookTest {

    @Test
    public void test() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        String bookJson = objectMapper.writeValueAsString(new JsonIgnore_Book(1L, "123-456-78"));
        System.out.println(bookJson);

        assertThat(bookJson, sameJSONAs("{" +
                "\"id\":1" +
                "}"));

        // check for deserialize
        objectMapper.readValue(bookJson, JsonIgnore_Book.class);
    }

    @Test
    public void readIgnorePropertyTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        String jsonIgnore_book = "{" +
                "\"id\":1," +
                "\"isbn\":\"123-456-78\"" +
                "}";

        JsonIgnore_Book book = objectMapper.readValue(jsonIgnore_book, JsonIgnore_Book.class);
        assertEquals(1L, ((long) book.getId()));
        assertNull(book.getIsbn());
    }
}