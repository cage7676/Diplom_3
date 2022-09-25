package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    public static final String URL = "http://stellarburgers.nomoreparties.site/login";

    @FindBy(how = How.CSS, using = "[name=\"name\"]")
    protected SelenideElement emailInput;

    @FindBy(how = How.CSS, using = ".Auth_fieldset__1QzWN  ~ .button_button__33qZ0 ")
    protected SelenideElement loginButton;

    @FindBy(how = How.CSS, using = ".Auth_login__3hAey > h2")
    protected SelenideElement loginHeader;

    @FindBy(how = How.CSS, using = "[name=\"Пароль\"]")
    protected SelenideElement passwordInput;

}
