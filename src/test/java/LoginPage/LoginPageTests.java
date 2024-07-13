package LoginPage;
import static org.junit.jupiter.api.Assertions.*;

import Pages.LoginPage;
import Utils.UseCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginPageTests extends UseCase {
    private static LoginPage loginPage;

    @BeforeAll
    public static void classSetup() {
        loginPage = new LoginPage();
    }

    @BeforeEach
    public void beforeTest() {
        loginPage.navigateToLoginPage();
    }


    @Test
    public void loginLoadTest(){
        Boolean loginLogo = loginPage.isLoginLogoExists();
        assertTrue(loginLogo);
    }

    @Test
    public void signinButtonTest() throws InterruptedException {
        loginPage.signinClick();
        Thread.sleep(2000); // В тесте ввели задержку, чтобы увидеть ошибку
    }

    @Test
    public void incorrectEmailTest(){
        loginPage.incorrectEmail();
    }

    @Test
    public void unregisteredAccount() throws InterruptedException {
        loginPage.unregisteredEmailInfo();
        loginPage.unregisteredPasswordInfo();

        loginPage.signinClick();
        Thread.sleep(10000);

        loginPage.incorrectError();
        //Тест не проходит из-за капчи и требует в попап меню ввести код из почты

    }




}