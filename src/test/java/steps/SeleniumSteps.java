package steps;

import java.util.Set;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import pages.HomePage;
import pages.LinkedInPage;

public class SeleniumSteps {
    HomePage home = new HomePage();
    LinkedInPage linked = new LinkedInPage();

    @Given("I go to selenium Website")
    public void goToSelenium(){
        home.goToSelenium();
    }
 
    @And("I click on {word}")
    public void clickMenuOption(String section){
        home.clickNavigationBar(section);
    }

    @Then("link of {word} shall be correct")
    public void correctLink(String section){
        String currentUrl = String.format("https://www.selenium.dev/%s/",section);
        home.getWindowURL();
        Assert.assertEquals(currentUrl, home.getWindowURL());
    }

    @And("I click on about {string}")
    public void clickAbout(String aboutSection){
        home.aboutSection(aboutSection);
    }

    @Then("I see the correct {word}")
    public void correctUrl(String url){
        String currentUrl = String.format("https://www.selenium.dev/%s/",url);
        Assert.assertEquals(currentUrl, home.getWindowURL());
        home.clickLogo();
    }

    @And("I click Join us link")
    public void clickJoin(){
        String currentWindow = home.getCurrentWindow();
        home.clickJoinUs();
        Set<String> allWindows = home.getAllWindows();

        for(String window : allWindows) {
			if(!window.equals(currentWindow)) {
				linked.switchLinkedIn(window);
                Assert.assertTrue(linked.isDisplayedLogo());
				linked.closeWindow();
			}
		}

    }

}
