package ru.yandex.praktikum.courier;
import com.github.javafaker.Faker;

public class CouriersData {
    public Registration baseCourier() {
        return new Registration("SuperWooopsen", "qwerty","Wooopsen");
    }
    public Registration registeredCourier() {
        return new Registration("poopsen1337","12345678","Pooopsen");
    }
    public Registration firstCourier() {
        return new Registration("ddShnuk", "onth3web", "Shnuk");
    }

    public Registration secondCourier() {
        return new Registration(login,password,name);
    }

    public Registration emptyLoginCourier() {
        return new Registration(null, password, name);
    }

    public Registration emptyPasswordCourier() {
        return new Registration(login, "", name);
    }

    Faker faker = new Faker();

    String login = faker.funnyName().name();
    String password = faker.internet().password();
    String name = faker.name().firstName();

}