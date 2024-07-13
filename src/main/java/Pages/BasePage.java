package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected static WebDriver webDriver;
    protected static WebDriverWait wait;
//Эта функция связывает UseCase abd BasePage только созданием драйвера и ожиданием
    public void setWebDriver(WebDriver webDriver){
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    }

    //Первую функция я создал поиск по ByXpath, так как в дальнейшем проще работать с другими методами
    protected WebElement findElementByXpath(String xpath){ //Чтобы найти мы используем аргумент Xpath
        WebElement element; //Здесь мы не присваиваем, что может запутать, а просто создаем элемент, который нашли
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))); //Смотри в первую функцию и ждем пока загрузиться элемент
        element = webDriver.findElement(By.xpath(xpath)); //Присваиваем найденный элемент переменной
        return element; //Возвращаем его
    }

    protected void clickByXpath(String xpath){
        findElementByXpath(xpath).click();
    }

    protected void sendTextToElement(String xpath, String text){
        findElementByXpath(xpath).sendKeys(text);
    }

    protected boolean elementExists(String xpath){
        try{
            webDriver.findElement(By.xpath(xpath));
            return true;
        }
        catch (Exception err){
            return false;
        }
    }


}
