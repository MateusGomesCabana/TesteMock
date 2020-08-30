/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.banco;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Mateus
 */
public class TesteAutomatizado {
    public static void main(String[] args) {

       System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mateus\\Desktop\\chromedriver.exe");

       WebDriver driver = new ChromeDriver();
       driver.get("http://www.google.com.br");
       WebElement campoDeTexto = driver.findElement(By.name("q"));
       campoDeTexto.sendKeys("brasil");
       campoDeTexto.submit();
   }
}
