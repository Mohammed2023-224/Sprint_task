package main;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomActions extends Setup {
	public void explicit_wait_till_visible(By ele, int time) {
		WebDriverWait wait = new WebDriverWait(SafeThread.getDriver(), Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}
	
	public void explicit_wait_till_present(By ele, int time) {
		WebDriverWait wait = new WebDriverWait(SafeThread.getDriver(), Duration.ofSeconds(time));
		wait.until(ExpectedConditions.presenceOfElementLocated(ele));
	}


	public void explicit_wait_till_visible(WebElement ele, int time) {
		WebDriverWait wait = new WebDriverWait(SafeThread.getDriver(), Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void explicit_wait_til_property_changes(By ele, int time, String property, String value) {
		WebDriverWait wait = new WebDriverWait(SafeThread.getDriver(), Duration.ofSeconds(time));
		wait.until(ExpectedConditions.domPropertyToBe(SafeThread.getDriver().findElement(ele), property, value));
	}

	public void explicit_wait_til_property_not_be(final By ele, int time, final String property, final String value) {
		WebDriverWait wait = new WebDriverWait(SafeThread.getDriver(), Duration.ofSeconds(time));
	    wait.until(new Function<WebDriver, Object>() {
			@Override
			public Object apply(WebDriver driver) {
			    String actualValue = driver.findElement(ele).getAttribute(property);
			    return !actualValue.equals(value);
			}
		});}

	public void explicit_wait_til_property_changes(WebElement ele, int time, String property, String value) {
		WebDriverWait wait = new WebDriverWait(SafeThread.getDriver(), Duration.ofSeconds(time));
		wait.until(ExpectedConditions.domPropertyToBe(ele, property, value));
	}

	public WebElement java_script_executor_shadow_host(By ele) {
		JavascriptExecutor js = (JavascriptExecutor) SafeThread.getDriver();
		WebElement shadow_root = (WebElement) js.executeScript("return arguments[0].shadowRoot",
				SafeThread.getDriver().findElement(ele));
		return shadow_root;
	}



	public void explicit_wait_till_text_disappears(By ele, int time, String text) {
		WebDriverWait wait = new WebDriverWait(SafeThread.getDriver(), Duration.ofSeconds(time));
		wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(ele, text)));
	}

	public void explicit_wait_till_text_appears(By ele, int time, String text) {
		WebDriverWait wait = new WebDriverWait(SafeThread.getDriver(), Duration.ofSeconds(time));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(ele, text));
	}

	public void explicit_wait_till_text_appears(WebElement ele, int time, String text) {
		WebDriverWait wait = new WebDriverWait(SafeThread.getDriver(), Duration.ofSeconds(time));
		wait.until(ExpectedConditions.textToBePresentInElement(ele, text));
	}

	public void explicit_wait_till_attribute_to_be(By ele, String attribute, String value, int time) {
		WebDriverWait wait = new WebDriverWait(SafeThread.getDriver(), Duration.ofSeconds(time));
		wait.until(ExpectedConditions.attributeContains(ele, attribute, value));
	}

	public void explicit_wait_till_clickable(By ele, int time) {
		WebDriverWait wait = new WebDriverWait(SafeThread.getDriver(), Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void explicit_wait_till_invisibility(By ele, int time) {
		WebDriverWait wait = new WebDriverWait(SafeThread.getDriver(), Duration.ofSeconds(time));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ele));
	}

	public void clicking_element(By ele) {
		SafeThread.getDriver().findElement(ele).click();
	}
	
	public List<WebElement> get_all_elements_in_list(By ele) {
		return SafeThread.getDriver().findElements(ele);
	}

	public void typing_in_element(By ele, String text) {
		SafeThread.getDriver().findElement(ele).sendKeys(text);
	}
	public void clearing_text_in_element(By ele) {
		SafeThread.getDriver().findElement(ele).clear();
	}

	public void clicking_enter(By ele) {
		SafeThread.getDriver().findElement(ele).sendKeys(Keys.ENTER);
	}

	public void clicking_arrow_up_key(By ele) {
		SafeThread.getDriver().findElement(ele).sendKeys(Keys.ARROW_UP);
	}

	public void clicking_arrow_down_key(By ele) {
		SafeThread.getDriver().findElement(ele).sendKeys(Keys.ARROW_DOWN);
	}

	public void clicking_arrow_right_key(By ele) {
		SafeThread.getDriver().findElement(ele).sendKeys(Keys.ARROW_RIGHT);
	}

	public void clicking_arrow_left_key(By ele) {
		SafeThread.getDriver().findElement(ele).sendKeys(Keys.ARROW_LEFT);
	}

	public void clicking_end_key(By ele) {
		SafeThread.getDriver().findElement(ele).sendKeys(Keys.END);
	}

	public WebElement return_element_from_list(By ele, int index) {
		WebElement elements = null;
		for (int i = 0; i < SafeThread.getDriver().findElements(ele).size(); i++) {
			if (i == index) {
				elements = SafeThread.getDriver().findElements(ele).get(index);
				break;
			} else {
				elements = SafeThread.getDriver().findElements(ele).get(0);
			}
		}
		return elements;
	}

	public WebElement search_elements_fro_text(By ele, String text) {
		WebElement element = null;
		for (int i = 0; i < SafeThread.getDriver().findElements(ele).size(); i++) {
			if (SafeThread.getDriver().findElements(ele).get(i).getText() == text) {
				element = SafeThread.getDriver().findElements(ele).get(i);
			}
		}
		return element;

	}

	public WebElement return_last_element_from_list(By ele) {
		List<WebElement> elements = SafeThread.getDriver().findElements(ele);
		return elements.get(elements.size() - 1);
	}

	public void return_parent_frame() {
		SafeThread.getDriver().switchTo().parentFrame();
	}

	public void switch_frame(By ele) {
		SafeThread.getDriver().switchTo().frame(SafeThread.getDriver().findElement(ele));
	}

	public void accept_alert() {
		SafeThread.getDriver().switchTo().alert().accept();
	}

	public void dismiss_alert() {
		SafeThread.getDriver().switchTo().alert().dismiss();
		;
	}

	public void switch_alert() {
		SafeThread.getDriver().switchTo().alert();
	}

	public boolean is_element_displayed(By ele) {
		try {
			return SafeThread.getDriver().findElement(ele).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public boolean is_element_selected(By ele) {
		return SafeThread.getDriver().findElement(ele).isSelected();
	}

	public boolean is_element_enabled(By ele) {
		return SafeThread.getDriver().findElement(ele).isEnabled();
	}

	public void drop_down_list_by_index(By ele, int index) {
		Select select = new Select(SafeThread.getDriver().findElement(ele));
		select.selectByIndex(index);
	}

	public String get_text_drop_down_list(By ele) {
		Select select = new Select(SafeThread.getDriver().findElement(ele));
		return select.getFirstSelectedOption().getText();
	}
	
	
	public String get_certain_property_value(By ele,String property) {
		return SafeThread.getDriver().findElement(ele).getDomProperty(property);
	}

	public void drop_down_list_by_value(By ele, String text) {
		Select select = new Select(SafeThread.getDriver().findElement(ele));
		select.selectByValue(text);
	}

	public boolean is_text_correct(By ele, String text) {
		String txt = SafeThread.getDriver().findElement(ele).getText();
		if (txt.toLowerCase().contains(text))
			return true;
		return false;
	}

	public String get_text(By ele) {
		return SafeThread.getDriver().findElement(ele).getText();
	}

	public String get_element_attribute_aria_label(By ele) {
		return SafeThread.getDriver().findElement(ele).getAttribute("aria-label");
	}
}
