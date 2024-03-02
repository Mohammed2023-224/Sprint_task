package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import main.Setup;
import pages.HomePage;
import pages.Inventory_page;

public class All_other_tests extends Setup {
	HomePage homepage;
	Inventory_page inventory;

	@Test
	public void Validating_browsing_logitech_accessory() {
		homepage=new HomePage();
		inventory=new Inventory_page();
		homepage.clicking_accessories_nav_bar();
		homepage.clicking_logitech_acessories_sub_link();
		Assert.assertEquals(inventory.checking_inv_title(),"Logitech" );
	}
	
	
	@Test
	public void Validating_browsing_nvidea_products() {
		homepage=new HomePage();
		inventory=new Inventory_page();
		homepage.clicking_computer_components_nav_bar();
		homepage.clicking_nvidea_subLink();
		Assert.assertEquals(inventory.checking_inv_title(),"Nvidia" );
	}
	
	
	@Test
	public void Validating_user_can_search_by_product_name() {
		homepage=new HomePage();
		inventory=new Inventory_page();
		homepage.filling_search_field("dell g15");
		homepage.clicking_seach_button();
		Assert.assertEquals(inventory.checking_inv_title(),"Search results\nProducts found: 42" );
	}
	
	
	@Test
	public void Validating_user_can_filter_from_low_to_high() {
		homepage=new HomePage();
		inventory=new Inventory_page();
		homepage.clicking_computer_Systems_nav_bar();
		homepage.clicking_laptops_notebooks_subLink();
		inventory.clicking_the_sorting_link();
		inventory.clicking_sort_ascending_price();
		Assert.assertEquals(inventory.checking_sorting_link(),"Price: Low to High" );
	}
	
	
	@Test
	public void Validate_that_user_can_filter_products_by_2_brands_and_certain_price() {
		homepage=new HomePage();
		inventory=new Inventory_page();
		homepage.clicking_computer_Systems_nav_bar();
		homepage.clicking_laptops_notebooks_subLink();
		inventory.activating_hp_checkbox();
		inventory.activating_lenovo_checkbox();
		inventory.filling_min_price_field("2000");
		inventory.filling_mx_price_field("20000");
		inventory.wait_for_cancel_price_button();
		Assert.assertTrue(inventory.check_all_prices_to_max_price());
		Assert.assertTrue(inventory.check_all_prices_to_min_price());
		Assert.assertEquals(inventory.checking_brand_count(),"Brand (2)" );
	}
}
