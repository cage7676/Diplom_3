package tests;

import api.UserServices;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import model.ProfileForm;
import model.ProfileGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.junit.Assert.assertTrue;

public class LoginTestCase {

    Map<String, String> user = new UserServices().register();
    String email = user.get("email");
    String password = user.get("password");
    MainPage main;

    @Before
    public void setUp() {

        main = open(MainPage.URL, MainPage.class);
    }

    @Tag("LoginTestCase")
    @Test
    @DisplayName("Проверка входа по кнопке «Войти в аккаунт» на главной")
    public void checkLoginOnEntryLoginToYourAccountOnMainPage() {

        main
                .clickLoginButton()
                .setEmail(email)
                .setPassword(password)
                .loginButtonClick();

        boolean button = main.checkoutButtonVisible();

        webdriver().shouldHave(url("http://stellarburgers.nomoreparties.site/"));
        assertTrue("Button invisible", button);

    }

    @Tag("LoginTestCase")
    @Test
    @DisplayName("Проверка входа через кнопку «Личный кабинет»")
    public void checkLoginThroughButtonPersonalAccount() {

        main
                .clickCabinetButton()
                .setEmail(email)
                .setPassword(password)
                .loginButtonClick();

        boolean button = main.checkoutButtonVisible();

        webdriver().shouldHave(url("http://stellarburgers.nomoreparties.site/"));
        assertTrue("Button invisible", button);
    }

    @Tag("LoginTestCase")
    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    public void checkLoginThroughButtonInRegistrationForm() {

        main
                .clickLoginButton()
                .regLinkClick()
                .goToLoginPageFromRegistrationPage()
                .setEmail(email)
                .setPassword(password)
                .loginButtonClick();

        boolean button = main.checkoutButtonVisible();

        webdriver().shouldHave(url("http://stellarburgers.nomoreparties.site/"));
        assertTrue("Button invisible", button);
    }

    @Tag("LoginTestCase")
    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    public void checkLoginThroughButtonInPasswordRecoveryForm() {

        main
                .clickLoginButton()
                .resetPasswordLinkClick()
                .loginLinkClick()
                .setEmail(email)
                .setPassword(password)
                .loginButtonClick();

        boolean button = main.checkoutButtonVisible();

        webdriver().shouldHave(url("http://stellarburgers.nomoreparties.site/"));
        assertTrue("Button invisible", button);
    }

    @After
    public void tearDown() {
        UserServices.deleteUser();
        webdriver().driver().close();
    }
}
