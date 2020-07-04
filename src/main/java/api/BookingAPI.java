package api;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.BookingPayload;
import payloads.PartialUpdatedPayload;


public class BookingAPI extends BaseAPI{
    private static final String apiURL = baseURL + "/booking/";

    public static Response getBookings() {
        return given().get(apiURL);
    }
    public static Response getBookingByID(String bookingID, String mediaType) {
        return  given()
                .header("Accept", mediaType)
                .get(apiURL + bookingID);
    }
    public static  Response postBooking(BookingPayload bookingPayload) {
        return given()
                .contentType(ContentType.JSON)
                .body(bookingPayload)
                .get(apiURL);
    }
    public static  Response deleteBooking(String bookingID, String token) {
        return given()
                .header("Cookie", "token=" + token)
                .delete(apiURL + bookingID);
    }
    public static Response partialUpdateBooking(String bookingID, String token, PartialUpdatedPayload partialUpdatedPayload) {
        return given()
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .body(partialUpdatedPayload)
                .patch(apiURL + bookingID);
    }
}
