package annotations.serialization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ISBN {

    @JsonProperty(value = "isbn")
    private String value;

    public ISBN() {
    }

    public ISBN(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
