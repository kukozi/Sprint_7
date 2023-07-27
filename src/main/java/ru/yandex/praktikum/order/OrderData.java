package ru.yandex.praktikum.order;


public class OrderData {
    public Order baseOrderVariableColor(String[] colors) {
        return new Order("FirstNameExample", "LastNameExample", "AddressExample",
                4, "+79999999999", 5,"2023-06-06", "Some_comment", colors);
    }
}
