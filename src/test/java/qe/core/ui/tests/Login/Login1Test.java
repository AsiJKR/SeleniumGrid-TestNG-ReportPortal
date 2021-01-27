package qe.core.ui.tests.Login;

import org.testng.annotations.Test;
import qe.core.ui.common.TestBase;
import qe.core.ui.functions.HomeFunctions;
import qe.core.ui.functions.NavigationBarFunctions;

public class Login1Test extends TestBase {

    @Test
    public void testLoginUser() {
        HomeFunctions.navigateTo("");
        HomeFunctions.clickOnNavigationPane();
        NavigationBarFunctions.clickSignIn();
    }
}

