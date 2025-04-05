package projectHelper;

import org.testng.asserts.SoftAssert;

public class SoftAssertClass {

    private static final SoftAssert softAssert = new SoftAssert();

    public static SoftAssert getInstance() {
        return softAssert;
    }

    public static void assertAll() {
        softAssert.assertAll();
    }
}
