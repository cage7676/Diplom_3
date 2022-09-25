package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import model.ProfileForm;
import model.ProfileGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import services.Login;
import services.Main;
import services.Profile;
import services.Registration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class ProfileTestCase {

    ProfileForm profile;

    @Before
    public void setUp() {
        profile = ProfileGenerator.getRandom();
        Registration registration = open(Registration.URL, Registration.class);
        registration.registerNewUser(profile);
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Tag("ProfileTestCase")
    @Test
    @DisplayName("Проверка перехода по клику на «Личный кабинет")
    public void checkTransitionByClickingOnPersonalAccount() {

        Login loginClass = open(Login.URL, Login.class);
        loginClass.login(profile);

        Main main = page(Main.class);
        main.goToProfilePage();

        Profile profile = page(Profile.class);
        profile.checkProfilePage();
    }

    @Tag("ProfileTestCase")
    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете")
    public void checkExitByClickLogoutButtonInYourAccount() {

        Login loginClass = open(Login.URL, Login.class);
        loginClass.login(profile);
        Main main = page(Main.class);
        main.goToProfilePage();

        Profile profile = page(Profile.class);
        profile.logout();

        loginClass = page(Login.class);
        loginClass.checkAuthorised();
    }
}
