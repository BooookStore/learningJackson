package annotations.serialization;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class JsonUnwrapped_Book {

    private Long id;

    private String title;

    @JsonUnwrapped
    private ISBN isbn;

    public JsonUnwrapped_Book() {
    }

    public JsonUnwrapped_Book(Long id, String title, ISBN isbn) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ISBN getIsbn() {
        return isbn;
    }

    public void setIsbn(ISBN isbn) {
        this.isbn = isbn;
    }
}
