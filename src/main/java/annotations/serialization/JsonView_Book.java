package annotations.serialization;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JsonView_Book {

    private Long id;

    @JsonView(JsonView_Book_Type.Normal.class)
    private String title;

    @JsonView(JsonView_Book_Type.Normal.class)
    private String description;

    @JsonView(JsonView_Book_Type.Management.class)
    private String author;

    @JsonView(JsonView_Book_Type.Management.class)
    private String publisher;

}
