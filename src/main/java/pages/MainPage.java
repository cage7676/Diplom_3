package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    public static final String URL = "http://stellarburgers.nomoreparties.site/";

    @FindBy (how = How.CSS, using = ".AppHeader_header__logo__2D0X2 ~ .AppHeader_header__link__3D_hX ")
    protected SelenideElement linkToLoginPageFromHeader;

    @FindBy(how = How.CSS,using = ".BurgerConstructor_basket__totalContainer__2Z-ho ~ button")
    protected SelenideElement linkToLoginPageButton;

    @FindBy(how = How.CSS,using = ".AppHeader_header__logo__2D0X2 ~ a")
    protected SelenideElement linkToProfilePage;

    @FindBy (how = How.CSS,using = ".BurgerConstructor_basket__totalContainer__2Z-ho ~ button")
    protected SelenideElement createOrderButton;

    @FindBy (how = How.CSS,using = ".BurgerIngredients_ingredients__1N8v2 h1")
    protected SelenideElement constructorLabel;

    @FindBy(how = How.CSS,using = ".BurgerIngredients_ingredients__1N8v2 .tab_tab__1SPyG:nth-child(1n)")
    protected SelenideElement bunsTab;

    @FindBy(how = How.CSS,using = ".BurgerIngredients_ingredients__menuContainer__Xu3Mo  > .text:nth-child(1)")
    protected SelenideElement bunsTitle;

    @FindBy(how = How.CSS,using = ".BurgerIngredients_ingredients__1N8v2 .tab_tab__1SPyG:nth-child(2n)")
    protected SelenideElement saucesTab;

    @FindBy(how = How.CSS,using = ".BurgerIngredients_ingredients__menuContainer__Xu3Mo  > .text:nth-child(3)")
    protected SelenideElement saucesTitle;

    @FindBy(how = How.CSS,using = ".BurgerIngredients_ingredients__1N8v2 .tab_tab__1SPyG:nth-child(3n)")
    protected SelenideElement fillingsTab;

    @FindBy(how = How.CSS,using = ".BurgerIngredients_ingredients__menuContainer__Xu3Mo  > .text:nth-child(5)")
    protected SelenideElement fillingsTitle;
}
