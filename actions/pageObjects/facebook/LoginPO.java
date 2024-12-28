package pageObjects.facebook;

import commons.BasePage;
import facebook.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPO extends BasePage {
    WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToNewAccountButton() {
        waitForElementClickAble(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
        clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
    }

    public void enterToEmailTextbox(String mail) {
    }

    public boolean isConfirmEmailTextboxDisplayed() {
        waitForElementVisible(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
        return isElementDisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
    }

    public boolean isConfirmEmailTextboxUndisplayed() {
        waitForElementInvisible(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
        return isElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
    }

    public void clickToCloseIcon() {
        waitForElementClickAble(driver, LoginPageUI.CLOSE_ICON_REGISTER);
        clickToElement(driver, LoginPageUI.CLOSE_ICON_REGISTER);
    }
}
