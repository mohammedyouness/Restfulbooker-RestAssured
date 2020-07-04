package payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PartialUpdatedPayload {

    @JsonProperty
    private String firstname;
    @JsonProperty
    private String lastname;

    public PartialUpdatedPayload(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}

