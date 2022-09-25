package services;

import io.qameta.allure.Step;
import model.ProfileForm;
import pages.RegistrationPage;

public class Registration extends RegistrationPage {

    @Step("Ввод имени")
    public void fillName(String name) {
        nameInput.setValue(name);
    }

    @Step("Ввод пароля")
    public void fillPassword(String password) {
        passwordInput.setValue(password);
    }

    @Step("Ввод электронной почты")
    public void fillEmail(String email) {
        emailInput.setValue(email);
    }

    @Step("Переход на страницу логина из регистрации")
    public void goToLoginPageFromRegistrationPage() {
        goToLoginPageButton.click();
    }

    @Step("Регистрация нового пользователя")
    public void registerNewUser(ProfileForm profile) {
        fillName(profile.getName());
        fillEmail(profile.getEmail());
        fillPassword(profile.getPassword());
        registrationButton.click();
    }

    @Step("Проверка уведомления о неверном пароле")
    public boolean checkInvalidPasswordTextDisplayed() {
        return invalidPasswordText.isDisplayed();
    }

}
