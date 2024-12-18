package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.users.UserSidebarPageUI;

public class SidebarPageObject extends BasePage {
    public SidebarPageObject(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    // sau khi topic 74 thì có thể bỏ WebDriver driver ở các hàm dưới vì đã có ham Contructor ở trên rồi
    // nhưng ở đây giữ lại vì sẽ ảnh hưởng đến level_07_switch

    public UserRewardPointPO openRewardPointPage() {
        waitForElementClickAble(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        clickToElement(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        return  PageGenerator.getUserRewardPointPage(driver);
    }

    public UserCustomerInfoPO openCustomerInfoPage() {
        waitForElementClickAble(driver, UserSidebarPageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, UserSidebarPageUI.CUSTOMER_INFO_LINK);
        return  PageGenerator.getUserCustomerInfoPage(driver);
    }

    public UserAddressPO openAddressPage() {
        waitForElementClickAble(driver, UserSidebarPageUI.ADDRESSES_LINK);
        clickToElement(driver, UserSidebarPageUI.ADDRESSES_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }


    public UserOrderPO openOrderPage() {
        waitForElementClickAble(driver, UserSidebarPageUI.ORDER_LINK);
        clickToElement(driver, UserSidebarPageUI.ORDER_LINK);
        return  PageGenerator.getUserOrderPage(driver);
    }
}
