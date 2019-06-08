package annotations.inclusion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs;

public class JsonIgnoreProperties_BookTest {

    /**
     * IgnorePropertiesアノテーションでシリアライズ/デシリアライズで無視するプロパティを設定できる。
     * さらに、ignoreUnknownでデシリアライズする際に、Javaクラスのフィールドと一致しないプロパティ
     * を無視する事ができる。
     *
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        String bookJson = objectMapper.writeValueAsString(new JsonIgnoreProperties_Book(1L, "12345", "DomainDrivenDesign"));
        System.out.println(bookJson);

        assertThat(bookJson, sameJSONAs("{" +
                "\"id\":1" +
                "}"));

        // ignore unknown properties
        JsonIgnoreProperties_Book readBook = objectMapper.readValue("{" +
                        "\"id\":1," +
                        "\"isbn\":\"12345\"," +
                        "\"title\":\"DomainDrivenDesign\"," +
                        "\"publishDate\":\"2000-01-01\"" +
                        "}"
                , JsonIgnoreProperties_Book.class);
        assertEquals(1L, (long) readBook.getId());
        assertNull(readBook.getIsbn());
        assertNull(readBook.getTitle());
    }

}