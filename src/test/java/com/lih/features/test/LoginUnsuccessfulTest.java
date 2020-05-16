package com.lih.features.test;

import com.lih.steps.serenity.EndUserSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/InvalidLoginTestData.csv")
public class LoginUnsuccessfulTest {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps user;

    public String email;
    public String password;


    @Issue("Login#2 - invalid credentials")
    @Test
    public void testUnsuccessfulLogin() {
        user.openPage();
        user.login(email, password);

        //check that an error message is shown
        WebElement alert = webdriver.findElement(By.className("Toastify__toast--error"));
        assertTrue(alert.isDisplayed());

        // check that no redirect occurred
        assertEquals(webdriver.getCurrentUrl(), "https://qlearn.lunguionut.tech/login");
    }
}
