package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.ArrayList;


public class D07_followUsStepDef {

    P03_homePage S1 = new P03_homePage();
    @When("user click on facebook")
    public void face_book() throws InterruptedException {
        S1.Facebook().click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        System.out.println("Before Switch "+ Hooks.driver.getCurrentUrl());
    }

    @Then("user navigated to page in new tap {string}")
    public void Face_book(String arg05){
        ArrayList<String> tab = new ArrayList<String>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tab.get(1));
        System.out.println("After Switch"+ Hooks.driver.getCurrentUrl());

        String ActualResult = Hooks.driver.getCurrentUrl();
        SoftAssert soft1= new SoftAssert();
        soft1.assertEquals(ActualResult,arg05);

        Hooks.driver.close();
        Hooks.driver.switchTo().window(tab.get(0));
        soft1.assertAll();

    }

    @When("user click on twitter icon")
    public void Twitter(){
        S1.Twitter().click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // inform selenium to wait till the second window is opened
    }

    @When("user click on rss icon")
    public void rss() {
        S1.rss().click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @When("user click on youtube icon")
    public void  youTube(){
        S1.youtube().click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

}

