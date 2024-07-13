package Pages;

import Consts.Consts;

public class HomePage extends BasePage{
    private static final String LOGO_IMG = "//img[@itemprop='logo']";
    //Находим xpath login button
    private static final String LOGIN_BUTTON = "//*[@class='icon icon-login']";
    //Находим xpath попап меню
    private static final String DROP_DOWN_MENU = "//*[@aria-controls='SiteNavLabel-books-by-language']";
    //Находим xpath в попап меню книг на английском языке
    private static final String ENGLISH_ONLY = "(//*[@class='site-nav__link site-nav__child-link'])[12]";



//Эту функцию иы будем использовать в тесте, чтобы возвращаться на главную страницу
    public void navigateMainPage(){
        //webDriver мы берем из BasePage
        webDriver.get(Consts.MAIN_URL);
    }

    public boolean isLogoExists(){
        Boolean logo = elementExists(LOGO_IMG);
        return logo;
    }

    public boolean isLogInExists(){
        Boolean logInButton = elementExists(LOGIN_BUTTON);
        return logInButton;
    }

    public void logInButtonClick(){
        clickByXpath(LOGIN_BUTTON);
    }

    public void booksDropMenu(){
        clickByXpath(DROP_DOWN_MENU);
    }

    public void englishBook(){
        clickByXpath(ENGLISH_ONLY);
    }

}
