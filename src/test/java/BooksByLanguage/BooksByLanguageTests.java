package BooksByLanguage;

import Pages.BooksByLanguage;
import Utils.UseCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BooksByLanguageTests extends UseCase{
    private static BooksByLanguage booksByLanguage;

    @BeforeAll
    public static void classSetup() {
        booksByLanguage = new BooksByLanguage();
    }

    @BeforeEach
    public void beforeTest() {
        booksByLanguage.navigateToEngBooksPage();
    }

    @Test
    public void loadBooksPage(){
        booksByLanguage.navigateToEngBooksPage();
    }

    @Test
    public void booksBannerExistsTest(){
        booksByLanguage.isLoginLogoExists();
    }

    @Test
    public void chosenBookExistsTest() throws InterruptedException {
        booksByLanguage.isBookExists();
        Thread.sleep(1000);
    }

    @Test
    public void chooseBookTest(){
        booksByLanguage.chooseBook();
    }

    @Test
    public void orderBookTest() throws InterruptedException {
        //Выбирай книгу
        booksByLanguage.chooseBook();
        //Выбираем формат
        booksByLanguage.printedFormatMenu();
        //Выбираем обложку
        booksByLanguage.hardcoverFormat();
        //Вводим нужное количество (5 книг)
        booksByLanguage.quantityMenu();
        Thread.sleep(1000);
        booksByLanguage.addQuantity();
        //Завершаем покупку книги, добавляя ее в корзину
        booksByLanguage.addCartButton();
        //Проверяем, что страница Cart открылась
        booksByLanguage.isCartButtonExists();
        Thread.sleep(1000);
        //Нажимаем на строку с количеством на странице Page
        booksByLanguage.quantityCartPage();
        Thread.sleep(1000);
        //Проверяем, что данные изменились на 6 книг
        booksByLanguage.changeQuantity();
        //Проверяем, что кнопка update на странице cart существует
        booksByLanguage.isUpdateButtonExists();
        //Нажимаем на кнопку update на странице cart
        booksByLanguage.updateButton();
        booksByLanguage.finalPrice();
    }





}
