package pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    protected static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    Actions action = new Actions(driver);

    static{
        WebDriverManager.chromedriver().setup();

		/*ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");           // Ejecuta sin GUI
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920,1080");*/

        driver = new ChromeDriver();
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
    }

    public static void navigateTo(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void closeBrowser(){
        driver.quit();
    }

    public WebElement findElement(String locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}
	
	public List<WebElement> findElements(String locator){
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
	}

    public String getText(String locator) {
		return findElement(locator).getText();
	}
	
	public void type(String inputText, String locator) {
		findElement(locator).sendKeys(inputText);
	}
	
	public void click(String locator) {
		findElement(locator).click();
	}
	
	public Boolean isDisplayed(String locator) {
		try {
			return findElement(locator).isDisplayed();
		}catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

    public void closeWindow() {
		driver.close();
	}

    public String currentWindow() {
		return driver.getWindowHandle();
	}
	
	public Set<String> allWindows(){
		return driver.getWindowHandles();
	}
	
	public void switchWindow(String newWindow) {
		driver.switchTo().window(newWindow);
	}
	
	public void hoverOverElement(String locator) {
		action.moveToElement(findElement(locator)).build().perform();
	}

	public String getCurrentURL(){
		//return driver.getTitle();
		return driver.getCurrentUrl();
	}

	public void selectOptionDropdown(String locator, String item, String searchOption){
		WebElement dropdown = findElement(locator);
		List<WebElement> options = findElements(item);
		for (WebElement option : options){
			//System.out.println(option.getText());
			//System.out.println(searchOption);
			if (option.getText().equals(searchOption))
			{
				option.click(); // click the desired option
				break;
			}
		}

	}
}
