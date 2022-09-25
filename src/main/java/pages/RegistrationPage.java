package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    public static final String URL = "http://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH, using = "//form/fieldset[1]/div/div/input")
    protected SelenideElement nameInput;

    @FindBy(how = How.XPATH, using = "//form/fieldset[2]/div/div/input")
    protected SelenideElement emailInput;

    @FindBy(how = How.CSS, using = "input[name=\"Пароль\"]")
    protected SelenideElement passwordInput;

    @FindBy(how = How.CSS, using = ".Auth_form__3qKeq > button")
    protected SelenideElement registrationButton;

    @FindBy(how = How.CSS, using = ".input__error ")
    protected SelenideElement invalidPasswordText;

    @FindBy(how = How.CSS, using = ".Auth_form__3qKeq ~ div a")
    protected SelenideElement goToLoginPageButton;

}
