package com.gabi.steps;

import com.gabi.pages.RegistrationPageObject;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class RegistrationSteps {

    @Steps
    private RegistrationPageObject registrationPageObject;

    @Given("^User entered application URL$")
    public void userEnteredApplicationURL() {
        registrationPageObject.openAnotherPagePage();
    }

    @And("^He selected his current insurer as Progressive$")
    public void heSelectedHisCurrentInsurerAsProgressive() {
    }

    @And("^He \"read\" Terms of Service and Privacy Policy$")
    public void heTermsOfServiceAndPrivacyPolicy() {
    }

    @When("^He finishes inputting his personal information$")
    public void heFinishesInputtingHisPersonalInformation(DataTable dataTable) {
        List<Map<String, String>> dt = dataTable.asMaps(String.class, String.class);
    }

    @Then("^He is asked to provide verification code$")
    public void heIsAskedToProvideVerificationCode() {

    }

    @And("^He selected that he does not have current auto insurance policy$")
    public void heSelectedThatHeDoesNotHaveCurrentAutoInsurancePolicy() {
    }

    @When("^He inputs his Name and Last Name with spaces$")
    public void heInputsHisNameAndLastNameWithSpaces(DataTable dataTable) {
        List<Map<String, String>> dt = dataTable.asMaps(String.class, String.class);
    }

    @Then("^His Name should not contain any spaces, but his last name should remain the same$")
    public void hisNameShouldNotContainAnySpacesButHisLastNameShouldRemainTheSame() {

    }

    @And("^He inputted Prog in the Insurer field and then he selected Progressive item$")
    public void heInputtedProgInTheInsurerFieldAndThenHeSelectedProgressiveItem() {

    }

    @And("^He inputted his Name, Last Name and Birthday$")
    public void heInputtedHisNameLastNameAndBirthday(DataTable dataTable) {
        List<Map<String, String>> dt = dataTable.asMaps(String.class, String.class);
    }

    @When("^He inputs Drive Thru in the Address field$")
    public void heInputsDriveThruInTheAddressField() {

    }

    @Then("^He selects Drive-thru, Madison, WI 53718 item$")
    public void heSelectsDriveThruMadisonWIItem() {
    }
}
