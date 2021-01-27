package qe.core.ui.tests.Login;

import org.testng.annotations.Test;
import qe.core.ui.common.TestBase;
import qe.core.ui.functions.HomeFunctions;

public class Login2Test extends TestBase {

    @Test
    public void testWhyUser() {
        HomeFunctions.navigateTo("'");
        HomeFunctions.clickOnNavigationPane();
    }
}
