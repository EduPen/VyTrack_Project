package com.cybertek.tests.CostPage;
import com.cybertek.pages.VehicleCostPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class VehicleCostPageTest extends TestBase {



    @Test //aaa
    public void AccessingVehicleCostPage(){

        String expectedUrl="https://qa2.vytrack.com/entity/Extend_Entity_VehicleCosts";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl , actualUrl ,"Verify that you accessed th cost page");
    }

    @Test
    public void CancelingVehicleCostPage(){

        VehicleCostPage createNewCost= new VehicleCostPage();

        String actualResult=createNewCost.totalRecords.getText();

        createNewCost.CreateVehicleCost.click();

        BrowserUtils.waitFor(4);
        createNewCost.Cancel.click();

        String expectedResult=createNewCost.totalRecords.getText();;
        Assert.assertEquals(expectedResult,actualResult,"verify that you canceled the cost creating");
    }


    @Test
    public void CreatingVehicleCost(){

        VehicleCostPage createNewCost= new VehicleCostPage();
        createNewCost.CreateVehicleCost.click();

        createNewCost.chooseAValue.click();

        createNewCost.select.click();

        createNewCost.totalPrice.sendKeys("100");

        createNewCost.cost.sendKeys("All drivers will get 100% support for the first year");

        createNewCost.SaveAndClose.click();

        BrowserUtils.waitForVisibility(createNewCost.message,5);

        String actualMessage=createNewCost.message.getText();

        String expectedMessage= "×\n" + "Entity saved";

        Assert.assertEquals(actualMessage,expectedMessage,"Verify that you created the cost");
    }



    @Test
    public void DeletingTheCost(){
        VehicleCostPage createNewCost= new VehicleCostPage();

        createNewCost.itemList.click();

        BrowserUtils.waitFor(4);

        createNewCost.delete.click();

        createNewCost.confirmDelete.click();

        BrowserUtils.waitForVisibility(createNewCost.message,5);
        String actualMessage=createNewCost.message.getText();

        String expectedMessage= "×\n" + "Vehicle Costs deleted";

        Assert.assertEquals(actualMessage,expectedMessage,"Verify that you delete the cost");
    }



    @Test
    public void EditingTheCost(){

        VehicleCostPage createNewCost= new VehicleCostPage();

        createNewCost.selectedCost.click();
        BrowserUtils.waitFor(4);

        createNewCost.edit.click();
        BrowserUtils.waitFor(4);

        createNewCost.clickType.click();

        WebElement dropdown = driver.findElement(By.name("custom_entity_type[Type]"));
        Select stateDropdown=new Select(dropdown);

        stateDropdown.selectByIndex(3);

        createNewCost.description.sendKeys("You have to allow to change");

        createNewCost.submit.click();

        BrowserUtils.waitForVisibility(createNewCost.message,5);
        String actualMessage=createNewCost.message.getText();

        String expectedMessage= "×\n" + "Entity saved";

        Assert.assertEquals(actualMessage,expectedMessage,"Verify that you edit the cost");
    }


    @Test
    public void AddingAttachmentToCost(){
        VehicleCostPage createNewCost= new VehicleCostPage();
        BrowserUtils.waitFor(4);
        createNewCost.itemList.click();
        createNewCost.waitUntilLoaderScreenDisappear();
        createNewCost.moreActions.click();
        BrowserUtils.waitFor(5);
        createNewCost.addAttachment.click();
        createNewCost.waitUntilLoaderScreenDisappear();
        String projectPath=System.getProperty("user.dir");
        String filePath="src/test/resources/star.png";

        String fullPath=projectPath+"/"+filePath;
        createNewCost.file.sendKeys(fullPath);

        BrowserUtils.waitFor(5);
        createNewCost.submit.click();

        BrowserUtils.waitFor(4);
        BrowserUtils.waitForVisibility(createNewCost.message,5);
        String actualMessage=createNewCost.message.getText();

        String expectedMessage= "×\n" + "Attachment created successfully";

        Assert.assertEquals(actualMessage,expectedMessage,"Verify that you add attachment");
    }


    @Test
    public void AddingNoteToCost(){

        VehicleCostPage createNewCost= new VehicleCostPage();
        createNewCost.itemList.click();
        BrowserUtils.waitFor(4);
        createNewCost.moreActions.click();
        BrowserUtils.waitFor(4);
        createNewCost.addNote.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));

        BrowserUtils.waitFor(4);
        driver.findElement(By.xpath("//*[@id=\"tinymce\"]")).sendKeys("This is my first note");

        driver.switchTo().parentFrame();

        createNewCost.add.click();

        BrowserUtils.waitForVisibility(createNewCost.message,5);
        String actualMessage=createNewCost.message.getText();

        String expectedMessage= "×\n" + "Note saved";

        Assert.assertEquals(actualMessage,expectedMessage,"Verify that you add note");
    }


    @Test
    public void AddingEventToCost(){
        VehicleCostPage createNewCost= new VehicleCostPage();
        createNewCost.itemList.click();
        BrowserUtils.waitFor(4);
        createNewCost.moreActions.click();
        BrowserUtils.waitFor(4);
        createNewCost.AddEvent.click();

        createNewCost.eventTitle.sendKeys("Maintenance will be start");

        createNewCost.organizerName.sendKeys("El parterro Jardineria Sl.");

        createNewCost.organizerEmail.sendKeys("jardineria@gmail.com");

        createNewCost.submit.click();

        BrowserUtils.waitForVisibility(createNewCost.message,5);
        String actualMessage=createNewCost.message.getText();

        String expectedMessage= "×\n" + "Calendar event saved";

        Assert.assertEquals(actualMessage,expectedMessage,"Verify that you add event");

    }




    @Test
    public void ResettingTheCostGrid(){
        VehicleCostPage createNewCost= new VehicleCostPage();
        List<WebElement> listOfGrid = driver.findElements(By.xpath("//tr[@class='grid-header-row']/th/a"));

        String expected="";
        for (WebElement list : listOfGrid) {

             expected+=list.getText()+" ";

        }
        System.out.println("expected ="+expected);
        createNewCost.GridSetting.click();

        Actions actions=new Actions(driver);

        actions.clickAndHold(createNewCost.dateGrid).moveToElement(createNewCost.idGrid).release(createNewCost.idGrid).perform();

        createNewCost.closeGridSetting.click();

        createNewCost.reset.click();

        List<WebElement> listOfGrid2 = driver.findElements(By.xpath("//tr[@class='grid-header-row']/th/a"));
        String actual="";
        for (WebElement newlist : listOfGrid2) {

           actual+=newlist.getText()+" ";

        }
        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected, "verify grid reset");




    }





}
