package pages;

import org.openqa.selenium.By;

import main.Loggers;
import main.Setup;

public class Checkout_and_cart extends Setup {
	public By checkout_link = By.linkText("Proceed to checkout");
	public By phone_field = By.id("litecheckout_phone");
	public By address_field = By.id("litecheckout_s_address");
	public By accept_terms = By.name("accept_terms");
	public By place_order_button = By.id("litecheckout_place_order");
	public By successful_order_message = By.className("ty-checkout-complete__order-success");

	public void activating_accept_terms_checkbox() {
		getCustomActions().explicit_wait_till_visible(accept_terms, 20);
		if (getCustomActions().is_element_selected(accept_terms) == false) {
			getCustomActions().clicking_element(accept_terms);
			Loggers.logger.info(" activating accept terms checkbox");
		}
	}

	public void filling_phone_field(String text) {
		getCustomActions().explicit_wait_till_visible(phone_field, 20);
		getCustomActions().typing_in_element(phone_field, text);
		Loggers.logger.info("typing in the phone field: " + text);
	}

	public void filling_address_field(String text) {
		getCustomActions().explicit_wait_till_visible(address_field, 20);
		getCustomActions().typing_in_element(address_field, text);
		Loggers.logger.info("typing in the address field: " + text);
	}

	public void clicking_place_order_button() {
		getCustomActions().explicit_wait_till_visible(place_order_button, 20);
		getCustomActions().clicking_element(place_order_button);
		Loggers.logger.info(" clicking on the place order button");
	}

	public void clicking_proceed_checkout() {
		getCustomActions().explicit_wait_till_visible(checkout_link, 30);
		getCustomActions().clicking_element(checkout_link);
		Loggers.logger.info(" clicking on the checkout link button");
	}

	public boolean checking_successful_message() {
		getCustomActions().explicit_wait_till_visible(successful_order_message, 20);
		return getCustomActions().is_element_displayed(successful_order_message);
	}

}
