package tests;

import api.UserServices;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;
import pages.ProfilePage;


import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class ConstructorTestCase {

    Map<String, String> user = new UserServices().register();
    String email = user.get("email");
    String password = user.get("password");
    MainPage main;
    @Before
    public void setUp() {
        main = open(MainPage.URL, MainPage.class);
        main
                .clickLoginButton()
                .setEmail(email)
                .setPassword(password)
                .loginButtonClick();
    }

    @Tag("ConstructorTestCase")
    @Test
    @DisplayName("Проверка перехода по клику на «Конструктор» и на логотип Stellar Burgers")
    public void checkingTransitionClickOnConstructorAndOnLogo() {

        main.goToProfilePage();

        ProfilePage profile = page(ProfilePage.class);
        profile.goToLogoBuilderPage();

        main.checkConstructorBlock();

    }

    @Tag("ConstructorTestCase")
    @Test
    @DisplayName("Проверка перехода в раздел «Булки»")
    public void checkTransitionToBunsSection() {

        main
                .goToFillingsClick()
                .goToBunsClick()
                .checkBunsClickOpen();
    }

    @Tag("ConstructorTestCase")
    @Test
    @DisplayName("Проверка перехода в раздел «Соусы»")
    public void checkTransitionToSaucesSection() {
        main
                .goToSaucesClick()
                .checkSaucesClickOpen();
    }

    @Tag("ConstructorTestCase")
    @Test
    @DisplayName("Проверка перехода в раздел «Начинки»")
    public void checkTransitionToFillingsSection() {

        main
                .goToFillingsClick()
                .checkFillingsClickOpen();
    }

    @After
    public void tearDown() {

        Selenide.closeWebDriver();
        UserServices.deleteUser();
    }
}
