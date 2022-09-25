package services;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.MainPage;

import static com.codeborne.selenide.Condition.visible;

public class Main extends MainPage {

    @Step("Нажать на кнопку логина в хидере")
    public void  goToLoginPageUsingButtonFromHeader(){
        linkToLoginPageFromHeader.click();
    }

    @Step("Нажать на центральную кнопку логина")
    public void  goToLoginPageUsingCentralButton(){
        linkToLoginPageButton.click();
    }

    @Step("Перейти на страницу профиля")
    public void  goToProfilePage(){
        linkToProfilePage.click();
    }

    @Step("Авторизация")
    public void checkUserAuthorised(){
        createOrderButton.shouldHave(Condition.text("Оформить заказ"));
    }

    @Step("Нажать на раздел Булки")
    public void goToBunsClick(){
        bunsTab.click();
    }

    @Step("Проверка видимости раздела Булки")
    public void checkBunsClickOpen(){
        bunsTitle.shouldBe(visible);
    }

    @Step("Нажать на раздел Соусы")
    public void goToSaucesClick(){
        saucesTab.click();
    }

    @Step("Проверка видимости раздела Соусы")
    public void checkSaucesClickOpen(){
        saucesTitle.shouldBe(visible);
    }

    @Step("Нажать на раздел Начинки")
    public void goToFillingsClick(){
        fillingsTab.click();
    }

    @Step("Проверка видимости раздела Начинки")
    public void checkFillingsClickOpen(){
        fillingsTitle.shouldBe(visible);
    }

    @Step("Проверка видимости блока Конструктор")
    public void checkConstructorBlock(){
        constructorLabel.shouldBe(visible);
    }

}
