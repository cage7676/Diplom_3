package api;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserServices {

    public static final String EMAIL = "@gmail.com";

    @Step("Регистрация пользователя")
    public Map<String, String> register() {

        String email = RandomStringUtils.randomAlphabetic(10) + EMAIL;
        String password = RandomStringUtils.randomAlphabetic(10);
        String name = RandomStringUtils.randomAlphabetic(10);

        Map<String, String> inputDataMap = new HashMap<>();
        inputDataMap.put("email", email);
        inputDataMap.put("password", password);
        inputDataMap.put("name", name);

        UserRegister response = given()
                .spec(Specification.getBaseSpec())
                .and()
                .body(inputDataMap)
                .when()
                .post("auth/register")
                .body()
                .as(UserRegister.class);

        Map<String, String> responseData = new HashMap<>();
        if (response != null) {
            responseData.put("email", response.getUser().getEmail());
            responseData.put("name", response.getUser().getName());
            responseData.put("password", password);

            Tokens.setAccessToken(response.getAccessToken().substring(7));
            Tokens.setRefreshToken(response.getRefreshToken());
        }
        return responseData;
    }

    @Step("Удалить пользователя")
    public static void deleteUser() {
        if (Tokens.getAccessToken() == null) {
            return;}
        given()
                .spec(Specification.getBaseSpec())
                .auth().oauth2(Tokens.getAccessToken())
                .when()
                .delete("auth/user")
                .then()
                .statusCode(202);
    }

}
