package com.lr.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {

	private String winHandleBefore;
	@FindBy(css = "#loginradius-login-emailid")
	WebElementFacade txtUserName;

	@FindBy(css = "#loginradius-login-password")
	WebElementFacade txtPassword;

	@FindBy(css = "#loginradius-submit-login")
	WebElementFacade btnLogin;

	@FindBy(css = "#lr-traditional-login")
	WebElementFacade frmLogin;

	@FindBy(xpath = "//h6[contains(text(),'Email Id')]")
	WebElementFacade homepage;

	@FindBy(css = "#validation-loginradius-login-emailid")
	WebElementFacade errorMsgEmailId;

	@FindBy(css = "#validation-loginradius-login-password")
	WebElementFacade errorMsgPwd;

	@FindBy(css = "#lr-raas-message")
	WebElementFacade errorMsg;

	@FindBy(xpath = "//span[@title='Sign up with Google']")
	WebElementFacade loginWithGoogleButton;

	@FindBy(xpath = "//div[text()='Use another account']")
	WebElementFacade useAnotherAcctButton;

	@FindBy(css = "#identifierId")
	WebElementFacade googleEmailId;

	@FindBy(xpath = "//input[@name='password']")
	WebElementFacade googlePwd;

	@FindBy(xpath = "//span[text()='Next']")
	WebElementFacade googleNextButton;

	@FindBy(xpath = "//div[@class='lr-menu-button']")
	WebElementFacade menuIcon;

	@FindBy(xpath = "//a[@class='lr-logout lr-menu-list']")
	WebElementFacade logoutLink;

	@FindBy(xpath = "//div[text()='Enter an email or phone number']")
	WebElementFacade emailIdError;

	@FindBy(xpath = "//span[text()='Enter a password']")
	WebElementFacade passwordError;

	public LoginPage launchAndMaximizeBrowser() {
		open();
		getDriver().manage().window().maximize();
		return this;
	}

	public LoginPage waitUntilLoginPageAppears() {
		frmLogin.waitUntilVisible();
		return this;
	}

	public LoginPage enterUserName(String username) {

		txtUserName.waitUntilVisible().clear();
		txtUserName.sendKeys(username);
		return this;
	}

	public LoginPage enterPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
		return this;
	}

	public LoginPage clickLoginButton() {
		btnLogin.waitUntilClickable().click();
		return this;
	}

	public LoginPage verifyTheHomePageDisplayed() {
		if (winHandleBefore != null) {
			waitABit(3000);
			getDriver().switchTo().window(winHandleBefore);
		}
		homepage.waitUntilVisible().isDisplayed();
		return this;
	}

	public boolean isErrorMessageVisibleForEmailId() {
		return errorMsgEmailId.isVisible();
	}

	public boolean isErrorMessageVisibleForPassword() {
		return errorMsgPwd.isVisible();
	}

	public String getErrorMessageForEmailId() {
		return errorMsgEmailId.waitUntilVisible().getText();
	}

	public String getErrorMessageForPassword() {
		return errorMsgPwd.waitUntilVisible().getText();
	}

	public String getErrorMessageForInvalidCreds() {
		return errorMsg.waitUntilVisible().getText();
	}

	public void clickOnLoginWithGoogleButton() {
		loginWithGoogleButton.waitUntilClickable().click();
		waitABit(2000);
		winHandleBefore = getDriver().getWindowHandle();
		for (String winHandle : getDriver().getWindowHandles()) {
			getDriver().switchTo().window(winHandle);
		}

	}

	public void clickOnUseAnotherAccountOnNewWindow() {

		useAnotherAcctButton.waitUntilClickable().click();
	}

	public LoginPage enterGoogleEmailId(String emailId) {
		googleEmailId.waitUntilVisible().type(emailId);
		return this;
	}

	public LoginPage enterGooglePassword(String password) {
		googlePwd.waitUntilVisible().type(password);
		return this;
	}

	public LoginPage clickNext() {
		googleNextButton.waitUntilVisible().waitUntilClickable().click();
		return this;
	}

	public void clickOnLogout() {
		menuIcon.waitUntilClickable().click();
		logoutLink.waitUntilClickable().click();
	}

	public String getErrorMessage(String field) {
		if (field.equalsIgnoreCase("email id")) {
			return emailIdError.waitUntilVisible().getText();
		} else if (field.equalsIgnoreCase("password")) {
			return passwordError.waitUntilVisible().getText();
		}
		return "";
	}

}
