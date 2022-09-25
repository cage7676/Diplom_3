package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import model.ProfileForm;
import model.ProfileGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import services.ForgotPassword;
import services.Login;
import services.Main;
import services.Registration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginTestCase {

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

    @Tag("LoginTestCase")
    @Test
    @DisplayName("Проверка входа по кнопке «Войти в аккаунт» на главной")
    public void checkLoginOnEntryLoginToYourAccountOnMainPage() {

        Main main = open(Main.URL, Main.class);
        main.goToLoginPageUsingCentralButton();

        Login login = page(Login.class);
        login.login(profile);

        main = page(Main.class);
        main.checkUserAuthorised();
    }

    @Tag("LoginTestCase")
    @Test
    @DisplayName("Проверка входа через кнопку «Личный кабинет»")
    public void checkLoginThroughButtonPersonalAccount() {

        Main main = open(Main.URL, Main.class);
        main.goToLoginPageUsingButtonFromHeader();

        Login login = page(Login.class);
        login.login(profile);

        main = page(Main.class);
        main.checkUserAuthorised();
    }

    @Tag("LoginTestCase")
    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    public void checkLoginThroughButtonInRegistrationForm() {

        Registration registration = open(Registration.URL, Registration.class);
        registration.goToLoginPageFromRegistrationPage();

        Login login = page(Login.class);
        login.login(profile);

        Main main = page(Main.class);
        main.checkUserAuthorised();
    }

    @Tag("LoginTestCase")
    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    public void checkLoginThroughButtonInPasswordRecoveryForm() {

        ForgotPassword forgotPassword = open(ForgotPassword.URL, ForgotPassword.class);
        forgotPassword.goLoginPageFromForgotPasswordPage();

        Login login = page(Login.class);
        login.login(profile);

        Main main = page(Main.class);
        main.checkUserAuthorised();
    }
}
