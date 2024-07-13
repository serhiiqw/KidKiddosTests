package CartPage;

import Pages.CartPage;
import Utils.UseCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartPageTests extends UseCase{
    private static CartPage cartPage;

    @BeforeAll
    public static void classSetup() {
        cartPage = new CartPage();
    }

    @BeforeEach
    public void beforeTest() {
        cartPage.navigateToCartPage();
    }

    @Test
    public void loadCartPage(){
        cartPage.isCartPageBannerExists();

    }

}
