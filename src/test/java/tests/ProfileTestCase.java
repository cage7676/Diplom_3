package tests;

import api.UserServices;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import model.ProfileForm;
import model.ProfileGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;
import pages.RegistrationPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class ProfileTestCase {

    Map<String, String> user = new UserServices().register();
    String email = user.get("email");
    String password = user.get("password");
    MainPage main;
    ProfilePage profile;
    LoginPage loginClass;
    @Before
    public void setUp() {
        loginClass = page(LoginPage.class);
        profile = page(ProfilePage.class);
        main = open(MainPage.URL, MainPage.class);
        main
                .clickLoginButton()
                .setEmail(email)
                .setPassword(password)
                .loginButtonClick();
    }

    @Tag("ProfileTestCase")
    @Test
    @DisplayName("Проверка перехода по клику на «Личный кабинет")
    public void checkTransitionByClickingOnPersonalAccount() {

        main.
                goToProfilePage();
        profile.
                checkProfilePage();
    }

    @Tag("ProfileTestCase")
    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете")
    public void checkExitByClickLogoutButtonInYourAccount() {

        main.goToProfilePage();
        profile.logout();
        loginClass.checkAuthorised();

    }
    @After
    public void tearDown() {
        UserServices.deleteUser();
        webdriver().driver().close();
    }
}
