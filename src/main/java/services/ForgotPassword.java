package services;

import io.qameta.allure.Step;
import pages.ForgotPasswordPage;

public class ForgotPassword extends ForgotPasswordPage {

    @Step("Перейти на страницу входа со страницы «Забыли пароль»")
    public void goLoginPageFromForgotPasswordPage() {
        linkToLoginPage.click();
    }
}
