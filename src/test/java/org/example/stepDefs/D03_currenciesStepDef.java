package org.example.stepDefs;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D03_currenciesStepDef {
    P03_homePage Curr = new P03_homePage() ;

P03_homePage Currency = new P03_homePage();


    @When("user select euro option")
    public void Currency_dropdown() throws InterruptedException {

        Select Currency = new Select(Curr.Currency_List());
        Currency.selectByVisibleText("Euro");

        Thread.sleep(3000);
    }

    @Then("euro symbol is displayed on all products")

    public void Currency_validation(){


        String[] x = new String[4];

        for(int i= 0 ; i<Curr.prices().size() ; i++){
            x[i]=Curr.prices().get(i).getText();
            System.out.println(x[i]);
            Assert.assertTrue(x[i].contains("€"));
        }




    }


}





