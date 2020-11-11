package objects;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdicionaProdutos {
    public  static WebDriver navegador;

@Test
    public static void adicionaProdutoCarrinho(){

        navegador = new ChromeDriver();
        navegador.findElement(By.id("add-product-4-btn")).click();
        navegador.findElement(By.id("add-product-5-btn")).click();
    }
}
