package pageObjects.saucelab;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.saucelab.ProductPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductPageObject extends BasePage{
	private WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInSortDropdown(String sortItem) {
		waitForElementClickAble(driver, ProductPageUI.SORT_DROPDOWN);
		selectItemInDropdown(driver, ProductPageUI.SORT_DROPDOWN, sortItem);
		sleepInSecond(2);
	}

	public boolean isProductNameSortByAscending() {
		// B1 Lấy hết productName lưu lại
		List<WebElement> allProductNameText =getListElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
		
		// =============== C1 ==================================
		List<String> actualProductName = new ArrayList<String>();
			for (WebElement productName : allProductNameText) {
				actualProductName.add(productName.getText());
		// ==================================================		
				
		// =============== C2 ================================== Java Stream API
		// List<String> actualProductName = allProductNameText.stream().map(n->n.getText()).collect(Collectors.toList()));
		// List<String> expectedProductName = new ArrayList<String>(actualProductName);
		// qua B3 va B4
			}

			logArrayList(actualProductName);
			
		// B2 Clone data từ b1 ra thành 1 dữ liệu mới
		List<String> expectedProductName = new ArrayList<String>();
		for (String name : actualProductName) {
			expectedProductName.add(name);
		}
		
		// B3 cho sort dữ liệu ở b2
		// Defaul : Ascending =====> Reverse : Descending
		Collections.sort(expectedProductName);

		logArrayList(expectedProductName);
		
		// B4 verify dữ liệu trước và sau khi sort giống nhau
		return actualProductName.equals(expectedProductName);
	}

	public boolean isProductNameSortByDescending() {
		List<WebElement> allProductNameText =getListElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
		List<String> actualProductName = new ArrayList<String>();
		
			for (WebElement productName : allProductNameText) {
				actualProductName.add(productName.getText());
			}
			
		List<String> expectedProductName = new ArrayList<String>();
		for (String name : actualProductName) {
			expectedProductName.add(name);
		}
		
		Collections.sort(expectedProductName);
		Collections.reverse(expectedProductName);
		
		return actualProductName.equals(expectedProductName);
	}
	
	public void logArrayList(List<String> products) {
		System.out.println("=====================");
		for (String product : products) {
			System.out.println(product);
		}
		System.out.println("=====================");
	}

	public boolean isProductPriceSortByAscending() {
		List<WebElement> allProductPriceText =getListElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);
		List<Float> actualProductPrice = new ArrayList<Float>();
		
			for (WebElement productPrice : allProductPriceText) {
				actualProductPrice.add(Float.parseFloat(productPrice.getText().replace("$", "")));
			}
			
		List<Float> expectedProductPrice = new ArrayList<Float>();
		for (Float price : actualProductPrice) {
			expectedProductPrice.add(price);
		}
		
		Collections.sort(expectedProductPrice);
		
		return actualProductPrice.equals(expectedProductPrice);
	}

	public boolean isProductPriceSortByDescending() {
		List<WebElement> allProductPriceText =getListElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);
		List<Float> actualProductPrice = new ArrayList<Float>();
		
			for (WebElement productPrice : allProductPriceText) {
				actualProductPrice.add(Float.parseFloat(productPrice.getText().replace("$", "")));
			}
			
		List<Float> expectedProductPrice = new ArrayList<Float>();
		for (Float price : actualProductPrice) {
			expectedProductPrice.add(price);
		}
		
		Collections.sort(expectedProductPrice);
		Collections.reverse(expectedProductPrice);
		
		return actualProductPrice.equals(expectedProductPrice);
	}

}
