import Pages.ContactUs;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class ContactUsTests extends BaseWeb {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void AutomatingContactUsForm() throws IOException {
        homePage.skipOnboarding();
        homePage.openContactUs();
        ContactUs contactUs = homePage.clickOnContactInformation();
        contactUs.setName("Test");
        contactUs.setPhoneNumber("0500000000");
        contactUs.setSubject("TestSubject");
        contactUs.setEmail("test@mbrhe.ae");
        contactUs.selectFromDropDown("No", "csCalling");
        contactUs.selectFromDropDown("Housing Grant", "category");
        contactUs.selectFromDropDown("Suggestion", "Type");
        contactUs.setMessage("test test test");
        contactUs.submit();
        contactUs.takeScreenShotForForm();
        contactUs.takeScreenShotForRecaptchaError();
        boolean actualStatus = contactUs.ErrorMessageVerification();
        softAssert.assertTrue(actualStatus);
        String actualError = contactUs.getErrorMessage();
        softAssert.assertTrue(actualError.contains("Security Code is Required"), "incorrect message");
        softAssert.assertAll();

    }
}
