package Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	 WebDriver driver;
	    WebDriverWait wait;

	    // Locators for elements on the homepage
	    By searchbox = By.xpath("(//input[@placeholder='Search for Products...'])[2]");
	    By priceRange = By.xpath("//label[contains(text(), 'Rs 21 to Rs 50')]");
	    By carrotProduct = By.xpath("(//h3[normalize-space()='Carrot - Orange (Loose)'])[1]");
	    By addButton = By.xpath("(//button[@color='rossoCorsa'][normalize-space()='Add'])[1]");
	    By removeButton = By.xpath("(//*[name()='svg'][@class='CtaOnDeck___StyledMinusIcon-sc-orwifk-9 dPdCkk'])[1]");

	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    // Actions
	    public void enterSearchTerm(String searchTerm) {
	        WebElement searchboxElement = driver.findElement(searchbox);
	        searchboxElement.sendKeys(searchTerm);
	    }

	    public void pressEnter() {
	        WebElement searchboxElement = driver.findElement(searchbox);
	        searchboxElement.sendKeys(Keys.ENTER);
	    }

	    public void scrollDown() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,500)");
	    }

	    public void selectPriceRange() {
	        WebElement pr = driver.findElement(priceRange);
	        pr.click();
	    }

	    public void waitForCarrotProduct() {
	        WebElement product = driver.findElement(carrotProduct);
	        wait.until(ExpectedConditions.visibilityOf(product));
	    }

	    public void clickAddToCart() {
	        WebElement add = driver.findElement(addButton);
	        add.click();
	    }

	    public void clickRemoveFromCart() {
	        WebElement remove = driver.findElement(removeButton);
	        remove.click();
	    }
}
