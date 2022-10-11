package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {

    public static final String URL = "http://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(how = How.CSS, using = "div > p > a")
    protected SelenideElement linkToLoginPage;

    @Step("Перейти на страницу входа со страницы «Забыли пароль»")
    public void goLoginPageFromForgotPasswordPage() {
        linkToLoginPage.click();
    }
}
