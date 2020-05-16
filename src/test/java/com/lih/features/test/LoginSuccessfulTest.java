package com.lih.features.test;

import com.lih.steps.serenity.EndUserSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/ValidLoginTestData.csv")
public class LoginSuccessfulTest {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps user;

    public String email;
    public String password;

    @Test
    @Issue("Login#1 - success")
    public void testSuccessfulLogin() throws InterruptedException {
        user.openPage();
        user.login(email, password);
        Thread.sleep(1000);
        assertEquals(webdriver.getCurrentUrl(), "https://qlearn.lunguionut.tech/teacher");
    }
}
