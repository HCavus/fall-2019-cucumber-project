package com.cybertek.library.my_step_definitions;

import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class UsersTableSearchStepDef {
    UsersPage usersPage=new UsersPage();
    @When("I search for any valid email")
    public void i_search_for_any_valid_email() {
        BrowserUtils.wait(1);
    String validEmail="pennywise@gmail.com";
    usersPage.search.sendKeys(validEmail);
    }

    @Then("the users table must display {int} records")
    public void the_users_table_must_display_records(int rows) {
        BrowserUtils.wait(1);
        int numberOfRows=usersPage.allRows.size();
        assertEquals(numberOfRows,rows);
    }
    @When("I search for any invalid email")
    public void i_search_for_any_invalid_email() {
        BrowserUtils.wait(1);
        String invalidEmail="abc@gmail.com";
        usersPage.search.sendKeys(invalidEmail);
    }

    @Then("the users table must display message {string}")
    public void the_users_table_must_display_message(String message) {
        BrowserUtils.wait(1);
        assertEquals(usersPage.noDataMessage.getText(),message);
    }
    @Then("users table should be sorted by {string} in {string} order")
    public void users_table_should_be_sorted_by_in_order(String userID, String order) {
       BrowserUtils.wait(1);
        List<String> ids=new ArrayList<>();
        for(WebElement each: usersPage.allUserIds){
            ids.add(each.getText());
        }
        List<String> idsNotSorted=new ArrayList<>(ids);
        Collections.sort(ids);
        if(order.equals("descending")){
            assertFalse(ids.equals(idsNotSorted));
        }else if(order.equals("ascending")){
            assertTrue(ids.equals(idsNotSorted));
        }
    }

    @When("I click on the {string} column")
    public void i_click_on_the_column(String columnName) {
        BrowserUtils.wait(1);
        if(columnName.equals("User ID")) {
            usersPage.columnuserID.click();
        }else if(columnName.equals("Email")){
            usersPage.columnemail.click();
        }
    }
    @When("I try to add new with the same email")
    public void i_try_to_add_new_with_the_same_email() {
        String name="Joseph Miller";
        String password="Jmiller1234";
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

    @Then("Add User dialog should still be open")
    public void add_User_dialog_should_still_be_open() {
       assertTrue(usersPage.dialogBody.isDisplayed());
    }

    @Then("error message {string} should display")
    public void error_message_should_display(String string) {

    }





}
