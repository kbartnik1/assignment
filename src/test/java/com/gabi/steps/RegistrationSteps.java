package com.gabi.steps;

import com.gabi.pages.RegistrationPageObject;
import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class RegistrationSteps {

    @Steps
    private RegistrationPageObject registrationPageObject;

    @Step("He selected his current insurer from the available list")
    public void selectInsurerFromTheList(String company) {
        registrationPageObject.heOpenedAvailableMenu();
        registrationPageObject.heSelectedCurrentInsurerCompany(company);
        registrationPageObject.heClickedOnNextStepButton();
    }

    @Step
    public void heReadTermsOfServiceAndPrivacyPolicies() {
        registrationPageObject.heReadTermsOfService();
        registrationPageObject.heReadPrivacyPolicies();
    }

    @Step
    public void heStartsInputtingRestOfTheData(DataTable dataTable) {
        List<Map<String, String>> dt = dataTable.asMaps(String.class, String.class);
        registrationPageObject.heInputsHisNameAndLastName(dt.get(0).get("Name"), dt.get(0).get("Last Name"));
        registrationPageObject.heInputsHisBirthdate(dt.get(0).get("Birthday"));
        registrationPageObject.heInputsHisAddressAndApartmentNumber(dt.get(0).get("Home Address"), dt.get(0).get("Apartment Number"));
        registrationPageObject.heInputsHisMailAddress(dt.get(0).get("Email Address"));
        registrationPageObject.heInputsHisPhoneNumber(dt.get(0).get("Phone Number"));
    }

    @Step
    public void heVerifiesThatGabiShouldSendTheCode() {
        registrationPageObject.checkIfAccountAlreadyExist();
        registrationPageObject.assertThatHesOnLastStep();
    }
}
