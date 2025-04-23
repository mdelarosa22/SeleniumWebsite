package pages;

import java.util.Set;

public class LinkedInPage extends BasePage{

    //locators
	String linkedLogo = "//a[@aria-label='LinkedIn']";

    public LinkedInPage(){
        super(driver);
    }

    public void switchLinkedIn(String newWindow) {
		switchWindow(newWindow);
	}
	
	public Set allOpenWindows() {
		return allWindows();
	}

	public boolean isDisplayedLogo(){
		return isDisplayed(linkedLogo);
	}
}
