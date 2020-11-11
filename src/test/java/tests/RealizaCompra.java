package tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import  objects.AdicionaProdutos;

import java.util.concurrent.TimeUnit;

public class RealizaCompra {

    public WebDriver navegador;

    @Before
    public  void abreNavegador(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.get("https://shopcart-challenge.4all.com/");
    }

    //@Test
    public  void CompraBrigadeiro() {

        navegador.findElement((By.xpath("//*[@id=\"open-categories-btn\"]/h2"))).click();
        navegador.findElement(By.id("category-1")).click();
        navegador.findElement(By.id("add-product-4-btn")).click();
        navegador.findElement(By.id("add-product-5-btn")).click();
        navegador.findElement((By.xpath("//*[@id=\"open-categories-btn\"]/h2"))).click();
        navegador.findElement((By.id("category-all"))).click();
        navegador.findElement(By.id("cart-btn")).click();

        for (int i =1; i<=3;i++) {
            navegador.findElement((By.xpath("//*[@id=\"add-product-4-qtd\"]/span"))).click();
        }

        navegador.findElement(By.id("finish-checkout-button")).click();

        WebElement validar = navegador.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div/h2"));
        String mensagem = validar.getText();
        Assert.assertEquals("Pedido realizado com sucesso!", mensagem);

        navegador.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div/button")).click();
    }

    @Test
    public void CompraRissoles(){

        navegador.findElement((By.xpath("//*[@id=\"open-categories-btn\"]/h2"))).click();
        navegador.findElement((By.xpath("//li[contains(.,'Bebidas')]"))).click();

        navegador.findElement(By.id("add-product-0-btn")).click();
        navegador.findElement(By.id("add-product-1-btn")).click();
        navegador.findElement(By.id("add-product-2-btn")).click();

        navegador.findElement((By.xpath("//*[@id=\"open-categories-btn\"]/h2"))).click();
        navegador.findElement((By.id("category-all"))).click();

        navegador.findElement(By.id("add-product-3-btn")).click();
        navegador.findElement(By.id("cart-btn")).click();

        for(int i=1;i<9;i++) {
            navegador.findElement((By.xpath("//*[@id=\"add-product-3-qtd\"]/span"))).click();
        }
        for(int i=9; i>5; i--){
            navegador.findElement((By.xpath("/html/body/div/div[2]/div[2]/ul/li[4]/div/div[1]/div[1]/span"))).click();
        }

        WebElement validarpreco = navegador.findElement(By.id("price-total-checkout"));
        String preco = validarpreco.getText();
        Assert.assertEquals("R$ 36,00",preco);

        navegador.findElement(By.id("finish-checkout-button")).click();

        WebElement validar = navegador.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div/h2"));
        String mensagem = validar.getText();
        Assert.assertEquals("Pedido realizado com sucesso!", mensagem);

        navegador.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div/button")).click();
    }


    @After
    public void fecha() {
        navegador.close();

    }
}
