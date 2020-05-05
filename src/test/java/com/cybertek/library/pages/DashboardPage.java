package com.cybertek.library.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends PageBase{
    @FindBy(css = "#navbarDropdown>span")
    public WebElement accountHolderName;
}
