package com.lr.automation.steps;

import com.lr.automation.pages.LoginPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginStep extends ScenarioSteps {

	LoginPage loginPage;

	@Step
	public LoginStep launchBrowserAndOpenApplication() {
		loginPage.launchAndMaximizeBrowser().waitUntilLoginPageAppears();
		return this;
	}

	@Step
	public LoginStep enterEmailId(String emailId) {
		loginPage.enterUserName(emailId);
		return this;
	}

	@Step
	public LoginStep enterPassword(String password) {
		loginPage.enterPassword(password);
		return this;
	}

	@Step
	public LoginStep clickOnLoginButton() {
		loginPage.clickLoginButton();
		return this;
	}

	@Step
	public LoginStep verifyTheHomePageDisplayed() {
		loginPage.verifyTheHomePageDisplayed();
		return this;
	}

	@Step
	public boolean isErrorMessageVisibleForEmailId() {
		return loginPage.isErrorMessageVisibleForEmailId();
	}

	@Step
	public boolean isErrorMessageVisibleForPassword() {
		return loginPage.isErrorMessageVisibleForPassword();
	}

	@Step
	public String getErrorMessageForEmailId() {
		return loginPage.getErrorMessageForEmailId();
	}

	@Step
	public String getErrorMessageForPassword() {
		return loginPage.getErrorMessageForPassword();
	}

	@Step
	public String getErrorMessageForInvalidCreds() {
		return loginPage.getErrorMessageForInvalidCreds();
	}

	@Step
	public void clickOnLoginWithGoogleButton() {
		loginPage.clickOnLoginWithGoogleButton();
	}

	@Step
	public void clickOnUseAnotherAccountOnNewWindow() {
		loginPage.clickOnUseAnotherAccountOnNewWindow();
	}

	@Step
	public LoginStep enterGoogleEmailId(String emailId) {
		loginPage.enterGoogleEmailId(emailId);
		return this;
	}

	@Step
	public LoginStep enterGooglePassword(String password) {
		loginPage.enterGooglePassword(password);
		return this;
	}

	@Step
	public LoginStep clickNext() {
		loginPage.clickNext();
		return this;
	}

	@Step
	public void clickOnLogout() {
		loginPage.clickOnLogout();
	}

	@Step
	public void seeLoginPage() {
		loginPage.waitUntilLoginPageAppears();
	}

	@Step
	public String getErrorMessage(String field) {
		return loginPage.getErrorMessage(field);
	}

}
