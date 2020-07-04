package utils;
import api.AuthAPI;
import io.restassured.response.Response;
import payloads.AuthPayload;
import payloads.AuthResponsePayload;

public class TokenGenerator {
    public static String generateToken() {
        // Login & Get Token
        AuthPayload authPayload = new AuthPayload("admin", "password123");
        Response authRes = AuthAPI.postAuth(authPayload);
        // System.out.println(authRes.getBody().prettyPrint());
        return authRes.as(AuthResponsePayload.class).getToken();
    }
}
