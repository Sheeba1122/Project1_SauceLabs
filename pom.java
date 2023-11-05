package project1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class pom {

	
	@FindBy(id="user-name") WebElement uid;
	@FindBy(id="password") WebElement psd;
	@FindBy(id="login-button") WebElement btn;
	@FindBy(className="inventory_item_img") WebElement img;
	@FindBy(xpath="//*[@id='add-to-cart-sauce-labs-backpack']") WebElement atc;
	@FindBy(xpath="//*[@id='shopping_cart_container']") WebElement atcc;
	@FindBy(xpath="//*[@id=\"checkout\"]") WebElement chk;
	@FindBy(id="first-name") WebElement firstname;
	@FindBy(id="last-name") WebElement lastname;
	@FindBy(id="postal-code") WebElement postlcode;
	@FindBy(id="continue") WebElement cnt;
	@FindBy(id="finish") WebElement finish;
	@FindBy(xpath="//*[contains(@class,'app_logo')]/parent::div") WebElement header;
	@FindBy(xpath="//*[contains(@class,'inventory_details_name large_size')]") WebElement productname;
	@FindBy(xpath="//*[contains(@class,'inventory_details_desc large_size')]") WebElement productdetails;
	@FindBy(xpath="//*[contains(@class,'inventory_details_price')]") WebElement productprice;
	@FindBy(id="checkout_complete_container") WebElement message;
	
}
