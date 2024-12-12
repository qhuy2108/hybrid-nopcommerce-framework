package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public void clickToMaleRadio() {
        waitForElementClickAble(driver, RegisterPageUI.GENDER_MALE_RADIO);
        checkToCheckbox(driver, RegisterPageUI.GENDER_MALE_RADIO);
    }

    public void enterToFirstName(String firstName) {
        waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX,firstName);
    }

    public void enterToLastName(String lastName) {
        waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX,lastName);
    }

    public void selectDayDropdown(String day) {
        waitForElementClickAble(driver, RegisterPageUI.DAY_DROP_DOWN);
        selectItemInDropdown(driver, RegisterPageUI.DAY_DROP_DOWN, day);
    }

    public void selectMonthDropdown(String month) {
        waitForElementClickAble(driver, RegisterPageUI.MONTH_DROP_DOWN);
        selectItemInDropdown(driver, RegisterPageUI.MONTH_DROP_DOWN, month);
    }

    public void selectYearDropdown(String year) {
        waitForElementClickAble(driver, RegisterPageUI.YEAR_DROP_DOWN);
        selectItemInDropdown(driver, RegisterPageUI.YEAR_DROP_DOWN, year);
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToCompanyTextbox(String companyName) {
        waitForElementVisible(driver, RegisterPageUI.COMPANY_NAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.COMPANY_NAME_TEXTBOX, companyName);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,password);
    }

    public void clickToRegisterButton() {
        waitForElementClickAble(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisteredSuccessMessage() {
        waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public void clickToLogoutButton() {
        waitForElementClickAble(driver, RegisterPageUI.REGISTER_LOGOUT_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_LOGOUT_BUTTON);
    }
}
