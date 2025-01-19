package com.example.LcwProject.test;

import org.junit.jupiter.api.Test;
import pages.HomePage;

public class LcwTest extends BaseTest {
    HomePage homePage = new HomePage(driver);

    @Test
    public void testLogin() throws InterruptedException {
        homePage.goToLoginPage()
                .fillEmailTextArea()
                .clickContinueButton()
                .fillPasswordTextArea()
                .clickLoginButton();
    }

}
