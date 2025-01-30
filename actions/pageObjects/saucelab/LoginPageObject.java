package pageObjects.saucelab;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.saucelab.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUserName(String userName) {
		waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX, userName);
		sendkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, userName);
	}

	public void enterToPassword(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public InventoryPageObject clickToLoginButton() {
		waitForElementClickAble(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGenerator.getProductPage(driver);
	}

}
