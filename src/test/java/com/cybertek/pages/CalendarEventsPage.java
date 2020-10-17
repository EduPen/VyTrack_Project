package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CalendarEventsPage extends BasePage {


    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;


    @FindBy(xpath = "//div[@href='#']")
    public WebElement options;

    @FindBy(xpath = "//input[@value='1']")
    public WebElement pageNumber;

    @FindBy(xpath = "//label[@class='dib'][2]")
    public WebElement scrollNumber;

    @FindBy(xpath = "//button[@data-toggle='dropdown']")
    public WebElement perPageNumber;


    @FindBy(xpath = "//label[@class='dib'][3]")
    public WebElement numberOfRecords;

    @FindBy(xpath = "//button/input")
    public WebElement selectAllEvents;

    @FindBy(xpath = "//td/input[@type='checkbox']")
    public WebElement totalEventCheckbox;

    @FindBy(xpath = "//td[.='Testers meeting']")
    public WebElement testersMeeting;

    @FindBy(xpath = "//div/label")
    public WebElement infoName;

    @FindBy(css = "div>.controls>div")
    public WebElement infoDescription;








    public void calenderEventPage(){

        VehicleCostPage costPage = new VehicleCostPage();
        costPage.navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitFor(5);
    }

}