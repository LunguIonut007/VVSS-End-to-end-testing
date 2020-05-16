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
@UseTestDataFrom("src/test/resources/ValidLoginTestData.csv")
public class LogoutTest {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps user;

    public String email;
    public String password;


    @Issue("Logout - success")
    @Test
    public void testLogout() throws InterruptedException {
        user.openPage();
        user.login(email, password);
        Thread.sleep(1000);
        user.logout();
        Thread.sleep(1000);
        // check that no redirect occurred
        assertEquals(webdriver.getCurrentUrl(), "https://qlearn.lunguionut.tech/login");
    }
}
