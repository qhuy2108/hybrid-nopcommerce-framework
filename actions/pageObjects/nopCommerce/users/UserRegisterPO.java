package pageObjects.nopCommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.users.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public void clickToMaleRadio() {
        waitForElementClickAble(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
        checkToCheckbox(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
    }

    public void enterToFirstName(String firstName) {
        waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX,firstName);
    }

    public void enterToLastName(String lastName) {
        waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX,lastName);
    }

    public void selectDayDropdown(String day) {
        waitForElementClickAble(driver, UserRegisterPageUI.DAY_DROP_DOWN);
        selectItemInDropdown(driver, UserRegisterPageUI.DAY_DROP_DOWN, day);
    }

    public void selectMonthDropdown(String month) {
        waitForElementClickAble(driver, UserRegisterPageUI.MONTH_DROP_DOWN);
        selectItemInDropdown(driver, UserRegisterPageUI.MONTH_DROP_DOWN, month);
    }

    public void selectYearDropdown(String year) {
        waitForElementClickAble(driver, UserRegisterPageUI.YEAR_DROP_DOWN);
        selectItemInDropdown(driver, UserRegisterPageUI.YEAR_DROP_DOWN, year);
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToCompanyTextbox(String companyName) {
        waitForElementVisible(driver, UserRegisterPageUI.COMPANY_NAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.COMPANY_NAME_TEXTBOX, companyName);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,password);
    }

    public void clickToRegisterButton() {
        waitForElementClickAble(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisteredSuccessMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public void clickToLogoutButton() {
        waitForElementClickAble(driver, UserRegisterPageUI.REGISTER_LOGOUT_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_LOGOUT_BUTTON);
    }

    public String getRegisterPageTitle() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_PAGE_TITLE);
        return getElementText(driver, UserRegisterPageUI.REGISTER_PAGE_TITLE);
    }
}
