package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Lista extends PageObject {
	//@FindBy(xpath = "//h3[contains(text(),'Coleira Petz Azul para C�es')]") //Desta forma comentada � o jeito mais simples por�m vai clicar sempre no mesmo texto.
	//private WebElement prudutoDesejado; // Desta forma comentada � o jeito mais simples por�m vai clicar sempre no mesmo texto.

	@FindBy(xpath = "/html[1]/body[1]/div[9]/div[2]/div[2]/div[2]/div[1]/h1[1]")
	WebElement cabecalhoResultado;
	
	public Lista(WebDriver driver) {
		super(driver);		
	}
	public void clicarNoProduto(String produto) {
		//prudutoDesejado.click(); // Desta forma comentada � o jeito mais simples por�m vai clicar sempre no mesmo texto.
		WebElement prudutoDesejado = driver.findElement(By.xpath("//h3[contains(text(),'" + produto + "')]"));
		prudutoDesejado.click();
	}
	
	public String lerCabecalhoResultado() {
		// WebElement cabecalhoResultado = driver.findElement(By.cssSelector("h2Categoria.nomeCategoria"));
		return cabecalhoResultado.getText();
		
	}
	
}
