package pageObjects.jquery;

import commons.BasePage;
import jquery.HomePageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePO extends BasePage {
    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    public void openPageByNumber(String pageNumber) {
        waitForElementClickAble(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        clickToElement(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        sleepInSecond(2);
    }

    public boolean isPageNumberActived(String pageNumber) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        return getElementAttribute(driver, HomePageUI.DYNAMIC_PAGE_LINK, "class", pageNumber).endsWith("active");
    }

    public void enterToTextboxByHeaderName(String headerName, String keysToSend) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, headerName);
        sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, keysToSend, headerName);
        pressKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, Keys.ENTER, headerName);
    }

    public boolean isRowDataValueDisplayed(String females, String country, String males, String total) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_DATA_ROW, females, country, males, total);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_DATA_ROW, females, country, males, total);
    }

    public void deleteRowByCountryName(String countryName) {
        waitForElementClickAble(driver, HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_DELETE_BUTTON_BY_COUNTRY, countryName);
        sleepInSecond(2);
    }

    public void editRowByCountryName(String countryName) {
        waitForElementClickAble(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTRY, countryName);
        sleepInSecond(2);
    }
}
