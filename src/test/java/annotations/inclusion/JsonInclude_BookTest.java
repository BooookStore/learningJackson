package annotations.inclusion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs;

public class JsonInclude_BookTest {

    @Test
    public void test() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        JsonInclude_Book jsonInclude_book = new JsonInclude_Book();
        jsonInclude_book.setId(1L);
        String bookJson = objectMapper.writeValueAsString(jsonInclude_book);
        System.out.println(bookJson);

        assertThat(bookJson, sameJSONAs("{" +
                "\"id\":1," +
                "\"isbn\":null" +
                "}"));

        // check for deserialize
        JsonInclude_Book readBook = objectMapper.readValue(bookJson, JsonInclude_Book.class);
        assertEquals(1L, (long) readBook.getId());
        assertNull(readBook.getIsbn());
    }

}