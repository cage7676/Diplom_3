package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import model.ProfileForm;
import model.ProfileGenerator;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import services.Login;
import services.Registration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class RegistrationTestCase {

    private ProfileForm profile;

    @Before
    public void setUp() {
        profile = ProfileGenerator.getRandom();
    }

    @AfterClass
    public static void tearDown() {
        Selenide.closeWebDriver();
    }

    @Tag("RegistrationTestCase")
    @Test
    @DisplayName("Проверка успешной регистрации")
    public void checkSuccessfulRegistration() {

        Registration registration = open(Registration.URL, Registration.class);
        registration.registerNewUser(profile);

        Login login = page(Login.class);
        login.loginPage();
    }

    @Tag("RegistrationTestCase")
    @Test
    @DisplayName("Проверка регистрации с паролем меньше минимальной длины")
    public void checkRegistrationWithPasswordLessMinimumLength() {

        Registration registration = open(Registration.URL, Registration.class);
        profile.setPassword("false");
        registration.registerNewUser(profile);

        assertTrue(registration.checkInvalidPasswordTextDisplayed());
    }
}
