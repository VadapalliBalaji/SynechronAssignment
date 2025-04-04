package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BasePage {
	WebDriver driver;
	public void invokeBrowser()
	{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.americanexpress.com/fr-fr/?inav=NavLogo");
        driver.manage().window().maximize();
	}
	public void getTitle(String givenTitle)
	{
		String title = driver.getTitle();
		Assert.assertEquals(title,givenTitle);
	}
	public void clickOption()
	{
		driver.findElement(By.xpath("//*[@href='https://www.americanexpress.com/fr-fr/carte-de-paiement/toutes-les-cartes/']")).click();
	}
	public void acceptCookie()
	{
		try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-testid='granular-banner-button-accept-all']")));
            acceptButton.click();
            System.out.println("Cookies accepted successfully.");
        } catch (Exception e) {
            System.out.println("No cookie popup found or button not clickable.");
        }
	}
}	