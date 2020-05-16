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
public class AnnouncementTest {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps user;

    public String email;
    public String password;

    @Issue("Announcement #1 - navigate")
    @Test
    public void testReadAnnouncements() throws InterruptedException {
        user.openPage();
        user.login(email, password);
        Thread.sleep(1000);
        user.goToAnnouncements(webdriver);
        assertEquals(webdriver.getCurrentUrl(), "https://qlearn.lunguionut.tech/teacher/announcement");
    }

    @Issue("Announcement #2 - create")
    @Test
    public void testCreateAnnouncement() throws InterruptedException {
        user.openPage();
        user.login(email, password);
        Thread.sleep(1000);
        user.goToAnnouncements(webdriver);
        assertEquals("is over", "is not");
    }

    @Issue("Announcement #3 - delete")
    @Test
    public void testDeleteAnnouncement() throws InterruptedException {
        user.openPage();
        user.login(email, password);
        Thread.sleep(1000);
        user.goToAnnouncements(webdriver);
        assertEquals("is over", "is not");

    }
}
