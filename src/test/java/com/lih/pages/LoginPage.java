package com.lih.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://qlearn.lunguionut.tech/login")
public class LoginPage extends PageObject {
    @FindBy(name = "email")
    public WebElementFacade emailInput;

    @FindBy(name = "password")
    public WebElementFacade passwordInput;

    @FindBy(className = "btn-login")
    public WebElementFacade loginButton;

    public void enterCredentials(String email, String password) {
        emailInput.type(email);
        passwordInput.type(password);
    }

    public void login() {
        loginButton.click();
    }
}
