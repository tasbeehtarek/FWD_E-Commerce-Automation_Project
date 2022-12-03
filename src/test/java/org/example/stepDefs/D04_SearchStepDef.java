package org.example.stepDefs;

import org.example.pages.P03_Currencies;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P04_Search;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.Keys.ENTER;
public class D04_SearchStepDef {

    P04_Search search =new P04_Search();

    @When("user click on search field")
    public void user_click_on_search_field(){
        search.searchfield().click();
    }

    @And("^user enter \"(.*)\" to search$")
    public void user_enter_the_name_of_product(String searchname){
        search.searchfield().sendKeys(searchname);
        search.searchbtn().sendKeys(ENTER);
        Hooks.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Then("user find the product and relative products")
    public void user_find_the_product_and_relative_products(){
        int numofProduct =Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).size();
        System.out.println(numofProduct);
        Assert.assertTrue(numofProduct>0);
        String url="https://demo.nopcommerce.com/search";
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains(url));
        ArrayList<String> resultproducts;
        resultproducts= new ArrayList();
        for (int n=0;n<numofProduct;n++){
            System.out.println(Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).get(n).getText());
            resultproducts.add(Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).get(n).getText());
        }
        System.out.println(resultproducts);
    }

    @Then("^user find \"(.*)\" product$")
    public void user_find_one_product(String found){
        int numofProduct =Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).size();
        System.out.println(numofProduct);
        Assert.assertEquals(numofProduct,1);
        String url="https://demo.nopcommerce.com/search";
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains(url));
        ArrayList<String> resultproducts=new ArrayList();
        for (int n=0;n<numofProduct;n++){
            System.out.println(Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).get(n).getText());
            resultproducts.add(Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).get(n).getText());
        }
        System.out.println(resultproducts);
        search.founded().click();
        Hooks.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String actual=Hooks.driver.findElement(By.cssSelector("div[class=\"sku\"] span[class=\"value\"]")).getText();
        Assert.assertTrue(actual.contains(found),"Right product founded");
    }
}
