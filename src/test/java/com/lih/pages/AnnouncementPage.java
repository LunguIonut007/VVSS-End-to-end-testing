package com.lih.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("https://qlearn.lunguionut.tech/teacher/announcement/create")
public class AnnouncementPage extends PageObject {

    @FindBy(className ="btn-primary" )
    public WebElementFacade createButton;

    @FindBy(name = "title")
    public WebElementFacade titleInput;

    @FindBy(id = "description")
    public WebElementFacade descriptionInput;

    public void createAnnouncement(String title,String description){
        createButton.click();

        titleInput.type(title);
        descriptionInput.type(description);

        createButton.click();


    }
}
