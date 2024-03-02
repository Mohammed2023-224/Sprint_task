package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import main.Loggers;
import main.Setup;

public class Inventory_page extends Setup {
	public By sorting_link = By.id("sw_elm_sort_fields");

	public By sort_ascending_price = By.xpath("//a[text()='Price: Low to High']");
	// xpath= //a[text()='Price: Low to High']

	public By hp_checkbox = By.xpath("//label[@for='elm_checkbox_562_10_93']");
	// xpath= (//ul[@id='ranges_562_10']//child::input)[2]

	public By lenovo_checkbox = By.xpath("//label[@for='elm_checkbox_562_10_138']");
	// xpath= (//ul[@id='ranges_562_10']//child::input)[5]

	public By min_price = By.id("slider_562_1_left");
	public By max_price = By.id("slider_562_1_right");
	public By products = By.xpath("//div[@class='ut2-gl__body content-on-hover']");
	public By products_price = By.xpath("//span[@class='ty-price']");
	public By product_titles_links = By.xpath("//a[@class='product-title']");
	public By inv_title = By.className("ty-mainbox-title");
	public By brand_title = By.xpath("//div[@id='sw_content_562_10']//bdi");
	public By price_exit_button = By.xpath("(//span[@class='ty-icon ty-icon-cancel-circle ty-reset-filters'])[2]");

	public void clicking_the_sorting_link() {
		getCustomActions().explicit_wait_till_visible(sorting_link, 20);
		getCustomActions().clicking_element(sorting_link);
		Loggers.logger.info(" clicking on the sorting link");
	}

	public void clicking_sort_ascending_price() {
		getCustomActions().explicit_wait_till_visible(sort_ascending_price, 20);
		getCustomActions().clicking_element(sort_ascending_price);
		getCustomActions().explicit_wait_till_text_appears(sorting_link, 20, "Price: Low to High");
		Loggers.logger.info(" clicking on the sort by ascending price button");
	}

	public void activating_hp_checkbox() {
		getCustomActions().explicit_wait_till_visible(hp_checkbox, 20);
		if (getCustomActions().is_element_selected(hp_checkbox) == false) {
			getCustomActions().clicking_element(hp_checkbox);
			Loggers.logger.info(" activating HP checkbox");
		}
	}

	public void activating_lenovo_checkbox() {
		getCustomActions().explicit_wait_till_visible(lenovo_checkbox, 20);
		if (getCustomActions().is_element_selected(lenovo_checkbox) == false) {
			getCustomActions().clicking_element(lenovo_checkbox);
			Loggers.logger.info(" activating lenovo checkbox");
			getCustomActions().explicit_wait_til_property_not_be(brand_title, 20, "outerText", "Brand");

		}
	}

	public void filling_min_price_field(String text) {
		getCustomActions().explicit_wait_till_visible(min_price, 20);
		getCustomActions().clearing_text_in_element(min_price);
		getCustomActions().typing_in_element(min_price, text);
		Loggers.logger.info("typing in the min price field: " + text);
	}

	public void filling_mx_price_field(String text) {
		getCustomActions().explicit_wait_till_visible(max_price, 20);
		getCustomActions().clearing_text_in_element(max_price);
		getCustomActions().typing_in_element(max_price, text);
		Loggers.logger.info("typing in the max price field: " + text);
	}

	public void clicking_the_first_product(int index) {
		getCustomActions().explicit_wait_till_visible(products, 20);
		String s = getCustomActions().return_element_from_list(products, index).getText();
		getCustomActions().return_element_from_list(products, index).click();
		Loggers.logger.info(" clicking on the product with the index: " + index + "and text: " + s);
	}

	public void wait_for_cancel_price_button() {
		getCustomActions().explicit_wait_till_visible(price_exit_button, 20);
	}

	public String checking_inv_title() {
		getCustomActions().explicit_wait_till_visible(inv_title, 20);
		return getCustomActions().get_text(inv_title);
	}

	public boolean check_all_prices_to_min_price() {
		getCustomActions().explicit_wait_till_visible(products_price, 20);
		boolean flag = true;
		String curr = "EGP";
		for (WebElement element : getCustomActions().get_all_elements_in_list(products_price)) {
			if (Integer.parseInt(element.getText().replace(curr, "").replace(",", "").trim()) < Integer
					.parseInt(getCustomActions().get_certain_property_value(min_price,"defaultValue"))) {
				flag = false;
			}
		}
		return flag;
	}

	public boolean check_all_prices_to_max_price() {
		getCustomActions().explicit_wait_till_visible(products_price, 20);
		boolean flag = true;
		String curr = "EGP";
		for (WebElement element : getCustomActions().get_all_elements_in_list(products_price)) {
			if (Integer.parseInt(element.getText().replace(curr, "").replace(",", "").trim()) > Integer
					.parseInt(getCustomActions().get_certain_property_value(max_price,"defaultValue"))) {
				flag = false;
			}
		}
		return flag;
	}

	public String checking_sorting_link() {
		return getCustomActions().get_text(sorting_link);
	}

	public String checking_brand_count() {
		return getCustomActions().get_text(brand_title);
	}

}
