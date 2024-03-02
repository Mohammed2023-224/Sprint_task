package pages;

import org.openqa.selenium.By;

import main.Loggers;
import main.Setup;

public class HomePage extends Setup {
	public By search_field = By.id("search_input");

	public By search_button = By.className("ty-search-magnifier");

	public By computer_Systems_nav_bar_link = By.xpath(
			"//a[@class='ty-menu__item-link a-first-lvl childs']//child::span[text()='Computer Systems                                ']");
	// another xpath= (//a[@class='ty-menu__item-link a-first-lvl childs'])[1]
	//another xpath = (//span[contains(text(),'Computer Systems')])[1]
	
	public By accessories_nav_bar_link = By.xpath(
			"(//span[contains(text(),'Accessories')])[1]");
	// another xpath= (//a[@class='ty-menu__item-link a-first-lvl childs'])[5]
	//another xpath = //a[@class='ty-menu__item-link a-first-lvl childs']//child::span[text()='Accessories                                ']
	
	public By computer_components_nav_bar_link = By.xpath(
			"//a[@class='ty-menu__item-link a-first-lvl childs']//child::span[text()='Computer Components                                ']");
	// another xpath= (//a[@class='ty-menu__item-link a-first-lvl childs'])[2]
	//another xpath = (//span[contains(text(),'Computer Components')])[1]
	

	public By laptops_notebooks_sub_link = By.xpath("//a[@href='https://egyptlaptop.com/laptops-and-notebooks']");
	// another xpath= (//span[contains(text(),'Laptops & Notebooks')])[2]
	//another xpath =  ((//div[@class='ty-menu__submenu-col' ])[1]//child::div)[5]

	public By nvidea_sub_link = By.xpath("//a[@href='https://egyptlaptop.com/nvidia']");
	// another xpath= //span[contains(text(),'Nvidia')]
	//another xpath= ((//div[@class='ty-menu__submenu-col' ])[7]//child::div)[5]

	public By logitech_acessories_sub_link = By.xpath("//a[@href='https://egyptlaptop.com/logitech-en-2']");
	// another xpath=(//span[contains(text(),'Logitech')])[2]
	// another xpath= ((//div[@class='ty-menu__submenu-col' ])[27]//child::div)[5]
	
	
	
	public void clicking_laptops_notebooks_subLink() {
		getCustomActions().explicit_wait_till_visible(laptops_notebooks_sub_link, 20);
		getCustomActions().clicking_element(laptops_notebooks_sub_link);
		Loggers.logger.info(" clicking on laptops & notebooks sublink");
	}
	
	
	public void clicking_nvidea_subLink() {
		getCustomActions().explicit_wait_till_visible(nvidea_sub_link, 20);
		getCustomActions().clicking_element(nvidea_sub_link);
		Loggers.logger.info(" clicking on nvidea sublink");
	}
	
	
	
	public void clicking_logitech_acessories_sub_link() {
		getCustomActions().explicit_wait_till_visible(logitech_acessories_sub_link, 20);
		getCustomActions().clicking_element(logitech_acessories_sub_link);
		Loggers.logger.info(" clicking on logitech accessories sublink");
	}
	
	
	
	public void clicking_accessories_nav_bar() {
		getCustomActions().explicit_wait_till_visible(accessories_nav_bar_link, 20);
		getCustomActions().clicking_element(accessories_nav_bar_link);
		Loggers.logger.info(" clicking on accessories from nav bar");
	}
	
	
	
	public void clicking_computer_Systems_nav_bar() {
		getCustomActions().explicit_wait_till_visible(computer_Systems_nav_bar_link, 20);
		getCustomActions().clicking_element(computer_Systems_nav_bar_link);
		Loggers.logger.info(" clicking on computer systems from nav bar");
	}
	
	
	
	public void clicking_computer_components_nav_bar() {
		getCustomActions().explicit_wait_till_visible(computer_components_nav_bar_link, 20);
		getCustomActions().clicking_element(computer_components_nav_bar_link);
		Loggers.logger.info(" clicking on computer component in nav bar");
	}
	
	
	public void clicking_seach_button() {
		getCustomActions().explicit_wait_till_visible(search_button, 20);
		getCustomActions().clicking_element(search_button);
		Loggers.logger.info(" clicking on the search button");
	}
	
	
	public void filling_search_field(String text) {
		getCustomActions().explicit_wait_till_visible(search_field, 20);
		getCustomActions().typing_in_element(search_field, text);
		Loggers.logger.info("typing in the search field: "+text);
	}
}
