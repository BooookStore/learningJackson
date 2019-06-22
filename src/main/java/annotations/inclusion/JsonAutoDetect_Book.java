package annotations.inclusion;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY,
        getterVisibility = JsonAutoDetect.Visibility.NONE
)
public class JsonAutoDetect_Book {

    public Long id;

    private String isbn;

    public JsonAutoDetect_Book() {

    }

    public JsonAutoDetect_Book(Long id, String isbn) {
        this.id = id;
        this.isbn = isbn;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}


