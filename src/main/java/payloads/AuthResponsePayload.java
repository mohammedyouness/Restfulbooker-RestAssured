package payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponsePayload {
    @JsonProperty
    private String token;

    public String getToken() {
        return token;
    }
}
