package ru.yandex.praktikum.courier;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
import static ru.yandex.praktikum.sitedata.ApiEndpoints.AUTH_COURIER;
import static ru.yandex.praktikum.sitedata.ApiEndpoints.BASE_URL;

public class CourierAuthorization {
    @Step("Courier system log in")
    public ValidatableResponse authorizationCourier(Authorization courier){
        return given()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(courier)
                .when()
                .post(AUTH_COURIER)
                .then();
    }
}