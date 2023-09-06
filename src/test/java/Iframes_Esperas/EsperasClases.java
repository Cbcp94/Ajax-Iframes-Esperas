package Iframes_Esperas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class EsperasClases {
    WebDriver navegador = new ChromeDriver();

    @Test
    public void esperasImplicitaExplicita() {

        //Este codigo es de una espera Implicita
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Este es el codigo de la espera Explicita
        WebDriverWait espera = new WebDriverWait(navegador, Duration.ofSeconds(10));

        navegador.get("https://thetestingstore.com/");
        navegador.manage().window().maximize();
        Actions mouseActions = new Actions(navegador);
        WebElement elementoProducto = navegador.findElement(By.xpath("/html/body/main/div/div[2]/section/div[2]/div/div[1]/a/div[1]/div/div/div/img"));
        mouseActions.moveToElement(elementoProducto).perform();
        navegador.findElement(By.xpath("/html/body/main/div/div[2]/section/div[2]/div/div[1]/a/p")).click();
        navegador.findElement(By.xpath("//*[@id=\"addToCartText-product-template\"]")).click();

        WebElement ventanaEspera = espera.until(ExpectedConditions.visibilityOf(navegador.findElement(By.xpath("//*[@id=\"ajaxifyCart\"]"))));

        System.out.println("Texto Header: " + navegador.findElement(By.xpath("/html/body/div[3]/div/form/h1")).getText());
        //String nombreProducto = navegador.findElement(By.xpath("/html/body/div[3]/div/form/h1")).getText();
        //System.out.println("Texto Header: " + nombreProducto);
        //Assert.assertEquals(nombreProducto, "SHOPPING CART");
        navegador.close();
    }
}
