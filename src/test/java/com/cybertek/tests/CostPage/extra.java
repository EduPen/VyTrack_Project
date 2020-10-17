package com.cybertek.tests.CostPage;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class extra {


    /**   @Test(dataProvider = "userData")
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

        }


      //  @DataProvider
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

     //   @Test(dataProvider ="testData")
        public void test1(String title,String meeting){

            extentLogger = report.createTest("TC-5 Verify that following data is displayed");
            extentLogger.info("Open Browser");
            LoginPage loginPage = new LoginPage();

            loginPage.loginAsStoreManager();

            extentLogger.info("Login teh app");

            CalendarEventsPage calendarEvents = new CalendarEventsPage();

            calendarEvents.calenderEventPage();

            calendarEvents.testersMeeting.click();

            for(int i=0 ; i< testData().length;i++){



            }
    }
    **/
}
