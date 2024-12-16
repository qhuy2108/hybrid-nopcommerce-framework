package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {

    private WebDriver driver;

    public CustomerInfoPageObject(WebDriver driver) {
        this.driver = driver;
    } // khi generate hàm này tự lên đầu vì nó sẽ chạy trước private WebDriver driver ở sau cũng dc


    public boolean isGenderMaleSelected() {
        waitForElementSelected(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
        return isElementSelected(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX,"value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX,"value");
    }

    public String getDayDropdownSelectedValue() {
        waitForElementClickAble(driver, CustomerInfoPageUI.DAY_DROP_DOWN);
        return getselectedItemInDropdown(driver, CustomerInfoPageUI.DAY_DROP_DOWN);
    }

    public String getMonthDropdownSelectedValue() {
        waitForElementClickAble(driver, CustomerInfoPageUI.MONTH_DROP_DOWN);
        return getselectedItemInDropdown(driver, CustomerInfoPageUI.MONTH_DROP_DOWN);
    }

    public String getYearDropdownSelectedValue() {
        waitForElementClickAble(driver, CustomerInfoPageUI.YEAR_DROP_DOWN);
        return getselectedItemInDropdown(driver, CustomerInfoPageUI.YEAR_DROP_DOWN);
    }

    public String getEmailTextboxValue() {
        waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX,"value");
    }

    public String getCompanyTextboxValue() {
        waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX,"value");
    }


}
