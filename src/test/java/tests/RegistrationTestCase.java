package tests;

import api.UserServices;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import model.ProfileForm;
import model.ProfileGenerator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class RegistrationTestCase {

    private ProfileForm profile;
    RegistrationPage registration;
    LoginPage login;
    MainPage mainPage;

    @Before
    public void setUp() {
        mainPage = open(MainPage.URL, MainPage.class);
        registration = open(RegistrationPage.URL, RegistrationPage.class);
        profile = ProfileGenerator.getRandom();
        login = page(LoginPage.class);
    }


    @Tag("RegistrationTestCase")
    @Test
    @DisplayName("Проверка успешной регистрации")
    public void checkSuccessfulRegistration() {

        registration.registerNewUser(profile);
        login.loginPage();

    }

    @Tag("RegistrationTestCase")
    @Test
    @DisplayName("Проверка регистрации с паролем меньше минимальной длины")
    public void checkRegistrationWithPasswordLessMinimumLength() {

        profile.setPassword("false");
        registration.registerNewUser(profile);
        assertTrue(registration.checkInvalidPasswordTextDisplayed());

    }

    @After
    public void tearDown() {
        webdriver().driver().close();
    }
}
