package annotations.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs;

public class JsonView_BookTest {

    @Test
    public void test() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        JsonView_Book jsonView_book = new JsonView_Book(
                1L,
                "title",
                "description",
                "author",
                "publisher"
        );

        String bookJson_normal = objectMapper.writerWithView(JsonView_Book_Type.Normal.class).writeValueAsString(jsonView_book);
        System.out.println(bookJson_normal);

        assertThat(bookJson_normal, sameJSONAs("{" +
                "\"id\":1," +
                "\"title\":\"title\"," +
                "\"description\":\"description\"" +
                "}"));

        String bookJson_management = objectMapper.writerWithView(JsonView_Book_Type.Management.class).writeValueAsString(jsonView_book);
        System.out.println(bookJson_management);

        assertThat(bookJson_management, sameJSONAs("{" +
                "\"id\":1," +
                "\"author\":\"author\"," +
                "\"publisher\":\"publisher\"" +
                "}"));

        // check for deserialize
        JsonView_Book readValue = objectMapper.readValue(bookJson_normal, JsonView_Book.class);
        assertEquals(1L, (long) readValue.getId());
        assertEquals("title", readValue.getTitle());
        assertEquals("description", readValue.getDescription());
        assertNull(readValue.getAuthor());
        assertNull(readValue.getPublisher());
    }

}