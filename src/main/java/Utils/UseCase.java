package Utils;
import Pages.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

public class UseCase {
//private мы можем использовать только в этом классе, а protected можем в классе и в пакете
    private static WebDriver webDriver;
    private static BasePage page;

    @BeforeAll
    //Этот класс будет связан со всеми тестам, не с BasePage(как можно понять в видео).
    //С BasePage его связывает только создание webDriver на строчке 24, так как мы вызовем Хром драйвер в BasePage и основную функцию из BasePage вернем суюда
    //чтоб не создавать wait = new WebDriverWait(webDriver, Duration.ofSeconds(5)) каждый раз
    public static void setupMain() {
        page = new BasePage(); //Каждый раз тест будем идти сюда и создавать страницу
        webDriver = SharedDriver.getWebdriver(SharedDriver.Browser.CHROME); //И создавать новый браузер
        page.setWebDriver(webDriver);//И ждать 5 сек
    }
    //Следующее действие в BasePage создать методы общие, которые будут базой для проверок


    @AfterAll
    public static void tearDownMain(){
        SharedDriver.closeWebDriver();
        webDriver = null;
    }
}
