package qe.core.ui.functions;

import qe.core.ui.pages.NavigationBarPage;

public class NavigationBarFunctions {

    static NavigationBarPage navigationBarPage = new NavigationBarPage();

    private NavigationBarFunctions() {
    }

    public static void clickSignIn() {
        navigationBarPage.clickSignIn();
    }
}
