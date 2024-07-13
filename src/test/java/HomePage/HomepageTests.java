package HomePage;

import static org.junit.jupiter.api.Assertions.*;

import Pages.HomePage;
import Utils.UseCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomepageTests extends UseCase {
    private static HomePage homePage;

    @BeforeAll
    public static void classSetup() {
        homePage = new HomePage();
    }

    @BeforeEach
    public void beforeTest() {
        homePage.navigateMainPage();
    }

    @Test
    public void homePageLoadTest(){
        Boolean logoSuccess = homePage.isLogoExists();
        assertTrue(logoSuccess);
    }

    @Test
    public void loginButton(){
        Boolean loginButtonExists = homePage.isLogInExists();
        assertTrue(loginButtonExists);
    }

    @Test
    public void loginButtonClick(){
        homePage.logInButtonClick();
    }

    @Test
    public void dropDownMenuTest() throws InterruptedException {
        homePage.booksDropMenu();
        Thread.sleep(2000);
        homePage.englishBook();
    }


}

