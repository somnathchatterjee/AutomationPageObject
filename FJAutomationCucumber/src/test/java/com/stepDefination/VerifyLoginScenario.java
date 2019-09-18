package com.stepDefination;

import com.pageObject.HomePage;
import com.pageObject.LoginPage;
import com.qa.utility.ScreenShot;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyLoginScenario {

    public static LoginPage loginPage = new LoginPage();
    public static HomePage homePage = new HomePage();


    @Given("^User should navigate to finance junction URL$")
    public void userShouldNavigateToFinanceJunctionURL() throws Exception {

    }

    @And("^User should enter valid username and password$")
    public void userShouldEnterValidUsernameAndPassword() throws Exception {
       loginPage.enterUsername("valid_username");
       loginPage.enterPassword("valid_password");
       loginPage.selectBusinessUnit("valid_buname");
       ScreenShot.takeScreenshot();
    }

    @When("^User click on Login button$")
    public void userClickOnLoginButton() {
        loginPage.clickSignInButton();
    }

    @Then("^User should login successfully and able to view the Home page$")
    public void userShouldLoginSuccessfullyAndAbleToViewTheHomePage() {

        boolean ER = homePage.homelogo();
        Assert.assertTrue(ER,"The user is not able to login with valid creaditional");
    }
}
