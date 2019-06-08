package annotations.inclusion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonIgnore_Book {

    private Long id;

    @JsonIgnore
    private String isbn;

    public JsonIgnore_Book() {

    }

    public JsonIgnore_Book(Long id, String isbn) {
        this.id = id;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    @JsonProperty
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}


