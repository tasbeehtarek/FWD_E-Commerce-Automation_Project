package org.example.stepDefs;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.util.List;
import java.util.Random;

public class D05_hoverCategoriesStepDef {

    @When("User click on Parent and select sub")
    public void hover_Test() throws InterruptedException {
        List<WebElement> Parent = Hooks.driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>Li>a[href]"));
        System.out.println("Size is "+ Parent.size());
        int random = new Random().nextInt(3);
        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(Parent.get(random)).perform();
        System.out.println(Parent.get(random).getText());
        random = random + 1;


        List<WebElement> Childs = Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/Li[" + random + "]/ul[@class=\"sublist first-level\"]/li"));
        int sub_ran = new Random().nextInt(3);
        String Child = Childs.get(sub_ran).getText();
        Childs.get(sub_ran).click();
        String title = Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"]")).getText();
        Assert.assertTrue(title.toLowerCase().contains(Child.toLowerCase()));
    }
}