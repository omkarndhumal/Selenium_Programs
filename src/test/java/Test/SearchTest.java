package Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.WebDriverFactory;
import Page.HomePage;

public class SearchTest {

	 WebDriver driver;
	    HomePage homePage;

	    @BeforeMethod
	    public void setup() {
	        driver = WebDriverFactory.getDriver();
	        homePage = new HomePage(driver);
	        driver.get("https://www.bigbasket.com/");
	    }

	    @Test
	    public void testProductSearchAndCart() throws InterruptedException {
	        // Search for the product "carrot"
	        homePage.enterSearchTerm("carrot");
	        Thread.sleep(5000); // Adding wait for demonstration
	        homePage.pressEnter();
	        Thread.sleep(5000);

	        // Scroll down the page
	        homePage.scrollDown();
	        Thread.sleep(4000);

	        // Select price range
	        homePage.selectPriceRange();
	        Thread.sleep(4000);

	        // Wait for the Carrot product to be visible
	        homePage.waitForCarrotProduct();
	        Thread.sleep(4000);

	        // Add product to the cart
	        homePage.clickAddToCart();
	        Thread.sleep(4000);

	        // Remove product from the cart
	        homePage.clickRemoveFromCart();
	        Thread.sleep(4000);
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
