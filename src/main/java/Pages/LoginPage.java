package Pages;

import Consts.Consts;

public class LoginPage extends BasePage {
    //Находим xpath лого на страницу Login чтобы в дальнейшем проверить существует ли он и убедиться, что мы зашли на страницу
    private static final String LOGIN_PAGE = "//h1[@class='text-center']";
    //Находим xpath LOGIN_BUTTON
    private static final String LOGIN_BUTTON = "//*[@class='icon icon-login']";
    //Находим xpath строки почты на странице Login
    private static final String EMAIL_LINE = "//*[@type='email']";
    //Находим xpath строки пароля на странице Login
    private static final String PASSWORD_LINE = "//*[@type='password']";
    //Находим xpath кнопки SIGNIN для будущего теста нажатия и проверки ввода
    private static final String SIGNIN_BUTTON = "//*[@class='btn']";



    public void navigateToLoginPage(){
        webDriver.get(Consts.LOGIN_PAGE);
    }

    //Проверяем существует ли лого на странице, тем самым убеждаемся что мы перешли с главной на страницу авторизации
    public boolean isLoginLogoExists(){
        Boolean loginLogo = elementExists(LOGIN_PAGE);
        return loginLogo;
    }

    //Проверяем существует ли строка почты на странице
    public boolean isemailLineExists(){
        Boolean lineEmail = elementExists(EMAIL_LINE);
        return lineEmail;
    }

    ////Проверяем существует ли строка пароля на странице
    public boolean isPasswordLineExists(){
        Boolean linePassword = elementExists(PASSWORD_LINE);
        return linePassword;
    }

    //Функция для нажатия на кнопку входа, функция взята из BasePage
    public void signinClick(){
        clickByXpath(SIGNIN_BUTTON);
        elementExists("//*[contains(text(), 'Incorrect email or password')]");
    }

    public void incorrectEmail(){
        sendTextToElement("//*[@id='CustomerEmail']", "email#email.gmail.com");
        clickByXpath(SIGNIN_BUTTON);
        elementExists("//*[contains(text(), 'Please include @')]");
    }

    //Не использовал так как не позволила страница увидеть ошибку(выводила капчу и возвращала на обновленную страницу)
    public void incorrectPassword(){
        sendTextToElement("//*[@id='CustomerPassword']", "");
    }

    //Функция для ввода не зарегистрированного логина
    public void unregisteredEmailInfo(){
        sendTextToElement(EMAIL_LINE, "email@gmail.com");
    }

    //Функция для ввода не зарегистрированного пароля
    public void unregisteredPasswordInfo(){
        sendTextToElement(PASSWORD_LINE, "1234567890@");
    }

    //Второй вариант при котором ловится ошибка
    public boolean incorrectError(){
        return elementExists("//*[contains(text(), 'Incorrect email or password.')]");
    }

}
