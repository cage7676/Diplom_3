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

public class ConstructorTestCase {

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

    @Tag("ConstructorTestCase")
    @Test
    @DisplayName("Проверка перехода по клику на «Конструктор» и на логотип Stellar Burgers")
    public void checkingTransitionClickOnConstructorAndOnLogo() {

        Login loginClass = open(Login.URL, Login.class);
        loginClass.login(profile);

        Main main = page(Main.class);
        main.goToProfilePage();

        Profile profile = page(Profile.class);
        profile.goToLogoBuilderPage();

        main = page(Main.class);
        main.checkConstructorBlock();

    }

    @Tag("ConstructorTestCase")
    @Test
    @DisplayName("Проверка перехода в раздел «Булки»")
    public void checkTransitionToBunsSection() {

        Main main = open(Main.URL, Main.class);
        main.goToFillingsClick();
        main.goToBunsClick();
        main.checkBunsClickOpen();
    }

    @Tag("ConstructorTestCase")
    @Test
    @DisplayName("Проверка перехода в раздел «Соусы»")
    public void checkTransitionToSaucesSection() {

        Main main = open(Main.URL, Main.class);
        main.goToSaucesClick();
        main.checkSaucesClickOpen();
    }

    @Tag("ConstructorTestCase")
    @Test
    @DisplayName("Проверка перехода в раздел «Начинки»")
    public void checkTransitionToFillingsSection() {

        Main main = open(Main.URL, Main.class);
        main.goToFillingsClick();
        main.checkFillingsClickOpen();
    }
}
