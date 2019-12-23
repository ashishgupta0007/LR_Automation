package com.lr.automation.stepDefs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import com.lr.automation.steps.LoginStep;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDef {

	@Steps
	LoginStep loginStep;
	private String eid;
	private String pwd;
	private String fieldName;

	@Given("^I launch browser and open application$")
	public void iLaunchBrowserAndOpenApplication() {

		loginStep.launchBrowserAndOpenApplication();
	}

	@When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void iEnterEmailIdAndPassword(String emailId, String password) {
		eid = emailId;
		pwd = password;
		loginStep.enterEmailId(emailId).enterPassword(password);

	}

	@And("^I click on Login button$")
	public void iClickOnLoginButton() {
		loginStep.clickOnLoginButton();

	}

	@Then("^I verify the home page displayed$")
	public void iVerifyTheHomePageDisplayed() {
		loginStep.verifyTheHomePageDisplayed();
	}

	@Then("^I verify the error message$")
	public void iVerifyTheErrorMessage() {
		if (eid.equalsIgnoreCase("") && pwd.equals("")) {
			assertEquals("The Email Id field is required.",
					loginStep.getErrorMessageForEmailId());
			assertEquals("The Password field is required.",
					loginStep.getErrorMessageForPassword());
		} else if (eid.equalsIgnoreCase("lr.user.test2019@gmail.com")
				&& pwd.equals("")) {
			assertFalse(loginStep.isErrorMessageVisibleForEmailId());
			assertEquals("The Password field is required.",
					loginStep.getErrorMessageForPassword());
		} else if (eid.equalsIgnoreCase("") && pwd.equals("Loginradius@2019")) {
			assertEquals("The Email Id field is required.",
					loginStep.getErrorMessageForEmailId());
			assertFalse(loginStep.isErrorMessageVisibleForPassword());
		} else if (eid.equalsIgnoreCase("lr.user.test2019")
				&& pwd.equals("Loginradius@2019")) {
			assertEquals(
					"The Email Id field must contain a valid email address.",
					loginStep.getErrorMessageForEmailId());
			assertFalse(loginStep.isErrorMessageVisibleForPassword());
		} else if (eid.equalsIgnoreCase("lr.user.test2019@gmail.com")
				&& pwd.equals("abcd")) {
			assertEquals(
					"Please use a valid user ID and password combination.",
					loginStep.getErrorMessageForInvalidCreds());
			assertFalse(loginStep.isErrorMessageVisibleForEmailId());
			assertFalse(loginStep.isErrorMessageVisibleForPassword());
		} else if (eid.equalsIgnoreCase("lr.user.test2019@gmail.coma")
				&& pwd.equals("Loginradius@2019")) {
			assertEquals(
					"The user's account does not exist, please use a valid user or create the user before processing this request.",
					loginStep.getErrorMessageForInvalidCreds());
			assertFalse(loginStep.isErrorMessageVisibleForEmailId());
			assertFalse(loginStep.isErrorMessageVisibleForPassword());
		}
	}

	@When("^I click on Login with Google button$")
	public void iClickOnLoginWithGoogleButton() {
		loginStep.clickOnLoginWithGoogleButton();
	}

	@And("^I click on Use Another Account on New window$")
	public void iClickOnUseAnotherAccountOnNewWindow() {
		loginStep.clickOnUseAnotherAccountOnNewWindow();
	}

	@And("^I Enter \"([^\"]*)\" as email id and Click Next$")
	public void iEnterAsEmailIdAndClickNext(String emailId) {
		fieldName = "email id";
		loginStep.enterGoogleEmailId(emailId).clickNext();
	}

	@And("^I Enter \"([^\"]*)\" as password and Click Next$")
	public void iEnterAsPasswordAndClickNext(String password) {
		fieldName = "password";
		loginStep.enterGooglePassword(password).clickNext();
	}

	@And("^I click on Logout$")
	public void iClickOnLogout() {
		loginStep.clickOnLogout();
	}

	@Then("^I should Logout$")
	public void iShouldLogout() {
		loginStep.seeLoginPage();
	}

	@And("^I leave \"([^\"]*)\" blank and Click Next$")
	public void iLeaveBlankAndClickNext(String field) {

		loginStep.clickNext();
	}

	@Then("^I verify the error message on popup$")
	public void iVerifyTheErrorMessageOnPopup() {
		if (fieldName.equalsIgnoreCase("email id")) {
			assertEquals("Enter an email or phone number",
					loginStep.getErrorMessage("email id"));

		} else if (fieldName.equalsIgnoreCase("password")) {
			assertEquals("Enter a password",
					loginStep.getErrorMessage("password"));

		}

	}

}
