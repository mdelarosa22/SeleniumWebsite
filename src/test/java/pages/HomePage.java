package pages;

import java.util.Set;

public class HomePage extends BasePage{

    //Locators
    String linkedinLogo = "//i[@class='fab fa-linkedin-in']";
	String readMoreWebDriver = "//a[@class='selenium-button selenium-webdriver text-uppercase fw-bold']";
    String sectionLink = "//a[@href='/%s']";
    String aboutSection = "//a[@id='navbarDropdown']";
    String aboutItem = "//a[@class='dropdown-item']";
    String logoSelenium = "//a[@class='navbar-brand']";
    String webDriverText = "//h1[text()='WebDriver']";

    public HomePage(){
        super(driver);
    }

    public void goToSelenium(){
        navigateTo("https://www.selenium.dev/");
    }

    public void clickNavigationBar(String section){
        String xpathSection = String.format(sectionLink, section);
        click(xpathSection);
    }

    public void clickLinkedInLogo() {
        hoverOverElement(linkedinLogo);
		click(linkedinLogo);
	}
	
	public String getCurrentWindow() {
		return currentWindow();
	}

    public Set<String> getAllWindows(){
        return allWindows();
    }
	
	public void readMoreWebDriver() {
		click(readMoreWebDriver);
	}
	
	public void hoverReadMe() {
		hoverOverElement(readMoreWebDriver);
	}

    public String getWindowURL(){
        return getCurrentURL();
    }

    public void aboutSection(String about){
        click(aboutSection);
        selectOptionDropdown(aboutSection, aboutItem, about);

    }

    public void clickLogo(){
        click(logoSelenium);
    }

    public void webDriverTextDisplayed(){
        isDisplayed(webDriverText);
    }
    
}
