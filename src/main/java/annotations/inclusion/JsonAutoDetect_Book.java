package annotations.inclusion;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class JsonAutoDetect_Book {

    private Long id;

    private String isbn;

    public JsonAutoDetect_Book() {

    }

    public JsonAutoDetect_Book(Long id, String isbn) {
        this.id = id;
        this.isbn = isbn;
    }

}


