package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

public class IHSScrollbarTest {

	static Actions actions = null;
	static WebDriver chromeDriver = null;

	public static void main(String[] args) throws InterruptedException {

		File file = new File("src/main/java/testing/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getPath());
		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches", "--disable-extensions");
		chromeDriver = new ChromeDriver(options);

		actions = new Actions(chromeDriver);
		WebDriverWait wait = new WebDriverWait(chromeDriver, 30);

		chromeDriver
				.get("http://snavigate.ihsenergy.com/?ApplicationName=navigate");
		chromeDriver.findElement(By.id("txtUsername")).sendKeys(
				"navigate_etouch@ihs.com");
		chromeDriver.findElement(By.id("txtPassword")).sendKeys("12345");
		chromeDriver.findElement(By.id("btnLogin")).click();

		// Add explicit wait till it loads the page with IHSNaviagte link
		new WebDriverWait(chromeDriver, 10).until(ExpectedConditions
				.visibilityOfElementLocated(By.id("lnkProduct")));
		chromeDriver.findElement(By.id("lnkProduct")).click();

		// IHS MenuPage
		chromeDriver.switchTo().window(
				(String) (chromeDriver.getWindowHandles().toArray()[1]));
		chromeDriver.manage().window().maximize();

		// IHS Navigate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("landingPageTileDiscover")));
		performClickById("landingPageTileDiscover");

		if (chromeDriver.findElement(By.xpath("//*[@id=\"helpExit\"]/div[1]"))
				.isDisplayed()) {
			performClickByXpath("//*[@id=\"helpExit\"]/div[1]");
			performClickById("landingPageTileDiscover");
		}
		// country
		chromeDriver
				.findElement(
						By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/ul/li[1]/div/ul/li[2]/div[1]"))
				.click();
		// Country/Other Areas
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("/html/body/div[4]/div[3]/div/div/div/div[3]/ul/li[2]/div[1]")));
		performClickByXpath("/html/body/div[4]/div[3]/div/div/div/div[3]/ul/li[2]/div[1]");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@for=\"cbCanada\"]")));
		chromeDriver.findElement(By.xpath("//*[@for=\"cbCanada\"]")).click();
		
		chromeDriver.findElement(By.xpath("//*[@id=\"longListHeader\"]/div[1]/span/span[1]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id=\"panelB\"]/ul/li[2]/div/ul/li[1]/div[1]/span[1]"))); 
		chromeDriver.findElement(By.xpath("//*[@id=\"panelB\"]/ul/li[2]/div/ul/li[1]/div[1]/span[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id=\"panelA\"]/ul/li[1]/div[1]/span[1]"))); 
		performClickByXpath("//*[@id=\"panelA\"]/ul/li[1]/div[1]/span[1]");
		chromeDriver.findElement(By.xpath("//*[@id=\"longListHeader\"]/div[7]/div/input")).sendKeys("Alberta Shelf (Alberta Basin)");
		chromeDriver.findElement(By.xpath("//*[@id=\"discoverySearchIcon2\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id=\"treeViewContainer\"]/ul/li/ul/li[1]"))); 
		chromeDriver.findElement(By.xpath("//*[@id=\"treeViewContainer\"]/ul/li/ul/li[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id=\"longListHeader\"]/div[2]/div/div/span[4]"))); 
		chromeDriver.findElement(By.xpath("//*[@id=\"longListHeader\"]/div[2]/div/div/span[4]")).click();
		chromeDriver.findElement(By.xpath("//*[@id=\"discoveryPanelContextMenu\"]/div/div[1]")).click();
		//*[@id="detailsGrid"]/div[2]/div
		List<WebElement> columns = chromeDriver.findElements(By.xpath("//*[@id=\"detailsGrid\"]/div[2]/div"));
		System.out.println("test");
	}

	public static void performClickByXpath(String xpath) {
		actions.moveToElement(chromeDriver.findElement(By.xpath(xpath)))
				.click().perform();
	}

	public static void performClickById(String id) {
		actions.moveToElement(chromeDriver.findElement(By.id(id))).click()
				.perform();
	}
}
