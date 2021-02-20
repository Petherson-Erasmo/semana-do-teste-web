package Iterasys.Petz;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.Home;
import pages.Lista;


public class ComprarProduto {

// 3.1 - Atributos
	String ulr; 		// Endere�o do site que vamos testar
	WebDriver driver; 	// Objeto do Selenium WebDriver
	
	Home home; 			// Objeto home herdando a classe Home
	Lista lista; 		// Objeto lista herdado da classe Lista
	
	// 3.2 - M�todos ou Fun��es
	@Before
	public void iniciar() {
		ulr = "https://www.petz.com.br/";
		
		System.setProperty("webdriver.chrome.driver", "Webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // maximiza a janela do browser
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS); // Espera implicita de 15 segundos
		
		home = new Home(driver); 	// Instanciar a class Home
		lista = new Lista(driver); 	// Instanciar a class Lista
	}
	
	@After // depois do teste
	public void finalizar() {
		driver.quit();
	}
	
	@Dado("^que acesso o site da Petz$")
	public void que_acesso_o_site_da_Petz() {
		driver.get(ulr); // Abre o site da Petz
		System.out.println("Passo 1");
	}

	@Quando("^busco por \"([^\"]*)\" e pressiono Enter$")
	public void busco_por_e_pressiono_Enter(String produto) {
		home.buscaProdutoComEnter(produto);
		System.out.println("Passo 2");
	}

	@Entao("^exibe uma lista de produtos relacionados com \"([^\"]*)\"$")
	public void exibe_uma_lista_de_produtos_relacionados_com(String produto) {
		assertEquals("RESULTADOS PARA \"" + produto.toUpperCase() + "\"", lista.lerCabecalhoResultado());
		System.out.println("Passo 3");
	}

	@Quando("^escolho \"([^\"]*)\"$")
	public void escolho(String produto) {
		lista.clicarNoProduto(produto);
		System.out.println("Passo 4");
	}

	@Entao("^exibe para o \"([^\"]*)\" o preco de \"([^\"]*)\"$")
	public void exibe_para_o_o_preco_de(String arg1, String arg2) {
		System.out.println("Passo 5");
	}

}
