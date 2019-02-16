package com.gabi.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RegistrationPageObject extends PageObject {

    private static final Logger LOG = LoggerFactory.getLogger(RegistrationPageObject.class);

    @FindBy(xpath = "//form//button//img[contains(@src,'shield_blue')]/parent::button")
    private WebElementFacade insurerDropdownButton;

    @FindBy(xpath = "//input[@placeholder='Search for your insurer']")
    private WebElementFacade insurerInputField;

    @FindBy(xpath = "//button[@type='submit' and @data-title='Next Step' and not(contains(@class,'disabled'))]")
    private WebElementFacade nextStepButton;

    @FindBy(xpath = "//button[@type='submit' and @data-title='I Don’t Have Insurance']")
    private WebElementFacade noInsuranceButton;

    @FindBy(xpath = "//input[@name='first_name']")
    private WebElementFacade firstNameInputField;

    @FindBy(xpath = "//input[@name='last_name']")
    private WebElementFacade lastNameInputField;

    @FindBy(xpath = "//button[text()='Terms Of Service']")
    private WebElementFacade termsOfServiceButton;

    @FindBy(xpath = "//button[text()='Privacy Policy']")
    private WebElementFacade privacyPolicyButton;

    @FindBy(xpath = "//form/div[contains(@class,'modalVisible')]/div[1]")
    private WebElementFacade visibleRegulationWindow;

    @FindBy(xpath = "//form//div[contains(@class,'Visible')]/button[contains(@class,'closeButton')]")
    private WebElementFacade closeButton;

    @FindBy(xpath = "//input[@name='month']")
    private WebElementFacade monthInput;

    @FindBy(xpath = "//input[@name='day']")
    private WebElementFacade dayInput;

    @FindBy(xpath = "//input[@name='year']")
    private WebElementFacade yearInput;

    @FindBy(xpath = "//input[@name='address-placeholder']")
    private WebElementFacade addressInput;

    @FindBy(xpath = "//input[@name='address2']")
    private WebElementFacade apartmentNumber;

    @FindBy(xpath = "//input[@name='email']")
    private WebElementFacade emailInput;

    @FindBy(xpath = "//input[@name='phone_number']")
    private WebElementFacade phoneInput;

    @FindBy(xpath = "//button[text()='NOPE']")
    private WebElementFacade nopeButton;

    @FindBy(xpath = "//div[contains(text(),'Have you created an account with Gabi.com before?')]")
    private WebElementFacade accountMightAlreadyExist;

    @FindBy(xpath = "//div[contains(text(),'enter the code we sent you')]")
    private WebElementFacade lastStepBanner;

    private WebElementFacade insurerSelector(String text) {
        return $("//div[contains(@class,'signupWrapper')]/div[contains(@class,'custom-scrollbar')]/button[contains(.,'" + text + "')]");
    }

    private WebElementFacade addressMatch(String partInputted, String retrievedFromGoogle) {
        return $("//div[contains(@class,'pac-container')]/div[contains(.,'" + partInputted + "') and contains(.,'" + retrievedFromGoogle + "')]");
    }

    @Step
    public void heOpenedAvailableMenu() {
        insurerDropdownButton.waitUntilPresent().click();
    }

    @Step
    public void heSelectedCurrentInsurerCompany(String company) {
        insurerSelector(company).waitUntilVisible().click();
    }

    public void heClickedOnNextStepButton() {
        nextStepButton.waitUntilClickable().click();
    }

    @Step
    public void heReadTermsOfService() {
        termsOfServiceButton.waitUntilPresent().click(); //bug
        termsOfServiceButton.waitUntilPresent().click();
        scrollRegulationWithJS();
        closeButton.click();
    }

    @Step
    public void heReadPrivacyPolicies() {
        privacyPolicyButton.waitUntilPresent().click();
        scrollRegulationWithJS();
        closeButton.click();
    }

    @Step
    public void heInputsHisNameAndLastName(String name, String last_name) {
        firstNameInputField.sendKeys(name);
        lastNameInputField.sendKeys(last_name);
        nextStepButton.click();
    }

    @Step
    public void heInputsHisBirthdate(String birthday) {
        String[] splittedBDay = birthday.split("\\.");
        monthInput.sendKeys(splittedBDay[0]);
        dayInput.sendKeys(splittedBDay[1]);
        yearInput.sendKeys(splittedBDay[2]);
        nextStepButton.click();
    }

    @Step
    public void heInputsHisAddressAndApartmentNumber(String home_address, String apartment_number) {
        addressInput.sendKeys(home_address);
        addressMatch("", "").waitUntilPresent();
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
        apartmentNumber.sendKeys(apartment_number);
        nextStepButton.click();
    }

    @Step
    public void heInputsHisMailAddress(String email_address) {
        emailInput.sendKeys(email_address);
        nextStepButton.click();
    }

    @Step
    public void heInputsHisPhoneNumber(String phone_number) {
        phoneInput.sendKeys(phone_number);
        nextStepButton.click();
    }

    public void checkIfAccountAlreadyExist() {
        if (accountMightAlreadyExist.isPresent())
            nopeButton.waitUntilPresent().click();
    }

    public void assertThatHesOnLastStep() {
        assertThat(lastStepBanner.isPresent()).isTrue();
    }


    //TODO: move it to utils at some point
    private void scrollRegulationWithJS() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            Long objectsScrollingHeight = (Long) js.executeScript("return arguments[0].scrollHeight;", visibleRegulationWindow);
            for (int i = 0; i < 10; i++) {
                js.executeScript("arguments[0].scrollBy(0," + objectsScrollingHeight / 10 + ")", visibleRegulationWindow);
                Thread.sleep(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
