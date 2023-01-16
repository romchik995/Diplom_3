import io.qameta.allure.junit4.DisplayName;
import main.Base;
import main.pom.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RegistrationTest extends Base {
    RegistrationPage registrationPage = new RegistrationPage(getDriver());
    LoginPage loginPage = new LoginPage(getDriver());

    @Before
    public void start() {
        openUrl();
        clickPersonalAccount();
        startRegistration();
    }

    @Test
    @DisplayName("Чек успешной регистрации")
    public void successfullRegistration() {
        registrationPage.registrationInputFieldsAndClickButton(getUserName(), getEmail(), getPassword());
        assertEquals("Войти", loginPage.buttonEnterText());
    }

    @Test
    @DisplayName("Чек регистрации с невалидным паролем")
    public void registrationWithInvalidPassword() throws Exception {
        try {
            registrationPage.registrationInputFieldsAndClickButton(getUserName(), getEmail(), getInvalidPassword());
            assertEquals("Войти", loginPage.buttonEnterText());
        } catch (Exception exception) {
        }
        assertEquals("Некорректный пароль", loginPage.textUncorrectPassword());
    }

    @After
    public void quitDriver() {
        baseAfter(getDriver());
    }
}
