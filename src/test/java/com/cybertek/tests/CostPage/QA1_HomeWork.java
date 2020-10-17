package com.cybertek.tests.CostPage;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Wrapper;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class QA1_HomeWork extends TestBase {



    @DataProvider
    public Object[][] userData() {

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx", "HW");

        String[][] dataArray = qa3short.getDataArrayWithoutFirstRow();

        return dataArray;
    }

    @Test(dataProvider = "userData")
    public void optionsDisplayed(String username, String password) {
        extentLogger= report.createTest("TC-1 Verifying the options is displayed");
        extentLogger.info("Open Chrome Browser");
        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);

        extentLogger.info("Login teh app");

        CalendarEventsPage calendarEvents=new CalendarEventsPage();

        calendarEvents.calenderEventPage();

        Assert.assertTrue(calendarEvents.options.isDisplayed() , "verify Options is dispalyed");

    }



    @Test(dataProvider = "userData")
    public void pageNumber(String username, String password) {
        extentLogger= report.createTest("TC-2 Verifying the page number");
        extentLogger.info("Open Browser");
        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);

        extentLogger.info("Login teh app");

        CalendarEventsPage calendarEvents=new CalendarEventsPage();

        calendarEvents.calenderEventPage();

        String actual=calendarEvents.pageNumber.getAttribute("value");
        Assert.assertEquals( actual,"1" ,"verify page number");

    }

    @Test(dataProvider = "userData")
    public void perpageNumber(String username, String password) {
        extentLogger= report.createTest("TC-3 Verifying the per page number");
        extentLogger.info("Open Browser");
        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);

        extentLogger.info("Login teh app");

        CalendarEventsPage calendarEvents=new CalendarEventsPage();

        calendarEvents.calenderEventPage();

        String expected="25";

        String actual=calendarEvents.perPageNumber.getText();

        Assert.assertEquals(actual,expected , "verify per page number");

    }

    @Test(dataProvider = "userData")
    public void numberOfRecords(String username, String password) {
        extentLogger= report.createTest("TC-4 Verify that number of calendar events (rows in\n" +
                "the table) is equals to number of records");
        extentLogger.info("Open Browser");
        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);

        extentLogger.info("Login teh app");

        CalendarEventsPage calendarEvents=new CalendarEventsPage();

        calendarEvents.calenderEventPage();

        String totalRecords=calendarEvents.numberOfRecords.getText();
        String records=totalRecords.substring(9,totalRecords.length()-8);

        int total=0;
        for (int i = 1; i <70; i++) {
            List<WebElement> allRowsWithoutHeader=driver.findElements(By.xpath("//table/tbody/tr"));
            calendarEvents.pageNumber.sendKeys("i");
            total+= allRowsWithoutHeader.size();

        }


        String totalRow=Integer.toString(total);

        Assert.assertEquals(totalRow,records,"Verify number of records equal to number of rows");

    }

    @Test(dataProvider = "userData")
    public void allCalenderEvent(String username, String password) {
        extentLogger = report.createTest("TC-5 Verify that all calendar events were selected");
        extentLogger.info("Open Browser");
        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);

        extentLogger.info("Login teh app");

        CalendarEventsPage calendarEvents = new CalendarEventsPage();

        calendarEvents.calenderEventPage();

        calendarEvents.selectAllEvents.click();

        Assert.assertTrue(calendarEvents.totalEventCheckbox.isSelected(), "Select all calender event");

    }

    @Test(dataProvider = "userData")
    public void dataDisplayed(String username, String password) {
        extentLogger = report.createTest("TC-5 Verify that following data is displayed");
        extentLogger.info("Open Browser");
        LoginPage loginPage = new LoginPage();

        loginPage.login(username, password);

        extentLogger.info("Login teh app");

        CalendarEventsPage calendarEvents = new CalendarEventsPage();

        calendarEvents.calenderEventPage();

        calendarEvents.testersMeeting.click();

        ExcelUtil testdata = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","sheet1");

        String[][] expectedData=testdata.getDataArray();
        System.out.println(Arrays.deepToString(expectedData));

        String [][] actual= new String[9][9];



    }

    @DataProvider
    public Object [][] testData(){
        String [][] data = {
                {"Title","Testers meeting"},
                {"Description","This is a a weekly testers meeting"},
                {"Start","Nov 27, 2019, 9:30 AM"},
                {"End","Nov 27, 2019, 10:30 AM"},
                {"All-Day Event","No"},
                {"Organizer","Stephan Haley"},
                {"Guests","Tom Smith"},
                {"Recurrence","Weekly every 1 week on Wednesday"},
                {"Call Via Hangout","No"}
        };
        return data;
    }

    @Test(dataProvider ="testData")
    public void test1(String title,String meeting) {

        extentLogger = report.createTest("TC-5 Verify that following data is displayed");
        extentLogger.info("Open Browser");
        LoginPage loginPage = new LoginPage();

        loginPage.loginAsStoreManager();

        extentLogger.info("Login teh app");

        CalendarEventsPage calendarEvents = new CalendarEventsPage();

        calendarEvents.calenderEventPage();

        String actual="";
        for (int i = 0; i < testData().length; i++) {
            actual+=title+" "+meeting;

        }
        System.out.println(actual);


    }

}



























