import io.qameta.allure.junit4.DisplayName;
import main.Base;
import main.pom.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConstructorTest extends Base {
    MainPage mainPage = new MainPage(getDriver());

    @Before
    public void openPage() {
        openUrl();
    }

    @Test
    @DisplayName("Чек перехода на вкладку Бургеры")
    public void clickOnBread() {
        mainPage.clickSauceButton();
        mainPage.clickBreadButton();
        assertEquals("Краторная булка N-200i", mainPage.getTextCratorBread());
    }

    @Test
    @DisplayName("Чек перехода на вкладку Соусы")
    public void clickOnSauce() {
        mainPage.clickSauceButton();
        assertEquals("Соус традиционный галактический", mainPage.getTextGalaxySauce());
    }

    @Test
    @DisplayName("Чек перехода на вкладку Начинки")
    public void clickOnFiling() {
        mainPage.clickFilingsButton();
        assertEquals("Филе Люминесцентного тетраодонтимформа", mainPage.getTextLumenFiling());
    }

    @After
    public void quitDriver() {
        baseAfter(getDriver());
    }
}