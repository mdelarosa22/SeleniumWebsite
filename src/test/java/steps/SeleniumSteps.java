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

    @Given("^I go to selenium Website$")
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

    @And("^I click LinkedIn logo$")
    public void clickJoin(){
        String currentWindow = home.getCurrentWindow();
        System.out.println(currentWindow);
        home.clickLinkedInLogo();
        Set<String> allWindows = home.getAllWindows();

        for(String window : allWindows) {
			if(!window.equals(currentWindow)) {
				linked.switchLinkedIn(window);
			}
		}
    }

    @Then("^I can see linked logo$")
    public void seeLogo(){
        Assert.assertTrue(linked.isDisplayedLogo());
		linked.closeWindow();
        Set<String> allWindows = home.getAllWindows();
        String seleniumpage = allWindows.iterator().next();
        System.out.println(allWindows.iterator().next());
        linked.switchLinkedIn(seleniumpage);
    }

    @And("^I click in read me link$")
    public void clickReadMe(){
        home.hoverReadMe();
        home.readMoreWebDriver();
    }

    @Then("^I can see Webdriver page$")
    public void iCanSeeWebdriverPage(){
        System.out.println("holi");
        home.webDriverTextDisplayed();
    }

}
