package com.cybertek.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UsersPage extends PageBase {
    @FindBy(name="tbl_users_length")
    public WebElement showRecords;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> allRows;

    @FindBy(tagName = "input")
    public WebElement search;

    @FindBy(xpath = "//table/tbody/tr/td[2]")
    public List<WebElement>allUserIds;

    @FindBy(xpath = "//table/tbody/tr/td[3]")
    public List<WebElement>allFullNames;

    @FindBy(xpath = "//table/tbody/tr/td[4]")
    public List<WebElement>allEmails;

    @FindBy(xpath = "//table/tbody/tr/td[5]")
    public List<WebElement>allGroups;

    @FindBy(tagName = "th")
    public List<WebElement> columnNames;

    @FindBy(css="a.btn-lg")
    public WebElement addUsers;

    @FindBy(xpath = "//th[2]")
    public WebElement columnuserID;

    @FindBy(name = "full_name")
    public WebElement fullName;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//th[4]")
    public WebElement columnemail;

    @FindBy(xpath = "(//div[@class='modal-body'])[1]")
    public WebElement dialogBody;

    @FindBy(name="email")
    public WebElement email;

    @FindBy(id = "address")
    public WebElement address;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement save;

    @FindBy(css="a.page-link:not([title])")
    public List<WebElement> pageList;




    @FindBy(linkText = "Add User")
    public WebElement addUserLink;

    @FindBy(name = "start_date")
    public  WebElement startDate;

    @FindBy(name = "end_date")
    public  WebElement endDate;

    @FindBy(xpath = "//th[@colspan='6']")
    public WebElement monthDisplayed;

    @FindBy(xpath = "//td[text()='21']")
    public WebElement activeDay;

    @FindBy(xpath = "//button[text()='Close']")
    public WebElement close;

    @FindBy(xpath = "//td[@colspan='6']")
    public WebElement noDataMessage;

    @FindBy(xpath = "//tr[@class='odd']/td[3]")
    public WebElement expectedName;

    @FindBy(xpath = "//tr[@class='odd']/td[4]")
    public WebElement expectedEmail;

    @FindBy(id = "user_groups")
    public WebElement userGroupValue;








    public Select getShowRecords(){
        return new Select(showRecords);
    }
    public Select getUserGroupValue(){
        return new Select(userGroupValue);
    }
}
