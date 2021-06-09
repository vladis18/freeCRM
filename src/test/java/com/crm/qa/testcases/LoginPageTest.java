package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LogInPage;
import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LogInPage loginPage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void SetUp() {
        initialization();
        loginPage = new LogInPage();

    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        String loginTitle = driver.getTitle();
        System.out.println("Page Title is " + loginTitle);
        Assert.assertEquals(title, "Human Management System");
    }

    @Test(priority = 2)
    public void crmLogoImageTest() {
        boolean flag = loginPage.validateCRMImage();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest() {
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



    @Test(dataProvider = "invalidData" )
    public void invalidLoginErrorMessageValidation(String userName,String passWord,String  errMessage){
        loginPage.login(userName,passWord);

    }

    @DataProvider
    public Object[][] invalidData() {
        Object[][] data = {
                {"Admin", "123!","Invalid credetials"},
                {"Admin1", "Hum@nhrm123"}, {"Invalid credentials"},
                {"Admin", "", "Password cannot be empty"},
                {"", "Syntax123", "Username cannot be empty"}

        };
        System.out.println("this is my data " + data);
        return data;

    } 
}

