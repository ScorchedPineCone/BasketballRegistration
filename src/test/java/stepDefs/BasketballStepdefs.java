package stepDefs;

import Selenium.BasketballRegistration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class BasketballStepdefs {

    private BasketballRegistration registrationPage;

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
        registrationPage = new BasketballRegistration();
        BasketballRegistration.open();
    }

    @When("I fill in the registration form with valid details")
    public void iFillInRegistrationFormWithValidDetails() {
        BasketballRegistration.validRegistration();
    }

    @When("I fill in the registration form without a last name")
    public void iFillInRegistrationFormWithoutProvidingLastName() {
        BasketballRegistration.registrationFormWithoutLastName();
    }

    @When("I fill in the registration form but my password is mismatched")
    public void iFillInTheRegistrationFormButMyPasswordIsMismatched() {
        BasketballRegistration.registrationFormWithMismatchedPassword();
    }
    
    @And("I agree to the terms and conditions")
    public void iAgreeToTheTermsAndConditions() {
        BasketballRegistration.agreeToTermsAndConditions();
    }

    @And("I agree to most terms and conditions but leave one box unchecked")
    public void iAgreeToMostTermsAndConditionsButLeaveOneBoxUnchecked() {
        BasketballRegistration.agreeToMostTermsAndConditions();
    }

    @And("I submit the registration form")
    public void iSubmitTheRegistrationForm() {
        BasketballRegistration.submitRegistrationForm();
    }

    
    @Then("I should see a success message")
    public void iShouldSeeASuccessMessage() {
        assertTrue(registrationPage.successMessageIsDisplayed());
    }

    @Then("I should see a error message for missing last name")
    public void iShouldSeeAErrorMessageForMissingLastName() {
        assertTrue(BasketballRegistration.isErrorMessageDisplayedForMissingLastName());
    }

    @Then("I should see a error message for missing terms and conditions")
    public void iShouldSeeAErrorMessageForMissingTermsAndConditions() {
        assertTrue(BasketballRegistration.isErrorMessageDisplayedForCodeOfEthicsAndConduct());
    }


    @Then("I should see a error message about mismatched password")
    public void iShouldSeeAErrorMessageAboutMismatchedPassword() {
        assertTrue(BasketballRegistration.isErrorMessageDisplayedForMismatchedPassword());
    }
    
}
