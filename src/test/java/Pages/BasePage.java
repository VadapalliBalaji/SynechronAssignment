package Pages;

import io.cucumber.datatable.DataTable;
import io.cucumber.messages.internal.com.google.protobuf.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	public void clickOption(String linkType)
	{
		
		if(linkType.equals("Cartes Particuliers"))
		{
			driver.findElement(By.xpath("(//*[@class='icon-text-container-34']/p)[1]")).click();
		}
		else if(linkType.equals("En Savior Plus"))
		{
			driver.findElement(By.xpath("(//*[@data-qe-id='CallToActionsWithLinks']/span/div/a)[2]")).click();
		}
		else if(linkType.equals("Demandez votre Carte"))
		{
			driver.findElement(By.xpath("//*[@href='https://www.americanexpress.com/fr/3534?intlink=fr-amex-cardshop-details-apply-GoldCardAmericanExpress-siderail']")).click();
		}
		else if(linkType.equals("Sauvegarder et Continuer"))
		{
			System.out.println("SauvegarderSauvegarderSauvegarderSauvegarder");
			WebElement button = driver.findElement(By.xpath("//button[@type='submit' and contains(@class, 'css-19hct2l')]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", button);
		}
	}
	public void acceptCookie()
	{
		try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-testid='granular-banner-button-accept-all']")));
            acceptButton.click();
            System.out.println("Cookies accepted successfully.");
        } catch (Exception e) {
            System.out.println("No cookie popup found or button not clickable.");
        }
	}
	public void fillDetails(DataTable dataTable) {
	    List<Map<String, String>> fields = dataTable.asMaps(String.class, String.class);
	    for (Map<String, String> row : fields) {
	        String field = row.get("Field");
	        String value = row.get("Value");
	        WebElement inputField = driver.findElement(getLocator(field));
	        if(value.equals("MR"))
	        {
	        	inputField.click();
	        }
	        else
	        {
	        	
	        	inputField.sendKeys(value);
	        }
	    }
	}
	public void captureErrorDetails(DataTable dataTable)
	{
		List<Map<String,String>> map = dataTable.asMaps(String.class,String.class);
		for(Map<String,String> m :map)
		{
			String field = m.get("Field");
			String message = m.get("ErrorMessage");
			String inputField = driver.findElement(By.xpath(field)).getText();
			Assert.assertEquals(inputField,message);			
		}
	}

	private By getLocator(String field) {
	    switch (field.toLowerCase()) {
	        case "civilite": return By.xpath("//*[@class=' flex']/div[1]/label/span");
	        case "prenom": return By.xpath("//*[@id='fieldControl-input-firstName']");
	        case "nom": return By.xpath("//*[@id='fieldControl-input-lastName']");
	        case "date": return By.xpath("//*[@id='fieldControl-input-dateOfBirth']");
	        case "telephone": return By.xpath("//*[@id='fieldControl-input-mobilePhoneNumber']");
	        case "adresse": return By.xpath("//*[text()='Merci de vérifier le format de votre adresse email (exemple : nom@domaine.fr). Les caractères autorisés sont : lettres, chiffres, tirets (_-), arobase (@), et point (.).']");
	        case "overall": return By.xpath("//*[text()='Veuillez corriger les erreurs ci-dessus pour continuer.']");
	        case "nomerror" : return By.xpath("//*[text()='Nom obligatoire.']");
	        default: throw new IllegalArgumentException("Unknown field: " + field);
	    }
	}
}	