package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.example.pages.P03_Currencies;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class D03_currenciesStepDef {
 //P03_homePage home= new P03_homePage();

P03_Currencies Currency = new P03_Currencies();


    @When("user select euro option")
    public void select_euro()
    {
      List<WebElement> categories = Hooks.driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li>a[href]"));
      int randomNumber = new Random().nextInt(3);

        Actions hover= new Actions(Hooks.driver);
        hover.moveToElement(categories.get(randomNumber)).perform();

       String mainCategory =  categories.get(randomNumber).getText();
        System.out.println(mainCategory );
        List<WebElement> subCategory = Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"/li["+randomNumber+"]/ul[@class=\"sublist first-level\"]/li"));
        int randomNumbersub = new Random().nextInt(3);

       String subCate = subCategory.get(randomNumbersub).getText();
        System.out.println(subCate);
        subCategory.get(randomNumbersub).click();

     String pageTitle =  Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"]")).getText();

   String url = Hooks.driver.getCurrentUrl();

        Assert.assertTrue(pageTitle.contains(subCate));

    }


    @Then("euro symbol is displayed on all products")
    public void euroSymbolIsDisplayedOnAllProducts() throws InterruptedException {

        //findElements
        for (int x = 0; x < Currency.prices().size(); x++) {
            String value = Currency.prices().get(x).getText();
            System.out.println(value.toLowerCase());

            //assertion   value contains €

            String selected = Hooks.driver.findElement(By.cssSelector("select[onchange=\"setLocation(this.value)\"]")).getText();
            Assert.assertTrue(selected.contains("Euro"), "Euro is selected Successfully");
            Currency.currencyEuro();
            Thread.sleep(1000);

        }
    }

        @When("user choose USD from dropdown menu")
        public void user_choose_USD_from_dropdown_menu () throws InterruptedException {
            Currency.chooseUSD();
            Thread.sleep(3000);
        }


        @Then("usd is selected successfully")
        public void usd_is_selected_successfully () throws InterruptedException {
            String selected = Hooks.driver.findElement(By.cssSelector("select[onchange=\"setLocation(this.value)\"]")).getText();
            Assert.assertTrue(selected.contains("US Dollar"), "US Dollar is selected Successfully");
            Currency.currencyDollar();
            Thread.sleep(1000);
        }

}





