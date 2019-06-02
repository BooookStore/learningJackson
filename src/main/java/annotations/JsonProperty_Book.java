package annotations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonProperty_Book {

    @JsonProperty("BOOK-ID")
    private Long id;

    @JsonProperty("BOOK-ISBN")
    private String isbn;

    public JsonProperty_Book() {

    }

    public JsonProperty_Book(Long id, String isbn) {
        this.id = id;
        this.isbn = isbn;
    }

}


