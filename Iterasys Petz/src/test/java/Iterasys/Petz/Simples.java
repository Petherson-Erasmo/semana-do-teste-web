// 1 - Nome do pacote
package Iterasys.Petz;
//2 - Bibliotecas Importadas 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

// 3 - Classe
public class Simples {
	// 3.1 - Atributos
	String ulr; // Endereço do site que vamos testar
	WebDriver driver; // objeto do Selenium WebDriver
	
	// 3.2 - Métodos ou Funções
	@Before
	public void iniciar() {
		ulr = "https://www.petz.com.br/";
		
		System.setProperty("webdriver.chrome.driver", "Webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // maximiza a janela do browser
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS); // Espera implicita de 15 segundos
	}
	
	@After // depois do teste
	public void finalizar() {
		driver.quit();
	}
	
	@Test //O Teste
	public void abriPagina() {
		driver.get(ulr);
		assertEquals("Pet Shop: Petz o maior pet shop do Brasil.", driver.getTitle());
	}

}
