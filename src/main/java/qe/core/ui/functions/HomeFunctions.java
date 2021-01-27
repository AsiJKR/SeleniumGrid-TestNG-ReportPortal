package qe.core.ui.functions;

import qe.core.ui.pages.HomePage;

public class HomeFunctions {

    private static HomePage homePage = new HomePage();

    private HomeFunctions() {
    }

    public static void navigateTo(String url){
        homePage.navigateTo(url);
    }

    public static void clickOnNavigationPane(){
        homePage.clickOnNavigationPane();
    }
}
