package com.lih.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://qlearn.lunguionut.tech/teacher")
public class HomePage extends PageObject {

    @FindBy(linkText = "Sign out")
    public WebElementFacade logoutButton;

    public void logout() {
        logoutButton.click();
    }

    public void goToAnnouncements(WebDriver driver) {
        List<WebElement> linkList=driver.findElements(By.className("nav-link"));
        for (WebElement webElement : linkList) {
            if (webElement.getText().contains("Announcements")) {
                webElement.click();
                break;
            }
        }
    }
}
