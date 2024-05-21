package Bindings;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class StepDefinitions {

    private WebDriver webDriver;
    private Actions action;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private ChromeOptions option;


    //--------------------------------------------------------------------------------------------------

    @Before
    public void initialization() {
        //for chrome
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Asus\\Downloads\\Video\\chromedriver-win64\\chromedriver.exe");

        option = new ChromeOptions();

//        option.addArguments("--window-size-1366,656");
//        option.addArguments("headless");
//        option.setExperimentalOption("useAutomationExtension", false);
//        option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        webDriver = new ChromeDriver(option);

        webDriver.manage().window().maximize();

        action = new Actions(webDriver);
        wait = new WebDriverWait(webDriver, 30);
        js = (JavascriptExecutor) webDriver;
    }


    @After
    public void exit() throws InterruptedException {
        Thread.sleep(10000);
        webDriver.close();
//        webDriver.quit();
    }


    //--------------------------------------------------------------------------------------------------


    @Given("^login page$")
    public void loginPage() throws InterruptedException {
        webDriver.get("https://mftplus.com/student/login");
//        webDriver.navigate().to("https://mftplus.com/student/login");

//        webDriver.get("https://udemyiran.com/acount");
        Thread.sleep(10000);
//        webDriver.findElement(By.xpath("//a[text()='Sign in']")).click();
    }

    // --------------------------------------------------------------------------------------------------

    @When("we enter {string} and {string}")
    public void loginInfo(String username, String password) throws InterruptedException {

//        webDriver.findElement(By.id("username")).click();
        webDriver.findElement(By.id("username")).sendKeys(username);
        Thread.sleep(1000);
//        webDriver.findElement(By.id("password")).click();
        webDriver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(2000);


//        **********************************************************

//        WebElement input1 = webDriver.findElement(By.id("user_login"));
//        wait.until(ExpectedConditions.elementToBeClickable(input1));
//        input1.click();
//        input1.sendKeys(username);
//        Thread.sleep(1000);
//
//        WebElement input2 = webDriver.findElement(By.id("user_pass"));
//        wait.until(ExpectedConditions.elementToBeClickable(input2));
//        input2.click();
//        input2.sendKeys(password);
//        Thread.sleep(2000);

    }

    // --------------------------------------------------------------------------------------------------

    @Then("login happens")
    public void login() {
        WebElement btn = webDriver.findElement(By.name("formbuttonsubmit"));
//        WebElement btn = webDriver.findElement(By.id("wp-submit"));
        wait.until(ExpectedConditions.elementToBeClickable(btn));
        btn.click();
    }




}












//    pip install webdriver-manager
//
//        from selenium import webdriver
//        from webdriver_manager.chrome import ChromeDriverManager
//
//        driver = webdriver.Chrome(ChromeDriverManager().install())