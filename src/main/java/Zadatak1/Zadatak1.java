package Zadatak1;

/*
Napraviti maven projekat i dodati selenium dependency.
U Mainu preko selenijuma otici na https://demoqa.com/text-box.

Zadatak je da popunite sva polja (Full Name, email, Current Address, Permanent Address) i da kliknete submit.

Uporediti da li u rezultatu (ispod submit), full name i email su isti kao uneseni pre submita, da nije doslo do izmene.
Upisati odgovarajucu poruku ako su isti ili ako se razlikuju podaci.

Zadatak okaciti na github.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ina\\Desktop\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Pera Peric");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("peraperic@yahoo.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Vojvode Misica 18");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Vojvode Bojovica 13");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;             //dodato zbog rezolucije
        javascriptExecutor.executeScript("window.scrollBy(0,400);", "");



        WebElement buttonSubmit = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        buttonSubmit.click();



        //poredjenje za ime:

        String fullNameExpectedResult = "Pera Peric";
        WebElement fullNameActualResult = driver.findElement(By.id("name"));

        System.out.println(" Full name Expected Results: " + fullNameExpectedResult);
        System.out.println(" Full Name Actual Results - \"fullName:\": " + fullNameActualResult.getText().substring(5));


        if (fullNameExpectedResult.equals(fullNameActualResult.getText().substring(5))) {
            System.out.println("Expected results and actual results of full names are the same.");
        } else {
            System.out.println("Expected results and actual results of full names are not the same.");
        }


        //poredjenje za email

        String emailExpectedResult = "peraperic@yahoo.com";
        WebElement emailActualResult = driver.findElement(By.id("email"));

        System.out.println(" Email Expected Results: " + emailExpectedResult);
        System.out.println(" Email Actual Results - \"Email :\": " + emailActualResult.getText().substring(6));

        if (emailExpectedResult.equals(emailActualResult.getText().substring(6))) {
            System.out.println("Expected results and actual results of emails are the same.");
        } else {
            System.out.println("Expected results and actual results of emails are not the same.");
        }

        driver.quit();


    }
}