package ru.yandex.praktikum;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import ru.yandex.praktikum.order.OrderAssert;
import ru.yandex.praktikum.order.OrdersList;

public class OrderListTest {
    OrdersList orderClient = new OrdersList();
    OrderAssert assertOrders = new OrderAssert();

    @Test
    @DisplayName("Get order list")
    @Description("Order list get successful")
    public void getOrderList() {
        ValidatableResponse orderList =  orderClient.getOrderList();
        assertOrders.successfulGetListOrders(orderList);
    }
}