import io.qameta.allure.junit4.DisplayName;
import main.Base;
import main.pom.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LoginTest extends Base {

    MainPage mainPage = new MainPage(getDriver());
    RegistrationPage registrationPage = new RegistrationPage(getDriver());
    RecoveryPasswordPage recoveryPasswordPage = new RecoveryPasswordPage(getDriver());

    @Before
    public void openPage() {
        openUrl();
    }

    @Test
    @DisplayName("Чек успешного входа через кнопку войти в аккаунт на главной странице")
    public void loginOnMainPage() {
        mainPage.clickEnterButton();
        login();
        assertEquals("Оформить заказ", mainPage.buttonCreateOrderText());
    }

    @Test
    @DisplayName("Чек успешного входа через кнопку личный кабинет")
    public void loginOnClickPersonalAccount() {
        mainPage.clickPersonalAccount();
        login();
        assertEquals("Оформить заказ", mainPage.buttonCreateOrderText());
    }

    @Test
    @DisplayName("Чек успешного входа через кнопку войти в форме регистрации")
    public void loginOnRegistrationForm() {
        clickPersonalAccount();
        startRegistration();
        mainPage.clickEnterOnRegistrationForm();
        login();
        assertEquals("Оформить заказ", mainPage.buttonCreateOrderText());
    }

    @Test
    @DisplayName("Чек успешного входа через кнопку войти в форме восстановления пароля")
    public void loginOnRefreshPasswordForm() {
        clickPersonalAccount();
        registrationPage.clickRecoveryPassword();
        recoveryPasswordPage.clickEnterButton();
        login();
        assertEquals("Оформить заказ", mainPage.buttonCreateOrderText());
    }

    @After
    public void quitDriver() {
        baseAfter(getDriver());
    }
}
