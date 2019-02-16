package com.gabi.cukes;

import com.gabi.pages.DefaultPage;
import com.gabi.steps.RegistrationSteps;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

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
        registrationSteps.heSelectedThatHeHasNoInsurance();
    }

    @When("^He inputs his Name and Last Name with spaces$")
    public void heInputsHisNameAndLastNameWithSpaces(DataTable dataTable) {
        registrationSteps.heInputsHisNameAndLastNameWithSpaces(dataTable);
    }

    @Then("^His Name should not contain any spaces, but his last name should remain the same$")
    public void hisNameShouldNotContainAnySpacesButHisLastNameShouldRemainTheSame() {
        registrationSteps.heVerifiedHisNameAndLastName();
    }

    @When("^He finishes inputting his personal information without name and last name$")
    public void heFinishesInputtingHisPersonalInformationWithoutNameAndLastName(DataTable dataTable) {
        registrationSteps.heInputtedRestOfTheDataWithoutNameAndLastName(dataTable);
    }
}
