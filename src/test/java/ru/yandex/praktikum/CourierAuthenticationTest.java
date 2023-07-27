package ru.yandex.praktikum;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.*;
import ru.yandex.praktikum.courier.AuthorizationAssert;
import ru.yandex.praktikum.courier.Authorization;
import ru.yandex.praktikum.courier.CourierAuthorization;
import ru.yandex.praktikum.courier.CouriersData;
import ru.yandex.praktikum.courier.CourierCreate;

public class CourierAuthenticationTest {
    static CourierCreate creatingCourier = new CourierCreate();
    Authorization auth;
    static ValidatableResponse authBaseCourier;
    CourierAuthorization authCourier = new CourierAuthorization();
    AuthorizationAssert assertsLogin = new AuthorizationAssert();
    static CouriersData courierData = new CouriersData();
    static int courierId;

    @BeforeClass
    public static void createBaseCourier(){
        creatingCourier.createCourier(courierData.firstCourier());
    }

    @Test
    @DisplayName("Auth successful")
    @Description("Successful authorization")
    public void successfulCourierAuth(){
        auth = Authorization.fromRegistrationCourier(courierData.firstCourier());
        authBaseCourier = authCourier.authorizationCourier(auth);
        assertsLogin.successfullyAuth(authBaseCourier);
    }

    @Test
    @DisplayName("Auth with login null")
    @Description("Authorization using null login")
    public void courierAuthWithEmptyLogin(){
        auth = Authorization.fromRegistrationCourier(courierData.emptyLoginCourier());
        authBaseCourier = authCourier.authorizationCourier(auth);
        assertsLogin.filedAuthLoginOrPasswordNull(authBaseCourier);

    }

    @Test
    @DisplayName("Auth with password null")
    @Description("Authorization using null password")
    public void courierAuthWithEmptyPassword(){
        auth = Authorization.fromRegistrationCourier(courierData.emptyPasswordCourier());
        authBaseCourier = authCourier.authorizationCourier(auth);
        assertsLogin.filedAuthLoginOrPasswordNull(authBaseCourier);
    }

    @Test
    @DisplayName("Unregistered courier auth")
    @Description("Attempt to authorize to an unexisting account")
    public void unregisteredCourierAuth(){
        auth = Authorization.fromRegistrationCourier(courierData.secondCourier());
        authBaseCourier = authCourier.authorizationCourier(auth);
        assertsLogin.filedAuthUserNotFound(authBaseCourier);
    }

    @AfterClass
    public static void deleteCourier(){
        courierId = authBaseCourier.extract().path("id");
        creatingCourier.deleteCourier(courierId);
    }
}