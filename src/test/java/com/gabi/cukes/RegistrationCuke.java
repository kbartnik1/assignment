package com.gabi.cukes;

import com.gabi.pages.DefaultPage;
import com.gabi.steps.RegistrationSteps;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class RegistrationCuke {

    @Steps
    private RegistrationSteps registrationSteps;
    private DefaultPage defaultPage;

    @Given("^User entered application URL$")
    public void userEnteredApplicationURL() {
        defaultPage.openPageBasedOnProperties();
    }

    @And("^He selected his current insurer as (.*)$")
    public void heSelectedHisCurrentInsurerAsProgressive(String company) {
        registrationSteps.selectInsurerFromTheList(company);
    }

    @And("^He \"read\" Terms of Service and Privacy Policy$")
    public void heTermsOfServiceAndPrivacyPolicy() {
        registrationSteps.heReadTermsOfServiceAndPrivacyPolicies();
    }

    @When("^He finishes inputting his personal information$")
    public void heFinishesInputtingHisPersonalInformation(DataTable dataTable) {
        registrationSteps.heStartsInputtingRestOfTheData(dataTable);
    }

    @Then("^He is asked to provide verification code$")
    public void heIsAskedToProvideVerificationCode() {
        registrationSteps.heVerifiesThatGabiShouldSendTheCode();
    }

    @And("^He selected that he does not have current auto insurance policy$")
    public void heSelectedThatHeDoesNotHaveCurrentAutoInsurancePolicy() {
    }

    @When("^He inputs his Name and Last Name with spaces$")
    public void heInputsHisNameAndLastNameWithSpaces(DataTable dataTable) {
        Map<String, String> dt = dataTable.asMap(String.class, String.class);
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
