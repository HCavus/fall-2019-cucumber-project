package com.cybertek.library.my_step_definitions;

import com.cybertek.library.pages.DashboardPage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddUserssStepDef {
    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();
    UsersPage usersPage=new UsersPage();
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        String url= ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
    }

    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
        String email=ConfigurationReader.getProperty("librarian_email");
        String password=ConfigurationReader.getProperty("librarian_password");
        loginPage.login(email,password);
    }

    @When("I click on {string} link")
    public void i_click_on_link(String link) {
        BrowserUtils.wait(2);
        switch (link.toLowerCase()) {
            case "dashboard":
                dashboardPage.dashboard.click();
                break;
            case "users":
                dashboardPage.users.click();
                break;
            case "books":
                dashboardPage.books.click();
                break;
        }
    }

    @When("{string} page should be displayed")
    public void page_should_be_displayed(String page) {
        assertTrue(Driver.getDriver().getCurrentUrl().endsWith(page.toLowerCase()));
        BrowserUtils.wait(1);
        switch(page.toLowerCase()){
            case "Users":
                String actual=dashboardPage.pageHeader.getText();
                assertEquals("User Management",actual);
                break;
            case "Books":
                actual=dashboardPage.pageHeader.getText();
                assertEquals("Book Management",actual);
                break;

        }
    }

    @When("I click on Add User")
    public void i_click_on_Add_User() {
        BrowserUtils.wait(1);
    usersPage.addUserLink.click();
    }

    @Then("start date should be today's date")
    public void start_date_should_be_today_s_date() {

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        BrowserUtils.wait(1);
        usersPage.startDate.click();
        String month=usersPage.monthDisplayed.getText();
        System.out.println("Start date Month1: "+month);
        actions.moveToElement(usersPage.activeDay).perform();
        String day=usersPage.activeDay.getText();
        System.out.println("End date day1: "+day);
        assertEquals(month,"April 2020");
        assertEquals(day,"21");


    }

    @Then("end date should be one month from today")
    public void end_date_should_be_one_month_from_today() {
        BrowserUtils.wait(2);
        usersPage.endDate.click();
        String month=usersPage.monthDisplayed.getText();
        System.out.println("End date Text2: "+month);
        String day=usersPage.activeDay.getText();
        System.out.println("End date day2: "+day);
        assertEquals(month,"May 2020");
        assertEquals(day,"21");
    }
    @Then("I enter new user information with random email")
    public void i_enter_new_user_information_with_random_email() {
        String email="abc@gmail.com";
        BrowserUtils.wait(2);
        usersPage.email.sendKeys(email);
        usersPage.close.click();
    }

    @When("I click the Close link")
    public void i_click_the_Close_link() {
        usersPage.close.click();
    }

    @Then("the users table should not contain user with that email")
    public void the_users_table_should_not_contain_user_with_that_email() {
        BrowserUtils.wait(1);
        String email="abc@gmail.com";
        usersPage.search.sendKeys(email);
        BrowserUtils.wait(1);
        String actualMessage="No data available in table";
        String expectedMessage=usersPage.noDataMessage.getText();
        assertEquals(actualMessage,expectedMessage);
    }
    @When("I save new user information with random email")
    public void i_save_new_user_information_with_random_email() {
        String name="Tom Smith";
        String password="abcd1234";
        String email="abc@gmail.com";
        BrowserUtils.wait(1);
        usersPage.fullName.sendKeys(name);
        BrowserUtils.wait(1);
        usersPage.password.sendKeys(password);
        BrowserUtils.wait(1);
        usersPage.email.sendKeys(email);
        BrowserUtils.wait(1);
        usersPage.save.click();
    }

    @When("the users table must contain the correct user information")
    public void the_users_table_must_contain_the_correct_user_information() {
        String name="Tom Smith";
        String password="abcd1234";
        String email="abc@gmail.com";
        BrowserUtils.wait(1);
        String expectedName=usersPage.expectedName.getText();
        String expectedEmail=usersPage.expectedEmail.getText();
        assertEquals(name,expectedName);
        assertEquals(email,expectedEmail);

    }



}
