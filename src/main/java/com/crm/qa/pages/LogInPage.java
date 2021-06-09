package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends TestBase {
    //Page Factory -OR: Object Repository
    @FindBy(name = "txtUsername")
    WebElement username;

    @FindBy(name = "txtPassword")
    WebElement password;

//    @FindBy(xpath = "//input[@type = 'submit']")
//    WebElement loginBtn;
   // Xpath=//tagname[@attribute='value']
    //@FindBy(xpath="//button[contains(text(),'Sign Up')]")
    @FindBy(xpath = "//input[@id='btnLogin']")
    WebElement loginBtn;
    //WebElement signUpBtn;

    //@FindBy(xpath = "//img[contains(@class, 'img-responsive')]")
    //WebElement crmLogo;

    @FindBy(xpath ="//img[contains(@src,'syntax.png' )]")
    WebElement syntaxLogo;


    @FindBy(xpath = "//span[contains(text(),'Username ca')]")
    WebElement emptyUserName;

    @FindBy(xpath = "//span[contains(text(),'Password ca')]")
    WebElement emptyPassword;

    @FindBy(xpath = "//span[contains(text(),'Invalid')]")
    WebElement invalidCredentials;

    //Initializing the Page Objects:
    public LogInPage(){
        PageFactory.initElements(driver,this);
    }

    //Actions:
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }
    public boolean validateCRMImage(){
        return syntaxLogo.isDisplayed();
    }
    public  HomePage login(String un, String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
        return new HomePage();
    }

}
