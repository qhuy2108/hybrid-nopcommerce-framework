package pageObjects.nopCommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.users.UserSearchPageUI;

public class UserSearchPO extends BasePage {
	WebDriver driver;

	public UserSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToSearchTextbox(String value) {
		waitForElementVisible(driver, UserSearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, UserSearchPageUI.SEARCH_TEXTBOX, value);
	}

	public void clickToSearchButton() {
		waitForElementClickAble(driver, UserSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, UserSearchPageUI.SEARCH_BUTTON);
	}	
	
	

}
