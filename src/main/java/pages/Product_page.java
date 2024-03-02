package pages;

import org.openqa.selenium.By;

import main.Loggers;
import main.Setup;

public class Product_page extends Setup {

	public By product_title=By.xpath("//div[@class='ut2-pb__title']//child::bdi");
	public By product_price=By.id("discounted_price_9650");
	public By add_to_cart_button=By.xpath("(//i[@class='ut2-icon-use_icon_cart'])[1]");
	public By popup_close_button=By.xpath("//span[@class='cm-notification-close close']");
	public By cart_icon=By.id("cart_icon_4700");
	public By cart_link=By.linkText("View cart");


	public String get_product_title() {
		getCustomActions().explicit_wait_till_visible(product_title, 20);
		return getCustomActions().get_text(product_title);	
	}
	
	public String get_product_price() {
		getCustomActions().explicit_wait_till_visible(product_price, 20);
		return getCustomActions().get_text(product_price);	
	}
	
	public void clicking_add_to_cart_button() {
		getCustomActions().explicit_wait_till_visible(add_to_cart_button, 20);
		getCustomActions().clicking_element(add_to_cart_button);
		Loggers.logger.info(" clicking on the add to cart button");
	}
	
	public void clicking_the_popup_close_button() {
		getCustomActions().explicit_wait_till_visible(popup_close_button, 20);
		getCustomActions().clicking_element(popup_close_button);
		Loggers.logger.info(" clicking on the popup close button");
	}
	
	
	public void clicking_the_cart_icon() {
		getCustomActions().explicit_wait_till_visible(cart_icon, 20);
		getCustomActions().clicking_element(cart_icon);
		Loggers.logger.info(" clicking on the cart_icon");
	}
	
	
	public void clicking_the_cart_link() {
		getCustomActions().explicit_wait_till_visible(cart_link, 20);
		getCustomActions().clicking_element(cart_link);
		Loggers.logger.info(" clicking on the cart link from cart icon");
	}
	
	
}
