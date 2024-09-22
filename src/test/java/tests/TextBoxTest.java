package tests;

import org.junit.jupiter.api.Test;
import pages.DemoqaFormPage;
import pages.TextBoxPage;

public class TextBoxTest extends TestBase {

    private final TextBoxPage textBoxPage = new TextBoxPage();

    String fullName = "Daria Sarycheva",
            userEmail = "daria@test.com",
            currentAddress = "World",
            permanentAddress = "Moscow";

    @Test

    void textBoxTest() {
        textBoxPage.openPage()
                .setFullName(fullName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit();

        textBoxPage.checkResult("Name:", fullName)
                .checkResult("Email:", userEmail)
                .checkResult("Current Address :", currentAddress)
                .checkResult("Permananet Address :", permanentAddress);

    }
}
