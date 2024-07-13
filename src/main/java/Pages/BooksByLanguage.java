package Pages;

import Consts.Consts;
import org.openqa.selenium.WebElement;

public class BooksByLanguage extends BasePage {
    //Находим xpath banner
    private static final String ENGLISH_BANNER = "//*[@class='section-header text-center']";
    //Находим xpath книги, котору мы выбрали для тестов страницы книги
    private static final String AMANDAS_DREAM_BOOK = "//*[@src='//kidkiddos.com/cdn/shop/products/childrens-motivational-bedtime-story-Amandas-Dream-cover_530x@2x.jpg?v=1625981696']";
    // Находим xpath для меню Quantity
    private static final String QUANTITY_INPUT = "//input[@id='Quantity']";
    // Находим xpath для button ADD TO CART
    private static final String ADD_TO_CART = "//button[@name='add']";
    // Банер на странице Cart
    private static final String CART_BUTTON = "//a[@class='btn btn--small btn--secondary cart__remove']";
    // Строка количества на странице Cart
    private static final String QUANTITY_CART_PAGE = "//input[@class='cart__qty-input']";
    // Кнопка Update
    private static final String UPDATE_BUTTON = "//input[@class='btn btn--secondary cart__update cart__update--large small--hide']";



    public void navigateToEngBooksPage(){
        webDriver.get(Consts.ENGLISH_BOOKS_PAGE);
    }

    public boolean isLoginLogoExists(){
        return elementExists(ENGLISH_BANNER);

    }

    public boolean isBookExists(){
        return elementExists("//*[@href='/collections/english-only/products/amandas-dream-childrens-picture-book-english-only']");
    }
    // Книга для тестов смены формата книги и добавления в корзину
    public void chooseBook(){
        findElementByXpath("//*[@href='/collections/english-only/products/amandas-dream-childrens-picture-book-english-only']").click();
    }

    public void printedFormatMenu(){
        clickByXpath("//*[@id='SingleOptionSelector-0']");
    }

    public void hardcoverFormat(){
        clickByXpath("//*[@id='SingleOptionSelector-0']//following-sibling::*[@value='Hardcover']");
    }

    //Чтоб ввести количество книг сначала найдем xpath меню Quantity
    public void quantityMenu(){
        findElementByXpath("//*[@class='product-form__item product-form__item--quantity']").click();
    }

    //Внести количество книг для покупки
    public void addQuantity() throws InterruptedException {
        Thread.sleep(1000);
        WebElement quantityElement =findElementByXpath(QUANTITY_INPUT);
        quantityElement.clear();
        quantityElement.sendKeys("5");
    }

    //Нажимаем на кнопку ADD TO CART
    public void addCartButton(){
        findElementByXpath(ADD_TO_CART).click();
    }

    //Проверяем, что страница Cart открылась
    public void isCartButtonExists(){
        elementExists(CART_BUTTON);
    }

    ////Чтоб ввести количество книг сначала найдем xpath меню Quantity
    public void quantityCartPage(){
        findElementByXpath(QUANTITY_CART_PAGE).click();
    }

    //Обновляем количество книг (было 5, обновляем на 6)
    public void changeQuantity(){
        WebElement quantityElement = findElementByXpath(QUANTITY_CART_PAGE);
        quantityElement.clear();
        quantityElement.sendKeys("6");
    }

    //Проверяем, что кнопка update на странице cart существует
    public boolean isUpdateButtonExists(){
       return elementExists(UPDATE_BUTTON);

    }

    //Нажимаем на кнопку update на странице cart
    public void updateButton(){
        findElementByXpath(UPDATE_BUTTON).click();
    }

    public boolean finalPrice(){
        double pricePerBook = 36.99;
        double previousPrice = pricePerBook*5;

        WebElement updatedPrice = findElementByXpath("//span[contains(@class, 'currency-converter-amount')]");
        String finalUpdatedPrice = updatedPrice.getText().replace("CAD", "").replace(",", "").trim();

        double actualTotalPrice;
        try {
            actualTotalPrice = Double.parseDouble(finalUpdatedPrice);
        } catch (NumberFormatException e) {
            // Если текст не может быть преобразован в число, возвращаем false
            e.printStackTrace();
            return false;
        }
        return actualTotalPrice != previousPrice;
    }


    }

