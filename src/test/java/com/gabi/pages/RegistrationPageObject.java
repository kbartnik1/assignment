package com.gabi.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

@DefaultUrl("google.com")
public class RegistrationPageObject extends PageObject {

    @FindBy(xpath = "//asd")
    WebElementFacade webElementFacade;

    @Step("kek")
    public void openAnotherPagePage() {

        getDriver().get("http://google.com");
        open();
//        open("google", withParameters());
//        this.open();
    }
}
