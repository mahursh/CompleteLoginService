package com.mft.completeloginservice.controller.ai;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium {

    private WebDriver webDriver;
    private Actions action;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private ChromeOptions option;

    //-----------------------------------------------------------------------

    public void initialization(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Asus\\Downloads\\Video\\chromedriver-win64\\chromedriver.exe");



        option = new ChromeOptions();

        webDriver = new ChromeDriver(option);

        webDriver.manage().window().maximize();

        action = new Actions(webDriver);
        wait = new WebDriverWait(webDriver, 30);
        js = (JavascriptExecutor) webDriver;
    }
    //-----------------------------------------------------------------------


    public void getGmailLoginPage() throws InterruptedException {
        webDriver.get("https://https://mail.google.com");
        Thread.sleep(10000);
    }

    //-----------------------------------------------------------------------

    public void loginHappens(String gmail, String password) throws InterruptedException {


        webDriver.findElement(By.id("identifierId")).sendKeys(gmail);


        WebElement gmailNextBtn = webDriver.findElement(By.id("identifierNext"));
        wait.until(ExpectedConditions.elementToBeClickable(gmailNextBtn));
        gmailNextBtn.click();

        Thread.sleep(10000);

        webDriver.findElement(By.id("password")).sendKeys(password);

        WebElement passwordNextBtn = webDriver.findElement(By.id("identifierNext"));
        wait.until(ExpectedConditions.elementToBeClickable(passwordNextBtn));
        passwordNextBtn.click();


    }

    public void sendingMail(String userName , String userEmail , String message){

        WebElement composeBtn = webDriver.findElement(By.xpath("//div[text()='Compose']"));
        wait.until(ExpectedConditions.elementToBeClickable(composeBtn));
        composeBtn.click();


       webDriver.findElement(By.name("to")).sendKeys(userEmail);

       webDriver.findElement(By.name("subjectbox")).sendKeys("Your New Password");



       webDriver.findElement(By.xpath("//div[@role='textbox']")).sendKeys(message);


        WebElement sendBtn = webDriver.findElement(By.xpath("//div[text()='Send']"));
        wait.until(ExpectedConditions.elementToBeClickable(sendBtn));
        composeBtn.click();


    }

    //-----------------------------------------------------------------------

    public void exit() throws InterruptedException {
        Thread.sleep(10000);
        webDriver.close();

    }
    //-----------------------------------------------------------------------

}
