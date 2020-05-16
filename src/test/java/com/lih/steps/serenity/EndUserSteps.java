package com.lih.steps.serenity;

import com.lih.pages.AnnouncementPage;
import com.lih.pages.HomePage;
import com.lih.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;


public class EndUserSteps {
    public LoginPage loginPage;
    public HomePage homePage;
    public AnnouncementPage announcementPage;
    @Step
    public void openPage() {
        loginPage.open();
    }

    @Step
    public void logout() {
        homePage.logout();
    }

    @Step
    public void login(String email, String password) {
        loginPage.enterCredentials(email, password);
        loginPage.login();
    }

    @Step
    public void goToAnnouncements(WebDriver webDriver) {
        homePage.goToAnnouncements(webDriver);
    }

    @Step
    public void createAnnouncement(String title,String description){
        announcementPage.createAnnouncement(title,description);
    }
}
