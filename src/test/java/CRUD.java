import api.AuthAPI;
import api.BookingAPI;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import payloads.*;
import utils.TokenGenerator;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CRUD {
    Response res = null;
    @Test
    public void getBookingIds() {
        res = BookingAPI.getBookings();
        assertThat(res.getStatusCode(), equalTo(200));
    }
    @Test
    public void getBooking() {
        res = BookingAPI.getBookingByID("1", "application/json");
         res.getBody().prettyPrint();
        assertThat(res.getStatusCode(), equalTo(200));
    }
    @Test
    public void createBooking() {
        BookingDatesPayload bookingDatesPayload = new BookingDatesPayload(new Date(), new Date());
        BookingPayload bookingPayload = new BookingPayload("John", "Doe", 555, false, bookingDatesPayload, "Dinner");
        res = BookingAPI.postBooking(bookingPayload);
        assertThat(res.getStatusCode(), equalTo(200));
    }
    @Test
    public void deleteBooking() {
        // Login & Get Token
        String token = TokenGenerator.generateToken();
        // Use token to delete booking
        Response bookingRes = BookingAPI.deleteBooking("1", token);

    }
    @Test
    public void updateBookingByID() { ;
        String token = TokenGenerator.generateToken();
        PartialUpdatedPayload partialUpdatedPayload = new PartialUpdatedPayload("John", "Doe");
        Response res = BookingAPI.partialUpdateBooking("1", token, partialUpdatedPayload);
         System.out.println(res.getBody().prettyPrint());
    }

    // Negative Test Case - Sending an invalid header (Making mediaType = "text/plain" Instead of "application/json")
    @Test
    public void getBookingIDReturn418() {
        res = BookingAPI.getBookingByID("1", "text/plain");
        assertThat(res.getStatusCode(), equalTo(418));
    }

}
