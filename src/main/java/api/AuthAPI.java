package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.AuthPayload;

public class AuthAPI extends BaseAPI {
    private static final String apiURL = baseURL + "/auth";

    public static Response postAuth(AuthPayload authPayload) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(authPayload)
                .when()
                .post(apiURL);
    }


}
