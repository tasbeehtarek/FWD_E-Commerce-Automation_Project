package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;



public class D02_loginStepDef {
    P02_login login = new P02_login();

    @Given("user navigates to Home page")
    public void user_navigate_to_Home_page(){
        String url = "https://demo.nopcommerce.com/";
        Hooks.driver.navigate().to(url);
        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @And("user clicks on login button")
    public void user_click_on_login(){
        login.login_link().click();
        Hooks.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @When("^user enter valid \"(.*)\" and valid \"(.*)\"$")
    public void user_enter_valid_email(String user,String pass){
        login.loginStep(user,pass);
    }

    @And("user clicks login button")
    public void user_clicks_login_button(){
        login.LoginBtn().click();
    }

    @Then("user logged in successfully")
    public void user_logged_in_successfully (){
        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertFalse(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/login?returnUrl=%2F/"));
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(Hooks.driver.findElement(By.cssSelector("a[href=\"/customer/info\"][class=\"ico-account\"]")).isDisplayed());
        soft.assertTrue(Hooks.driver.findElement(By.cssSelector("a[href=\"/logout\"][class=\"ico-logout\"]")).isDisplayed());
        soft.assertAll();
    }

    @Then("user could not login")
    public void user_could_not_login() {
        Hooks.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        String mesage=login.errormessage().getText();
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(mesage.contains("Login was unsuccessful. Please correct the errors and try again."));
        String sscolor=login.errormessage().getCssValue("color");
        soft.assertEquals(sscolor,"#e4434b");
    }
}