package services;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.ProfilePage;

public class Profile extends ProfilePage {

    @Step("Клик по кнопке Выход")
    public void logout() {
        signOutButton.click();
    }

    @Step("Проверка видимости кнопки выхода")
    public void checkProfilePage() {
        signOutButton.shouldHave(Condition.text("Выход"));
    }

    @Step("Переход на страницу конструктора по логотипу")
    public void goToLogoBuilderPage() {
        logoButton.click();
    }

}
