package ru.yandex.praktikum.order;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static ru.yandex.praktikum.sitedata.ApiEndpoints.*;

public class OrdersList {

    @Step("Create new order")
    public ValidatableResponse createNewOrder(Order order){
        return given()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(order)
                .when()
                .post(ORDERS)
                .then();
    }

    @Step("Get orders list")
    public ValidatableResponse getOrderList(){
        return given()
                .baseUri(BASE_URL)
                .when()
                .get(ORDERS)
                .then();
    }
    @Step("Cancel order")
    public ValidatableResponse cancelOrder(int track){
        return given()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(track)
                .when()
                .post(CANCEL_ORDER)
                .then();
    }
}
