package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import main.Setup;
import pages.Checkout_and_cart;
import pages.HomePage;
import pages.Inventory_page;
import pages.Product_page;

public class End_to_end_tests extends Setup {
	HomePage homepage;
	Inventory_page inventory;
	Product_page productPage;
	Checkout_and_cart checkout;
	@Test
	public void end_to_end() {
		homepage=new HomePage();
		inventory=new Inventory_page();
		productPage=new  Product_page();
		checkout=new Checkout_and_cart();
		homepage.clicking_computer_Systems_nav_bar();
		homepage.clicking_laptops_notebooks_subLink();
		inventory.clicking_the_first_product(0);
		productPage.clicking_add_to_cart_button();
		productPage.clicking_the_popup_close_button();
		productPage.clicking_the_cart_icon();
		productPage.clicking_the_cart_link();
		checkout.clicking_proceed_checkout();
		checkout.filling_phone_field("213");
		checkout.filling_address_field("sd");
		checkout.activating_accept_terms_checkbox();
		checkout.clicking_place_order_button();
		Assert.assertTrue(checkout.checking_successful_message());
		
		
		
	}
}
