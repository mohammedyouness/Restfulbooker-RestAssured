package payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class BookingDatesPayload {
    @JsonProperty
    private Date checkIn;
    @JsonProperty
    private Date checkOut;

    public BookingDatesPayload(Date checkIn, Date checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
}
