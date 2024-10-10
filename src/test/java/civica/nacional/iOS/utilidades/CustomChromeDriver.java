package civica.nacional.iOS.utilidades;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CustomChromeDriver {
	
	public static void iniciarChromeDriver() {
	    System.setProperty("webdriver.chrome.driver", Credenciales.parametrosGenerales().getProperty("ubicacion.driverchrome"));

	    // Configuración de ChromeOptions
	    ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.setAcceptInsecureCerts(true);
	    chromeOptions.addArguments("--disable-features=HttpsFirstMode");
	    chromeOptions.addArguments("--disable-features=HttpCache");

	    // Crear una nueva instancia de ChromeDriver con las opciones configuradas
	    BaseUtil.chromeDriver = new ChromeDriver(chromeOptions);
	    BaseUtil.chromeDriver.manage().window().maximize();
	    System.out.println(BaseUtil.chromeDriver);
	    System.out.println(chromeOptions);
	    
	}
	
	public static void capturarIp() {
	    InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
		    System.out.println("IP address: " + ip.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void iniciarChromeDriverLatinia() {
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/Mac/chromedriver.exe");
		BaseUtil.chromeDriverLatinia = new ChromeDriver();
		//base.chromeDriver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		BaseUtil.chromeDriverLatinia.manage().window().maximize();
	}
	public void iniciarChromeDriverNLatinia() {
		System.setProperty("webdriver.chrome.driver", Credenciales.parametrosGenerales().getProperty("ubicacion.driverchrome"));
		BaseUtil.chromeDriverNLatinia = new ChromeDriver();
		//base.chromeDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		BaseUtil.chromeDriverNLatinia.manage().window().maximize();
	}
	
	public static void cerrarChromeDriver() {
		//base.chromeDriver.close();
		BaseUtil.chromeDriver.quit();
	}
	
	public void cerrarChromeDriverLatinia() {
		BaseUtil.chromeDriverLatinia.close();
		BaseUtil.chromeDriverLatinia.quit();
	}
	
	public void cerrarChromeDriverNLatinia() {
		BaseUtil.chromeDriverNLatinia.close();
		BaseUtil.chromeDriverNLatinia.quit();
	}
}
