package firstexample;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Album {

    private String title;

    private Artist artist;

    private String[] links;

    private List<String> songs;

}

