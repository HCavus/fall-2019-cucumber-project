package com.cybertek.library.my_step_definitions;


import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserGroupStepDef {
    UsersPage usersPage=new UsersPage();


    @Then("User group default value should be {string}")
    public void user_group_default_value_should_be(String userGroupValue) {
        BrowserUtils.wait(1);
       WebElement defaultValue=usersPage.getUserGroupValue().getFirstSelectedOption();
       assertEquals(defaultValue.getText(),userGroupValue);

    }

    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> options) {
        System.out.println("options size: "+options.size());
        System.out.println(options);
        List<WebElement> webElements=usersPage.getUserGroupValue().getOptions();
        List<String> elementsText=BrowserUtils.getElementsText(webElements);
        assertEquals(options,elementsText);
    }
    @When("I select User group {string}")
    public void i_select_User_group(String option) {
        BrowserUtils.wait(1);
     usersPage.getUserGroupValue().selectByVisibleText(option);
    }

    @When("I select Show {int} records")

    public void i_select_Show_records(Integer option) {
        BrowserUtils.wait(1);
        usersPage.getShowRecords().selectByVisibleText(option.toString());
    }

    @Then("Groups columns in user table should only contain {string}")
    public void groups_columns_in_user_table_should_only_contain(String group) {
        BrowserUtils.wait(1);
       List<String> groupName=new ArrayList<>();
       for(WebElement each: usersPage.allGroups){
           groupName.add(each.getText());
           assertEquals(each.getText(),group);
       }
    }
    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer option) {
        BrowserUtils.wait(1);
        String actual=usersPage.getShowRecords().getFirstSelectedOption().getText();
        Assert.assertEquals(option+"",actual);// there is a bug default value is 10
    }



}
