import io.qameta.allure.junit4.DisplayName;
import main.Base;
import main.pom.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonalAccountTest extends Base {
    MainPage mainPage = new MainPage(getDriver());
    LoginPage loginPage = new LoginPage(getDriver());
    PersonalAccountPage personalAccountPage = new PersonalAccountPage(getDriver());

    @Before
    public void openPage() {
        openUrl();
        clickEnterOnMainPage();
        login();
    }

    @Test
    @DisplayName("Чек перехода в личный кабинет")
    public void clickOnPersonalAccount() {
        clickPersonalAccount();
        assertEquals("Выход", personalAccountPage.logoutButtonText());
    }

    @Test
    @DisplayName("Чек нажатия на логотип из личного кабинета")
    public void clickOnLogo() {
        clickPersonalAccount();
        personalAccountPage.clickLogo();
        assertEquals("Соберите бургер", mainPage.textOfChooseBurger());
    }

    @Test
    @DisplayName("Чек перехода в конструктор из личного кабинета")
    public void clickOnConstructorButton() {
        clickPersonalAccount();
        personalAccountPage.clickConstructorButton();
        assertEquals("Соберите бургер", mainPage.textOfChooseBurger());
    }

    @Test
    @DisplayName("Чек выхода из аккаунта")
    public void successfullyLogout() {
        clickPersonalAccount();
        personalAccountPage.clickLogoutButton();
        assertEquals("Войти", loginPage.buttonEnterText());
    }

    @After
    public void quitDriver() {
        baseAfter(getDriver());
    }
}
