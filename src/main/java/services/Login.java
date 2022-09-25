package services;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import model.ProfileForm;
import pages.LoginPage;

public class Login extends LoginPage {

    @Step("Логин в хидере")
    public void loginPage() {
        loginHeader.shouldHave(Condition.text("Вход"));
    }

    @Step("Логин по кнопке")
    public void login(ProfileForm profile) {
        fillLogin(profile.getEmail());
        fillPassword(profile.getPassword());
        loginButton.click();
    }

    @Step("Ввод логина")
    public void fillLogin(String name) {
        emailInput.setValue(name);
    }

    @Step("Ввод пароля")
    public void fillPassword(String password) {
        passwordInput.setValue(password);
    }

    @Step("Проверка видимости авторизации")
    public void checkAuthorised() {
        loginButton.shouldBe(Condition.visible);
    }
}
