package ru.yandex.praktikum.courier;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
import static ru.yandex.praktikum.sitedata.ApiEndpoints.*;


public class CourierCreate {
    @Step("Create courier")
    public ValidatableResponse createCourier(Registration courier){
        return given()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(courier)
                .when()
                .post(CREATE_COURIER)
                .then();
    }
    @Step("Remove courier")
    public ValidatableResponse deleteCourier(int id){
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .when()
                .delete(DELETE_COURIER + id)
                .then();
    }

}