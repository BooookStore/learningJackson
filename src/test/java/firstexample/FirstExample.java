package firstexample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FirstExample {

    @Test
    public void example() throws IOException {
        Album album = new Album();
        album.setTitle("初恋");

        // アーティスト
        Artist artist = new Artist();
        artist.setName("宇多田ヒカル");
        artist.setDateOfBirth(LocalDate.of(1983, 1, 19));

        // 出演
        Map<String, String> appearanceOfStage = new HashMap<>();
        appearanceOfStage.put("ラジオ", "J-WAVE, InterFM");
        appearanceOfStage.put("CM", "ソニー, NTTドコモ, サントリー");
        appearanceOfStage.put("テレビ", "HERO, NHK");
        artist.setAppearanceOnStage(appearanceOfStage);

        album.setArtist(artist);
        album.setLinks(new String[]{"link1", "link2"});
        album.setSongs(Arrays.asList("Play A Love Song", "あなた", "初恋"));

        // JavaからJSONへ変換
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.writeValue(System.out, album);
    }

    @Test
    public void readExample() throws IOException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        URL resource = getClass().getClassLoader().getResource("Album.json");
        Album album = objectMapper.readValue(Paths.get(Objects.requireNonNull(resource).toURI()).toFile(), Album.class);
    }

}
