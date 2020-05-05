package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.UsersPage;

import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddUsersStepDef {
    UsersPage usersPage=new UsersPage();
    @When("I click on Add Users")
    public void i_click_on_Add_Users() {

        usersPage.addUsers.click();
    }
    @Then("dialog fields must have matching placeholder")
    public void dialog_fields_must_have_matching_placeholder(Map<String,String> fields) {
        for (String key : fields.keySet()) {
            System.out.println("key: " + key);
            System.out.println("value: " + fields.get(key));
            System.out.println();
        }
        String expectedFullname = fields.get("fullname");
        String actualFullname = usersPage.fullName.getAttribute("placeholder");
        assertEquals("Full name placeholder value did not match", expectedFullname, actualFullname);

        String expectedEmail = fields.get("email");
        String actualEmail = usersPage.email.getAttribute("placeholder");
        assertEquals("Email placeholder value did not match", expectedEmail, actualEmail);

        String expectedPassword = fields.get("password");
        String actualPassword = usersPage.password.getAttribute("placeholder");
        assertEquals("Password placeholder value did not match", expectedPassword, actualPassword);


        String actualAddress = usersPage.address.getAttribute("placeholder");
        assertEquals("Address placeholder value did not match", "", actualAddress);//empty string is still an object
    }
        @Then("table should contain this data")
        public void table_should_contain_this_data(Map<String,String> user) {
            System.out.println(user.entrySet());


            String name=user.get("Full Name");
            String email=user.get("Email");
            String id=user.get("User ID");

            System.out.println("name: "+name);
            System.out.println("email: "+id);

            //get all rows.verify that at least one of the rows contains all of the user info
            List<WebElement> allRows=usersPage.allRows;
            List<String>allRowsText= BrowserUtils.getElementsText(allRows);

            boolean found=true;
            for(String row: allRowsText){
                System.out.println("row: "+row);
                found=row.contains(id) && row.contains(name) && row.contains(email);
                if(found){
                    break;
                }
            }
            assertTrue(user+"was not found ",found);
        }

    @Then("Each user id should be unique")
    public void each_user_id_should_be_unique() {
        usersPage.getShowRecords().selectByVisibleText("100");
        BrowserUtils.wait(1);
       List<String> list=BrowserUtils.getElementsText(usersPage.allUserIds);
        System.out.println(list);

        Set<String> set=new HashSet<>(list);
        System.out.println(set);
        assertEquals(list.size(),set.size());
    }



}


