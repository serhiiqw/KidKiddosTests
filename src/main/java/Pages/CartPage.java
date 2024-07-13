package Pages;
import Consts.Consts;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

    // Банер на странице Cart
    private static final String CART_BANNER = "//*[text()='Your cart']";
    // Строка количества на странице Cart
    private static final String QUANTITY_CART_PAGE = "//*[text()='Your cart']";

    public void navigateToCartPage(){
        webDriver.get(Consts.CART_PAGE);
    }

    public boolean isCartPageBannerExists(){
        Boolean cartBanner = elementExists(CART_BANNER);
        return cartBanner;
    }



}
