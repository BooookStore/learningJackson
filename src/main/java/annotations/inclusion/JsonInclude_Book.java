package annotations.inclusion;

import com.fasterxml.jackson.annotation.JsonInclude;

public class JsonInclude_Book {

    private Long id;

    @JsonInclude
    private String isbn;

    public JsonInclude_Book() {

    }

    public JsonInclude_Book(Long id, String isbn) {
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

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
